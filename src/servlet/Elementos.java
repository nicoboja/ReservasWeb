package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Elementos
 */
@WebServlet("/Elementos")
public class Elementos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Elementos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(" GET - ELEMENTO");
		
		String pagina = "/elemento.jsp";
		HttpSession session = request.getSession();
		
		try {
			if(session.getAttribute("usuario")!=null) {
				
				
				
				
			}else{
				pagina = "/login.jsp";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		RequestDispatcher dispatcher =  getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);  
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
