package code.model;

import javax.validation.constraints.*;

public class Locality {
    @NotBlank
    @Size(min=1, max=10)
    private String postalCode;
    @NotBlank
    @Size(min=1, max=50)
    private String city;

    public Locality(){}

    public Locality(String postalCode, String city) {
        this.postalCode = postalCode;
        this.city = city;
    }

    // GETTERS
    public String getPostalCode() {
        return postalCode;
    }
    public String getCity() {
        return city;
    }

    // SETTERS
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public void setCity(String city) {
        this.city = city;
    }
}