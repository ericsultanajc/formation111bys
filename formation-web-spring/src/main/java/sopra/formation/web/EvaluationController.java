package sopra.formation.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sopra.formation.model.Evaluation;
import sopra.formation.repository.IEvaluationRepository;

@Controller
@RequestMapping("/evaluation")
public class EvaluationController {
	@Autowired
	private IEvaluationRepository evaluationRepo;

	public EvaluationController() {
		super();
	}

	@GetMapping("/list")
	public String list(Model model) {
		List<Evaluation> evaluations = evaluationRepo.findAll();

		model.addAttribute("mesEvaluations", evaluations);

		return "evaluation/list";
	}

	@GetMapping("/add")
	public String add(Model model) {
//		Pour initialiser le formulaire avec des données par défaut (ex : version = 0)
		model.addAttribute("monEvaluation", new Evaluation());
		
		return "evaluation/form";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam("id") Long idEval, Model model) {
		model.addAttribute("monEvaluation", evaluationRepo.findById(idEval).get());

		return "evaluation/form";
	}

	@PostMapping("/save")
	public String save(@RequestParam Long id, @RequestParam int version, @RequestParam Integer comportementale,
			@RequestParam Integer technique, @RequestParam String commentaires) {

		Evaluation evaluation = new Evaluation(id, comportementale, technique, commentaires);
		evaluation.setVersion(version);

		evaluationRepo.save(evaluation);

		return "redirect:/evaluation/list";
	}

	@GetMapping("/cancel")
	public String cancel() {
		return "forward:/evaluation/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") Long idEval, Model model) {
		evaluationRepo.deleteById(idEval);

		return list(model);
	}
}
