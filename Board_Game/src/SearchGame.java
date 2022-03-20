import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.Game;
import util.Info;
import util.UtilDB;

@WebServlet("/SearchGame")
public class SearchGame extends HttpServlet implements Info {
   private static final long serialVersionUID = 1L;

   public SearchGame() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String keyword = request.getParameter("keyword").trim();

      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Database Result";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<ul>");

      List<Game> listGames = null;
      if (keyword != null && !keyword.isEmpty()) {
         listGames = UtilDB.listGames(keyword);
      } else {
         listGames = UtilDB.listGames();
      }
      display(listGames, out);
      out.println("</ul>");
      out.println("<a href=/" + projectName + "/" + searchWebName + ">Search Data</a> <br>");
      out.println("</body></html>");
   }

   void display(List<Game> listGames, PrintWriter out) {
      for (Game game : listGames) {
         System.out.println("[DBG] " + game.getId() + ", " //
               + game.getName() + ", " //
               + game.getType()
               + game.getPlayers());

         out.println("<li>" + game.getId() + ", " //
               + game.getName() + ", " //
               + game.getType() + ", " //
               + game.getPlayers() + "</li>");
      }
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
