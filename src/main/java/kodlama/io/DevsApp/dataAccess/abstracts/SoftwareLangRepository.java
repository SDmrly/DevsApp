package kodlama.io.DevsApp.dataAccess.abstracts;

import kodlama.io.DevsApp.entities.concretes.SoftwareLang;

import java.util.List;

public interface SoftwareLangRepository {
    List<SoftwareLang> getAll();
    SoftwareLang save(SoftwareLang lang) throws Exception;
    SoftwareLang getById(int id) throws Exception;
    SoftwareLang update(int index, SoftwareLang lang);
    void delete(int id) throws Exception;
}
