package sopra.formation.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.support.ClassPathXmlApplicationContext;

@WebListener
public class WebApplicationListener implements ServletContextListener {

	public WebApplicationListener() {
	}

	public void contextDestroyed(ServletContextEvent sce) {
		ClassPathXmlApplicationContext springContext = (ClassPathXmlApplicationContext) sce.getServletContext().getAttribute("springContext");
		
		springContext.close();
	}

	public void contextInitialized(ServletContextEvent sce) {
		ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("classpath:application-context.xml");
	
		sce.getServletContext().setAttribute("springContext", springContext);
	}

}
