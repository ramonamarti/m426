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
 */
@Entity(name = "list")
@Table(name = "list")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_login")
    @SequenceGenerator(name = "seq_login", allocationSize = 10)
    private Long id;

    @NotEmpty
    @NotNull
    private String date;

    @NotEmpty
    @NotNull
    private String description;

    @NotEmpty
    @NotNull
    private Integer personFk;

    public Login(@NotEmpty @NotNull String date, @NotEmpty @NotNull String description, @NotEmpty @NotNull Integer personFk) {
        this.date = date;
        this.description = description;
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

    public Integer getPersonFk() {
        return personFk;
    }

    public void setPersonFk(Integer personFk) {
        this.personFk = personFk;
    }
}
