package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.UtilDB;

@WebServlet("/ProcessReview")
public class ProcessReview extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProcessReview() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String rating = request.getParameter("rating").trim();
		String review = request.getParameter("review").trim();
		String gameParams = request.getParameterNames().nextElement();
	    String[] attributes = gameParams.split("\\|");
	    PrintWriter out = response.getWriter();
	    
	    UtilDB.createFeedback(attributes[1], rating, review);
		retrieveDisplayData(out, attributes, gameParams);
	}
	
	void retrieveDisplayData(PrintWriter out, String[] attributes, String gameParams) {
		out.print("<html>\r\n" + 
				"  <head>\r\n" + 
				"    <style>\r\n" + 
				"      header {\r\n" + 
				"        background-color: grey;\r\n" + 
				"        color: white;\r\n" + 
				"        text-align: center;\r\n" + 
				"        padding: 5px;\r\n" + 
				"      }\r\n" + 
				"\r\n" + 
				"      section {\r\n" + 
				"        float: left;\r\n" + 
				"        padding: 10px;\r\n" + 
				"      }\r\n" + 
				"\r\n" + 
				"      footer {\r\n" + 
				"        background-color: grey;\r\n" + 
				"        color: white;\r\n" + 
				"        clear: both;\r\n" + 
				"        text-align: center;\r\n" + 
				"        padding: 5px;\r\n" + 
				"      }\r\n" + 
				"\r\n" + 
				"      th,\r\n" + 
				"      td {\r\n" + 
				"        border: 1px solid black;\r\n" + 
				"      }\r\n" + 
				"    </style>\r\n" + 
				"  </head>\r\n" + 
				"  <body>\r\n" + 
				"    <header>\r\n" + 
				"      <h1>Success</h1>\r\n" + 
				"    </header>\r\n" + 
				"    <section>\r\n" + 
				"      <form action=\"ViewGame\" method=\"POST\">\r\n" + 
				"        <input type=\"submit\" value=\"Return to " + attributes[1] + "\" name=\"" + gameParams + "\">\r\n" + 
				"      </form>\r\n" + 
				"      <a href=\"/Board_Game/SearchGame.html\">Return to Homepage</a>\r\n" + 
				"    </section>\r\n" + 
				"    <footer> Copyright - BoardGame - 2022 </footer>\r\n" + 
				"  </body>\r\n" + 
				"</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
