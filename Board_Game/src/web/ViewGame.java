package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.Feedback;
import datamodel.Game;
import util.UtilDB;

@WebServlet("/ViewGame")
public class ViewGame extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewGame() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String gameName = request.getParameter("name").trim();
		gameName = UtilDB.formatInfo(gameName);
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
		retrieveDisplayData(out, gameName, response);
	
	}

	void retrieveDisplayData(PrintWriter out, String gameName, HttpServletResponse response) throws IOException {
		
		 List<Feedback> listFeedback = UtilDB.listFeedback();
		 Game game = new Game();
		 
		 // Catch potential out-of-bounds error due to empty game list being returned, just go back to homepage
		 try {
		 game = UtilDB.listGames(UtilDB.formatInfo(gameName)).get(0);
		 }
		 catch (java.lang.IndexOutOfBoundsException e) 
		 {
			 try {
				response.sendRedirect("/Board_Game/Homepage");
			} catch (IOException e1) {
				System.out.println("Couldn't find game.");
				e1.printStackTrace();
			}
		 }
		 
		 
		 double totalRating = 10;
		 double avgRating = 0;
		 double count = 1;
		 String feedbackTable = "";
		 
		 for (Feedback feedback : listFeedback) {
			 
			 if (feedback.getGameName().equals(game.getName())) {
			 // Build Table
			 feedbackTable += "<tr>"
			 		+ "<td>"
			 		+ "<b>(" + feedback.getRating() + "/10.0) </b>" + feedback.getReview() + "<hr>"
			 		+ "</td>"
			 		+ "</tr>";
			 
			 totalRating += feedback.getRating();
			 count++;
			 }
		 }
		 
		 avgRating = Math.round((totalRating/count) * 10.0) / 10.0; 
		 
		 
		 
		 
		
		out.print("<html>\r\n" + 
				"  <head>\r\n" + 
				"    <style>\r\n" + 
				"      header {\r\n" + 
				"        background-color: #6495ED;\r\n" + 
				"        color: white;\r\n" + 
				"        text-align: center;\r\n" + 
				"        padding: 5px;\r\n" + 
				"        font-size: 25px;\r\n" + 
				"      }" +  
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
				"\r\n" + 
				"      #container div {\r\n" + 
				"        display: inline-block;\r\n" + 
				"        padding: 5px;\r\n" + 
				"      }\r\n" + 
				"\r\n" + 
				"      section {\r\n" + 
				"        font-size: 20px;\r\n" + 
				"        width: 600px;\r\n" + 
				"        display: block;\r\n" + 
				"        margin-left: auto;\r\n" + 
				"        margin-right: auto;\r\n" + 
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
				"      .subbutton {\r\n" + 
				"        background-color: #FF6347;\r\n" + 
				"        border-radius: 10px;\r\n" + 
				"        border-style: none;\r\n" + 
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
				"\r\n" + 
				"      span {\r\n" + 
				"        color: white;\r\n" + 
				"        background-color: #7B68EE;\r\n" + 
				"        font-style: italic;\r\n" + 
				"        font-size: 35px;\r\n" + 
				"        font-weight: bold;\r\n" + 
				"      }\r\n" + 
				"\r\n" + 
				"      .review {\r\n" + 
				"        width: 150px;\r\n" + 
				"      }\r\n" + 
				"    </style>\r\n" + 
				"  </head>\r\n" + 
				"  <body>\r\n" + 
				"    <header>\r\n" + 
				"      <h1>The Game Board</h1>\r\n" + 
				"    </header>\r\n" + 
				"    <div id=\"container\">\r\n" + 
				"      <center>\r\n" + 
				"        <div>\r\n" + 
				"          <a href=\"/Board_Game/Homepage\">\r\n" + 
				"            <button class=\"button\">Home</button>\r\n" + 
				"          </a>\r\n" + 
				"        </div>\r\n" + 
				"        <div>\r\n" + 
				"      </center>\r\n" + 
				"    </div>\r\n" + 
				"    <br>\r\n" + 
				"    <center>\r\n" + 
				"      <span>" + game.getName() + "</span>\r\n" + 
				"    </center>" +
				"    <br> " +
				"    <center>" +
			    "      <img src=\"DisplayImage?name=" + URLEncoder.encode(game.getName(), "UTF-8") + "&bckgrd=no\" alt=\"Game Image\" width=\"400\" height=\"400\">" +
				"    </center>\r\n" + 
				"    <section>\r\n" + 
				"      <h3>Rating: " + avgRating + "/10.0</h3>\r\n" + 
				"      <p>Type: " + game.getType() + "</p>\r\n" + 
				"      <p>Players: " + game.getMinPlayers() + "-" + game.getMaxPlayers() + "</p>\r\n" + 
				"      <p>Instruction: </p>"+ game.getDescription() +"<br>\r\n" + 
				"      <br>\r\n" + 
				"      <br>\r\n" + 
				"    </section>\r\n" + 
				"    <center>\r\n" + 
				"    <form action=\"ReviewGame\" method=\"POST\">\r\n" + 
				"      <button class=\"subbutton\" type=\"submit\" name=\"name\" value=\"" + game.getName() + "\">Leave a Review</button>\r\n" + 
				"    </form>\r\n" + 
				"    </center>"+ 
				"	<section>" +
				"    <table style=\"width:100%\">\r\n" + feedbackTable +
				"    </table>\r\n" + 
				"	<section>" +
				"    <br>\r\n" + 
				"    <footer> Copyright - BoardGame - 2022 </footer>\r\n" + 
				"  </body>\r\n" + 
				"</html>");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
