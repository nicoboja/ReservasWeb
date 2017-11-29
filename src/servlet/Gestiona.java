package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlers.CtrlABMPersona;
import entity.Categoria;
import entity.Persona;

/**
 * Servlet implementation class Gestiona
 */
@WebServlet({ "/gestiona/*", "/Gestiona/*", "/GESTIONA/*" })
public class Gestiona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Gestiona() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch (request.getPathInfo()) {
		case "/listado_persona":
			this.listado(request,response);
			break;
		case "/buscar_persona":
			this.gestionaPersona(request,response);
			break;
		case "/buscar_dni":
			this.buscarDni(request, response);
			break;
		
			
		default:
			this.error(request,response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" PERSONA BUSCAR");
		String pagina = "/pages/buscar_persona.jsp";
		try {
			if (request.getSession().getAttribute("persona")!=null) {
				System.out.println("sesion iniciada");
				CtrlABMPersona ctrlPer= new CtrlABMPersona();
				request.setAttribute("categorias", ctrlPer.getCategorias());
				
				String dni=request.getParameter("dni");
				System.out.println("parametro "+dni);
				
				Persona perdni = new Persona();
				perdni = ctrlPer.getByDni(dni);
				System.out.println("parametro "+perdni.getDni());
				
				if(perdni!=null){
				request.setAttribute("perdni", perdni);
				}else{
					request.setAttribute("nuevodni", dni);
				}
								
			}else{
				pagina = "/pages/login.jsp";
			}
			RequestDispatcher dispatcher =  getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);  
			
			request.getRequestDispatcher(pagina).forward(request, response);		
		} catch (Exception e) {
			this.error(request,response);
		}
	

	}
	private void error(HttpServletRequest request, HttpServletResponse response) {
		response.setStatus(404);
		//redirigir a página de error
	}
	
	private void listado(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//response.getWriter().append("Consulta, requested action: ").append(request.getPathInfo()).append(" through post");
		//crear el controlador y ejecutar el getOne o getById
		
		System.out.println(" PERSONA LISTADO");
		String pagina = "/pages/listado_persona.jsp";
		
		try {
			
			if (request.getSession().getAttribute("persona")!=null) {
				System.out.println("sesion iniciada");
				CtrlABMPersona ctrlPer= new CtrlABMPersona();
				ArrayList<Persona> listaper = ctrlPer.getAll();
				System.out.println(listaper.get(1).getApellido());
				request.setAttribute("listaper", listaper);
				//ArrayList<Categoria> listacat = ctrlPer.getCategorias();
				//request.setAttribute("listacat", listacat);
				//System.out.println(listacat.get(1).getDescripcion());
								
			}else{
				pagina = "/pages/login.jsp";
			}

			RequestDispatcher dispatcher =  getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);  
			
			request.getRequestDispatcher(pagina).forward(request, response);	
			
		} catch (Exception e) {
			this.error(request,response);
		}
	}
	private void gestionaPersona(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(" PERSONA BUSCAR");
		String pagina = "/pages/buscar_persona.jsp";
		
		try {
			if (request.getSession().getAttribute("persona")!=null) {
				System.out.println("sesion iniciada");
				CtrlABMPersona ctrlPer= new CtrlABMPersona();
				request.setAttribute("categorias", ctrlPer.getCategorias());
								
			}else{
				pagina = "/pages/login.jsp";
			}
			
			RequestDispatcher dispatcher =  getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);  
			
			request.getRequestDispatcher(pagina).forward(request, response);		
		} catch (Exception e) {
			this.error(request,response);
		}
		
		
		
	}
	private void buscarDni(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(" PERSONA BUSCAR");
		String pagina = "/pages/buscar_persona.jsp";
		try {
			if (request.getSession().getAttribute("persona")!=null) {
				System.out.println("sesion iniciada");
				CtrlABMPersona ctrlPer= new CtrlABMPersona();
				
				
				String dni=request.getParameter("dni");
				System.out.println("parametro "+dni);
				
				Persona perdni = new Persona();
				perdni = ctrlPer.getByDni(dni);
				System.out.println("parametro "+perdni.getDni());
				request.setAttribute("perdni", perdni);
				
				if(perdni!=null){
					System.out.println(perdni.getApellido());
				request.getSession().setAttribute("perdni", perdni);
				}else{
					request.setAttribute("nuevodni", dni);
				}
				request.setAttribute("categorias", ctrlPer.getCategorias());
								
			}else{
				pagina = "/pages/login.jsp";
			}
			RequestDispatcher dispatcher =  getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);  
			
			request.getRequestDispatcher(pagina).forward(request, response);		
		} catch (Exception e) {
			this.error(request,response);
		}
	
	}

}
