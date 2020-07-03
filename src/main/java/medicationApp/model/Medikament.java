package medicationApp.model;


import javax.persistence.*;

@Entity
@Table(name = "medikamente")

public class Medikament {


    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "dosis", nullable = false)
    private Long dosis;

    public Medikament() {

    }

    public Medikament(String name, Long dosis) {

        this.name = name;
        this.dosis = dosis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDosis() {
        return dosis;
    }

    public void setDosis(Long dosis) {
        this.dosis = dosis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
