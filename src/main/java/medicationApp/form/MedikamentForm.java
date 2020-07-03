package medicationApp.form;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class MedikamentForm {


    private String name;
    private long dosis;


    public long getDosis() {

        return dosis;
    }

    public void setDosis(long dosis) {
        this.dosis = dosis;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }
}
