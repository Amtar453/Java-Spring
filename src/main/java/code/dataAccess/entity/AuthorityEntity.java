package code.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="authority")
public class AuthorityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="label")
    private String label;

    @Column(name="username")
    private String username;

    public AuthorityEntity() {}

    // Getters
    public Integer getId() {
        return id;
    }
    public String getLabel() {
        return label;
    }
    public String getUsername() {
        return username;
    }

    // Setters
    public void setId(Integer id) {
        this.id = id;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
