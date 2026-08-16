package code.dataAccess.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(LocalityIdEntity.class)
@Table(name="locality")
public class LocalityEntity implements Serializable {
    @Id
    @Column(name="postal_code")
    private String postalCode;
    @Id
    @Column(name="city")
    private String city;

    public LocalityEntity() {}

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
}

