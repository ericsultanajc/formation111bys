package sopra.formation.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import sopra.formation.model.Adresse;
import sopra.formation.model.Evaluation;
import sopra.formation.model.NiveauEtude;
import sopra.formation.model.Stagiaire;
import sopra.formation.repository.IEvaluationRepository;
import sopra.formation.repository.IPersonneRepository;

@WebServlet("/stagiaire")
public class StagiaireController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IEvaluationRepository evaluationRepo;
	private IPersonneRepository personneRepo;

	public StagiaireController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ClassPathXmlApplicationContext springContext = (ClassPathXmlApplicationContext) getServletContext()
				.getAttribute("springContext");
		evaluationRepo = springContext.getBean(IEvaluationRepository.class);
		personneRepo = springContext.getBean(IPersonneRepository.class);
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
		request.setAttribute("stagiaires", personneRepo.findAllStagiaire());

		request.getRequestDispatcher("/WEB-INF/views/stagiaire/list.jsp").forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("niveauEtudes", NiveauEtude.values());
		request.setAttribute("evaluations", evaluationRepo.findAllOrphan());

		request.getRequestDispatcher("/WEB-INF/views/stagiaire/form.jsp").forward(request, response);
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.valueOf(request.getParameter("id"));

		request.setAttribute("niveauEtudes", NiveauEtude.values());
		request.setAttribute("evaluations", evaluationRepo.findAllOrphanAndCurrentStagiaire(id));
		request.setAttribute("stagiaire", personneRepo.findById(id).get());

		request.getRequestDispatcher("/WEB-INF/views/stagiaire/form.jsp").forward(request, response);
	}

	private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Long id = (request.getParameter("id") != null && request.getParameter("id").length() > 0)
				? Long.valueOf(request.getParameter("id"))
				: null;
		Integer version = (request.getParameter("version") != null && request.getParameter("version").length() > 0)
				? Integer.valueOf(request.getParameter("version"))
				: 0;
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");

		String telephone = request.getParameter("telephone");
		Date dtNaissance = null;
		try {
			dtNaissance = request.getParameter("dtNaissance") != null
					&& request.getParameter("dtNaissance").length() == 10
							? sdf.parse(request.getParameter("dtNaissance"))
							: null;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		NiveauEtude niveauEtude = (request.getParameter("niveauEtude") != null
				&& !request.getParameter("niveauEtude").isEmpty())
						? NiveauEtude.valueOf(request.getParameter("niveauEtude"))
						: null;

		String rue = request.getParameter("rue");
		String complement = request.getParameter("complement");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		
		Long evaluationId = (request.getParameter("evaluation") != null && request.getParameter("evaluation").length() > 0)
				? Long.valueOf(request.getParameter("evaluation"))
				: null;
				
		Evaluation evaluation = new Evaluation();
		evaluation.setId(evaluationId);

		Stagiaire stagiaire = new Stagiaire(id, version, nom, prenom, email, telephone,
				new Adresse(rue, complement, codePostal, ville), dtNaissance, niveauEtude);
		
		stagiaire.setEvaluation(evaluation);

		personneRepo.save(stagiaire);

		request.getRequestDispatcher("/stagiaire?mode=list").forward(request, response);
	}

	private void cancel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("stagiaire?mode=list");
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.valueOf(request.getParameter("id"));

		personneRepo.deleteById(id);

		request.getRequestDispatcher("/stagiaire?mode=list").forward(request, response);
	}
}
