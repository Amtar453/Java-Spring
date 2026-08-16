package code.model;

import javax.validation.constraints.*;

public class Address {
    @NotBlank
    @Size(min=5, max=100)
    private String street;
    @NotBlank
    @Size(min=1, max=5)
    private String number;
    private Locality locality;

    public Address(){}

    public Address(String street, String number, Locality locality) {
        this.street = street;
        this.number = number;
        this.locality = locality;
    }

    // GETTERS
    public String getStreet() {
        return street;
    }
    public String getNumber() {
        return number;
    }
    public  Locality getLocality() {
        return locality;
    }

    // SETTERS
    public void setStreet(String street) {
        this.street = street;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public void setLocality(Locality locality) {
        this.locality = locality;
    }
}
