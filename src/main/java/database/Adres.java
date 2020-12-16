package database;

public class Adres {
    private int id_adresu;
    private String miasto;
    private String ulica;
    private String numer;
    private String kod_pocztowy;

    public Adres(int id_adresu, String miasto, String ulica, String numer, String kod_pocztowy) {
        super();
        this.id_adresu = id_adresu;
        this.miasto = miasto;
        this.ulica = ulica;
        this.numer = numer;
        this.kod_pocztowy = kod_pocztowy;
    }

    public Adres() {
    }

    public int getId_adresu() {
        return id_adresu;
    }

    public void setId_adresu(int id_adresu) {
        this.id_adresu = id_adresu;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNumer() {
        return numer;
    }

    public void setNumer(String numer) {
        this.numer = numer;
    }

    public String getKod_pocztowy() {
        return kod_pocztowy;
    }

    public void setKod_pocztowy(String kod_pocztowy) {
        this.kod_pocztowy = kod_pocztowy;
    }

    @Override
    public String toString() {
        return "Adresy{" +
                "id_adresu=" + id_adresu +
                ", miasto='" + miasto + '\'' +
                ", ulica='" + ulica + '\'' +
                ", numer='" + numer + '\'' +
                ", kod_pocztowy='" + kod_pocztowy + '\'' +
                '}';
    }
}
