package medicationApp.form;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class MedikamentForm {


    private String name;
    private String form;
    private int dosis;
    private boolean rezeptpflichtig;

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public int getDosis() {
        return dosis;
    }

    public void setDosis(int dosis) {
        this.dosis = dosis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRezeptpflichtig() {
        return rezeptpflichtig;
    }

    public void setRezeptpflichtig(boolean rezeptpflichtig) {
        this.rezeptpflichtig = rezeptpflichtig;
    }
}
