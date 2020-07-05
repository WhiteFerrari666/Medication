package medicationApp.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
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

    //    @OneToMany
//    @JoinColumn(name = "medikament_name")
//    @ForeignKey
    @Column(name = "medikament", nullable = true)
    private String medikament;
//    private Medikament medikamentenName;
//    = medikamentenName.toString()

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumns({
//            @JoinColumn(name="medikament_name", referencedColumnName="name"),
//            @JoinColumn(name="medikament_dosis", referencedColumnName="dosis")})

    @Column(name = "dosis", nullable = true)
    private int dosis;

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
    private Date anfangsdatum;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "enddatum", nullable = true)
    private Date enddatum;

    public Erinnerung() {

    }

    public Erinnerung(String bezeichnung, String medikament, int dosis, boolean aktiv, boolean montag, boolean dienstag, boolean mittwoch, boolean donnerstag, boolean freitag, boolean samstag, boolean sonntag, Date anfangsdatum, Date enddatum) {
        this.bezeichnung = bezeichnung;
        this.medikament = medikament;
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
