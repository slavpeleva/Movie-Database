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
import model.Genre;

/**
 * Servlet implementation class AddGenreServlet
 */
@WebServlet("/AddGenreServlet")
public class AddGenreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGenreServlet() {
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
		//List<Genre> genres = RequestMyReq.showGenre();
		String genre = request.getParameter("genre");
		RequestMyReq.insertGenre(genre);
		out.println("<html>");
		out.println("<head>");
		out.println("\t<title>User Form</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2 align = \"left\">User form registration</h2>");
		out.println("<form method=\"GET\" action=\"AddGenreServlet\">");
		out.println("<table bgcolor=\"cyan\"border=\"1\" style=\"width:40%\"<tr><td>Please add Genre</td><td>"
		+ "<input type=\"text\" name=\"genre\" required pattern=[A-Za-z]+></td></td></tr><br>");		
		out.println("</tr></table>");
		out.println("<input type=\"submit\" value=\"submit\">");
		out.println("</form>");
		out.println("<form method=\"GET\" action=\"ViewServlet\">");
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
