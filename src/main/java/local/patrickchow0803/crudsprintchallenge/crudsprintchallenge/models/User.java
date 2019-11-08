package local.patrickchow0803.crudsprintchallenge.crudsprintchallenge.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userid;

    @Column(unique = true,
            nullable = false)
    private String username;

    @Column(unique = true,
            nullable = false)
    private String primaryemail;

    @Column(nullable = false)
    private String password;

    @ManyToMany
    @JoinTable(name = "userroles",
    joinColumns = @JoinColumn(name = "userid"),
    inverseJoinColumns = @JoinColumn(name = "roleid"))
    List<Role> roles = new ArrayList<>();

    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    List<Todo> todos = new ArrayList<>();

}
