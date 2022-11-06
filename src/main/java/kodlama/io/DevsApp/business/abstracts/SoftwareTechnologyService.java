package kodlama.io.DevsApp.business.abstracts;

import kodlama.io.DevsApp.dataAccess.dtos.SoftwareTechnologyCreateDTO;
import kodlama.io.DevsApp.dataAccess.dtos.SoftwareTechnologyDTO;

import java.util.List;

public interface SoftwareTechnologyService {
    List<SoftwareTechnologyDTO> getAllTechnology();
    SoftwareTechnologyDTO getByTechnologyID(int id);
    SoftwareTechnologyCreateDTO saveTechnology(SoftwareTechnologyCreateDTO createDTO);
    SoftwareTechnologyDTO updateTechnology(int id, SoftwareTechnologyDTO technologyDTO);
    void deleteTechnology(int id);
}
