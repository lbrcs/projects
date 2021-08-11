package fahrzeuge;

public class Pkw extends Fahrzeug {
    /*private int id;
    private String marke;
    private int baujahr;
    private int grundpreis;
    private int aktuellesJahr;
    private int vorführwagenJahr;
    private double rabatt;
    private int endeVorfuehrwagen = 2015;*/
    private int serviceJahr = 2018;

    //constructor:
    public Pkw(int id, String marke, int baujahr, int grundpreis, int serviceJahr) {
        super(id, marke, baujahr, grundpreis);
        this.serviceJahr = serviceJahr;
    }

    @Override
    public double getRabatt() {
        double result = 0.01 * (5 * (super.getAktuellesJahr() - super.getBaujahr()) + 3 * (serviceJahr - super.getBaujahr()));
        if(result > 0.10) {
            return 0.10;
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
        System.out.print("Servicejahr: " + serviceJahr);
    }

    public int getServiceJahr() {
        return serviceJahr;
    }

    //Achtung Servicejahr muss überprüft werden
    public void setServiceJahr(int serviceJahr) {
        if (serviceJahr > super.getAktuellesJahr()) {
            System.out.println("Das Jahr liegt in der Zukunft!");
        } else if (serviceJahr < super.getAktuellesJahr()) {
            System.out.println("Das Servicejahr liegt vor dem Baujahr!");
        } else {
            this.serviceJahr = serviceJahr;
        }
    }

    /*public void setVorfuehrwagenJahr(int jahr) {
        if (jahr < baujahr || jahr > endeVorfuehrwagen) {
            System.out.println("Ungültiges Jahr!");
        } else {
            jahr = vorführwagenJahr;
        }
    }*/

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

    public int getEndeVorfuehrwagen() {
        return endeVorfuehrwagen;
    }

    public void setEndeVorfuehrwagen(int endeVorfuehrwagen) {
        this.endeVorfuehrwagen = endeVorfuehrwagen;
    }

    public int getAktuellesJahr() {
        return aktuellesJahr;
    }

    public void setAktuellesJahr(int aktuellesJahr) {
        this.aktuellesJahr = aktuellesJahr;
    }

    public void setServiceJahr(int serviceJahr) {
        this.serviceJahr = serviceJahr;
    }

    public void setRabatt(double rabatt) {
        this.rabatt = rabatt;
    }*/



}