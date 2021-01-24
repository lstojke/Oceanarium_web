package database;

import java.sql.Date;

public class Zwierze {
    private int id_zwierze;
    private String imie;
    private Date data_urodzenia;
    private int id_akwen;
    private int id_gatunku;
    private int id_wolontariusz;

    public Zwierze(int id_zwierze, String imie, Date data_urodzenia, int id_akwen, int id_gatunku, int id_wolontariusz) {
        this.id_zwierze = id_zwierze;
        this.imie = imie;
        this.data_urodzenia = data_urodzenia;
        this.id_akwen = id_akwen;
        this.id_gatunku = id_gatunku;
        this.id_wolontariusz = id_wolontariusz;
    }

    public Zwierze() {
    }

    public int getId_zwierze() {
        return id_zwierze;
    }

    public void setId_zwierze(int id_zwierze) {
        this.id_zwierze = id_zwierze;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public Date getData_urodzenia() {
        return data_urodzenia;
    }

    public void setData_urodzenia(Date data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }

    public int getId_akwen() {
        return id_akwen;
    }

    public void setId_akwen(int id_akwen) {
        this.id_akwen = id_akwen;
    }

    public int getId_gatunku() {
        return id_gatunku;
    }

    public void setId_gatunku(int id_gatunku) {
        this.id_gatunku = id_gatunku;
    }

    public int getId_wolontariusz() {
        return id_wolontariusz;
    }

    public void setId_wolontariusz(int id_wolontariusz) {
        this.id_wolontariusz = id_wolontariusz;
    }

    @Override
    public String toString() {
        return "Zwierze{" +
                "id_zwierze=" + id_zwierze +
                ", imie='" + imie + '\'' +
                ", data urodzenia='" + data_urodzenia + '\'' +
                ", id_akwen='" + id_akwen + '\'' +
                ", id_gatunku='" + id_gatunku + '\'' +
                ", id_wolontariusz='" + id_wolontariusz + '\'' +
                '}';
    }
}
