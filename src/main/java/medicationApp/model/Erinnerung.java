package medicationApp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "erinnerungen")
public class Erinnerung {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
    private String bezeichnung;
    private int dosis;
    private boolean aktiv;
    private boolean montag;
    private boolean dienstag;
    private boolean mittwoch;
    private boolean donnerstag;
    private boolean freitag;
    private boolean samstag;
    private boolean sonntag;
    private Date anfangsdatum;
    private Date enddatum;

    public Erinnerung() {

    }

    public Erinnerung(String bezeichnung, int dosis, boolean aktiv, boolean montag, boolean dienstag, boolean mittwoch, boolean donnerstag, boolean freitag, boolean samstag, boolean sonntag, Date anfangsdatum, Date enddatum) {
        this.bezeichnung = bezeichnung;
        this.dosis = dosis;
        this.aktiv = aktiv;
        this.montag = montag;
        this.dienstag = dienstag;
        this.mittwoch = mittwoch;
        this.donnerstag = donnerstag;
        this.freitag = freitag;
        this.samstag = samstag;
        this.sonntag = sonntag;
        this.anfangsdatum = anfangsdatum;
        this.enddatum = enddatum;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public int getDosis() {
        return dosis;
    }

    public void setDosis(int dosis) {
        this.dosis = dosis;
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

    public Date getAnfangsdatum() {
        return anfangsdatum;
    }

    public void setAnfangsdatum(Date anfangsdatum) {
        this.anfangsdatum = anfangsdatum;
    }

    public Date getEnddatum() {
        return enddatum;
    }

    public void setEnddatum(Date enddatum) {
        this.enddatum = enddatum;
    }
}
