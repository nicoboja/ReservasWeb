package servlet;

import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.print.PrintException;
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
import entity.Reserva;
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
		System.out.println("Nueva Reserva");
		String pagina = "/nueva_reserva_elemento.jsp";
		HttpSession session = request.getSession();
		try {
			if (session.getAttribute("usuario")!=null) {
				
				int hora = Integer.parseInt(request.getParameter("horaInicio"));
				int cantHoras = Integer.parseInt(request.getParameter("cantHoras"));
				
				
				if(hora+cantHoras<24){
					String fechaString = request.getParameter("fechaInicio");
					System.out.println(fechaString);
					SimpleDateFormat formatFecha = new SimpleDateFormat("yyyy-MM-dd");
					Date fechaUtil = formatFecha.parse(fechaString);
					java.sql.Date fechaSql = new java.sql.Date(fechaUtil.getTime());
					//
					String horaString = "0"+hora+":00:00";
					DateFormat formatHora = new SimpleDateFormat("hh:mm:ss");
					Date horaUtil = formatHora.parse(horaString);
				    java.sql.Time horaSql = new java.sql.Time(horaUtil.getTime());
					//
				    Reserva res = new Reserva();
				    res.setCantHoras(cantHoras);
				    res.setFecha(fechaSql);
					res.setHora(horaSql);
					//
					int idTipo = Integer.parseInt(request.getParameter("idTipo"));
					System.out.println("ID: "+idTipo+ " "+cantHoras+" "+fechaSql+" "+horaSql);
					//
					CtrlABMElemento ctrlElem = new CtrlABMElemento();
					
					ArrayList<Elemento> elementos = ctrlElem.getDisponibles(res, idTipo);
					if(elementos!=null){
						request.setAttribute("elementos", elementos);
						request.setAttribute("datosR", res);
						
					}else{
						CtrlABMTipoElemento ctrlTipo = new CtrlABMTipoElemento();
						ArrayList<TipoElemento> tipos = ctrlTipo.getAll();
						request.setAttribute("tipos", tipos);
						request.setAttribute("aviso", "Advertencia: No existen elementos en disponibles");
						pagina = "/nueva_reserva.jsp";
					}
					
						
				}else{
					
					CtrlABMTipoElemento ctrlTipo = new CtrlABMTipoElemento();
					ArrayList<TipoElemento> tipos = ctrlTipo.getAll();
					request.setAttribute("tipos", tipos);
					request.setAttribute("aviso", "Advertencia: La hora fin supera el dia de la fecha");
					pagina = "/nueva_reserva.jsp";
					
				}
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

	
	
}
