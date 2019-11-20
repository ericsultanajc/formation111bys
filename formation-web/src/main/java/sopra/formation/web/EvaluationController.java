package sopra.formation.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sopra.formation.model.Evaluation;
import sopra.formation.repository.IEvaluationRepository;

@WebServlet("/evaluation")
public class EvaluationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IEvaluationRepository evaluationRepo;
	
	public EvaluationController() {
		super();
	}
	
	public void init(ServletConfig config) throws ServletException {
	    super.init(config);
		ClassPathXmlApplicationContext springContext = (ClassPathXmlApplicationContext) getServletContext()
				.getAttribute("springContext");
		evaluationRepo = springContext.getBean(IEvaluationRepository.class);
	  }

	// ETAPE 1 : Réception de la Request par le Controller
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mode = request.getParameter("mode") != null ? request.getParameter("mode") : "list";

		if (mode.contentEquals("list")) {
			list(request, response);
		} else if (mode.contentEquals("add")) {
			add(request, response);
		} else if (mode.contentEquals("edit")) {
			edit(request, response);
		} else if (mode.contentEquals("save")) {
			save(request, response);
		} else if (mode.contentEquals("cancel")) {
			cancel(request, response);
		} else if (mode.contentEquals("delete")) {
			delete(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ETAPE 2 : Récupération des données

		// ETAPE 3 : Remplir le Model
		request.setAttribute("mesEvaluations", evaluationRepo.findAll());

		// ETAPE 4 : Appel de la View
		request.getRequestDispatcher("/WEB-INF/views/evaluation/list.jsp").forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/evaluation/form.jsp").forward(request, response);
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.valueOf(request.getParameter("id"));

		request.setAttribute("monEvaluation", evaluationRepo.findById(id).get());

		request.getRequestDispatcher("/WEB-INF/views/evaluation/form.jsp").forward(request, response);
	}

	private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = (request.getParameter("id") != null && request.getParameter("id").length() > 0)
				? Long.valueOf(request.getParameter("id"))
				: null;
		Integer version = Integer.valueOf(request.getParameter("version"));
		Integer comportementale = Integer.valueOf(request.getParameter("comportementale"));
		Integer technique = Integer.valueOf(request.getParameter("technique"));
		String commentaires = request.getParameter("commentaires");

		Evaluation evaluation = new Evaluation(id, comportementale, technique, commentaires);
		evaluation.setVersion(version);

		evaluationRepo.save(evaluation);

		request.getRequestDispatcher("/evaluation?mode=list").forward(request, response); 
	}

	private void cancel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		list(request, response); 1ère solution
//		request.getRequestDispatcher("/evaluation?mode=list").forward(request, response); 2ème solution
		response.sendRedirect("evaluation?mode=list"); // 3ème solution par redirection du navigateur
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.valueOf(request.getParameter("id"));

		evaluationRepo.deleteById(id);

		request.getRequestDispatcher("/evaluation?mode=list").forward(request, response);
	}
}
