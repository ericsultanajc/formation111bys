package sopra.formation;

import sopra.formation.model.Evaluation;
import sopra.formation.repository.IEvaluationRepository;

public class TestJpaWithRepo {

	public static void main(String[] args) {
		IEvaluationRepository evaluationRepo = Application.getInstance().getEvaluationRepo();
		
		int startNumber = evaluationRepo.findAll().size();

		Evaluation evalSylvain = new Evaluation(12, 15, "pas tout le temps clair");

		evalSylvain = evaluationRepo.save(evalSylvain);

		Evaluation evalSylvainFind = evaluationRepo.find(evalSylvain.getId());

		System.out.println(evalSylvainFind.getComportementale());
		System.out.println(evalSylvainFind.getTechnique());
		System.out.println(evalSylvainFind.getCommentaires());

		evalSylvain.setComportementale(16);
		evalSylvain.setTechnique(5);
		evalSylvain.setCommentaires("commence à exprimer sa ralure");

		evalSylvain = evaluationRepo.save(evalSylvain);

		evalSylvainFind = evaluationRepo.find(evalSylvain.getId());

		System.out.println(evalSylvainFind.getComportementale());
		System.out.println(evalSylvainFind.getTechnique());
		System.out.println(evalSylvainFind.getCommentaires());
		
		int middleNumber = evaluationRepo.findAll().size();
	
		System.out.println(middleNumber - startNumber);
		
		evaluationRepo.delete(evalSylvain);
		
		evalSylvainFind = evaluationRepo.find(evalSylvain.getId());

		System.out.println(evalSylvainFind==null);

	}

}
