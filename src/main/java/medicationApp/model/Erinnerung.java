package medicationApp.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "erinnerungen")
public class Erinnerung {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "bezeichnung", nullable = false, unique = true)
    private String bezeichnung;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "medikamente_name", referencedColumnName="name")
//    private Medikament medikament;
    @Column(name="medikamente_name", nullable = true)
    private String medikament;

    @Column(name = "aktiv", nullable = false)
    private boolean aktiv;

    @Column(name = "montag", nullable = true)
    private boolean montag;

    @Column(name = "dienstag", nullable = true)
    private boolean dienstag;

    @Column(name = "mittwoch", nullable = true)
    private boolean mittwoch;

    @Column(name = "donnerstag", nullable = true)
    private boolean donnerstag;

    @Column(name = "freitag", nullable = true)
    private boolean freitag;

    @Column(name = "samstag", nullable = true)
    private boolean samstag;

    @Column(name = "sonntag", nullable = true)
    private boolean sonntag;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "anfangsdatum", nullable = false)
    private LocalDate anfangsdatum;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "enddatum", nullable = false)
    private LocalDate enddatum;

    public Erinnerung() {

    }

    public Erinnerung(String bezeichnung, String medikament, boolean aktiv, boolean montag, boolean dienstag, boolean mittwoch, boolean donnerstag, boolean freitag, boolean samstag, boolean sonntag, LocalDate anfangsdatum, LocalDate enddatum) {
        this.bezeichnung = bezeichnung;
        this.medikament = medikament;
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

    public void setId(Long ID) {
        this.id = id;
    }

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
