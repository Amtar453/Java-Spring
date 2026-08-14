package code.dataAccess.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(AddressIdEntity.class)
@Table(name="address")
public class AddressEntity{
    @Id
    @Column(name = "street")
    private String street;
    @Id
    @Column(name = "number")
    private String number;

    public AddressEntity() {}

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
