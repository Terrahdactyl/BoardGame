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
			 		+ "<input class=\"gamebutton\" type=\"submit\" value=\"" + game.getName() + "\" name=\"name\"/>"
			 		+ "</td>"
			 		+ "</tr>";
		 }
		
		 
		   out.print("<html>\r\n" + 
		   		"  <head>\r\n" + 
		   		"    <style>\r\n" + 
		   		"      header {\r\n" + 
		   		"        background-color: #6495ED;\r\n" + 
		   		"        color: white;\r\n" + 
		   		"        text-align: center;\r\n" + 
		   		"        padding: 5px;\r\n" + 
		   		"        font-size: 25px;\r\n" + 
		   		"      }\r\n" + 
		   		"\r\n" + 
		   		"      .button {\r\n" + 
		   		"        background-color: #483D8B;\r\n" + 
		   		"        border-radius: 20px;\r\n" + 
		   		"        border-style: none;\r\n" + 
		   		"        box-sizing: border-box;\r\n" + 
		   		"        color: #FFFFFF;\r\n" + 
		   		"        cursor: pointer;\r\n" + 
		   		"        font-size: 16px;\r\n" + 
		   		"        height: 40px;\r\n" + 
		   		"        line-height: 10px;\r\n" + 
		   		"        list-style: none;\r\n" + 
		   		"        margin: 0;\r\n" + 
		   		"        outline: none;\r\n" + 
		   		"        padding: 10px 16px;\r\n" + 
		   		"        position: relative;\r\n" + 
		   		"        text-align: center;\r\n" + 
		   		"      }\r\n" + 
		   		"      }\r\n" + 
		   		"\r\n" + 
		   		"      section {\r\n" + 
		   		"        float: left;\r\n" + 
		   		"        padding: 10px;\r\n" + 
		   		"      }\r\n" + 
		   		"\r\n" + 
		   		"      footer {\r\n" + 
		   		"        background-color: #6495ED;\r\n" + 
		   		"        color: white;\r\n" + 
		   		"        clear: both;\r\n" + 
		   		"        text-align: center;\r\n" + 
		   		"        padding: 5px;\r\n" + 
		   		"      }\r\n" + 
		   		"\r\n" + 
		   		"      #container div {\r\n" + 
		   		"        display: inline-block;\r\n" + 
		   		"        padding: 2px;\r\n" + 
		   		"      }\r\n" + 
		   		"\r\n" + 
		   		"      .intro {\r\n" + 
		   		"        font-size: 20px;\r\n" + 
		   		"        position: relative;\r\n" + 
		   		"        padding-left: 100px;\r\n" + 
		   		"        padding-right: 100px;\r\n" + 
		   		"      }\r\n" + 
		   		"\r\n" + 
		   		"      .gamebutton {\r\n" + 
		   		"        background-color: #fff000;\r\n" + 
		   		"        border-radius: 12px;\r\n" + 
		   		"        color: #000;\r\n" + 
		   		"        cursor: pointer;\r\n" + 
		   		"        font-weight: bold;\r\n" + 
		   		"        padding: 15px 90px;\r\n" + 
		   		"        text-align: center;\r\n" + 
		   		"        width: 100%;\r\n" + 
		   		"        box-sizing: border-box;\r\n" + 
		   		"        border: 0;\r\n" + 
		   		"        font-size: 24px;\r\n" + 
		   		"      }\r\n" + 
		   		"		::placeholder {\r\n" + 
		   		"  			color: White;\r\n" + 
		   		"  			opacity: 1;\r\n" + 
		   		"		}\r\n" + 
		   		"		input:focus::placeholder {\r\n" + 
		   		"  			color: transparent;\r\n" + 
		   		"		}" +
		   		"    </style>\r\n" + 
		   		"  </head>\r\n" + 
		   		"  <body>\r\n" + 
		   		"    <header>\r\n" + 
		   		"      <h1>The Game Board</h1>\r\n" + 
		   		"    </header>\r\n" + 
		   		"    <div id=\"container\">\r\n" + 
		   		"      <center>\r\n" + 
		   		"		<form action=\"SearchGame\" method=\"POST\">" +
		   		"        <div>\r\n" + 
		   		"          <a href=\"/Board_Game/InsertGame.html\" class=\"button\" style=\"text-decoration:none;\">Add a New Game</a>" + 
		   		"        </div>\r\n" + 
		   		"        <div>\r\n" + 
		   		"          <input class =\"button\" type=\"text\" name=\"name\" placeholder=\"Search for a Game\">" + 
		   		"        </div>\r\n" + 
		   		"		</form>" +
		   		"      </center>\r\n" + 
		   		"      <p class=\"intro\">Greetings die rollers, card throwers, and game lovers! We are the Game Board! The Game Board is a new tool for board game fans to wield. Look up the rule, discover new games, and even more abilities await you1 Rate the games you've played, or leave a glowing (or scathing) review on those games for others to see! All of this more, here at the Game Board. Game on.</p>\r\n" + 
		   		"    </div>\r\n" + 
		   		"    <center>\r\n" + 
		   		"      <form action=\"ViewGame\" method=\"POST\">\r\n" + 
		   		"        <table>\r\n" + gameTable + 
		   		"        </table>\r\n" + 
		   		"      </form>\r\n" + 
		   		"    </center>\r\n" + 
		   		"    <br>\r\n" + 
		   		"    <br>\r\n" + 
		   		"    <footer> Copyright - BoardGame - 2022 </footer>\r\n" + 
		   		"  </body>\r\n" + 
		   		"</html>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
