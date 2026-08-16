package code.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.*;
import java.util.Collection;
import java.util.Set;

public class User implements UserDetails {
    private Integer id;
    @NotBlank
    @Size(min=1, max=100)
    private String name;
    @NotBlank
    @Size(min=1, max=100)
    private String firstName;
    @NotBlank
    @Size(min=10, max=10)
    @Pattern(regexp="^04\\d{2}\\s?\\d{2}\\s?\\d{2}\\s?\\d{2}$")
    private String phoneNumber;
    @NotBlank
    @Email
    @Size(min=5, max=100)
    private String email;
    private String gender;
    @NotBlank
    @Size(min=1, max=100)
    private String username;
    @NotBlank
    @Size(min=5, max=72)
    private String password;
    private Boolean enabled;
    private Address address;
    private Set<Authority> authorityList;

    public User(){}

    // GETTERS
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
    public String getGender() {
        return gender;
    }
    public Address getAddress() {
        return address;
    }
    public String getEmail() {
        return email;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorityList;
    }

    // SETTERS
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
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

}