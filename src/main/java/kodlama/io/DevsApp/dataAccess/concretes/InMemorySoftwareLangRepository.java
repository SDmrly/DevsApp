package kodlama.io.DevsApp.dataAccess.concretes;

import kodlama.io.DevsApp.dataAccess.abstracts.SoftwareLangRepository;
import kodlama.io.DevsApp.entities.concretes.SoftwareLang;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemorySoftwareLangRepository implements SoftwareLangRepository {
    List<SoftwareLang> langs;

    public InMemorySoftwareLangRepository() {
       langs = new ArrayList<>();

       langs.add(new SoftwareLang(1, "Java"));
       langs.add(new SoftwareLang(2, "GoLang"));

    }

    @Override
    public List<SoftwareLang> getAll() {
        return langs;
    }

    @Override
    public SoftwareLang save(SoftwareLang language) {
        langs.add(language);
        return language;
    }

    @Override
    public SoftwareLang getById(int id) {
        return langs.stream().filter(lang -> lang.getLangId() == id).findFirst().orElseThrow(() -> new RuntimeException("Kayıt Bulunamadı!"));
    }

    @Override
    public SoftwareLang update(int index, SoftwareLang lang) {
        langs.set(index, lang);
        return lang;
    }

    @Override
    public void delete(int id) {
        SoftwareLang lang = getById(id);
        langs.remove(lang);
    }
}
