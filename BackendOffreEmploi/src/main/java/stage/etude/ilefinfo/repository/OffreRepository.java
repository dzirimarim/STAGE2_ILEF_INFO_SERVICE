package stage.etude.ilefinfo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import stage.etude.ilefinfo.model.OffreModel;
@Repository
public interface OffreRepository extends JpaRepository<OffreModel, Long>{
	List<OffreModel> findByLabelContaining(String label);
	List<OffreModel> findByLabelContainingAndLienContaining(String label , String lien); 
	List<OffreModel> findByLabelContainingAndLienContainingAndTexteContaining(String label , String lien , String texte); 

}
