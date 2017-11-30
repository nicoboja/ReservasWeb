package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controlers.CtrlABMPersona;
import controlers.CtrlABMReserva;
import entity.Persona;
import entity.Reserva;

/**
 * Servlet implementation class Inicio
 */
@WebServlet({ "/Inicio", "/inicio", "/INICIO" })
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
		String pagina = "/index.jsp";
		request.getRequestDispatcher(pagina).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = "/home.jsp";
		HttpSession session = request.getSession();
		try {
			String user=request.getParameter("user");
			String pass=request.getParameter("pass");
			
			if(user!=null){
				Persona per=new Persona();
				Persona pers=new Persona();
				pers= null;
				per.setUss(user);
				per.setPass(pass);
				session.setAttribute("error", null);
				CtrlABMPersona ctrlPer= new CtrlABMPersona();
				
				pers=ctrlPer.login(per);
				if (pers == null) {
					session.setAttribute("usuario", null);
					session.setAttribute("error", true);
					pagina = "/login.jsp";
					}else{
						CtrlABMReserva ctrlRes = new CtrlABMReserva();
						ArrayList<Reserva> listaRes = ctrlRes.getById(pers.getId());
						System.out.println("ID usuario ingreso: "+pers.getId());
						System.out.println("Reservas: "+listaRes.get(1).getDetalle());
						
						session.setAttribute("usuario", pers);
						request.setAttribute("listares", listaRes );
					}
				
				}
			} catch (Exception e) {
				// TODO: handle exception ERROR EN LA BD
			}
			System.out.println("#############INGRESO##############");
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
	        dispatcher.forward(request, response);  
	}
}


