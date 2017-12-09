package servlet;

import java.io.IOException;


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
 * Servlet implementation class NuevoTipoElemento
 */
@WebServlet({ "/NuevoTipoElemento", "/nuevotipoelemento", "/NUEVOTIPOELEMENTO" })
public class NuevoTipoElemento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevoTipoElemento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" GET - NUEVO TIPO ELEMENTO");
		
		String pagina = "/nuevo_tipo_elemento.jsp";
		HttpSession session = request.getSession();
		try {
			
			if (session.getAttribute("usuario")==null) {
				pagina = "/login.jsp";
			}
			
		} catch (Exception e) {
			request.setAttribute("aviso", e);
		}
		RequestDispatcher dispatcher =  getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);  
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" POST - NUEVO TIPO ELEMENTO");
		
		String pagina = "/nuevo_tipo_elemento.jsp";
		HttpSession session = request.getSession();
		try {
			CtrlABMTipoElemento ctrlTipo = new CtrlABMTipoElemento();
		
			
			if (session.getAttribute("usuario")!=null) {
				System.out.println("sesion iniciada");
				int max = Integer.parseInt(request.getParameter("max"));
				int dias = Integer.parseInt(request.getParameter("dias"));
				String desc = request.getParameter("descripcion");
				TipoElemento te = new TipoElemento();
				
				te.setCantMax(max);
				te.setDescripcion(desc);
				te.setDiasMaxAnt(dias);
				
				ctrlTipo.add(te);
				request.setAttribute("aviso", "Se agrego el Tipo de Elemento: <b>"+te.getDescripcion()+"</b>");
				
			}else{
				pagina = "/login.jsp";
			}
			
		} catch (Exception e) {
			request.setAttribute("aviso", e);
		}
		RequestDispatcher dispatcher =  getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);  
	}

}
