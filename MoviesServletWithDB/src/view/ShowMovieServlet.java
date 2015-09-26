package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import controler.RequestMyReq;
import model.Actor;
import model.Genre;
import model.Movie;

/**
 * Servlet implementation class ShowMovieServlet
 */
@WebServlet("/ShowMovieServlet")
public class ShowMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowMovieServlet() {
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
		RequestMyReq req= new RequestMyReq();
	
		List<Movie> movie = req.showAllMovies();
	
//		String firstName = request.getParameter("firstName");		
//		String lastName = request.getParameter("lastName");
		out.println("<html>");
		out.println("<head>");
		out.println("\t<title>Registry</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2><dl>Information about Movies</h2>");	
		out.println("<form method=\"GET\" action=\"ViewServlet\">");
		out.println("<input type=\"submit\" value=\"Home\">");
		out.println("</form>");
		out.println("<form method=\"GET\" action=\"AddActorServlet\">");
		out.println("<input type=\"submit\" value=\"Add actor\">");
		out.println("</form>");
		out.println("<form method=\"GET\" action=\"AddMovieServlet\">");
		out.println("<input type=\"submit\" value=\"Add movie\">");
		out.println("</form>");
		out.println("<form method=\"GET\" action=\"EditActorServlet\">");
		out.println("<input type=\"submit\" value=\"Edit Actor\">");
		out.println("</form>");
		out.println("<form method=\"GET\" action=\"EditMovieServlet\">");
		out.println("<input type=\"submit\" value=\"Edit movie\">");
		out.println("</form>");
		out.println("<form method=\"GET\" action=\"AddGenreServlet\">");
		out.println("<input type=\"submit\" value=\"Add Genre\">");
		out.println("</form>");
		
		out.println("<table bgcolor=\"cyan\"border=\"1\" style=\"width:40%\"<tr>"
				+ "<td>Movie Title</td>"
				+ "<td>Actor's Name</td>"
				+ "<td>Movie Genre</td></tr>");
		String act="";
		String gen="";
		for (Movie movie2 : movie) {
			out.println("<tr><td>"+ movie2.getTitle()+ "</td><td>");
			for (Actor actor : movie2.getActor()) {
				act= actor.getFirstName() +" "+  actor.getLastName() + " ";
				out.println(act);			
			}
			out.println("</td>");
			out.println("<td>");
			for (Genre genre : movie2.getGenre()) {
				gen= genre.getGenre() +" ";
				out.println(gen);
			}
			out.println("</td>");
		}
	
		out.println("</tr></table>");
		
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
