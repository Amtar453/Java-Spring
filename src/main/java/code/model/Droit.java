package code.model;

import org.springframework.security.core.GrantedAuthority;

public class Droit implements GrantedAuthority {
    private Integer id;
    private String label;
    private User user;

    public Droit(){}

    public Integer getId() {
        return id;
    }
    public String getAuthority() {
        return label;
    }
    public User getUser() {
        return user;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setAuthority(String authority) {
        this.label = authority;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
