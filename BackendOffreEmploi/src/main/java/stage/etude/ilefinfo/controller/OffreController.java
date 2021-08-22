package stage.etude.ilefinfo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import stage.etude.ilefinfo.exception.RessourceNotFoundException;
import stage.etude.ilefinfo.model.Employee;
import stage.etude.ilefinfo.model.OffreModel;
import stage.etude.ilefinfo.repository.OffreRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class OffreController {
	 @Autowired
		private OffreRepository offreRepository ;
		
		// get all employees
		
		@GetMapping("/offres")
		public List<OffreModel> getAllOffres(){
			return offreRepository.findAll(); 
		}
		
		//create employee rest api
		@PostMapping("/offres")
		public OffreModel createOffre(@RequestBody OffreModel offre) {
			return offreRepository.save(offre);
		}
		
		// get employee by id rest api 
		@GetMapping("offres/{id}")
		public ResponseEntity<OffreModel> getOffreById(@PathVariable Long id){
			OffreModel offre = offreRepository.findById(id)
					 .orElseThrow(() -> new RessourceNotFoundException("Offre not exist with id :" + id));
			return ResponseEntity.ok(offre);
		}

		
		@GetMapping("/offres/label")
		public ResponseEntity<List<OffreModel>> getOffreByLabel(@RequestParam String label) {
			return new ResponseEntity<List<OffreModel>>(offreRepository.findByLabelContaining(label), HttpStatus.OK);
		}
		
		/*****/
		@GetMapping("/offres/{label}/{lien}")
		public ResponseEntity<List<OffreModel>> getOffreByLabelAndLien(@PathVariable String label ,@PathVariable String lien) {
			return new ResponseEntity<List<OffreModel>>(offreRepository.findByLabelContainingAndLienContaining(label, lien) , HttpStatus.OK);
		}

		/****/
		@GetMapping("/offres/{label}/{lien}/{texte}")
		public ResponseEntity<List<OffreModel>> getOffreByLabelAndLienAndTexte(@PathVariable String label ,@PathVariable String lien , @PathVariable String texte) {
			return new ResponseEntity<List<OffreModel>>(offreRepository.findByLabelContainingAndLienContainingAndTexteContaining(label, lien , texte) , HttpStatus.OK);
		}

		/****/
		//update employee rest api 
		
		@PutMapping("/offres/{id}")
		public ResponseEntity<OffreModel> updateOffre(@PathVariable Long id ,@RequestBody OffreModel offreDetails ){
			OffreModel offre = offreRepository.findById(id)
					 .orElseThrow(() -> new RessourceNotFoundException("offre not exist with id  : " + id));
		    offre.setTexte(offreDetails.getTexte());
		    offre.setLien(offreDetails.getLien());
		    offre.setLabel(offreDetails.getLabel());
		    
		    OffreModel updatedoffre =  offreRepository.save(offre);
		    return ResponseEntity.ok(updatedoffre);
		}
		
		// delete employee rest api 
		@DeleteMapping("/offre/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
			OffreModel offre = offreRepository.findById(id)
					.orElseThrow(() -> new RessourceNotFoundException("employee not exist with id: " +id ) );
			offreRepository.delete(offre);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted" , Boolean.TRUE);
			return ResponseEntity.ok(response);
		}

}
