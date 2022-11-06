package kodlama.io.DevsApp.business.concretes;

import kodlama.io.DevsApp.business.abstracts.SoftwareTechnologyService;
import kodlama.io.DevsApp.common.MessageConstant;
import kodlama.io.DevsApp.dataAccess.abstracts.SoftwareLangRepository;
import kodlama.io.DevsApp.dataAccess.abstracts.SoftwareTechnologyRepository;
import kodlama.io.DevsApp.dataAccess.dtos.SoftwareTechnologyCreateDTO;
import kodlama.io.DevsApp.dataAccess.dtos.SoftwareTechnologyDTO;
import kodlama.io.DevsApp.entities.concretes.SoftwareLang;
import kodlama.io.DevsApp.entities.concretes.SoftwareTechnology;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SoftwareTechnologyManager implements SoftwareTechnologyService {
    @Inject
    private SoftwareTechnologyRepository technologyRepository;

    @Inject
    private SoftwareLangRepository langRepository;

    @Inject
    private ModelMapper modelMapper;

    @Override
    public List<SoftwareTechnologyDTO> getAllTechnology() {
        return technologyRepository.findAll().stream().map(techno -> modelMapper.map(techno, SoftwareTechnologyDTO.class)).collect(Collectors.toList());
    }

    @Override
    public SoftwareTechnologyDTO getByTechnologyID(int id) {
        return technologyRepository.findById(id).map(technology -> modelMapper.map(technology, SoftwareTechnologyDTO.class)).orElseThrow(() -> {
            throw new RuntimeException(String.format(MessageConstant.NOT_FOUND_ID_MESSAGE, id));
        });
    }

    @Override
    public SoftwareTechnologyCreateDTO saveTechnology(SoftwareTechnologyCreateDTO createDTO) {
        SoftwareTechnology technology = modelMapper.map(createDTO, SoftwareTechnology.class);
        isSoftwareTechnologyNameExist(technology);

        SoftwareLang lang = langRepository.findById(createDTO.getLangId()).orElseThrow(() -> {
            throw new RuntimeException(String.format(MessageConstant.NOT_FOUND_ID_MESSAGE, createDTO.getLangId()));
        });

        technology.setSoftwareLang(lang);
        technologyRepository.save(technology);
        return createDTO;
    }

    @Override
    public SoftwareTechnologyDTO updateTechnology(int id, SoftwareTechnologyDTO technologyDTO) {
        SoftwareTechnology resultTechnology = technologyRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException(String.format(MessageConstant.NOT_FOUND_ID_MESSAGE, id));
        });

        isSoftwareTechnologyNameExist(modelMapper.map(technologyDTO, SoftwareTechnology.class));
        resultTechnology.setTechnologyName(technologyDTO.getTechnologyName());

        return modelMapper.map(technologyRepository.save(resultTechnology), SoftwareTechnologyDTO.class);
    }

    @Override
    public void deleteTechnology(int id) {
        SoftwareTechnology resultTechnology = technologyRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException(String.format(MessageConstant.NOT_FOUND_ID_MESSAGE, id));
        });

        technologyRepository.delete(resultTechnology);
    }

    public void isSoftwareTechnologyNameExist(SoftwareTechnology softwareTechnology) {
        getAllTechnology().stream().filter(technology -> technology.getTechnologyName().equalsIgnoreCase(softwareTechnology.getTechnologyName())).findFirst()
                .ifPresent(technology -> {
                    throw new RuntimeException(String.format(MessageConstant.NAME_EXIST_MESSAGE, softwareTechnology.getTechnologyName()));
                });
    }
}
