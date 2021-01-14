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
public class AdresyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AdresyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Adres> list(){
        String sql = "SELECT * FROM ADRESY";
        List<Adres> adresy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adres.class));
        return adresy;
    }

    //insert
    public void save(Adres adres){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("adresy").usingColumns("miasto", "ulica", "numer", "kod_pocztowy");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adres);
        insertActor.execute(param);
    }

    //delete
    public void delete(int id){
    }

    //get
    public Adres get(int id){
        Object[] args = {id};
        String sql = "SELECT  * FROM  ADRESY WHERE id_adresu = " + args[0];
        Adres adres = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Adres.class));
        return adres;
    }

    //update
    public void upadate(Adres adres){
        String sql = "UPDATE ADRESY SET miasto=:miasto, ulica=:ulica, numer=:numer, kod_pocztowy=:kod_pocztowy WHERE id_adresu=:id_adresu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adres);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql,param);
    }

}
