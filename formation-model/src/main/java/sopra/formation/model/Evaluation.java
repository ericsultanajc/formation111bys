package sopra.formation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rating")
public class Evaluation {
	@Id
	@GeneratedValue
	private Long id;
	private Integer comportementale;
	private Integer technique;
	private String commentaires;
	private Stagiaire stagiaire;

	public Evaluation() {
		super();
	}

	public Evaluation(Integer comportementale, Integer technique, String commentaires) {
		super();
		this.comportementale = comportementale;
		this.technique = technique;
		this.commentaires = commentaires;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getComportementale() {
		return comportementale;
	}

	public void setComportementale(Integer comportementale) {
		this.comportementale = comportementale;
	}

	public Integer getTechnique() {
		return technique;
	}

	public void setTechnique(Integer technique) {
		this.technique = technique;
	}

	public String getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}

	public Stagiaire getStagiaire() {
		return stagiaire;
	}

	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}

}
