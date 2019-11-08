package local.patrickchow0803.crudsprintchallenge.crudsprintchallenge.models;

import javax.persistence.*;

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



}
