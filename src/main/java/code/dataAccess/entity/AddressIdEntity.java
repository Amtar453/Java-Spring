package code.dataAccess.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AddressIdEntity implements Serializable {
    private String street;
    private String number;

    public AddressIdEntity() {}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressIdEntity that = (AddressIdEntity) o;

        return java.util.Objects.equals(street, that.street)
                && java.util.Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(street, number);
    }
}
