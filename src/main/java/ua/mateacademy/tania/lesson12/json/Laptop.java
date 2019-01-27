package ua.mateacademy.tania.lesson12.json;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

/**
 * Created by Tania Nebesna on 27.01.2019.
 */
public class Laptop implements Serializable {
    private String firm;
    private String model;
    private String brandRegistrationCountry;

    public Laptop(String firm, String model, String brandRegistrationCountry) {
        this.firm = firm;
        this.model = model;
        this.brandRegistrationCountry = brandRegistrationCountry;
    }

    public Laptop() {
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @XmlTransient
    @JsonIgnore
    public String getBrandRegistrationCountry() {
        return brandRegistrationCountry;
    }

    public void setBrandRegistrationCountry(String brandRegistrationCountry) {
        this.brandRegistrationCountry = brandRegistrationCountry;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "firm='" + firm + '\'' +
                ", model='" + model + '\'' +
                ", brandRegistrationCountry='" + brandRegistrationCountry + '\'' +
                '}';
    }
}
