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
		
		System.out.println(request.getContentType());
		
		Pattern pattern = Pattern.compile("user/json/*");
		Matcher matcher = pattern.matcher(request.getRequestURL());
		
		Pattern patternModale = Pattern.compile("user/(modale)");
		Matcher matcherModale = patternModale.matcher(request.getRequestURL());
		
		Pattern pattern2 = Pattern.compile("user/([0-9]*)");
		Matcher matcher2 = pattern2.matcher(request.getRequestURL());
		
		if (matcher.find())
		{
			Pattern pattern1 = Pattern.compile("(all)");
			Matcher matcher1 = pattern1.matcher(request.getRequestURL());
			if (matcher1.find()) {
				response.setContentType("application/json; charset=UTF-8");
				ArrayList<UserIHMTemp> users = new ArrayList<UserIHMTemp>();
				
				UserIHMTemp a = new UserIHMTemp();
				a.setId(1);
				a.setFirstName("BouchardAll");
				a.setLastName("gérard");
				a.setMail("gerard@bouchard.com");
				a.setYear(1);
				a.setYearName("CDI09");
				a.setAvailability(true);
				users.add(a);
				
				UserIHMTemp a1 = new UserIHMTemp();
				a1.setId(2);
				a1.setFirstName("Bouchard");
				a1.setLastName("michel");
				a1.setMail("gerard@bouchard.com");
				a1.setYear(1);
				a1.setYearName("IT Start 03");
				a1.setAvailability(false);
				users.add(a1);
				
				UserIHMTemp a11 = new UserIHMTemp();
				a11.setId(3);
				a11.setFirstName("Petiot");
				a11.setLastName("romain");
				a11.setMail("rpetiot@gmail.com");
				a11.setYear(1);
				a11.setYearName("CDPN 06");
				a11.setAvailability(true);
				users.add(a11);
				
				UserIHMTemp a111 = new UserIHMTemp();
				a111.setId(4);
				a111.setFirstName("bouchard2");
				a111.setLastName("jean-luc");
				a111.setMail("");
				a111.setYear(1);
				a111.setYearName("CDI09");
				a111.setAvailability(false);
				users.add(a111);
				
				
				PrintWriter writer = response.getWriter();
				Gson gson = new Gson();
				
				String json = gson.toJson(users);
				writer.print(json);
			}
			else
			{
				/*Pattern patternUser = Pattern.compile("user/json/([0-9]*)");
				Matcher matcherUser = patternUser.matcher(request.getRequestURL());
				Integer idUser = Integer.valueOf(matcherUser.group(1));*/
				response.setContentType("application/json; charset=UTF-8");
				PrintWriter writer = response.getWriter();
				Gson gson = new Gson();
				UserIHMTemp a = new UserIHMTemp();
				a.setFirstName("Bouchard");
				a.setLastName("gérard");
				a.setMail("gerard@bouchard.com");
				a.setYear(1);
				a.setYearName("CDI 09");
				a.setAvailability(true);
				a.setAvailabilityName("disponible");
				String json = gson.toJson(a);
				writer.print(json);
			}
		}
		else if(matcherModale.find())
		{
			//Integer idUser = Integer.valueOf(matcher2.group(1));
			ServletContext context= request.getSession().getServletContext();
			RequestDispatcher rd= context.getRequestDispatcher("/userModale.jsp");
			rd.include(request, response);
		}
		else if (matcher2.find())
		{
			Integer idUser = Integer.valueOf(matcher2.group(1));
			ServletContext context= request.getSession().getServletContext();
			RequestDispatcher rd= context.getRequestDispatcher("/user.jsp");
			rd.include(request, response);
		}
		else if (matcher.find()) {
			Integer idUser = Integer.valueOf(matcher.group(1));
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			Gson gson = new Gson();
			UserIHMTemp a = new UserIHMTemp();
			a.setFirstName("Bouchard");
			a.setLastName("gérard");
			a.setMail("gerard@bouchard.com");
			a.setYear(1);
			a.setYearName("CDI 09");
			a.setAvailability(true);
			a.setAvailabilityName("disponible");
			String json = gson.toJson(a);
			writer.print(json);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pattern pattern = Pattern.compile("user/([0-9]*)");
		Matcher matcher = pattern.matcher(request.getRequestURL());
		if (matcher.find()) {
			Integer idUser = Integer.valueOf(matcher.group(1));
		}
	}

}
