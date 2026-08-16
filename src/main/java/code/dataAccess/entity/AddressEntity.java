package code.dataAccess.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(AddressIdEntity.class)
@Table(name="address")
public class AddressEntity implements Serializable {
    @Id
    @Column(name="street")
    private String street;
    @Id
    @Column(name="number")
    private String number;
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name="locality_postal_code", referencedColumnName="postal_code"),
            @JoinColumn(name="locality_city", referencedColumnName="city")
    })
    private LocalityEntity locality;

    public AddressEntity() {}

    // GETTERS
    public String getStreet() {
        return street;
    }
    public String getNumber() {
        return number;
    }
    public LocalityEntity getLocality() {
        return locality;
    }

    // SETTERS
    public void setStreet(String street) {
        this.street = street;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public void setLocality(LocalityEntity locality) {
        this.locality = locality;
    }
}
