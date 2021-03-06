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
    void name() {
    }

    @Test
    void list() {
        List<Adres> adresList = dao.list();
        assertFalse(adresList.isEmpty());
    }

    @Test
    void save() {
        //Adres adres = new Adres(0, "Legionowo", "Piaskowa", "11A", "05-119");
        //dao.save(adres);
    }

    @Test
    void delete() {
        int id=25;
        dao.delete(id);
    }

    @Test
    void get() {
        int id=4;
        Adres adres = dao.get(id);
        assertNotNull(adres);
    }

    @Test
    void upadate() {
        Adres adres = new Adres();
        adres.setId_adresu(21);
        adres.setMiasto("Warszawa");
        adres.setUlica("Zabawna");
        adres.setNumer("14");
        adres.setKod_pocztowy("09-412");
        dao.update(adres);
    }
}