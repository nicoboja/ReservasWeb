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

import controlers.CtrlABMTipoElemento;
import entity.TipoElemento;

/**
 * Servlet implementation class ModificaTipoElemento
 */
@WebServlet("/ModificaTipoElemento")
public class ModificaTipoElemento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaTipoElemento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" GET - Modifica TIPO ELEMENTO");
		
		String pagina = "/modifica_tipo_elemento.jsp";
		HttpSession session = request.getSession();
		try {
			if (session.getAttribute("usuario")==null) {
				pagina = "/login.jsp";
			}else{
				
				CtrlABMTipoElemento ctrlTipo = new CtrlABMTipoElemento();
				ArrayList<TipoElemento> tipos = ctrlTipo.getAll();
				System.out.println(tipos);
				request.setAttribute("tipos", tipos);
				

				
			}
		} catch (Exception e) {
			request.setAttribute("aviso", e);
		}
		
		request.getRequestDispatcher(pagina).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println(" POST - NUEVO TIPO ELEMENTO");
		
		String pagina = "/modifica_tipo_elemento.jsp";
		HttpSession session = request.getSession();
		try {
			
			CtrlABMTipoElemento ctrlTipo = new CtrlABMTipoElemento();
			if (session.getAttribute("usuario")!=null) {
				System.out.println("sesion iniciada");
				int id = Integer.parseInt(request.getParameter("id"));
				int max = Integer.parseInt(request.getParameter("cant"));
				int dias = Integer.parseInt(request.getParameter("dias"));
				String desc = request.getParameter("desc");
				TipoElemento te = new TipoElemento();
				te.setIdT(id);
				te.setCantMax(max);
				te.setDescripcion(desc);
				te.setDiasMaxAnt(dias);
				
				ctrlTipo.update(te);
				request.setAttribute("aviso", "Se Modifico el Tipo de Elemento: <b>"+te.getDescripcion()+"</b>");
				
			}else{
				pagina = "/login.jsp";
			}
			
			ArrayList<TipoElemento> tipos = ctrlTipo.getAll();
			request.setAttribute("tipos", tipos);
			
		} catch (Exception e) {
			request.setAttribute("aviso", e);
		}
		RequestDispatcher dispatcher =  getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response); 
	}

}
