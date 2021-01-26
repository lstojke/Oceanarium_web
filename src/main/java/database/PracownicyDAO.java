package database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Repository
public class PracownicyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PracownicyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Pracownik> list(){
        String sql = "SELECT * FROM PRACOWNICY";
        List<Pracownik> pracownicy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pracownik.class));
        return pracownicy;
    }

    //insert
    public void save(Pracownik pracownik){
        System.out.println("urodzenie " + pracownik.getData_urodzenia());
        System.out.println("adres: " + pracownik.getId_adresu());
        System.out.println("zatrudnienie: "+pracownik.getData_zatrudnienia());
        System.out.println("Plec :"+pracownik.getPlec());
        System.out.println("Oceanarium: "+pracownik.getId_oceanarium());
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("pracownicy").usingColumns("imie", "nazwisko", "data_urodzenia", "plec", "pesel", "data_zatrudnienia", "id_oceanarium", "id_adresu", "id_stanowiska");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownik);
        insertActor.execute(param);
    }

    //delete
    public void delete(int id){
        String sql = "DELETE FROM PRACOWNICY WHERE id_pracownika = ?";
        jdbcTemplate.update(sql, id);
    }

    //get
    public Pracownik get(int id){
        Object[] args = {id};
        String sql = "SELECT  * FROM  PRACOWNICY WHERE id_pracownika = " + args[0];
        Pracownik pracownik = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Pracownik.class));
        return pracownik;
    }

    //update
    public void update(Pracownik pracownik){
        String sql = "UPDATE PRACOWNICY SET imie=:imie, nazwisko=:nazwisko, data_urodzenia=:data_urodzenia, plec=:plec, pesel=:pesel, data_zatrudnienia=:data_zatrudnienia, id_oceanarium=:id_oceanarium, id_adresu=:id_adresu, id_stanowiska=:id_stanowiska WHERE id_pracownika=:id_pracownika";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownik);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql,param);
    }

}
