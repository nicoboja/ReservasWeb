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

import controlers.CtrlABMElemento;
import controlers.CtrlABMTipoElemento;
import entity.Elemento;
import entity.TipoElemento;

/**
 * Servlet implementation class NuevaReserva
 */
@WebServlet({ "/NuevaReserva", "/nuevareserva", "/NUEVARESERVA" })
public class NuevaReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevaReserva() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Nueva Reserva (GET)");
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
			request.setAttribute("aviso", "Error: "+e);
		}
		RequestDispatcher dispatcher =  getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Nueva Reserva");
		String pagina = "/nueva_reserva_elemento.jsp";
		HttpSession session = request.getSession();
		try {
			if (session.getAttribute("usuario")!=null) {
				
				int hora = Integer.parseInt(request.getParameter("horaInicio"));
				int cantHoras = Integer.parseInt(request.getParameter("cantHoras"));
				if(hora+cantHoras<24){
					//CtrlABMElemento ctrlElem = new CtrlABMElemento();
					//CtrlABMTipoElemento ctrlTipo = new CtrlABMTipoElemento();
					//Elemento elemento = new Elemento();
					
					
					
					String fechaInicio = request.getParameter("fechaInicio");
					int idTipo = Integer.parseInt(request.getParameter("idTipo"));
					
					System.out.println("Fecha Inicio: "+fechaInicio+" ID"+idTipo);
					
					//
					CtrlABMTipoElemento ctrlTipo = new CtrlABMTipoElemento();
					ArrayList<TipoElemento> tipos = ctrlTipo.getAll();
					System.out.println(tipos.get(1).getIdT());
					request.setAttribute("tipos", tipos);
					
				}else{
					
					System.out.println("sesion iniciada");
					CtrlABMTipoElemento ctrlTipo = new CtrlABMTipoElemento();
					ArrayList<TipoElemento> tipos = ctrlTipo.getAll();
					System.out.println(tipos.get(1).getIdT());
					request.setAttribute("tipos", tipos);
					request.setAttribute("aviso", "Advertencia: La hora fin supera el dia de la fecha");
					pagina = "/nueva_reserva.jsp";
					
				}
			}else{
				pagina = "/login.jsp";
			}
			
		} catch (Exception e) {
			request.setAttribute("aviso", "Error: "+e);
		}
		RequestDispatcher dispatcher =  getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response); 
	}

	
	
}
