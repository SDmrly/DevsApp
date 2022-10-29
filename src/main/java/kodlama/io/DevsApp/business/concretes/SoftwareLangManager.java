package kodlama.io.DevsApp.business.concretes;

import kodlama.io.DevsApp.business.abstracts.SoftwareLangService;
import kodlama.io.DevsApp.dataAccess.abstracts.SoftwareLangRepository;
import kodlama.io.DevsApp.entities.concretes.SoftwareLang;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class SoftwareLangManager implements SoftwareLangService {
    @Inject
    SoftwareLangRepository langRepository;

    @Override
    public List<SoftwareLang> getAll() {
        return langRepository.getAll();
    }

    @Override
    public SoftwareLang save(SoftwareLang lang) throws Exception {
        isSoftwareLangIDExist(lang);
        isSoftwareLangNameExist(lang);

        if (lang.getLangName().isEmpty() || lang.getLangName().isBlank()) {
            throw new RuntimeException("İsim alanı boş olamaz!");
        }
        return langRepository.save(lang);
    }

    @Override
    public SoftwareLang getById(int id) throws Exception {
        return langRepository.getById(id);
    }

    @Override
    public SoftwareLang update(int id, SoftwareLang lang) throws Exception {
        isSoftwareLangNameExist(lang);
        if (lang.getLangName().isEmpty() || lang.getLangName().isBlank()) {
            throw new RuntimeException("İsim alanı boş olamaz!");
        }

        int index = getAll().indexOf(getById(id));
        return langRepository.update(index, lang);

    }

    @Override
    public void delete(int id) throws Exception {
         langRepository.delete(id);
    }

    public void isSoftwareLangIDExist(SoftwareLang lang) {
        getAll().stream().filter(language -> language.getLangId() == lang.getLangId())
                .findFirst().ifPresent(language -> {
                    throw new RuntimeException("ID kullanılmaktadır!");
                });
    }

    public void isSoftwareLangNameExist(SoftwareLang lang) {
        getAll().stream().filter(language -> language.getLangName().equalsIgnoreCase(lang.getLangName())).findFirst()
                .ifPresent(language -> {
                    throw new RuntimeException("Isim kullanılmaktadır!");
                });
    }
}
