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

import controlers.CtrlABMReserva;
import controlers.CtrlABMTipoElemento;
import entity.TipoElemento;
import entity.Persona;

/**
 * Servlet implementation class ConfirmaReserva
 */
@WebServlet({ "/ConfirmaReserva", "/confirmareserva", "/CONFIRMARESERVA" })
public class ConfirmaReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmaReserva() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Confirma Reserva (GET)");
		String pagina = "/nueva_reserva.jsp";
		HttpSession session = request.getSession();
		
		try {
			if (session.getAttribute("usuario")!=null) {
				System.out.println("sesion iniciada");
				CtrlABMTipoElemento ctrlTipo = new CtrlABMTipoElemento();
				ArrayList<TipoElemento> tipos = ctrlTipo.getAll();
				System.out.println(tipos.get(1).getIdT());
				request.setAttribute("tipos", tipos);
			}else{
				pagina = "/login.jsp";
			}
			
		} catch (Exception e) {
			pagina = "/440.jsp";
			request.setAttribute("aviso", "Error: "+e);
		}
		RequestDispatcher dispatcher =  getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response); 
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Confirma Reserva (GET)");
		String pagina = "/home.jsp";
		HttpSession session = request.getSession();
		
		try {
			if (session.getAttribute("usuario")!=null) {
			int hora = Integer.parseInt(request.getParameter("horaI"));
			int cantHoras = Integer.parseInt(request.getParameter("cantH"));
			String fechaString = request.getParameter("fechaR");
			int idE = Integer.parseInt(request.getParameter("idE"));
			int idP = ((Persona)session.getAttribute("usuario")).getId();
			CtrlABMReserva ctrlRes = new CtrlABMReserva( );
			
			}else{
				pagina = "/login.jsp";
			}
			
		} catch (Exception e) {
			pagina = "/440.jsp";
			request.setAttribute("aviso", "Error: "+e);
		}
		
	}

}
