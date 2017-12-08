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
import entity.Elemento;
import util.AppDataException;

/**
 * Servlet implementation class ModificaElemento
 */
@WebServlet("/ModificaElemento")
public class ModificaElemento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaElemento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Modifica Elemento GET");
		String pagina = "/modifica_elemento.jsp";
		HttpSession session = request.getSession();
		try {
			if (session.getAttribute("usuario")!=null) {
				System.out.println("sesion iniciada");
				CtrlABMElemento ctrlElem = new CtrlABMElemento();
				ArrayList<Elemento> listelem = ctrlElem.getAll();
				
				request.setAttribute("listaelem", listelem);
			}else{
				pagina = "/login.jsp";
			}
			
		} catch (AppDataException e) {
			request.setAttribute("aviso", "Error: "+e);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		RequestDispatcher dispatcher =  getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Modifica Elemento POST");
		String pagina = "/modifica_elemento.jsp";
		HttpSession session = request.getSession();
		try {
			if (session.getAttribute("usuario")!=null) {
				System.out.println("sesion iniciada");
				int idE = Integer.parseInt(request.getParameter("idE"));
				
				String nom = request.getParameter("nom");
				String desc = request.getParameter("desc");
				CtrlABMElemento ctrlElem = new CtrlABMElemento();
				Elemento e = new Elemento();
				e.setId(idE);
				e.setDescrip(desc);
				e.setNombre(nom);
				
				
				ctrlElem.update(e);
				
				request.setAttribute("aviso", "Se modifico el elemento: <b>"+nom+"</b>");
				ArrayList<Elemento> listelem = ctrlElem.getAll();
				request.setAttribute("listaelem", listelem);
				
			}else{
				pagina = "/login.jsp";
			}
			
		} catch (AppDataException e) {
			request.setAttribute("aviso", "Error: "+e);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		RequestDispatcher dispatcher =  getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response); 
	}

}
