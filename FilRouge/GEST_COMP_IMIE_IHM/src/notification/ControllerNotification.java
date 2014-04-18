package notification;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;



/**
 * Servlet implementation class notification
 */
@WebServlet("/notification/*")
public class ControllerNotification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerNotification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json; charset=UTF-8");
		
		PrintWriter writer = response.getWriter();
		Gson gson = new Gson();
		  
		ArrayList<Notification> mesNotifications = new ArrayList<Notification>();
		
		Notification a = new Notification();
		a.setHtml("text1");
		a.setProjet(1);
		a.setSkill(3);
		a.setStatus("candidature");
		mesNotifications.add(a);
		
		a.setHtml("text2");
		a.setProjet(1);
		a.setSkill(3);
		a.setStatus("invitation");
		mesNotifications.add(a);
		
		a.setHtml("text3");
		a.setProjet(1);
		a.setSkill(3);
		a.setStatus("invitation");
		mesNotifications.add(a);
		
		String json = gson.toJson(mesNotifications);
		
	    writer.print(json);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
