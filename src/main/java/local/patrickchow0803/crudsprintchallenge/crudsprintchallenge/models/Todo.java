package local.patrickchow0803.crudsprintchallenge.crudsprintchallenge.models;

import javax.persistence.*;

@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;

    private String description;
    private String datestarted;
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "userid",
                nullable = false)
    private User user;

}
