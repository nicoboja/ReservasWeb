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
import util.AppDataException;

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
		System.out.println(" GET -INICIO");
		String pagina = "/home.jsp";
		HttpSession session = request.getSession();
		try {
			if(session.getAttribute("usuario")!=null) {
				System.out.println("sesion iniciada");
				Persona per = new Persona();
				per = (Persona)session.getAttribute("usuario");
				CtrlABMReserva ctrlRes = new CtrlABMReserva();
				ArrayList<Reserva> listaRes = ctrlRes.getById(per.getId());
				request.setAttribute("listares", listaRes );
				
				
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
		String pagina = "/home.jsp";
		HttpSession session = request.getSession();
		try {
				String user=request.getParameter("user");
				String pass=request.getParameter("pass");
			if (user!=null) {
				Persona per=new Persona();
				per.setUss(user);
				per.setPass(pass);
				
				Persona plog=new Persona();
				plog= null;
				
				CtrlABMPersona ctrlPer= new CtrlABMPersona();
				plog=ctrlPer.login(per);
				if (plog != null) {
					if (plog.isHabilitado()) {
						
						session.setAttribute("usuario", plog);
						CtrlABMReserva ctrlRes = new CtrlABMReserva();
						ArrayList<Reserva> listaRes = ctrlRes.getById(plog.getId());
						request.setAttribute("listares", listaRes );
					}else{
						request.setAttribute("error", "Error: <b>"+plog.getUss()+"<b> no esta <b>Habilitado</b>");
						session.setAttribute("usuario", null);
						pagina = "/login.jsp";
					}
					
				}else{
					request.setAttribute("error", "Error: Usuario o Contraseña incorrecta!");
					session.setAttribute("usuario", null);
					pagina = "/login.jsp";
				}
				
			}else{
				request.setAttribute("error", "Error: Ingrese Usuario y Contraseña");
				session.setAttribute("usuario", null);
				pagina = "/login.jsp";
			}
			
			} catch (AppDataException e) {
				request.setAttribute("error", "Error: "+e);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			System.out.println("#############INGRESO##############");
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
	        dispatcher.forward(request, response); 
		
	}
}


