package database;

import org.junit.jupiter.api.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdresyDAOTest {

    private AdresyDAO dao;

    @BeforeEach
    void setUp() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf");
        dataSource.setUsername("LSTOJKE");
        dataSource.setPassword("lstojke");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        //Import JdbcTemplate
        dao = new AdresyDAO(new JdbcTemplate(dataSource));
    }

    @Test
    void list() {
        List<Adres> adresList = dao.list();
        assertFalse(adresList.isEmpty());
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void get() {
    }

    @Test
    void upadate() {
    }
}