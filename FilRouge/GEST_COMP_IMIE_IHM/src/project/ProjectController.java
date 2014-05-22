package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import fr.imie.entity.projects.Project;
import fr.imie.services.ProjectServices;

/**
 * Servlet implementation class Project
 */
@WebServlet("/project/*")
public class ProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	@EJB
	ProjectServices projectService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pattern patternAll = Pattern.compile("project/json/all");
		Matcher matcherAll = patternAll.matcher(request.getRequestURL());
		
		Pattern pattern = Pattern.compile("project/json/([0-9]*)");
		Matcher matcher = pattern.matcher(request.getRequestURL());
		
		Pattern pattern2 = Pattern.compile("project/([0-9]*)");
		Matcher matcher2 = pattern2.matcher(request.getRequestURL());
		
		Pattern pattern3 = Pattern.compile("project/modale/");
		Matcher matcher3 = pattern3.matcher(request.getRequestURL());
		
		if (matcherAll.find()) {
			response.setContentType("application/json; charset=UTF-8");
			
			
			List<Project> projects = new ArrayList<Project>();
			
			
			projects=projectService.findAllProjectsWithOutMembers();
			
			

			
			PrintWriter writer = response.getWriter();
			Gson gson = new Gson();
			String json = gson.toJson(projects);
			writer.print(json);
		}
		else if (matcher.find()) {
			
			/*String json = gson.toJson(a);
			writer.print(json);*/
		}
		else if (matcher3.find())
		{
			ServletContext context= request.getServletContext();
			RequestDispatcher rd= context.getRequestDispatcher("/projectModale.jsp");
			rd.include(request, response);
		}
		else if (matcher2.find())
		{
			//Integer idUser = Integer.valueOf(matcher2.group(1));
			ServletContext context= request.getSession().getServletContext();
			RequestDispatcher rd= context.getRequestDispatcher("/projet.jsp");
			rd.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Pattern pattern = Pattern.compile("project/candidate/([0-9]*)");
		Matcher matcher = pattern.matcher(request.getRequestURL());
		
		if (matcher.find())
		{
			Integer idUser = Integer.valueOf(matcher.group(1));
			//implementer la candidature
		}
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Pattern pattern = Pattern.compile("project/([0-9]*)");
		Matcher matcher = pattern.matcher(request.getRequestURL());
		
		if (matcher.find())
		{
			Integer idUser = Integer.valueOf(matcher.group(1));
			System.out.println(idUser);
			//implementer la candidature
		}
	}
}
