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
				"    background-color:#6495ED;\r\n" + 
				"    color:white;\r\n" + 
				"    text-align:center;\r\n" + 
				"    padding:5px;\r\n" + 
				"    font-size: 25px;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"section {\r\n" + 
				"    font-size: 20px;\r\n" + 
				"    width: 300px;\r\n" + 
				"    display: block;\r\n" + 
				"    margin-left: auto;\r\n" + 
				"    margin-right: auto;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"footer {\r\n" + 
				"    background-color:#6495ED;\r\n" + 
				"    color:white;\r\n" + 
				"    clear:both;\r\n" + 
				"    text-align:center;\r\n" + 
				"    padding:5px;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"span {\r\n" + 
				"    color: white;\r\n" + 
				"    background-color: #7B68EE;\r\n" + 
				"    font-style: italic;\r\n" + 
				"    font-size: 25px;\r\n" + 
				"    font-weight: bold;\r\n" + 
				"}\r\n" + 
				"#container div{\r\n" + 
				"    display:inline-block;\r\n" + 
				"    padding:5px;\r\n" + 
				"}\r\n" + 
				".button {\r\n" + 
				"    background-color: #483D8B;\r\n" + 
				"    border-radius: 20px;\r\n" + 
				"    border-style: none;\r\n" + 
				"    box-sizing: border-box;\r\n" + 
				"    color: #FFFFFF;\r\n" + 
				"    cursor: pointer;\r\n" + 
				"    font-size: 16px;\r\n" + 
				"    height: 40px;\r\n" + 
				"    line-height: 10px;\r\n" + 
				"    list-style: none;\r\n" + 
				"    margin: 0;\r\n" + 
				"    outline: none;\r\n" + 
				"    padding: 10px 16px;\r\n" + 
				"    position: relative;\r\n" + 
				"    text-align: center;\r\n" + 
				"}\r\n" + 
				".subbutton {\r\n" + 
				"    background-color: #FF6347;\r\n" + 
				"    border-radius: 10px;\r\n" + 
				"    border-style: none;\r\n" + 
				"    color: #FFFFFF;\r\n" + 
				"    cursor: pointer;\r\n" + 
				"    font-size: 16px;\r\n" + 
				"    height: 40px;\r\n" + 
				"    line-height: 10px;\r\n" + 
				"    list-style: none;\r\n" + 
				"    margin: 0;\r\n" + 
				"    outline: none;\r\n" + 
				"    padding: 10px 16px;\r\n" + 
				"    position: relative;\r\n" + 
				"    text-align: center;\r\n" + 
				"}\r\n" + 
				"</style>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<header>\r\n" + 
				"<h1>The Game Board</h1>\r\n" + 
				"</header>\r\n" + 
				"<div id=\"container\">\r\n" + 
				"    <center>\r\n" + 
				"        <div><a href=\"/Board_Game/Homepage\"><button class=\"button\">Home</button></a></div>\r\n" + 
				"    </center>\r\n" + 
				"</div>\r\n" + 
				"<br>\r\n" + 
				"<center><span>Leave a Review for " + attributes[1] + "</span></center>\r\n" + 
				"<br>\r\n" + 
				"<section>\r\n" + 
				"<form action=\"ProcessReview\" method=\"POST\">\r\n" + 
				"<input type=\"hidden\" name=\"" + gameParams + "\"/>" +
				"Rating: <input type=\"number\" min=\"0\" max=\"10\" name=\"rating\"> <br> <br>\r\n" + 
				"Review: <textarea rows=\"3\" cols=\"40\" name=\"review\"></textarea> <br> <br>\r\n" + 
				"<center><input class=\"subbutton\" type=\"submit\" value=\"Submit\" /></center>\r\n" + 
				"</form>\r\n" + 
				"<br>\r\n" + 
				"</section>\r\n" + 
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
