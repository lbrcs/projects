package fahrzeuge;

public class Lkw extends Fahrzeug {
    /*private int id;
    private String marke;
    private int baujahr;
    private int grundpreis;
    private int aktuellesJahr = 2021;
    private double rabatt = getRabatt();*/


    //constructor:
    public Lkw(int id, String marke, int baujahr, int grundpreis) {
        super(id, marke, baujahr, grundpreis);
    }

    @Override
    public double getRabatt() {
        double result = 0.06 * (super.getAktuellesJahr() - super.getBaujahr());
        if (result > 0.15) {
            return 0.15;
        } else {
            return result;
        }
    }

    @Override
    public double getNeuerPreis(double rabatt, double grundpreis) {
        double neuerPreis = grundpreis - (grundpreis * rabatt);
        return neuerPreis;
    }

    @Override
    public void print() {
        System.out.print("ID: " + super.getId() + "\n");
        System.out.print("Marke: " + super.getMarke() + "\n");
        System.out.print("Baujahr: " + super.getBaujahr() + "\n");
        System.out.print("Grundpreis: " + super.getGrundpreis() + "\n");
    }

    /*public int getId() {
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

    public double getGrundpreis() {
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

    public void setRabatt(double rabatt) {
        this.rabatt = rabatt;
    }*/

}