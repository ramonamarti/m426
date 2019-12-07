package gruppe3.todoliste.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Diese Klasse erstellt die Tabelle "list" mit den folgenden Attributen:
 * id
 * date
 * description
 * personFk
 * Author: Cristina
 */
@Entity(name = "list")
@Table(name = "list")
public class List {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_list")
    @SequenceGenerator(name = "seq_list", allocationSize = 10)
    private Long id;

    @NotEmpty
    @NotNull
    @Column(name = "listDate")
    private String date;

    @NotEmpty
    @NotNull
    private String description;

    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "ListPerson_Fk")
    private Person personFk;

    public List(@NotEmpty @NotNull String date, @NotEmpty @NotNull String description, @NotEmpty @NotNull Person personFk) {
        this.date = date;
        this.description = description;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Person getPersonFk() {
        return personFk;
    }

    public void setPersonFk(Person personFk) {
        this.personFk = personFk;
    }
}
