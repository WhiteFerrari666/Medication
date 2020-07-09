package medicationApp.form;

import medicationApp.model.Medikament;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

public class ErinnerungForm {
    private String bezeichnung;
    private String medikament;
    private boolean aktiv;
    private boolean montag;
    private boolean dienstag;
    private boolean mittwoch;
    private boolean donnerstag;
    private boolean freitag;
    private boolean samstag;
    private boolean sonntag;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate anfangsdatum;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate enddatum;

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getMedikament() {
        return medikament;
    }

    public void setMedikament(String medikament) {
        this.medikament = medikament;
    }

    public boolean isAktiv() {
        return aktiv;
    }

    public void setAktiv(boolean aktiv) {
        this.aktiv = aktiv;
    }

    public boolean isMontag() {
        return montag;
    }

    public void setMontag(boolean montag) {
        this.montag = montag;
    }

    public boolean isDienstag() {
        return dienstag;
    }

    public void setDienstag(boolean dienstag) {
        this.dienstag = dienstag;
    }

    public boolean isMittwoch() {
        return mittwoch;
    }

    public void setMittwoch(boolean mittwoch) {
        this.mittwoch = mittwoch;
    }

    public boolean isDonnerstag() {
        return donnerstag;
    }

    public void setDonnerstag(boolean donnerstag) {
        this.donnerstag = donnerstag;
    }

    public boolean isFreitag() {
        return freitag;
    }

    public void setFreitag(boolean freitag) {
        this.freitag = freitag;
    }

    public boolean isSamstag() {
        return samstag;
    }

    public void setSamstag(boolean samstag) {
        this.samstag = samstag;
    }

    public boolean isSonntag() {
        return sonntag;
    }

    public void setSonntag(boolean sonntag) {
        this.sonntag = sonntag;
    }

    public LocalDate getAnfangsdatum() {
        return anfangsdatum;
    }

    public void setAnfangsdatum(LocalDate anfangsdatum) {
        this.anfangsdatum = anfangsdatum;
    }

    public LocalDate getEnddatum() {
        return enddatum;
    }

    public void setEnddatum(LocalDate enddatum) {
        this.enddatum = enddatum;
    }
}

