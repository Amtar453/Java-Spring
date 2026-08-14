package code.dataAccess.entity;

import javax.persistence.*;

@Entity
@IdClass(LocalityIdEntity.class)
@Table(name="locality")
public class LocalityEntity {
    @Id
    @Column(name="postal_code")
    private String postalCode;
    @Id
    @Column(name="city")
    private String city;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name="address_street", referencedColumnName="street"),
            @JoinColumn(name="address_number", referencedColumnName="number")
    })
    private AddressEntity address;

    public LocalityEntity() {}

    // Getters
    public String getPostalCode() {
        return postalCode;
    }
    public String getCity() {
        return city;
    }
    public  AddressEntity getAddressEntity() {
        return address;
    }

    // Setters
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setAddressEntity(AddressEntity addressEntity) {
        this.address = addressEntity;
    }
}

