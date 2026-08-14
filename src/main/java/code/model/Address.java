package code.model;

import javax.validation.constraints.*;

public class Address {
    @NotBlank
    @Size(min=5, max=100)
    public String street;
    @NotBlank
    @Size(min=1, max=5)
    public String number;

    public Address(){}

    public Address(String street, String number) {
        this.street = street;
        this.number = number;
    }

    // GETTERS
    public String getStreet() {
        return street;
    }
    public String getNumber() {
        return number;
    }

    // SETTERS
    public void setStreet(String street) {
        this.street = street;
    }
    public void setNumber(String number) {
        this.number = number;
    }
}
