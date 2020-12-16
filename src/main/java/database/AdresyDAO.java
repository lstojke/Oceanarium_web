package database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
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

    }
    //delete
    public void delete(int id){

    }
    //get
    public Adres get(int id){
        return null;
    }
    //update
    public void upadate(Adres adres){

    }
}
