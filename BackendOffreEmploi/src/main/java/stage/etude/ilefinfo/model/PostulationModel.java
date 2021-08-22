package stage.etude.ilefinfo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Postulation")
public class PostulationModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	
	@Column(name ="Email " )
	private String email ;
	
	@Column(name="nomPrenom")
	private String nomPrenom ;
	
	@Column(name = "lettreMotiv")
	private String lettreMotiv ;
	
	@Column(name = "id_Prop")
	private String id_Prop ;

	public PostulationModel(String email, String nomPrenom, String lettreMotiv, String id_Prop) {
		super();
		this.email = email;
		this.nomPrenom = nomPrenom;
		this.lettreMotiv = lettreMotiv;
		this.id_Prop = id_Prop;
	}

	public PostulationModel() {

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

	public String getLettreMotiv() {
		return lettreMotiv;
	}

	public void setLettreMotiv(String lettreMotiv) {
		this.lettreMotiv = lettreMotiv;
	}

	public String getId_Prop() {
		return id_Prop;
	}

	public void setId_Prop(String id_Prop) {
		this.id_Prop = id_Prop;
	}
	
	
	

	
	


}
