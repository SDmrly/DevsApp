package kodlama.io.DevsApp.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "languages")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SoftwareLang implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lang_id")
    private int langId;

    @NotBlank
    @NotEmpty
    @Column(name = "lang_name")
    private String langName;

    @OneToMany(mappedBy = "softwareLang")
    private List<SoftwareTechnology> technologies;

    public SoftwareLang() {
    }

    public SoftwareLang(int langId, String langName) {
        this.langId = langId;
        this.langName = langName;
    }

    public SoftwareLang(int langId, String langName, List<SoftwareTechnology> technologies) {
        this.langId = langId;
        this.langName = langName;
        this.technologies = technologies;
    }

    public int getLangId() {
        return langId;
    }

    public void setLangId(int langId) {
        this.langId = langId;
    }

    public String getLangName() {
        return langName;
    }

    public void setLangName(String langName) {
        this.langName = langName;
    }

    public List<SoftwareTechnology> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<SoftwareTechnology> technologies) {
        this.technologies = technologies;
    }
}
