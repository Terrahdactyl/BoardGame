package util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DisplayImage")
public class DisplayImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String imagesDir = "/var/lib/tomcat7/webapps/Board_Game/Images/";

	public static final String bckgrdImage = "/var/lib/tomcat7/webapps/Board_Game/background.png"; 

	
    public DisplayImage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("image/jpeg"); 
        String name = request.getParameter("name").trim();
        String bckgrd = request.getParameter("bckgrd").trim();
        
        if (bckgrd.equals("no")) {
        ServletOutputStream outStream;
        outStream = response.getOutputStream();
        FileInputStream fin = new FileInputStream(imagesDir + UtilDB.formatInfo(name) + ".png");

        BufferedInputStream bin = new BufferedInputStream(fin);
        BufferedOutputStream bout = new BufferedOutputStream(outStream);
        int ch =0; ;
        while((ch=bin.read())!=-1)
            bout.write(ch);

        bin.close();
        fin.close();
        bout.close();
        outStream.close();
        }
        
        else {       	
            ServletOutputStream outStream;
            outStream = response.getOutputStream();
            FileInputStream fin = new FileInputStream(bckgrdImage);

            BufferedInputStream bin = new BufferedInputStream(fin);
            BufferedOutputStream bout = new BufferedOutputStream(outStream);
            int ch =0; ;
            while((ch=bin.read())!=-1)
                bout.write(ch);

            bin.close();
            fin.close();
            bout.close();
            outStream.close();
        }
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
