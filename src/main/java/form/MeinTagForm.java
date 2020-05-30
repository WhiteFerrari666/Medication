package form;

import model.Medikament;

public class MeinTagForm {

    private int datum;
    private Medikament medikament;

    public int getDatum() {
        return datum;
    }

    public void setDatum(int datum) {
        this.datum = datum;
    }

    public Medikament getMedikament() {
        return medikament;
    }

    public void setMedikament(Medikament medikament) {
        this.medikament = medikament;
    }
}
