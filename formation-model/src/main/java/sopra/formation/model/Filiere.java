package sopra.formation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="training")
public class Filiere {
	@Id
	@GeneratedValue
	private Long id;
	private String intitule;
	private String promotion;
	private Date dtDebut;
	private Integer duree;
	private Dispositif dispositif;
	@Transient
	private List<Module> modules = new ArrayList<Module>();
	@Transient
	private List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();
	@ManyToOne
	@JoinColumn(name="referent_id")
	private Formateur referent;

	public Filiere() {
		super();
	}

	public Filiere(String intitule, Date dtDebut) {
		super();
		this.intitule = intitule;
		this.dtDebut = dtDebut;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getPromotion() {
		return promotion;
	}

	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}

	public Date getDtDebut() {
		return dtDebut;
	}

	public void setDtDebut(Date dtDebut) {
		this.dtDebut = dtDebut;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public Dispositif getDispositif() {
		return dispositif;
	}

	public void setDispositif(Dispositif dispositif) {
		this.dispositif = dispositif;
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public List<Stagiaire> getStagiaires() {
		return stagiaires;
	}

	public void setStagiaires(List<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}

	public Formateur getReferent() {
		return referent;
	}

	public void setReferent(Formateur referent) {
		this.referent = referent;
	}

	@Override
	public String toString() {
		return "Filiere [id=" + id + ", intitule=" + intitule + ", promotion=" + promotion + ", dtDebut=" + dtDebut
				+ ", duree=" + duree + ", dispositif=" + dispositif + "]";
	}

}
