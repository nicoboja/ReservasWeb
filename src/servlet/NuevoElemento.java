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
 * Servlet implementation class NuevoElemento
 */
@WebServlet("/NuevoElemento")
public class NuevoElemento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevoElemento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Nuevo Elemento");
		String pagina = "/nuevo_elemento.jsp";
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
		System.out.println("Nuevo Elemento");
		String pagina = "/nuevo_elemento.jsp";
		HttpSession session = request.getSession();
		
		try {
			System.out.println("IDTIPO: "+request.getParameter("idTipo"));
			System.out.println("DESC: "+request.getParameter("desc"));
			System.out.println("Nombre: "+request.getParameter("nom_elem"));
			
			
			if (session.getAttribute("usuario")!=null) {
				try {
					System.out.println("sesion iniciada");
					CtrlABMTipoElemento ctrlTipo = new CtrlABMTipoElemento();
					ArrayList<TipoElemento> tipos = ctrlTipo.getAll();
					request.setAttribute("tipos", tipos);
					
					CtrlABMElemento ctrlElem = new CtrlABMElemento();
					
					Elemento elem = new Elemento();
					
					int idTE = Integer.parseInt(request.getParameter("idTipo"));
					String descrip = request.getParameter("desc");
					String nombre = request.getParameter("nom_elem");
					elem.setDescrip(descrip);
					elem.setNombre(nombre);
					elem.setTipoElem(ctrlTipo.getById(idTE));
					ctrlElem.add(elem);	
					
					request.setAttribute("aviso", "Se agrego el elemento: "+nombre);
					
				} catch (AppDataException e) {
					request.setAttribute("aviso", "Error: "+e);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
							
				
			}else{
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		RequestDispatcher dispatcher =  getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}
	
	

}
