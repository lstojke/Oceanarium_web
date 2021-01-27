package database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

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
        /*SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("pracownicy").usingColumns("imie", "nazwisko", "data_urodzenia", "plec", "pesel", "data_zatrudnienia", "id_oceanarium", "id_adresu", "id_stanowiska");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownik);*/
        String sql = "INSERT INTO Pracownicy(imie,nazwisko,data_urodzenia,PESEL,data_zatrudnienia,id_oceanarium,id_adresu,id_stanowiska,plec) VALUES(?,?," +
                "TO_DATE(?, 'YYYY-MM-DD'),?,TO_DATE(?, 'YYYY-MM-DD'),?,?,?,?)";
        jdbcTemplate.update(sql,pracownik.getImie(),pracownik.getNazwisko(),pracownik.getData_urodzenia(),pracownik.getPesel(),pracownik.getData_zatrudnienia(),pracownik.getId_oceanarium(),pracownik.getId_adresu(),pracownik.getId_stanowiska(),pracownik.getPlec());
        //insertActor.execute(param);
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
        String sql = "UPDATE PRACOWNICY SET imie=?, nazwisko=?, data_urodzenia=TO_DATE(?, 'YYYY-MM-DD'), plec=?, pesel=?, data_zatrudnienia=TO_DATE(?, 'YYYY-MM-DD'), id_oceanarium=?, id_adresu=?, id_stanowiska=? WHERE id_pracownika=?";
        System.out.println(pracownik.getData_urodzenia());
        jdbcTemplate.update(sql, pracownik.getImie(),pracownik.getNazwisko(),pracownik.getData_urodzenia(),pracownik.getPlec(),pracownik.getPesel(),pracownik.getData_zatrudnienia(),pracownik.getId_oceanarium(),pracownik.getId_adresu(),pracownik.getId_stanowiska(),pracownik.getId_pracownika());
/*
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownik);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql,param);*/
    }

}
