package sopra.formation.model;

import java.util.Date;

public class Stagiaire extends Personne {
	private Date dtNaissance;
	private NiveauEtude niveauEtude;
	private Filiere filiere;
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
