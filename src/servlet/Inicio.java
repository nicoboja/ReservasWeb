package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlers.CtrlABMPersona;
import controlers.CtrlABMReserva;
import entity.Persona;

/**
 * Servlet implementation class Inicio
 */
@WebServlet({ "/Inicio", "/inicio" })
public class Inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inicio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String pagina = "/pages/principal.jsp";
		//if (request.) {
	//		System.out.println("SESION NUEVA!");
			
	//	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pagina = "/pages/principal.jsp";
		try {
			String user=request.getParameter("user");
			String pass=request.getParameter("pass");
			
			Persona per=new Persona();
			Persona pers=new Persona();
			pers= null;
			per.setUss(user);
			per.setPass(pass);
			
			CtrlABMPersona ctrlPer= new CtrlABMPersona();
			CtrlABMReserva ctrlRes = new CtrlABMReserva();
			try {
				pers=ctrlPer.login(per);
				if (pers == null) {
				pagina = "/pages/login.jsp";
													
				}else{
					System.out.println(pers.getId());
					request.setAttribute("respend", ctrlRes.getById(pers.getId()));
					request.getSession().setAttribute("persona", pers);
					//request.getSession().setAttribute("respend", ctrlRes.getById(pers.getId()));
				
					System.out.println(pers.getApellido());
				}
			} catch (Exception e) {
				// TODO: handle exception ERROR EN LA BD
			}
			System.out.println("###########################");
			
			request.getRequestDispatcher(pagina).forward(request, response);
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
