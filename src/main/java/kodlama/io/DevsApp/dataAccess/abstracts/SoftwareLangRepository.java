package kodlama.io.DevsApp.dataAccess.abstracts;

import kodlama.io.DevsApp.entities.concretes.SoftwareLang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoftwareLangRepository extends JpaRepository<SoftwareLang, Integer> {

}
