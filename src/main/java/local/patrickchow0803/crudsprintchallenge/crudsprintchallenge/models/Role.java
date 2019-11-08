package local.patrickchow0803.crudsprintchallenge.crudsprintchallenge.models;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roleid;

    @Column(unique = true,
            nullable = false)
    private String rolename;

    public Role(){}

    public Role(String rolename) {
        this.rolename = rolename;
    }

    public long getRoleid() {
        return roleid;
    }

    public void setRoleid(long roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
