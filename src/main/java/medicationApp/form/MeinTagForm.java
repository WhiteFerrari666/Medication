package medicationApp.form;

import medicationApp.model.Erinnerung;
import medicationApp.model.Medikament;

public class MeinTagForm {

    public Medikament getMedikament() {
        return medikament;
    }

    public void setMedikament(Medikament medikament) {
        this.medikament = medikament;
    }

    public Erinnerung getErinnerung() {
        return erinnerung;
    }

    public void setErinnerung(Erinnerung erinnerung) {
        this.erinnerung = erinnerung;
    }

    Medikament medikament;
    Erinnerung erinnerung;



}
