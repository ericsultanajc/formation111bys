package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

public class Salle {
	private String nom;
	private Integer capacite;
	private Adresse adresse;
	private List<Module> modules = new ArrayList<Module>();

	public Salle(String nom, Integer capacite) {
		super();
		this.nom = nom;
		this.capacite = capacite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(Integer capacite) {
		this.capacite = capacite;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

}
