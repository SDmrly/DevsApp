package kodlama.io.DevsApp.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "technologies")
public class SoftwareTechnology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank
    @NotEmpty
    @Column(name = "technology_name")
    private String technologyName;

    @NotEmpty
    @NotBlank
    @ManyToOne
    @JoinColumn(name = "lang_id", nullable = false)
    @JsonIgnore
    private SoftwareLang softwareLang;

    public SoftwareTechnology() {
    }

    public SoftwareTechnology(int id, String technologyName, SoftwareLang softwareLang) {
        this.id = id;
        this.technologyName = technologyName;
        this.softwareLang = softwareLang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyName(String technologyName) {
        this.technologyName = technologyName;
    }

    public SoftwareLang getSoftwareLang() {
        return softwareLang;
    }

    public void setSoftwareLang(SoftwareLang softwareLang) {
        this.softwareLang = softwareLang;
    }
}
