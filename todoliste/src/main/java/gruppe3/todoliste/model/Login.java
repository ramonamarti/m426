package gruppe3.todoliste.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Diese Klasse erstellt die Tabelle "list" mit den folgenden Attributen:
 * id
 * username
 * password
 * personFk
 */
@Entity(name = "login")
@Table(name = "login")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_login")
    @SequenceGenerator(name = "seq_login", allocationSize = 10)
    private Long id;

    @NotEmpty
    @NotNull
    @Column(unique = true)
    private String username;

    @NotEmpty
    @NotNull
    private String password;

    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "LoginPerson_Fk")
    private Person personFk;

    public Login(@NotEmpty @NotNull String username, @NotEmpty @NotNull String password, @NotEmpty @NotNull Person personFk) {
        this.username = username;
        this.password = password;
        this.personFk = personFk;
    }

    public Login(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPersonFk() {
        return personFk;
    }

    public void setPersonFk(Person personFk) {
        this.personFk = personFk;
    }
}
