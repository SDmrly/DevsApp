package kodlama.io.DevsApp.business.abstracts;

import kodlama.io.DevsApp.entities.concretes.SoftwareLang;

import java.util.List;

public interface SoftwareLangService {
    List<SoftwareLang> getAll();
    SoftwareLang save(SoftwareLang lang) throws Exception;
    SoftwareLang getById(int id) throws Exception;
    SoftwareLang update(int id, SoftwareLang lang) throws Exception;
    void delete(int id) throws Exception;
}
