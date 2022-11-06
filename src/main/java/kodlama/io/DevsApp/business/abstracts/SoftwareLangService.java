package kodlama.io.DevsApp.business.abstracts;

import kodlama.io.DevsApp.dataAccess.dtos.SoftwareLangDTO;
import kodlama.io.DevsApp.dataAccess.dtos.SoftwareLangWithSoftwareTechnologyDTO;

import java.util.List;

public interface SoftwareLangService {
    List<SoftwareLangDTO> getAllLanguage();
    List<SoftwareLangWithSoftwareTechnologyDTO> getAllLanguageWithTechnology();
    SoftwareLangDTO getByLanguageID(int id);
    SoftwareLangDTO saveLanguage(SoftwareLangDTO lang);
    SoftwareLangDTO updateLanguage(int id, SoftwareLangDTO lang);
    void deleteLanguage(int id);
}
