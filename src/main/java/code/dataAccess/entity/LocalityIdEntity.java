package code.dataAccess.entity;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class LocalityIdEntity implements Serializable {
    private String postalCode;
    private String city;

    public LocalityIdEntity() {}

    // Getters
    public String getPostalCode() {
        return postalCode;
    }
    public String getCity() {
        return city;
    }

    // Setters
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocalityIdEntity that = (LocalityIdEntity) o;

        return java.util.Objects.equals(postalCode, that.postalCode)
                && java.util.Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(postalCode, city);
    }
}
