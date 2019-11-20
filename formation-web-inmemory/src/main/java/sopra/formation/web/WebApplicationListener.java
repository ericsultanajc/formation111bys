package sopra.formation.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import sopra.formation.model.Evaluation;

@WebListener
public class WebApplicationListener implements ServletContextListener {

	public WebApplicationListener() {
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}

	public void contextInitialized(ServletContextEvent sce) {
		List<Evaluation> evaluations = new ArrayList<Evaluation>();
		evaluations.add(new Evaluation(1L, 15, 12, "Sensible"));
		evaluations.add(new Evaluation(2L, 18, 17, "Bienveillant"));
		evaluations.add(new Evaluation(3L, 7, 12, "Malveillant"));

		sce.getServletContext().setAttribute("evaluations", evaluations);
	}

}
