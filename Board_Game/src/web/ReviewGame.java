package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.Game;
import util.UtilDB;

@WebServlet("/ReviewGame")
public class ReviewGame extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReviewGame() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    String gameParams = request.getParameterNames().nextElement();
		    String[] attributes = gameParams.split("\\|");
		    
			retrieveDisplayData(out, attributes, gameParams);
			
	}
	
void retrieveDisplayData(PrintWriter out, String[] attributes, String gameParams) {
		
		out.print("<html>\r\n" + 
				"<head>\r\n" + 
				"<style>\r\n" + 
				"header {\r\n" + 
				"    background-color:grey;\r\n" + 
				"    color:white;\r\n" + 
				"    text-align:center;\r\n" + 
				"    padding:5px;	 \r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"section {\r\n" + 
				"    width:350px;\r\n" + 
				"    float:left;\r\n" + 
				"    padding:10px;	 	 \r\n" + 
				"}\r\n" + 
				"footer {\r\n" + 
				"    background-color:grey;\r\n" + 
				"    color:white;\r\n" + 
				"    clear:both;\r\n" + 
				"    text-align:center;\r\n" + 
				"    padding:5px;	 	 \r\n" + 
				"}\r\n" + 
				"</style>\r\n" + 
				"</head>\r\n" + 
				"\r\n" + 
				"<body>\r\n" + 
				"<header>\r\n" + 
				"<h1>Leave a Review for " + attributes[1] + "</h1>\r\n" + 
				"</header>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<section>\r\n" + 
				"	\r\n" + 
				"	<form action=\"ProcessReview\" method=\"POST\">\r\n" + 
				"	\r\n" + 
				"		<input type=\"hidden\" name=\"" + gameParams + "\"/>" +
				"		Rating: <input type=\"number\" min=\"0\" max=\"5\" name=\"rating\"> <br />\r\n" + 
				"		Review: <textarea rows = \"3\" cols = \"40\" name = \"review\"></textarea> <br />\r\n" + 
				"		\r\n" + 
				"		<input type=\"submit\" value=\"Submit\" />\r\n" + 
				"	</form>\r\n" + 
				"    <br><a href=\"/Board_Game/Homepage\">Return to Homepage</a>\r\n" + 
				"</section>\r\n" + 
				"\r\n" + 
				"<footer>\r\n" + 
				"Copyright - BoardGame - 2022\r\n" + 
				"</footer>\r\n" + 
				"</body>\r\n" + 
				"</html>");
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
