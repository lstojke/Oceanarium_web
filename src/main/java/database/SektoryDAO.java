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
public class SektoryDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public SektoryDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Sektor> list(){
        String sql = "SELECT * FROM SEKTORY";
        List<Sektor> sektorList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Sektor.class));
        return sektorList;
    }

    //insert
    public void save(Sektor sektor){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("sektory").usingColumns("nazwa", "status", "id_oceanarium", "id_adresu");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(sektor);
        insertActor.execute(param);
    }

    //delete
    public void delete(int id){
        String sql = "DELETE FROM SEKTORY WHERE id_sektora = ?";
        jdbcTemplate.update(sql, id);
    }

    //get
    public Sektor get(int id){
        Object[] args = {id};
        String sql = "SELECT  * FROM SEKTORY WHERE id_sektora = " + args[0];
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Sektor.class));
    }

    //update
    public void update(Sektor sektor){
        String sql = "UPDATE SEKTORY SET nazwa=:nazwa, status=:status, id_oceanarium=:id_oceanarium, id_adresu=:id_adresu WHERE id_sektora=:id_sektora";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(sektor);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql,param);
    }

}
