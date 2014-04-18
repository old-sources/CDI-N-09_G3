package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notification.Notification;

import com.google.gson.Gson;

/**
 * Servlet implementation class user
 */
@WebServlet("/user/*")
public class ControllerUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer userId = null;
		Pattern pattern = Pattern.compile(".user/([0-9]*)");
		Matcher matcher = pattern.matcher(request.getRequestURL());
		if (matcher.find()) {
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			Gson gson = new Gson();
			User a = new User();
			a.setFirstName("Bouchard");
			a.setLastName("gérard");
			a.setMail("gerard@bouchard.com");
			a.setYear(1);
			a.setYearName("CDI 09");
			a.setAvailability(1);
			a.setAvailabilityName("disponible");
			String json = gson.toJson(a);
			writer.print(json);
		}
		else
		{
			ServletContext context= request.getSession().getServletContext();
			RequestDispatcher rd= context.getRequestDispatcher("/user.jsp");
			rd.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
