package web;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import util.DisplayImage;
import util.UtilDB;

@WebServlet("/InsertGame")
@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 10,      // 10 MB
		  maxRequestSize = 1024 * 1024 * 100)   // 100 MB
public class InsertGame extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public InsertGame() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
	   
	  String name = request.getParameter("name").trim();
	  String description = request.getParameter("description").trim();
	  String type = request.getParameter("type").trim();
	  String minplayers = request.getParameter("minplayers").trim();
	  String maxplayers = request.getParameter("maxplayers").trim();
	  
	  Part filePart = request.getPart("file");
	  boolean createGame = true;
	 
	  
	  // Check if file is png or jpeg
	  if (!(filePart.getHeaders("content-disposition").toString().contains(".png") || 
			  filePart.getHeaders("content-disposition").toString().contains(".jpg"))) {
		  System.out.println("File wasn't png or jpg, game was not made");   
		  createGame = false;
	  }
	  // Check if file is empty
	  if (filePart.getSize() == 0) {
		  System.out.println("File is empty, game was not made");   
		  createGame = false;
	  }
	  

	  if (createGame) {
	      if(UtilDB.createGames(name, description, type, minplayers, maxplayers)) {
	    	  filePart.write(DisplayImage.imagesDir + UtilDB.formatInfo(name) + ".png");
	      }
	  }
	  
      response.sendRedirect("/Board_Game/Homepage");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}