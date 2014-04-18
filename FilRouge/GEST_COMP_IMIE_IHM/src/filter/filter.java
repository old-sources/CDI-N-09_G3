package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class filter
 */
@WebFilter("/*")
public class filter implements Filter {

    /**
     * Default constructor. 
     */
    public filter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
//
//		Boolean authentified = false;
//		Boolean authentifying = false;
//		Boolean resourceToScan = true;
//		Boolean requestInterupted = false;
//		if (httpServletRequest.getRequestURI().contains("test") || httpServletRequest.getRequestURI().contains(".css") || httpServletRequest.getRequestURI().contains(".js") || httpServletRequest.getRequestURI().contains(".gif")) {
//			resourceToScan = false;
//		}
//		if (httpServletRequest.getRequestURI().contains("controllerIdentification")) {
//			
//			authentifying = true;
//			//Interception forcée des POST des URL contenant TP13
//			if (httpServletRequest.getMethod().equals("POST")
//					&& httpServletRequest.getParameter("valider") != null) {
//				String inputNom = request.getParameter("inputNom");
//				String inputPassword = request.getParameter("inputPassword");
//				Personne searchPersonne = new Personne();
//				searchPersonne.setNom(inputNom);
//				searchPersonne.setPassw(inputPassword);
//				IGestionEcoleService gestionEcoleService = ConcreteSingletonFactory
//						.getInstance().creategGestionEcoleService();
//				Personne authPersonne = null;
//				try {
//					authPersonne = gestionEcoleService
//							.verifierAuthPersonne(searchPersonne);
//				} catch (ServiceException e) {
//					request.setAttribute("messageException", e.getMessage());
//				}
//				if (authPersonne != null) {
//					httpServletRequest.getSession().setAttribute(
//							"authentifiedPersonne", authPersonne);
//					String uri = (String) httpServletRequest.getSession()
//							.getAttribute("originURL");
//					httpServletResponse.sendRedirect(uri);
//				} else {
//					RequestDispatcher dispatcher = request
//							.getRequestDispatcher("./formulaire.jsp");
//					dispatcher.forward(request, response);
//				}
//				requestInterupted = true;
//			}
//
//		}
//		if (httpServletRequest.getSession()
//				.getAttribute("authentifiedPersonne") != null) {
//			authentified = true;
//		}
//		if (!requestInterupted) {
//			if (!authentified && !authentifying && resourceToScan) {
//				
//				String requestParam = httpServletRequest.getQueryString()!=null?"?".concat(httpServletRequest.getQueryString().toString()):"";
//				httpServletRequest.getSession().setAttribute("originURL",
//						httpServletRequest.getRequestURL().toString().concat(requestParam));
//				httpServletResponse.sendRedirect("http://localhost:8080/TPServlet2/controllerIdentification");
//			} else {
//				chain.doFilter(request, response);
//			}
//		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
