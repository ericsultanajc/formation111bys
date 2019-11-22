package sopra.formation.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sopra.formation.model.Adresse;
import sopra.formation.model.Evaluation;
import sopra.formation.model.NiveauEtude;
import sopra.formation.model.Stagiaire;
import sopra.formation.repository.IEvaluationRepository;
import sopra.formation.repository.IPersonneRepository;

@Controller
@RequestMapping("/stagiaire")
public class StagiaireController {
	@Autowired
	private IEvaluationRepository evaluationRepo;

	@Autowired
	private IPersonneRepository personneRepo;

	public StagiaireController() {
		super();
	}

	@GetMapping({ "", "/list" })
	public String list(Model model) {
		List<Stagiaire> stagiaires = personneRepo.findAllStagiaire();

		model.addAttribute("stagiaires", stagiaires);

		return "stagiaire/list";
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("niveauEtudes", NiveauEtude.values());
		model.addAttribute("stagiaire", new Stagiaire());

		model.addAttribute("evaluations", evaluationRepo.findAllOrphan());

		return "stagiaire/form";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam("id") Long idEval, Model model) {
		model.addAttribute("stagiaire", personneRepo.findById(idEval).get());
		model.addAttribute("niveauEtudes", NiveauEtude.values());

		model.addAttribute("evaluations", evaluationRepo.findAllOrphanAndCurrentStagiaire(idEval));

		return "stagiaire/form";
	}

	@PostMapping("/save")
	public String save(@RequestParam Long id, @RequestParam int version, @RequestParam String nom,
			@RequestParam String prenom, @RequestParam String email, @RequestParam String telephone,
			@RequestParam String rue, @RequestParam String complement, @RequestParam String codePostal,
			@RequestParam String ville, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dtNaissance,
			@RequestParam NiveauEtude niveauEtude, @RequestParam("evaluation") Long idEvaluation) {

		Stagiaire stagiaire = null;
		stagiaire = new Stagiaire(id, version, nom, prenom, email, telephone,
				new Adresse(rue, complement, codePostal, ville), dtNaissance, niveauEtude);
		stagiaire.setVersion(version);

		Evaluation evaluation = evaluationRepo.findById(idEvaluation).get();
		stagiaire.setEvaluation(evaluation);

		personneRepo.save(stagiaire);

		return "redirect:/stagiaire/list";
	}

	@GetMapping("/cancel")
	public String cancel() {
		return "forward:/stagiaire/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") Long idEval, Model model) {
		personneRepo.deleteById(idEval);

		return list(model);
	}
}
