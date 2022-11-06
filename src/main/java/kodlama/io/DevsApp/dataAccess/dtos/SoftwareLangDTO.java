package kodlama.io.DevsApp.dataAccess.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SoftwareLangDTO {
    @NotEmpty
    @NotBlank
    private String langName;

    public String getLangName() {
        return langName;
    }

    public void setLangName(String langName) {
        this.langName = langName;
    }
}
