package model;

public class Erinnerung {

    private String name;
    private int dosis;

    public Erinnerung() {

    }

    public Erinnerung(String name, int dosis) {
        this.name = name;
        this.dosis = dosis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDosis() {
        return dosis;
    }

    public void setDosis(int dosis) {
        this.dosis = dosis;
    }
}
