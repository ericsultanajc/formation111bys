package sopra.formation.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue("trainee")
public class Stagiaire extends Personne {
	@Temporal(TemporalType.DATE)
	@Column(name = "birthdate")
	private Date dtNaissance;
	@Enumerated(EnumType.STRING)
	@Column(name = "studylevel")
	private NiveauEtude niveauEtude;
	@ManyToOne
	@JoinColumn(name = "training_id")
	private Filiere filiere;
	@OneToOne
	@JoinColumn(name = "rating_id")
	private Evaluation evaluation;

	public Stagiaire() {
		super();
	}

	public Stagiaire(String nom, String prenom) {
		super(nom, prenom);
	}

	public Date getDtNaissance() {
		return dtNaissance;
	}

	public void setDtNaissance(Date dtNaissance) {
		this.dtNaissance = dtNaissance;
	}

	public NiveauEtude getNiveauEtude() {
		return niveauEtude;
	}

	public void setNiveauEtude(NiveauEtude niveauEtude) {
		this.niveauEtude = niveauEtude;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	public Evaluation getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}

}
