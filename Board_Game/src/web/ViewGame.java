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
		 double totalRating = 5;
		 double avgRating = 0;
		 double count = 1;
		 String feedbackTable = "";
		 
		 for (Feedback feedback : listFeedback) {
			 
			 if (feedback.getGameName().equals(attributes[1])) {
			 // Build Table
			 feedbackTable += "<tr>"
			 		+ "<td>"
			 		+ feedback.getReview()
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
				"      <h1>" + attributes[1] + "</h1>\r\n" + 
				"      <h3>Type: " + attributes[3] + " &emsp; Rating " + avgRating + "/5.0 &emsp; Players " + attributes[4] + "-" + attributes[5] + "</h3>" + 
				"    </header>\r\n" + 
				"    <section>" + attributes[2] + "<br>\r\n" + 
				"      <br>\r\n" + 
				"      <form action=\"ReviewGame\" method=\"POST\">\r\n" + 
				"        <input type=\"submit\" name=\"" + paramNames + "\"value=\"Leave a Review\">\r\n" + 
				"        <br>\r\n" + 
				"        <br>\r\n" + 
				"      </form>\r\n" + 
				"      <table style=\"border: 1px solid black\">\r\n" + feedbackTable + 
				"      </table>\r\n" + 
				"      <br>\r\n" + 
				"      <a href=\"/Board_Game/Homepage\">Return to Homepage</a>\r\n" + 
				"    </section>\r\n" + 
				"    <footer> Copyright - BoardGame - 2022 </footer>\r\n" + 
				"  </body>\r\n" + 
				"</html>");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
