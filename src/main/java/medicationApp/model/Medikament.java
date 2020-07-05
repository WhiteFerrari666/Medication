package medicationApp.model;


import javax.persistence.*;

@Entity
@Table(name = "medikamente")

public class Medikament {


    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "form", nullable = false)
    private String form;

    @Column(name ="dosis", nullable = false)
    private int dosis;

    @Column(name ="rezeptpflichtig", nullable = false)
    private boolean rezeptpflichtig;

    public Medikament() {

    }

    public Medikament(String name, String form, int dosis, boolean rezeptpflichtig) {
        this.name = name;
        this.form = form;
        this.dosis = dosis;
        this.rezeptpflichtig = rezeptpflichtig;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDosis() {
        return dosis;
    }

    public void setDosis(int dosis) {
        this.dosis = dosis;
    }

    public boolean isRezeptpflichtig() {
        return rezeptpflichtig;
    }

    public void setRezeptpflichtig(boolean rezeptpflichtig) {
        this.rezeptpflichtig = rezeptpflichtig;
    }
}
