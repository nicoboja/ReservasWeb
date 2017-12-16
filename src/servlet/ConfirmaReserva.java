package servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controlers.CtrlABMElemento;
import controlers.CtrlABMPersona;
import controlers.CtrlABMReserva;
import controlers.CtrlABMTipoElemento;
import entity.TipoElemento;
import entity.Elemento;
import entity.Persona;
import entity.Reserva;

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
		System.out.println("Confirma Reserva (POST)");
		System.out.println(request.getParameter("idE"));
		String pagina = "/home.jsp";
		HttpSession session = request.getSession();
		
		try {
			if (session.getAttribute("usuario")!=null) {
				
			String detalle = request.getParameter("detalle");
			int cantHoras = Integer.parseInt(request.getParameter("cantH"));
				
			String horaString = request.getParameter("horaI");
		
			DateFormat formatHora = new SimpleDateFormat("hh:mm:ss");
			Date horaUtil = formatHora.parse(horaString);
		    java.sql.Time horaSql = new java.sql.Time(horaUtil.getTime());
		    
			String fechaString = request.getParameter("fechaR");
			SimpleDateFormat formatFecha = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaUtil = formatFecha.parse(fechaString);
			java.sql.Date fechaSql = new java.sql.Date(fechaUtil.getTime());
			
			int idE = Integer.parseInt(request.getParameter("idE"));
			//int idP = ((Persona)session.getAttribute("usuario")).getId();
			
			CtrlABMReserva ctrlRes = new CtrlABMReserva( );
			CtrlABMElemento ctrlElem = new CtrlABMElemento();
			CtrlABMPersona ctrlPer = new CtrlABMPersona();
			
			Elemento elem = new Elemento();
			elem = ctrlElem.getByid(idE);
			
			Persona per = new Persona();
			per = ctrlPer.getByDni((Persona)session.getAttribute("usuario"));
			
			//Reserva res = new Reserva(fechaSql,horaSql,detalle,elem,per,cantHoras,"Pendiente");
			Reserva res = new Reserva();
			
			System.out.println(cantHoras);
			System.out.println(detalle);
			System.out.println(elem.getId());
			System.out.println("Pendiente");
			System.out.println(fechaSql);
			System.out.println(horaSql);
			System.out.println(per.getId());
			
			res.setCantHoras(cantHoras);
			res.setDetalle(detalle);
			res.setElem(elem);
			res.setEstado("Pendiente");
			res.setFecha(fechaSql);
			res.setHora(horaSql);
			res.setPer(per);
			ctrlRes.add(res);
			
			request.setAttribute("aviso", "Se agrego la reserva del dia "+fechaString+" Elemento: "+elem.getNombre()+" "+elem.getDescrip());
			ArrayList<Reserva> listaRes = ctrlRes.getById(per.getId());
			request.setAttribute("listares", listaRes );
			
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
