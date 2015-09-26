package view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controler.RequestMyReq;
import model.Actor;

/**
 * Servlet implementation class ShowActorServlet
 */
@WebServlet("/ShowActorServlet")
public class ShowActorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowActorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		ServletOutputStream out = response.getOutputStream();
	
		List<Actor> actors = RequestMyReq.showActors();
//		String firstName = request.getParameter("firstName");		
//		String lastName = request.getParameter("lastName");
		out.println("<html>");
		out.println("<head>");
		out.println("\t<title>Registry</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2><dl>Information about Actor</h2>");	
		out.println("<table bgcolor=\"cyan\"border=\"1\" style=\"width:40%\"<tr>"
				+ "<td>Name</td>"
				+ "<td>Last name</td><tr>");
		for (Actor actor : actors) {
			out.println("<tr><td>"+ actor.getFirstName()+ "</td>");	
			out.println("<td>" + actor.getLastName() + "</td></tr>");
			
		}
		out.println("</tr></table>");
		out.println("<form method=\"GET\" action=\"ViewServlet\">");
		out.println("<input type=\"submit\" value=\"Home\">");
		out.println("</form>");
		out.println("<form method=\"GET\" action=\"EditActorServlet\">");
		out.println("<input type=\"submit\" value=\"Edit Actor\">");
		out.println("</form>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
