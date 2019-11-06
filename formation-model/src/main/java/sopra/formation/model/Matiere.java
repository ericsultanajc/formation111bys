package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class Matiere {
	@Id
	@Column(name = "name")
	private String nom;
	@Enumerated(EnumType.STRING)
	private NiveauMatiere niveau;
	private Integer duree;
	private String preRequis;
	private String objectifs;
	private String programme;
	@ManyToMany(mappedBy = "competences")
	private List<Formateur> formateurs = new ArrayList<Formateur>();

	public Matiere(String nom, NiveauMatiere niveau, Integer duree) {
		super();
		this.nom = nom;
		this.niveau = niveau;
		this.duree = duree;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public NiveauMatiere getNiveau() {
		return niveau;
	}

	public void setNiveau(NiveauMatiere niveau) {
		this.niveau = niveau;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public String getPreRequis() {
		return preRequis;
	}

	public void setPreRequis(String preRequis) {
		this.preRequis = preRequis;
	}

	public String getObjectifs() {
		return objectifs;
	}

	public void setObjectifs(String objectifs) {
		this.objectifs = objectifs;
	}

	public String getProgramme() {
		return programme;
	}

	public void setProgramme(String programme) {
		this.programme = programme;
	}

	public List<Formateur> getFormateurs() {
		return formateurs;
	}

	public void setFormateurs(List<Formateur> formateurs) {
		this.formateurs = formateurs;
	}

}
