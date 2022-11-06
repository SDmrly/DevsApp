package kodlama.io.DevsApp.business.concretes;

import kodlama.io.DevsApp.business.abstracts.SoftwareLangService;
import kodlama.io.DevsApp.common.MessageConstant;
import kodlama.io.DevsApp.dataAccess.abstracts.SoftwareLangRepository;
import kodlama.io.DevsApp.dataAccess.dtos.SoftwareLangDTO;
import kodlama.io.DevsApp.dataAccess.dtos.SoftwareLangWithSoftwareTechnologyDTO;
import kodlama.io.DevsApp.entities.concretes.SoftwareLang;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SoftwareLangManager implements SoftwareLangService {
    @Inject
    private SoftwareLangRepository langRepository;

    @Inject
    private ModelMapper modelMapper;

    @Override
    public List<SoftwareLangDTO> getAllLanguage() {
        return langRepository.findAll().stream().map(language -> modelMapper.map(language, SoftwareLangDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<SoftwareLangWithSoftwareTechnologyDTO> getAllLanguageWithTechnology() {
        return langRepository.findAll().stream().map(language -> modelMapper.map(language, SoftwareLangWithSoftwareTechnologyDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public SoftwareLangDTO getByLanguageID(int id) {
        return langRepository.findById(id).map(softwareLang -> modelMapper.map(softwareLang, SoftwareLangDTO.class)).orElseThrow(() -> {
            throw new RuntimeException(String.format(MessageConstant.NOT_FOUND_ID_MESSAGE, id));
        });
    }

    @Override
    public SoftwareLangDTO saveLanguage(SoftwareLangDTO langDTO) {
        SoftwareLang language = modelMapper.map(langDTO, SoftwareLang.class);
        isSoftwareLangNameExist(language);

        return modelMapper.map(langRepository.save(language), SoftwareLangDTO.class);
    }

    @Override
    public SoftwareLangDTO updateLanguage(int id, SoftwareLangDTO langDTO) {
        SoftwareLang resultLanguage = langRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException(String.format(MessageConstant.NOT_FOUND_ID_MESSAGE, id));
        });

        isSoftwareLangNameExist(modelMapper.map(langDTO, SoftwareLang.class));

        resultLanguage.setLangName(langDTO.getLangName());
        return modelMapper.map(langRepository.save(resultLanguage), SoftwareLangDTO.class);
    }

    @Override
    public void deleteLanguage(int id) {
        SoftwareLang resultLanguage = langRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException(String.format(MessageConstant.NOT_FOUND_ID_MESSAGE, id));
        });

        langRepository.delete(resultLanguage);
    }

    public void isSoftwareLangNameExist(SoftwareLang lang) {
        getAllLanguage().stream().filter(language -> language.getLangName().equalsIgnoreCase(lang.getLangName())).findFirst()
                .ifPresent(language -> {
                    throw new RuntimeException(String.format(MessageConstant.NAME_EXIST_MESSAGE, lang.getLangName()));
                });
    }
}
