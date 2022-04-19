package web;

import java.io.IOException;
import java.io.PrintWriter;
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

		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    String paramNames = request.getParameterNames().nextElement();
		String[] attributes = paramNames.split("\\|");
		
		retrieveDisplayData(out, attributes, paramNames);
	
	}

	void retrieveDisplayData(PrintWriter out, String[] attributes, String paramNames) {
		
		 List<Feedback> listFeedback = UtilDB.listFeedback();
		 double totalRating = 10;
		 double avgRating = 0;
		 double count = 1;
		 String feedbackTable = "";
		 
		 for (Feedback feedback : listFeedback) {
			 
			 if (feedback.getGameName().equals(attributes[1])) {
			 // Build Table
			 feedbackTable += "<tr>"
			 		+ "<td>"
			 		+ feedback.getReview() + "<hr>"
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
				"      <h1>The Board Game</h1>\r\n" + 
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
				"      <span>" + attributes[1] + "</span>\r\n" + 
				"    </center>\r\n" + 
				"    <br>\r\n" + 
				"    <section>\r\n" + 
				"      <h3>Rating: " + avgRating + "/10</h3>\r\n" + 
				"      <p>Type: " + attributes[3] + "</p>\r\n" + 
				"      <p>Players: " + attributes[4] + "-" + attributes[5] + "</p>\r\n" + 
				"      <p>Intruction: </p>"+ attributes[2] +"<br>\r\n" + 
				"      <br>\r\n" + 
				"      <br>\r\n" + 
				"    </section>\r\n" + 
				"    <center>\r\n" + 
				"    <form action=\"ReviewGame\" method=\"POST\">\r\n" + 
				"      <input class=\"subbutton\" type=\"submit\" name=\"" + paramNames + "\"value=\"Leave a Review\">\r\n" + 
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
