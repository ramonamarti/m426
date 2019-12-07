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
 * Author: Cristina
 */
@Entity(name = "login")
@Table(name = "login")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_login")
    @SequenceGenerator(name = "seq_login", allocationSize = 10)
    private Long id;

    /**
     * Erstellung Attribut username
     */
    @NotEmpty
    @NotNull
    @Column(unique = true)
    private String username;

    /**
     * Erstellung Attribut password
     */
    @NotEmpty
    @NotNull
    private String password;

    /**
     * Erstellung Frendschlüssel personFk
     */
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "loginPersonFk")
    private Person personFk;

    /**
     * Erstellung Konstruktor mit folgenden Parameter:
     * @param username
     * @param password
     * @param personFk
     */
    public Login(@NotEmpty @NotNull String username, @NotEmpty @NotNull String password, @NotEmpty @NotNull Person personFk) {
        this.username = username;
        this.password = password;
        this.personFk = personFk;
    }

    /**
     * Erstellung leerer Konstruktor
     */
    public Login(){

    }

    /**
     * Erstellung Getter und Setter
     */
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
