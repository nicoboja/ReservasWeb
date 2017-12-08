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
import entity.Categoria;
import util.AppDataException;

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
		String pagina = "/persona.jsp";
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
					
					entity.Persona perdni = new entity.Persona();
					perdni = ctrlPer.getByDni(dni);
					
					request.setAttribute("existedni", perdni);
					if(perdni==null){
					request.setAttribute("nuevodni", dni);
					}
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
		System.out.println("------- POST PERSONA -------");
		String pagina = "/persona.jsp";
		HttpSession session = request.getSession();
		
		try {
			if (session.getAttribute("usuario")!=null) {
				System.out.println("sesion iniciada");
				CtrlABMPersona ctrlPer= new CtrlABMPersona();
				
				System.out.println("DNIFORM: "+request.getParameter("dniform"));
				System.out.println("NOMBRE: "+request.getParameter("nombre"));
				
				if(!request.getParameter("dniform").isEmpty()){
					
					String dni=request.getParameter("dniform");
					System.out.println("parametro "+dni);
					
					entity.Persona perdni = new entity.Persona();
					
					System.out.println(request.getParameter("categoria"));
					int idcat = Integer.parseInt(request.getParameter("categoria"));
					
				//	System.out.println(idcat);
					
					
					
					entity.Persona perform = new entity.Persona();
					perform.setCategoria(new Categoria());
					perform.getCategoria().setId(idcat);
					perform.setDni(request.getParameter("dniform"));
					perform.setNombre(request.getParameter("nombre"));
					perform.setApellido(request.getParameter("apellido"));
					perform.setUss(request.getParameter("uss"));
					perform.setPass(request.getParameter("pass"));
					
					if (request.getParameter("habilita").equals("true")) {
						perform.setHabilitado(true);
					}else{
						perform.setHabilitado(false);
					}
					
					perdni = ctrlPer.getByDni(dni);
					
					//System.out.println(perdni.getApellido());
					
					if(perdni==null){
						System.out.println("NUEVO");
						try {
							ctrlPer.add(perform);
							
						} catch (AppDataException e) {
							request.setAttribute("error", "Error: "+e);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}else{
						
					try {
						perform.setId(perdni.getId());
						System.out.println("MODIFICAR");
						ctrlPer.update(perform);	
						
					} catch (AppDataException e) {
						request.setAttribute("error", "Error: "+e);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
						
					}
				}
					
					
					ArrayList<entity.Persona> listaper = ctrlPer.getAll();
					request.setAttribute("listaper", listaper);
					request.setAttribute("categorias", ctrlPer.getCategorias());
				
			}else{
				pagina = "/login.jsp";	
			}
			
		} catch (AppDataException e) {
			request.setAttribute("error", "Error: "+e);
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher =  getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);  
	}
	protected void mapearDeForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}


}
