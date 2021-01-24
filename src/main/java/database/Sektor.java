package database;

public class Sektor {

    private int id_sektora;
    private String nazwa;
    private String status;
    private int id_oceanarium;
    private int id_adresu;

    public Sektor() {
    }

    public Sektor(int id_sektora, String nazwa, String status, int id_oceanarium, int id_adresu) {
        this.id_sektora = id_sektora;
        this.nazwa = nazwa;
        this.status = status;
        this.id_oceanarium = id_oceanarium;
        this.id_adresu = id_adresu;
    }

    @Override
    public String toString() {
        return "Sektor{" +
                "id_sektora=" + id_sektora +
                ", nazwa='" + nazwa + '\'' +
                ", status='" + status + '\'' +
                ", id_oceanarium=" + id_oceanarium +
                ", id_adresu=" + id_adresu +
                '}';
    }

    public int getId_sektora() {
        return id_sektora;
    }

    public void setId_sektora(int id_sektora) {
        this.id_sektora = id_sektora;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

}
