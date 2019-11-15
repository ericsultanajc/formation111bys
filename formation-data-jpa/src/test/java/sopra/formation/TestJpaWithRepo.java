package sopra.formation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import sopra.formation.model.Evaluation;
import sopra.formation.model.Stagiaire;
import sopra.formation.repository.IEvaluationRepository;

public class TestJpaWithRepo {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		IEvaluationRepository evaluationRepo = Application.getInstance().getEvaluationRepo();
		
//		int startNumber = evaluationRepo.findAll().size();
//
//		Evaluation evalSylvain = new Evaluation(12, 15, "pas tout le temps clair");
//
//		evalSylvain = evaluationRepo.save(evalSylvain);
//
//		Evaluation evalSylvainFind = evaluationRepo.find(evalSylvain.getId());
//
//		System.out.println(evalSylvainFind.getComportementale());
//		System.out.println(evalSylvainFind.getTechnique());
//		System.out.println(evalSylvainFind.getCommentaires());
//
//		evalSylvain.setComportementale(16);
//		evalSylvain.setTechnique(5);
//		evalSylvain.setCommentaires("commence à exprimer sa ralure");
//
//		evalSylvain = evaluationRepo.save(evalSylvain);
//	
//		evalSylvainFind = evaluationRepo.find(evalSylvain.getId());
//
//		System.out.println(evalSylvainFind.getComportementale());
//		System.out.println(evalSylvainFind.getTechnique());
//		System.out.println(evalSylvainFind.getCommentaires());
//		
//		int middleNumber = evaluationRepo.findAll().size();
//	
//		System.out.println(middleNumber - startNumber);
//		
//		Stagiaire sylvain = new Stagiaire("HANSMETZGER", "Sylvain");
//
//		sylvain.setEvaluation(evalSylvain);
//
//		Application.getInstance().getPersonneRepo().save(sylvain);
		
//		evaluationRepo.delete(evalSylvain);
		
//		evalSylvainFind = evaluationRepo.find(evalSylvain.getId());
//
//		System.out.println(evalSylvainFind==null);
		
		List<Evaluation> evaluations = evaluationRepo.findAllByDtNaissance(sdf.parse("01/01/1991"));
	
		for(Evaluation evaluation : evaluations) {
			System.out.println(evaluation.getComportementale());
			
			System.out.println(evaluation.getStagiaire().getNom());
		}
	
	}

}
