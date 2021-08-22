package stage.etude.ilefinfo.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "annonces")
public class AnnonceAPublier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "email")
	private String email;

	@Column(name = "nomPrenom ")
	private String nomPrenom;

	@Column(name = "nomEntreprise ")
	private String nomEntreprise;

	@Column(name = "siteWeb ")
	private String siteWeb;

	@Column(name = "password ")
	private String password;

	@Column(name = "téléphone ")
	private String telephone;

	@Column(name = "adresse ")
	private String adresse;

	@Column(name = "description ")
	private String description;

	@Column(name = "isAccepted ")
	private boolean isAccepted;



	public AnnonceAPublier(long id, String email, String nomPrenom, String nomEntreprise, String siteWeb,
			String password, String telephone, String adresse, String description, boolean isAccepted) {
		super();
		this.id = id;
		this.email = email;
		this.nomPrenom = nomPrenom;
		this.nomEntreprise = nomEntreprise;
		this.siteWeb = siteWeb;
		this.password = password;
		this.telephone = telephone;
		this.adresse = adresse;
		this.description = description;
		this.isAccepted = isAccepted;

	}


	public AnnonceAPublier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomPrenom() {
		return nomPrenom;
	}

	public void setNomPrenom(String nomPrenom) {
		this.nomPrenom = nomPrenom;
	}

	public String getNomEntreprise() {
		return nomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}

	public String getSiteWeb() {
		return siteWeb;
	}

	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isAccepted() {
		return isAccepted;
	}

	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}

}
