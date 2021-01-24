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
public class ZwierzetaDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ZwierzetaDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Zwierze> list(){
        String sql = "SELECT * FROM ZWIERZETA";
        List<Zwierze> zwierzeta = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Zwierze.class));
        return zwierzeta;
    }

    //insert
    public void save(Zwierze zwierze){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("zwierzeta").usingColumns("imie", "data_urodzenia", "id_akwen", "id_gatunku", "id_wolontariusz");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(zwierze);
        insertActor.execute(param);
    }

    //delete
    public void delete(int id){
        String sql = "DELETE FROM ZWIERZETA WHERE id_zwierze = ?";
        jdbcTemplate.update(sql, id);
    }

    //get
    public Zwierze get(int id){
        Object[] args = {id};
        String sql = "SELECT  * FROM ZWIERZETA WHERE id_zwierze = " + args[0];
        Zwierze zwierze =jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Zwierze.class));
        return zwierze;
    }

    //update
    public void update(Zwierze zwierze){
        String sql = "UPDATE ZWIERZETA SET imie=:imie, data_urodzenia=:data_urodzenia, id_akwen=:id_akwen, id_gatunku=:id_gatunku id_wolontariusz=:id_wolontariusz WHERE id_zwierze=:id_zwierze";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(zwierze);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql,param);
    }
    
    
}
