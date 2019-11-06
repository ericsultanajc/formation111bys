package sopra.formation.model;

public class Module {
	private Integer code;
	private Integer duree;
	private Integer ordre;
	private Filiere filiere;
	private Formateur formateur;
	private Matiere matiere;
	private Salle salle;

	public Module(Integer code) {
		super();
		this.code = code;
	}

	public Module(Integer code, Integer duree, Integer ordre, Filiere filiere, Formateur formateur, Matiere matiere,
			Salle salle) {
		super();
		this.code = code;
		this.duree = duree;
		this.ordre = ordre;
		this.filiere = filiere;
		this.formateur = formateur;
		this.matiere = matiere;
		this.salle = salle;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public Integer getOrdre() {
		return ordre;
	}

	public void setOrdre(Integer ordre) {
		this.ordre = ordre;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

}
