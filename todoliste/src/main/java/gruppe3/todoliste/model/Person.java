package gruppe3.todoliste.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Diese Klasse erstellt die Tabelle "person" mit den folgenden Attributen:
 * id
 * vorname
 * nachname
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
    private String vorname;

    /**
     * Erstellung Attribut nachname
     */
    @NotEmpty
    @NotNull
    private String nachname;

    /**
     * Konstruktor mit folgenden Parameter:
     * @param vorname
     * @param nachname
     */
    public Person(@NotEmpty @NotNull String vorname, @NotEmpty @NotNull String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
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

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
}
