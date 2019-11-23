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
@Entity(name = "list")
@Table(name = "list")
public class List {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_login")
    @SequenceGenerator(name = "seq_login", allocationSize = 10)
    private Long id;

    @NotEmpty
    @NotNull
    private String username;

    @NotEmpty
    @NotNull
    private String password;

    @NotEmpty
    @NotNull
    private Integer personFk;

    public List(@NotEmpty @NotNull String username, @NotEmpty @NotNull String password, @NotEmpty @NotNull Integer personFk) {
        this.username = username;
        this.password = password;
        this.personFk = personFk;
    }

    public List(){

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

    public Integer getPersonFk() {
        return personFk;
    }

    public void setPersonFk(Integer personFk) {
        this.personFk = personFk;
    }
}
