package sopra.formation;

import org.junit.Assert;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;
import sopra.formation.model.Evaluation;
import sopra.formation.repository.IEvaluationRepository;

public class EvaluationRepositoryOldSchoolTest extends TestCase {

	public void testEvaluation() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		IEvaluationRepository evaluationRepo = context.getBean(IEvaluationRepository.class);

		int startNumber = evaluationRepo.findAll().size();

		Evaluation evalSylvain = new Evaluation(12, 15, "pas tout le temps clair");

		evalSylvain = evaluationRepo.save(evalSylvain);

		Evaluation evalSylvainFind = evaluationRepo.find(evalSylvain.getId());

		Assert.assertEquals((Integer) 12, evalSylvainFind.getComportementale());
		Assert.assertEquals((Integer) 15, evalSylvainFind.getTechnique());
		Assert.assertEquals("pas tout le temps clair", evalSylvainFind.getCommentaires());

		evalSylvain.setComportementale(16);
		evalSylvain.setTechnique(5);
		evalSylvain.setCommentaires("commence à exprimer sa ralure");

		evalSylvain = evaluationRepo.save(evalSylvain);

		evalSylvainFind = evaluationRepo.find(evalSylvain.getId());

		Assert.assertEquals((Integer) 16, evalSylvainFind.getComportementale());
		Assert.assertEquals((Integer) 5, evalSylvainFind.getTechnique());
		Assert.assertEquals("commence à exprimer sa ralure", evalSylvainFind.getCommentaires());

		int middleNumber = evaluationRepo.findAll().size();

		Assert.assertEquals(1,middleNumber - startNumber);

		evaluationRepo.delete(evalSylvain);

		evalSylvainFind = evaluationRepo.find(evalSylvain.getId());

		Assert.assertNull(evalSylvainFind);
		
//		if(evalSylvainFind != null) {
//			Assert.fail("Suppression en erreur");
//		}

		context.close();
	}

}
