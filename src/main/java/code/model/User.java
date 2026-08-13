package code.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

public class User implements UserDetails {
    private Integer id;
    private String name, first_name, phone_number, email, gender;
    private String locality_postal_code, locality_city;
    private String username, password;
    private Boolean enabled;
    private Set<Droit> droitList;

    public User(){}

    // GETTERS
    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getFirst_name() {
        return first_name;
    }
    public String getPhone_number() {
        return phone_number;
    }
    public String getGender() {
        return gender;
    }
    public String getLocality_postal_code() {
        return locality_postal_code;
    }
    public String getLocality_city() {
        return locality_city;
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
        return droitList;
    }

    // SETTERS
    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setLocality_postal_code(String locality_postal_code) {
        this.locality_postal_code = locality_postal_code;
    }
    public void setLocality_city(String locality_city) {
        this.locality_city = locality_city;
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
    public void setEnabled(Boolean enabled) {
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
