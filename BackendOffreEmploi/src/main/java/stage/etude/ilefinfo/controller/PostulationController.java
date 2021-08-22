package stage.etude.ilefinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import stage.etude.ilefinfo.exception.RessourceNotFoundException;
import stage.etude.ilefinfo.model.PostulationModel;
import stage.etude.ilefinfo.repository.PostulatinRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class PostulationController {
	
	@Autowired
	private PostulatinRepository postulationRepository ;
	
	@GetMapping("/postulations")
	public List<PostulationModel> getAllOffres(){
		return postulationRepository.findAll(); 
	}
	
	//create employee rest api
	@PostMapping("/postulations")
	public PostulationModel createOffre(@RequestBody PostulationModel poste) {
		return postulationRepository.save(poste);
	}
	
	// get employee by id rest api 
	@GetMapping("postulations/{id}")
	public ResponseEntity<PostulationModel> getOffreById(@PathVariable Long id){
		PostulationModel post = postulationRepository.findById(id)
				 .orElseThrow(() -> new RessourceNotFoundException("Offre not exist with id :" + id));
		return ResponseEntity.ok(post);
	}
	

}
