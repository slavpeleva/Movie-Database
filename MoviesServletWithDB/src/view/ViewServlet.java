package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();		
		out.println("<html>");
		out.println("<head>");
		out.println("\t<title>User Form</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2 align = \"left\">Movies</h2>");
		out.println("<form method=\"GET\" action=\"ShowMovieServlet\">");
		out.println("<input type=\"submit\" value=\"Show movies\">");
		out.println("</form>");
		out.println("<form method=\"GET\" action=\"ShowActorServlet\">");
		out.println("<input type=\"submit\" value=\"Show Actors\">");
		out.println("</form>");
		out.println("<form method=\"GET\" action=\"DeleteActorServlet\">");
		out.println("<input type=\"submit\" value=\"Delete Actor\">");
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
