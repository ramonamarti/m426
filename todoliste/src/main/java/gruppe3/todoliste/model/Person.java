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
 * Author: Cristina
 */

@Entity(name = "person")
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_person")
    @SequenceGenerator(name = "seq_person", allocationSize = 10)
    private Long id;

    /**
     * Erstellung Attribut vorname
     */
    @NotEmpty
    @NotNull
    private String firstname;

    /**
     * Erstellung Attribut nachname
     */
    @NotEmpty
    @NotNull
    private String familyname;

    /**
     * Konstruktor mit folgenden Parameter:
     * @param fistname
     * @param familyname
     */
    public Person(@NotEmpty @NotNull String firstname, @NotEmpty @NotNull String familyname) {
        this.firstname = firstname;
        this.familyname = familyname;
    }

    /**
     * leerer Konstruktor
     */
    public Person(){

    }

    /**
     * Getter und Setter für alle Attribute
     * */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFamilyname() {
        return familyname;
    }

    public void setFamilyname(String familyname) {
        this.familyname = familyname;
    }
}
