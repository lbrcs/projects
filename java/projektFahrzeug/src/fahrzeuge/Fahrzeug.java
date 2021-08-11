package fahrzeuge;

public abstract class Fahrzeug {

    private int id;
    private String marke;
    private int baujahr;
    private int aktuellesJahr = 2021;
    private int grundpreis;

    public Fahrzeug(int id, String marke, int baujahr, int grundpreis) {
        super();
        this.id = id;
        this.marke = marke;
        this.baujahr = baujahr;
        this.grundpreis = grundpreis;
    }

    public abstract double getRabatt();
    public abstract double getNeuerPreis(double rabatt, double grundpreis);
    public abstract void print();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public int getBaujahr() {
        return baujahr;
    }

    public void setBaujahr(int baujahr) {
        this.baujahr = baujahr;
    }

    public int getGrundpreis() {
        return grundpreis;
    }

    public void setGrundpreis(int grundpreis) {
        this.grundpreis = grundpreis;
    }

    public int getAktuellesJahr() {
        return aktuellesJahr;
    }

    public void setAktuellesJahr(int aktuellesJahr) {
        this.aktuellesJahr = aktuellesJahr;
    }
}
