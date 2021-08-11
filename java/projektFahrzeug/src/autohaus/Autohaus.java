package autohaus;

import fahrzeuge.Fahrzeug;
import fahrzeuge.Lkw;
import fahrzeuge.Pkw;

import java.util.HashMap;

public class Autohaus {
    private HashMap<Integer, Fahrzeug> fahrzeugeMap;
    // Ich habe hier eine HashMap verwendet, um in weiterer Folge die Auto-ID als unique key verwenden zu können.
    private int abstellplaetze;
    private boolean isFull;
    private String name = "Heinzis Autos";

    //constructor:
    public Autohaus(int abstellplaetze, String name) {
        super();
        this.fahrzeugeMap = new HashMap<>();
        this.abstellplaetze = abstellplaetze;
        this.isFull = false;
        this.name = name;
    }

    public boolean zuVieleFahrzeuge (int mitarbeiter) {
        if (fahrzeugeMap.size() / mitarbeiter > 3) {
            isFull = true;
        } else {
            isFull = false;
        }
        return isFull;
    }

    public boolean zuVieleFahrzeuge () {
        if (fahrzeugeMap.size() > abstellplaetze) {
            isFull = true;
        } else {
            isFull = false;
        }
        return isFull;
    }

    public void anzahlFahrzeuge() {
        System.out.println("Die Anzahl der Fahrzeuge beträgt: " + fahrzeugeMap.size());
    }

    public void setFahrzeug(String fahrzeugTyp, int id, String marke, int baujahr, int grundpreis, int serviceJahr) {
        if(fahrzeugTyp.equals("Pkw")) {
            fahrzeugeMap.put(id, new Pkw(id, marke, baujahr, grundpreis, serviceJahr));

        } else if(fahrzeugTyp.equals("Lkw")) {
            fahrzeugeMap.put(id, new Lkw(id, marke, baujahr, grundpreis));
        } else {
            System.out.println("Ungültiger Fahrzeugtyp!");
        }
    }

    public void print() {
        System.out.print("~~~" + name + "~~~");
    }


    // ---- getter & setter ----
    public HashMap<Integer, Fahrzeug> getFahrzeugeMap() {
        return fahrzeugeMap;
    }

    public int getAbstellplaetze() {
        return abstellplaetze;
    }

    public void setAbstellplaetze(int abstellplaetze) {
        this.abstellplaetze = abstellplaetze;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean isFull) {
        this.isFull = isFull;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
