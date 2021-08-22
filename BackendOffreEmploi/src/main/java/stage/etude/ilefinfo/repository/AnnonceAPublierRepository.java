package stage.etude.ilefinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import stage.etude.ilefinfo.model.AnnonceAPublier;


@Repository
public interface AnnonceAPublierRepository extends JpaRepository<AnnonceAPublier, Long> {

}
