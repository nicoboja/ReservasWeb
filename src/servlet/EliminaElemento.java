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
import util.AppDataException;

/**
 * Servlet implementation class EliminaElemento
 */
@WebServlet({ "/EliminaElemento", "/eliminaelemento", "/ELIMINAELEMENTO" })
public class EliminaElemento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminaElemento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Elimina Elemento GET");
		String pagina = "/elimina_elemento.jsp";
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
		System.out.println("Elimina Elemento POST");
		String pagina = "/elimina_elemento.jsp";
		HttpSession session = request.getSession();
		try {
			if (session.getAttribute("usuario")!=null) {
				System.out.println("sesion iniciada");
				int idE = Integer.parseInt(request.getParameter("idE"));
				
				String nom = request.getParameter("nom");
				
				CtrlABMElemento ctrlElem = new CtrlABMElemento();
				Elemento e = new Elemento();
				e.setId(idE);
				System.out.println("SERVLET ID E: "+e.getId());
				ctrlElem.delete(e);
				
				request.setAttribute("aviso", "Se elimino el elemento: <b>"+nom+"</b>");
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
