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

import controlers.CtrlABMPersona;

/**
 * Servlet implementation class Persona
 */
@WebServlet({ "/Persona", "/persona", "/PERSONA" })
public class Persona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Persona() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" PERSONA LISTADO");
		String pagina = "/listado_persona.jsp";
		HttpSession session = request.getSession();
		
		try {
			if (session.getAttribute("usuario")!=null) {
				System.out.println("sesion iniciada");
				CtrlABMPersona ctrlPer= new CtrlABMPersona();
				ArrayList<entity.Persona> listaper = ctrlPer.getAll();
				System.out.println(listaper.get(1).getApellido());
				request.setAttribute("listaper", listaper);
				request.setAttribute("categorias", ctrlPer.getCategorias());
				
				if(request.getParameter("dni")!=null){
					String dni=request.getParameter("dni");
					System.out.println("parametro "+dni);
					entity.Persona perdni = new entity.Persona();
					perdni = ctrlPer.getByDni(dni);
					
					session.setAttribute("existedni", perdni);
					if(perdni==null){
					session.setAttribute("nuevodni", dni);
					}else{
					session.setAttribute("nuevodni", null);
					}
				}else{
					session.setAttribute("perdni", null);
				}
				
			}else{
				pagina = "/login.jsp";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		RequestDispatcher dispatcher =  getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);  
		
		//request.getRequestDispatcher(pagina).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
