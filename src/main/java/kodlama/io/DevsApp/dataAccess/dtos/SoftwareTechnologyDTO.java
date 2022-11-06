package kodlama.io.DevsApp.dataAccess.dtos;

import kodlama.io.DevsApp.entities.concretes.SoftwareLang;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class SoftwareTechnologyDTO {
    @NotBlank
    @NotEmpty
    private String technologyName;

    public String getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyName(String technologyName) {
        this.technologyName = technologyName;
    }
}
