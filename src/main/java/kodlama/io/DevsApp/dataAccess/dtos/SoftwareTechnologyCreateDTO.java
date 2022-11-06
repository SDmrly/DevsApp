package kodlama.io.DevsApp.dataAccess.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SoftwareTechnologyCreateDTO {
    @NotNull
    private int langId;

    @NotBlank
    @NotEmpty
    private String technologyName;

    public int getLangId() {
        return langId;
    }

    public void setLangId(int langId) {
        this.langId = langId;
    }

    public String getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyName(String technologyName) {
        this.technologyName = technologyName;
    }
}
