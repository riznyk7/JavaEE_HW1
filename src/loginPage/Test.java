package loginPage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        users.put("Yura", "koko");
        // TODO Auto-generated constructor stub
    }

    private HashMap<String, String> users = new HashMap<String, String>();
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName =request.getParameter("fname");
		int password =request.getParameter("password").hashCode();
		boolean b=false;
		try{
		b = users.get(firstName).hashCode()==password;
		}catch(NullPointerException e){};
		if(b){
			PrintWriter pw = response.getWriter();
			pw.print("Hi, user ");
			pw.print(firstName);
		}
		else
		{
			response.sendRedirect("/HW_1/index.html");
		}
	}

}
