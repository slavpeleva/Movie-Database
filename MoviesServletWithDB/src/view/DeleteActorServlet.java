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
 * Servlet implementation class DeleteActorServlet
 */
@WebServlet("/DeleteActorServlet")
public class DeleteActorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteActorServlet() {
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
		String id = request.getParameter("actorId");
		int actorId = Integer.parseInt(id);
		String firstName = request.getParameter("firstName");		
		String lastName = request.getParameter("lastName");	
		List<Actor> actors = RequestMyReq.showActors();
		for (Actor actor : actors) {
			
			RequestMyReq.deleteActor(actor.getId(), actor.getFirstName(), actor.getLastName());
		}	
		out.println("<html>");
		out.println("<head>");
		out.println("\t<title>User Form</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2 align = \"left\">User form registration</h2>");
		out.println("<form method=\"GET\" action=\"DeletedServlet\">");
		out.println("<table bgcolor=\"cyan\"border=\"1\" style=\"width:40%\"<tr><td>Please enter actor's ID</td><td>"
		+ "<input type=\"text\" name=\"actorId\" required pattern=[A-Za-z]+></td></td></tr><br>");
		out.println("<tr><td>Please enter your surname</td><td>" + "<input type=\"text\""
				+ " name=\"firstName\"required pattern=[A-Za-z]+></td></td></tr><br>");
		out.println("<tr><td>Please enter your last name</td><td>" + 
				"<input type=\"text\" name=\"lastName\"required pattern=[A-Za-z]+></td></td></tr><br>");
		out.println("</tr></table>");
		out.println("<input type=\"submit\" value=\"Home\">");
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
