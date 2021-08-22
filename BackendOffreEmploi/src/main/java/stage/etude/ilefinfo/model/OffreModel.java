package stage.etude.ilefinfo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="offre_emploi")
public class OffreModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	
	@Column(name ="lien " )
	private String lien ;
	
	@Column(name="texte ")
	private String texte ;
	
	@Column(name = "label")
	private String label ;
	
	public OffreModel(long id, String lien, String texte, String label) {
		super();
		this.id = id;
		this.lien = lien;
		this.texte = texte;
		this.label = label;
	}
 
	public OffreModel() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLien() {
		return lien;
	}

	public void setLien(String lien) {
		this.lien = lien;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
    	

}
