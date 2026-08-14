package code.model;

import javax.validation.constraints.*;

public class Locality {
    @NotBlank
    @Size(min=1, max=10)
    private String postalCode;
    @NotBlank
    @Size(min=1, max=50)
    private String city;
    private Address address;

    public Locality(){}

    public Locality(String postalCode, String city, Address address) {
        this.postalCode = postalCode;
        this.city = city;
        this.address = address;
    }

    // GETTERS
    public String getPostalCode() {
        return postalCode;
    }
    public String getCity() {
        return city;
    }
    public Address getAddress() {
        return address;
    }

    // SETTERS
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
}