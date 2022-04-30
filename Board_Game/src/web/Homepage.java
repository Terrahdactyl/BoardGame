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
			 		+ "<input id=\"gameFo\" class=\"gamebutton\" type=\"submit\" value=\"" + game.getName() + "\" name=\"name\"/>"
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
		   		"        margin-top: 10px;\r\n" + 
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
		   		"        margin-bottom: 20px;\r\n" + 
		   		"      }\r\n" + 
		   		"\r\n" + 
		   		"      .game {\r\n" + 
		   		"        position: relative;\r\n" + 
		   		"        text-align: center;\r\n" + 
		   		"        width: auto;\r\n" + 
		   		"        margin-bottom: 100px;\r\n" + 
		   		"      }\r\n" + 
		   		"\r\n" + 
		   		"      .cover {\r\n" + 
		   		"        position: relative;\r\n" + 
		   		"        display: inline-block;\r\n" + 
		   		"        top: 20px;\r\n" + 
		   		"      }\r\n" + 
		   		"\r\n" + 
		   		"      .dice {\r\n" + 
		   		"        position: relative;\r\n" + 
		   		"        width: 100px;\r\n" + 
		   		"        height: 100px;\r\n" + 
		   		"        transform-style: preserve-3d;\r\n" + 
		   		"        transition: transform 1s;\r\n" + 
		   		"      }\r\n" + 
		   		"\r\n" + 
		   		"      .dot {\r\n" + 
		   		"        position: absolute;\r\n" + 
		   		"        width: 20px;\r\n" + 
		   		"        height: 20px;\r\n" + 
		   		"        margin: -10px 5px 5px -10px;\r\n" + 
		   		"        border-radius: 20px;\r\n" + 
		   		"        background-color: #ef233c;\r\n" + 
		   		"        box-shadow: inset 2px 2px #d90429;\r\n" + 
		   		"      }\r\n" + 
		   		"\r\n" + 
		   		"      .side {\r\n" + 
		   		"        position: absolute;\r\n" + 
		   		"        background-color: #ffF;\r\n" + 
		   		"        border-radius: 5px;\r\n" + 
		   		"        width: 100px;\r\n" + 
		   		"        height: 100px;\r\n" + 
		   		"        border: 1px solid #e5e5e5;\r\n" + 
		   		"        text-align: center;\r\n" + 
		   		"        line-height: 2em;\r\n" + 
		   		"      }\r\n" + 
		   		"\r\n" + 
		   		"      .side:nth-child(1) {\r\n" + 
		   		"        transform: translateZ(3.1em);\r\n" + 
		   		"      }\r\n" + 
		   		"\r\n" + 
		   		"      .side:nth-child(6) {\r\n" + 
		   		"        transform: rotateY(90deg) translateZ(3.1em);\r\n" + 
		   		"      }\r\n" + 
		   		"\r\n" + 
		   		"      .side:nth-child(3) {\r\n" + 
		   		"        transform: rotateY(-90deg) translateZ(3.1em);\r\n" + 
		   		"      }\r\n" + 
		   		"\r\n" + 
		   		"      .side:nth-child(4) {\r\n" + 
		   		"        transform: rotateX(90deg) translateZ(3.1em);\r\n" + 
		   		"      }\r\n" + 
		   		"\r\n" + 
		   		"      .side:nth-child(5) {\r\n" + 
		   		"        transform: rotateX(-90deg) translateZ(3.1em);\r\n" + 
		   		"      }\r\n" + 
		   		"\r\n" + 
		   		"      .side:nth-child(2) {\r\n" + 
		   		"        transform: rotateY(-180deg) translateZ(3.1em);\r\n" + 
		   		"      }\r\n" + 
		   		"\r\n" + 
		   		"      .two-1,\r\n" + 
		   		"      .three-1,\r\n" + 
		   		"      .four-1,\r\n" + 
		   		"      .five-1,\r\n" + 
		   		"      .six-1 {\r\n" + 
		   		"        top: 20%;\r\n" + 
		   		"        left: 20%;\r\n" + 
		   		"      }\r\n" + 
		   		"\r\n" + 
		   		"      .four-3,\r\n" + 
		   		"      .five-3,\r\n" + 
		   		"      .six-4 {\r\n" + 
		   		"        top: 20%;\r\n" + 
		   		"        left: 80%;\r\n" + 
		   		"      }\r\n" + 
		   		"\r\n" + 
		   		"      .one-1,\r\n" + 
		   		"      .three-2,\r\n" + 
		   		"      .five-5 {\r\n" + 
		   		"        top: 50%;\r\n" + 
		   		"        left: 50%;\r\n" + 
		   		"      }\r\n" + 
		   		"\r\n" + 
		   		"      .four-2,\r\n" + 
		   		"      .five-2,\r\n" + 
		   		"      .six-3 {\r\n" + 
		   		"        top: 80%;\r\n" + 
		   		"        left: 20%;\r\n" + 
		   		"      }\r\n" + 
		   		"\r\n" + 
		   		"      .two-2,\r\n" + 
		   		"      .three-3,\r\n" + 
		   		"      .four-4,\r\n" + 
		   		"      .five-4,\r\n" + 
		   		"      .six-6 {\r\n" + 
		   		"        top: 80%;\r\n" + 
		   		"        left: 80%;\r\n" + 
		   		"      }\r\n" + 
		   		"\r\n" + 
		   		"      .six-2 {\r\n" + 
		   		"        top: 50%;\r\n" + 
		   		"        left: 20%;\r\n" + 
		   		"      }\r\n" + 
		   		"\r\n" + 
		   		"      .six-5 {\r\n" + 
		   		"        top: 50%;\r\n" + 
		   		"        left: 80%;\r\n" + 
		   		"      }\r\n" + 
		   		"\r\n" + 
		   		"      .rollbutton {\r\n" + 
		   		"        position: relative;\r\n" + 
		   		"        top: 60px;\r\n" + 
		   		"        padding: 15px 50px;\r\n" + 
		   		"        color: #fff;\r\n" + 
		   		"        background-color: #f4d35e;\r\n" + 
		   		"        border: none;\r\n" + 
		   		"        font-size: 20px;\r\n" + 
		   		"        border-radius: 20px;\r\n" + 
		   		"        box-shadow: 1px 3px #50514F;\r\n" + 
		   		"        outline: none;\r\n" + 
		   		"        transition: .3s;\r\n" + 
		   		"      }\r\n" + 
		   		"\r\n" + 
		   		"      .rollbutton:hover,\r\n" + 
		   		"      .rollbutton:active {\r\n" + 
		   		"        outline: none;\r\n" + 
		   		"        background: #50514F;\r\n" + 
		   		"        cursor: pointer;\r\n" + 
		   		"        transform: translateY(15px);\r\n" + 
		   		"      }\r\n" + 
		   		"\r\n" + 
		   		"      .show-1 {\r\n" + 
		   		"        transform: rotateX(720deg) rotateZ(-720deg);\r\n" + 
		   		"      }\r\n" + 
		   		"\r\n" + 
		   		"      .show-6 {\r\n" + 
		   		"        transform: rotateX(-900deg) rotateZ(1080deg);\r\n" + 
		   		"      }\r\n" + 
		   		"\r\n" + 
		   		"      .show-3 {\r\n" + 
		   		"        transform: rotateY(-450deg) rotateZ(-1440deg);\r\n" + 
		   		"      }\r\n" + 
		   		"\r\n" + 
		   		"      .show-4 {\r\n" + 
		   		"        transform: rotateY(810deg) rotateZ(720deg);\r\n" + 
		   		"      }\r\n" + 
		   		"\r\n" + 
		   		"      .show-5 {\r\n" + 
		   		"        transform: rotateX(-810deg) rotateZ(-1080deg);\r\n" + 
		   		"      }\r\n" + 
		   		"\r\n" + 
		   		"      .show-2 {\r\n" + 
		   		"        transform: rotateX(450deg) rotateZ(-720deg);\r\n" + 
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
		   		"          <a href=\"/Board_Game/InsertGame.html\">\r\n" + 
		   		"            <button class=\"button\">Add a New Game</button>\r\n" + 
		   		"          </a>\r\n" + 
		   		"        </div>\r\n" + 
		   		"        <div>\r\n" + 
		   		"          <form action=\"SearchGame\" method=\"POST\">\r\n" + 
		   		"            <input class=\"button\" type=\"text\" name=\"name\" placeholder=\"Search for a Game\">\r\n" + 
		   		"          </form>\r\n" + 
		   		"        </div>\r\n" + 
		   		"        <p class=\"intro\">Greetings die rollers, card throwers, and game lovers! We are the Game Board! The Game Board is a new tool for board game fans to wield. Look up the rules, discover new games, and do much more! Rate the games you have played, or leave a glowing (or scathing) review on those games for others to see! All of this more, here at the Game Board. Game on.</p>\r\n" + 
		   		"      </center>\r\n" + showDice(listGames) +
		   		"    <center>\r\n" + 
		   		"      <form id=\"gameForm\" action=\"ViewGame\" method=\"POST\">\r\n" + 
		   		"        <table>\r\n" + gameTable +
		   		"        </table>\r\n" + 
		   		"      </form>\r\n" + 
		   		"    </center>\r\n" + 
		   		"    <br>\r\n" + 
		   		"        <script>\r\n" + 
		   		"      var elDiceOne = document.getElementById('dice1');\r\n" + 
		   		"      var elComeOut = document.getElementById('roll');\r\n" + 
		   		"      elComeOut.onclick = function() {\r\n" + 
		   		"        rollDice();\r\n" + 
		   		"      };\r\n" + 
		   		"\r\n" + 
		   		"      function rollDice() {\r\n" + 
		   		"        var diceOne = Math.floor((Math.random() * 6) + 1);\r\n" + 
		   		"        for (var i = 1; i <= 6; i++) {\r\n" + 
		   		"          elDiceOne.classList.remove('show-' + i);\r\n" + 
		   		"          if (diceOne === i) {\r\n" + 
		   		"            elDiceOne.classList.add('show-' + i);\r\n" + 
		   		"          }\r\n" + 
		   		"        }\r\n" + 
		   		"        setTimeout(() => { selectGame(); }, 1200);\r\n" + 
		   		"      }\r\n" + 
		   		"      \r\n" + 
		   		"      function selectGame() {\r\n" + 
		   		"      \r\n" + 
		   		"      console.log(document.getElementById(\"game\"))\r\n" + 
		   		"      var x = document.getElementById(\"gameForm\").elements[Math.floor(Math.random() * (document.getElementById(\"gameForm\").length))].value;\r\n" + 
		   		"     window.open(\"SearchGame?name=\" + encodeURIComponent(x),\"_self\");\r\n" +  
		   		"      console.log(x)\r\n" + 
		   		"      }\r\n" + 
		   		"    </script>\r\n" + 
		   		"    <br>\r\n" + 
		   		"    <footer> Copyright - BoardGame - 2022 </footer>\r\n" + 
		   		"  </body>\r\n" + 
		   		"</html>");
	}
	
	String showDice(List<Game> listGames ) {
		if (listGames.size() > 1)
			return "    </div>\r\n" + 
					"    <div class=\"game\">\r\n" + 
					"      <div class=\"cover\">\r\n" + 
					"        <div id=\"dice1\" class=\"dice dice-one show-4\">\r\n" + 
					"          <div id=\"dice-one-side-one\" class=\"side one\">\r\n" + 
					"            <div class=\"dot one-1\"></div>\r\n" + 
					"          </div>\r\n" + 
					"          <div id=\"dice-one-side-two\" class=\"side two\">\r\n" + 
					"            <div class=\"dot two-1\"></div>\r\n" + 
					"            <div class=\"dot two-2\"></div>\r\n" + 
					"          </div>\r\n" + 
					"          <div id=\"dice-one-side-three\" class=\"side three\">\r\n" + 
					"            <div class=\"dot three-1\"></div>\r\n" + 
					"            <div class=\"dot three-2\"></div>\r\n" + 
					"            <div class=\"dot three-3\"></div>\r\n" + 
					"          </div>\r\n" + 
					"          <div id=\"dice-one-side-four\" class=\"side four\">\r\n" + 
					"            <div class=\"dot four-1\"></div>\r\n" + 
					"            <div class=\"dot four-2\"></div>\r\n" + 
					"            <div class=\"dot four-3\"></div>\r\n" + 
					"            <div class=\"dot four-4\"></div>\r\n" + 
					"          </div>\r\n" + 
					"          <div id=\"dice-one-side-five\" class=\"side five\">\r\n" + 
					"            <div class=\"dot five-1\"></div>\r\n" + 
					"            <div class=\"dot five-2\"></div>\r\n" + 
					"            <div class=\"dot five-3\"></div>\r\n" + 
					"            <div class=\"dot five-4\"></div>\r\n" + 
					"            <div class=\"dot five-5\"></div>\r\n" + 
					"          </div>\r\n" + 
					"          <div id=\"dice-one-side-six\" class=\"side six\">\r\n" + 
					"            <div class=\"dot six-1\"></div>\r\n" + 
					"            <div class=\"dot six-2\"></div>\r\n" + 
					"            <div class=\"dot six-3\"></div>\r\n" + 
					"            <div class=\"dot six-4\"></div>\r\n" + 
					"            <div class=\"dot six-5\"></div>\r\n" + 
					"            <div class=\"dot six-6\"></div>\r\n" + 
					"          </div>\r\n" + 
					"        </div>\r\n" + 
					"      </div>\r\n" + 
					"      <div id=\"roll\">\r\n" + 
					"        <button class=\"rollbutton\">Just roll the dice!</button>\r\n" + 
					"      </div>\r\n" + 
					"    </div>";
					
		return "";
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
