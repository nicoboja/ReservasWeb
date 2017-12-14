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
import entity.Persona;
import entity.Reserva;

/**
 * Servlet implementation class CancelarReserva
 */
@WebServlet("/CancelarReserva")
public class CancelarReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelarReserva() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" GET -Cancelar Reserva");
		String pagina = "/cancelar_reserva.jsp";
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
		System.out.println(" POST -Cancelar Reserva");
		String pagina = "/cancelar_reserva.jsp";
		HttpSession session = request.getSession();
		try {
			if(session.getAttribute("usuario")!=null) {
				System.out.println("sesion iniciada");
				CtrlABMReserva ctrlRes = new CtrlABMReserva();
				
				try {
					int idRes = Integer.parseInt(request.getParameter("idRes"));
					System.out.println(idRes);
					Reserva res = new Reserva();
					res.setId(idRes);
					ctrlRes.cancelRes(res);
					request.setAttribute("aviso", "Se ha cancelado la reserva exitosamente");
					Persona per = new Persona();
					per = (Persona)session.getAttribute("usuario");
					ArrayList<Reserva> listaRes = ctrlRes.getById(per.getId());
					request.setAttribute("listares", listaRes );
					System.out.println("cancelado");
				} catch (Exception e) {
					request.setAttribute("aviso", "Error: "+e);
					Persona per = new Persona();
					per = (Persona)session.getAttribute("usuario");
					ArrayList<Reserva> listaRes = ctrlRes.getById(per.getId());
					request.setAttribute("listares", listaRes );
					System.out.println("catch");
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
