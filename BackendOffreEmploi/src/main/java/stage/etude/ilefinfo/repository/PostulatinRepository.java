package stage.etude.ilefinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import stage.etude.ilefinfo.model.PostulationModel;
@Repository
public interface PostulatinRepository extends JpaRepository<PostulationModel, Long>{

}
