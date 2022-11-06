package kodlama.io.DevsApp.dataAccess.abstracts;

import kodlama.io.DevsApp.entities.concretes.SoftwareTechnology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoftwareTechnologyRepository extends JpaRepository<SoftwareTechnology, Integer> {
}
