package sopra.formation.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sopra.formation.model.Evaluation;

@WebServlet("/evaluation")
public class EvaluationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EvaluationController() {
		super();
	}

	// ETAPE 1 : Réception de la Request par le Controller
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mode = request.getParameter("mode");

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
		List<Evaluation> evaluations = (List<Evaluation>) request.getServletContext().getAttribute("evaluations");

		// ETAPE 3 : Remplir le Model
		request.setAttribute("mesEvaluations", evaluations);

		// ETAPE 4 : Appel de la View
		request.getRequestDispatcher("/WEB-INF/views/evaluation/list.jsp").forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/evaluation/form.jsp").forward(request, response);
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.valueOf(request.getParameter("id"));

		List<Evaluation> evaluations = (List<Evaluation>) request.getServletContext().getAttribute("evaluations");

		for (Evaluation evaluation : evaluations) {
			if (evaluation.getId() == id) {
				request.setAttribute("monEvaluation", evaluation);
				break;
			}
		}

		request.getRequestDispatcher("/WEB-INF/views/evaluation/form.jsp").forward(request, response);
	}

	private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.valueOf(request.getParameter("id"));
		Integer comportementale = Integer.valueOf(request.getParameter("comportementale"));
		Integer technique = Integer.valueOf(request.getParameter("technique"));
		String commentaires = request.getParameter("commentaires");
		
		List<Evaluation> evaluations = (List<Evaluation>) request.getServletContext().getAttribute("evaluations");
		
		int indice;

		boolean find = false;

		for (indice = 0; indice < evaluations.size(); indice++) {
			Evaluation evaluation = evaluations.get(indice);

			if (evaluation.getId() == id) {
				find = true;
				break;
			}
		}
		
		Evaluation evaluation = new Evaluation(id, comportementale, technique, commentaires);
		
		if(find) {
			evaluations.set(indice, evaluation);
		} else {
			evaluations.add(evaluation);
		}

		list(request, response);
	}

	private void cancel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		list(request, response); 1ère solution
//		request.getRequestDispatcher("/evaluation?mode=list").forward(request, response); 2ème solution
		response.sendRedirect("evaluation?mode=list"); // 3ème solution par redirection du navigateur
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.valueOf(request.getParameter("id"));

		List<Evaluation> evaluations = (List<Evaluation>) request.getServletContext().getAttribute("evaluations");

		int indice;

		boolean find = false;

		for (indice = 0; indice < evaluations.size(); indice++) {
			Evaluation evaluation = evaluations.get(indice);

			if (evaluation.getId() == id) {
				find = true;
				break;
			}
		}

		if (find) {
			evaluations.remove(indice);
		}
		
		request.getRequestDispatcher("/evaluation?mode=list").forward(request, response);
	}
}
