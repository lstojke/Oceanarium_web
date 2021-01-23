package database;

import java.sql.Date;

public class Pracownik {
    private int id_pracownika;
    private String imie;
    private String nazwisko;
    private Date data_urodzenia;
    private char plec;
    private String pesel;
    private Date data_zatrudnienia;
    private int id_oceanarium;
    private int id_adresu;
    private int id_stanowiska;

    public Pracownik(int id_pracownika, String imie, String nazwisko, Date data_urodzenia, char plec, String pesel, Date data_zatrudnienia, int id_oceanarium, int id_adresu, int id_stanowiska) {
        this.id_pracownika = id_pracownika;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.data_urodzenia = data_urodzenia;
        this.plec = plec;
        this.pesel = pesel;
        this.data_zatrudnienia = data_zatrudnienia;
        this.id_oceanarium = id_oceanarium;
        this.id_adresu = id_adresu;
        this.id_stanowiska = id_stanowiska;
    }

    public Pracownik() {
    }

    public int getId_pracownika() {
        return id_pracownika;
    }

    public void setId_pracownika(int id_pracownika) {
        this.id_pracownika = id_pracownika;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Date getData_urodzenia() {
        return data_urodzenia;
    }

    public void setData_urodzenia(Date data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }

    public char getPlec() {
        return plec;
    }

    public void setPlec(char plec) {
        this.plec = plec;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Date getData_zatrudnienia() {
        return data_zatrudnienia;
    }

    public void setData_zatrudnienia(Date data_zatrudnienia) {
        this.data_zatrudnienia = data_zatrudnienia;
    }

    public int getId_oceanarium() {
        return id_oceanarium;
    }

    public void setId_oceanarium(int id_oceanarium) {
        this.id_oceanarium = id_oceanarium;
    }

    public int getId_adresu() {
        return id_adresu;
    }

    public void setId_adresu(int id_adresu) {
        this.id_adresu = id_adresu;
    }

    public int getId_stanowiska() {
        return id_stanowiska;
    }

    public void setId_stanowiska(int id_stanowiska) {
        this.id_stanowiska = id_stanowiska;
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "id_adresu=" + id_pracownika +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", data urodzenia='" + data_urodzenia + '\'' +
                ", plec='" + plec + '\'' +
                ", pesel='" + pesel + '\'' +
                ", data_zatrudnienia='" + data_zatrudnienia + '\'' +
                ", id_oceanarium='" + id_oceanarium + '\'' +
                ", id_adresu='" + id_adresu + '\'' +
                ", id_stanowiska='" + id_stanowiska + '\'' +
                '}';
    }
}
