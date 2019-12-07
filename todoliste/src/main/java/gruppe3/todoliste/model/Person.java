package gruppe3.todoliste.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Diese Klasse erstellt die Tabelle "person" mit den folgenden Attributen:
 * id
 * firstname
 * familyname
 * and represent the object entity
 */
@Entity(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_person")
    @SequenceGenerator(name = "seq_person", allocationSize = 10)
    private Long id;

    @NotEmpty
    @NotNull
    private String firstname;

    @NotEmpty
    @NotNull
    private String familyname;


    public Person(@NotEmpty @NotNull String firstname, @NotEmpty @NotNull String familyname) {
        this.firstname = firstname;
        this.familyname = familyname;
    }

    public Person(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVorname() {
        return firstname;
    }

    public void setVorname(String firstname) {
        this.firstname = firstname;
    }

    public String getNachname() {
        return familyname;
    }

    public void setNachname(String familyname) {
        this.familyname = familyname;
    }
}
