package main;

import autohaus.Autohaus;
import fahrzeuge.Fahrzeug;
import fahrzeuge.Pkw;
import fahrzeuge.Lkw;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
		/*String pkw1 = "Audi";
		String pkw2 = "Mercedes";
		String pkw3 = "VW";
		String lkw1 = "Volvo";
		String lkw2 = "VW";
        int anzahlLkws = 3;
        int anzahlPkws = 2;
        int anzahlFahrzeuge = anzahlLkws + anzahlPkws;*/
        Autohaus autohaus = new Autohaus(5, "Heinzis Autos");
		/*double preis = 2000;
		double rabatt = 0.0;*/


        /*Pkw pkw1 = new Pkw(1, "Audi", 2008, 20000, 2011, 2021);
        Pkw pkw2 = new Pkw(2, "Mercedes", 2018, 40000, 2020, 2021);
        Pkw pkw3 = new Pkw(3, "VW", 2020, 25000, 2025, 2021);

        Lkw lkw1 = new Lkw(4, "Volvo", 2017, 65000, 2021);
        Lkw lkw2 = new Lkw(5, "VW", 2010, 70000, 2021);

        pkw1.setId(6);
        pkw1.setMarke("Porsche");
        pkw1.setBaujahr(2020);
        pkw1.setGrundpreis(200000);
        pkw1.setEndeVorfuehrwagen(2022);
        pkw1.setAktuellesJahr(2021);

        for (int i = 1; i <= anzahlFahrzeuge; i++) {
            System.out.println("Es gibt ein neues Fahrzeug im Autohaus. Anzahl Fahrzeuge:" + i +".");
            while (i < anzahlFahrzeuge) {
                System.out.println("Es sind noch nicht alle Fahrzeuge registriert.");
                break;
            }
            if (i==anzahlFahrzeuge) {
                System.out.println("Folgende Marken sind zu verkaufen: " + pkw1.getMarke() + ", " + pkw2.getMarke() + ", " + pkw3.getMarke() + ", " + lkw1.getMarke() + ".");
            }
        }*/
/*
        if (pkw1.getMarke().equals(lkw1.getMarke()) || pkw1.getMarke().equals(lkw2.getMarke())) {
            System.out.println("Es gibt einen PKW und LKW, die vom gleichen Hersteller sind.");
        } else if (pkw2.getMarke().equals(lkw1.getMarke()) || pkw2.getMarke().equals(lkw2.getMarke())) {
            System.out.println("Es gibt einen PKW und LKW, die vom gleichen Hersteller sind.");
        } else if (pkw3.getMarke().equals(lkw1.getMarke()) || pkw3.getMarke().equals(lkw2.getMarke())) {
            System.out.println("Es gibt einen PKW und LKW, die vom gleichen Hersteller sind.");
        }

        anzahlFahrzeuge *= 2;
        System.out.println("Es gibt neue Fahrzeuge im Autohaus. Anzahl Fahrzeuge: " + anzahlFahrzeuge);

        if (!lkw1.getMarke().equals(lkw2.getMarke())) {
            System.out.println("Die LKWs sind nicht von der gleichen Marke.");
        } else {
            System.out.println("Die LKWs sind von der gleichen Marke.");
        }

        System.out.print("Der Preis des PKWs Nr." + pkw1.getId() + " beträgt: " + pkw1.getNeuerPreis(pkw1.getRabatt(), pkw1.getGrundpreis()) + "\n");
        System.out.print("Der Preis des PKWs Nr." + pkw2.getId() + " beträgt: " + pkw2.getNeuerPreis(pkw2.getRabatt(), pkw2.getGrundpreis()) + "\n");
        System.out.print("Der Preis des PKWs Nr." + pkw3.getId() + " beträgt: " + pkw3.getNeuerPreis(pkw3.getRabatt(), pkw3.getGrundpreis()) + "\n");
        System.out.print("Der Preis des LKWs Nr." + lkw1.getId() + " beträgt: " + lkw1.getNeuerPreis(lkw1.getRabatt(), lkw1.getGrundpreis()) + "\n");
        System.out.print("Der Preis des LKWs Nr." + lkw2.getId() + " beträgt: " + lkw2.getNeuerPreis(lkw2.getRabatt(), lkw2.getGrundpreis()) + "\n");
*/
        /*switch (pkw1) {
            case "Audi":
                rabatt = (preis / 100 * 5) * 5 / 2;
                if (rabatt >= (preis / 100 * 15)) {
                    rabatt = preis / 100 * 15;
                }
                System.out.println("Der Preis des ersten PKWs ist: " + (preis - rabatt));
                break;

            case "Mercedes":
                rabatt = (preis / 100 * (5 + 10)) * 5 / 2;
                if (rabatt > (preis / 100 * 15)) {
                    rabatt = preis / 100 * 15;
                }
                System.out.println("Der Preis des ersten PKWs ist: " + (preis - rabatt));
                break;

            case "Volvo":
                if (preis % 2 == 0) {
                    preis = 1500;
                } else {
                    preis = 1700;
                }
                System.out.println("Der Preis des ersten PKWs ist: " + preis);
                break;

            case "VW":
                if (preis % 2 == 0) {
                    preis = 1500;
                } else {
                    preis = 1700;
                }
                System.out.println("Der Preis des ersten PKWs ist: " + preis);
                break;

            default:
                System.out.println("Der Preis konnte nicht berechnet werden, da die Marke des Fahrzeugs nicht erkennbar ist.");

        }*/

        autohaus.setFahrzeug("Pkw", 1, "Audi", 2008, 20000, 2011);
        autohaus.setFahrzeug("Pkw", 2, "Mercedes", 2018, 40000, 2020);
        autohaus.setFahrzeug("Pkw", 3, "VW", 2020, 25000, 2025);
        autohaus.setFahrzeug("Lkw", 4, "Volvo", 2017, 65000, -1);
        autohaus.setFahrzeug("Lkw", 5, "VW", 2010, 70000, -1);


        for (int i = 1; i <= autohaus.getFahrzeugeMap().size(); i++) {
            System.out.println("Es gibt ein neues Fahrzeug im Autohaus. Anzahl Fahrzeuge: " + i +".");
            while (i < autohaus.getFahrzeugeMap().size()) {
                System.out.println("Es sind noch nicht alle Fahrzeuge registriert.");
                break;
            }
            if (i==autohaus.getFahrzeugeMap().size()) {
                System.out.print("Folgende Marken sind zu verkaufen: ");
                for (Map.Entry<Integer, Fahrzeug> auto : autohaus.getFahrzeugeMap().entrySet()) {
                    String marken = "";
                    if (auto.getKey() < autohaus.getFahrzeugeMap().entrySet().size()) {
                        marken += (auto.getValue().getMarke() + ", ");
                    } else {
                        marken += (auto.getValue().getMarke());
                    }
                    System.out.print(marken);
                }
            }
        }

        System.out.println("\nFolgende Marken sind zu verkaufen: ");
        for (int j = 1; j <= autohaus.getFahrzeugeMap().entrySet().size(); j++) {
            for (Map.Entry<Integer, Fahrzeug> auto : autohaus.getFahrzeugeMap().entrySet()) {
                if (auto.getValue().getId() == j) {
                    System.out.println(auto.getValue().getMarke());
                    break;
                }
            }
        }

        System.out.println("Das Autohaus ist überlastet: " + autohaus.zuVieleFahrzeuge());
        System.out.println("Das Autohaus ist überlastet: " + autohaus.zuVieleFahrzeuge(10));

        for (int k = 1; k <= autohaus.getFahrzeugeMap().entrySet().size(); k++) {
            for (Map.Entry<Integer, Fahrzeug> auto : autohaus.getFahrzeugeMap().entrySet()) {
                if (auto.getValue().getId() == k) {
                    System.out.println("Der Preis von Auto Nr. " + auto.getValue().getId() + " beträgt " + auto.getValue().getNeuerPreis(auto.getValue().getRabatt(), auto.getValue().getGrundpreis()));
                    break;
                }
            }
        }

        for(Fahrzeug fahrzeug : autohaus.getFahrzeugeMap().values()) {
            if(fahrzeug instanceof Lkw) {
                System.out.println("Das Fahrzeug ist ein LKW.");
            } else if(fahrzeug instanceof Pkw) {
                System.out.println("Das Fahrzeug ist ein PKW.");
            }
        }

    }

}
