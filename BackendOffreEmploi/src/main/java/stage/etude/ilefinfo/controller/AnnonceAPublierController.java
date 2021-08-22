package stage.etude.ilefinfo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import stage.etude.ilefinfo.exception.RessourceNotFoundException;
import stage.etude.ilefinfo.model.AnnonceAPublier;
import stage.etude.ilefinfo.model.Employee;
import stage.etude.ilefinfo.repository.AnnonceAPublierRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class AnnonceAPublierController {

	@Autowired
	private AnnonceAPublierRepository annonceRepository;

	@GetMapping("/annonces")
	public List<AnnonceAPublier> getAllAnnonces() {
		return annonceRepository.findAll();
	}

	@PostMapping("/annonces")
	public AnnonceAPublier createAnnonce(@RequestBody AnnonceAPublier annonce) {
		return annonceRepository.save(annonce);
	}

	@DeleteMapping("/annonces/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteAnnonce(@PathVariable Long id) {
		AnnonceAPublier annonce = annonceRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("annonce not exist with id: " + id));
		annonceRepository.delete(annonce);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	// get employee by id rest api
	@GetMapping("/annonces/{id}")
	public ResponseEntity<AnnonceAPublier> getAnnonceById(@PathVariable Long id) {
		AnnonceAPublier annonce = annonceRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFoundException("Annonce not exist with id :" + id));
		return ResponseEntity.ok(annonce);
	}
}
