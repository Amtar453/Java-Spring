package code.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "phone_number", unique = true)
    private String phoneNumber;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "gender")
    private String gender;
    @Column(name = "username", unique = true)
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "enabled")
    private Boolean enabled;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name = "locality_postal_code", referencedColumnName = "postal_code"),
            @JoinColumn(name = "locality_city", referencedColumnName = "city")
    })
    private LocalityEntity locality;


    public UserEntity() {}

    // Getters
    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public String getGender() {
        return gender;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public Boolean getEnabled() {
        return enabled;
    }
    public LocalityEntity getLocality() {
        return locality;
    }

    // Setters
    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    public void setLocality(LocalityEntity locality) {
        this.locality = locality;
    }

}