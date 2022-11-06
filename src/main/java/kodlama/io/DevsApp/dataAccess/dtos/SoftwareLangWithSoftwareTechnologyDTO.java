package kodlama.io.DevsApp.dataAccess.dtos;

import java.util.List;

public class SoftwareLangWithSoftwareTechnologyDTO {
    private String langName;
    private List<SoftwareTechnologyDTO> technologies;

    public String getLangName() {
        return langName;
    }

    public void setLangName(String langName) {
        this.langName = langName;
    }

    public List<SoftwareTechnologyDTO> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<SoftwareTechnologyDTO> technologies) {
        this.technologies = technologies;
    }
}
