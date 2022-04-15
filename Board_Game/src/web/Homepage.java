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

@WebServlet("/Homepage")
public class Homepage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Homepage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    retrieveDisplayData(out);
	    
	}

	void retrieveDisplayData(PrintWriter out) {
		
		 List<Game> listGames = UtilDB.listGames();
		 String gameTable = "";
		 
		 for (Game game : listGames) {
			 
			 // Build Table
			 gameTable += "<tr>"
			 		+ "<td>"
			 		+ "<input type=\"submit\" value=\"" + game.getName() + "\" name=\"" + game.toString() + "\"/>"
			 		+ "</td>"
			 		+ "</tr>";
		 }
		
		 
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
		    		"      <h1>The Game Board</h1>\r\n" + 
		    		"    </header>\r\n" + 
		    		"    \r\n" + 
		    		"    <section>\r\n" + 
		    		"        <a href=\"/Board_Game/InsertGame.html\">Add a New Game</a>\r\n" + 
		    		"      <form action=\"ViewGame\" method=\"POST\">\r\n" + 
		    		"        <br />\r\n" + 
		    		"        <table style=\"border: 1px solid black\">\r\n" + gameTable + 
		    		"        </table>\r\n" + 
		    		"      </form>\r\n" + 
		    		"    </section>\r\n" + 
		    		"    <footer> Copyright - BoardGame - 2022 </footer>\r\n" + 
		    		"  </body>\r\n" + 
		    		"</html>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
