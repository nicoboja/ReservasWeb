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
 * Servlet implementation class Elemento
 */
@WebServlet({ "/Elemento", "/elemento", "/ELEMENTO" })
public class Elemento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Elemento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(" GET - TIPO ELEMENTO");
		
		String pagina = "/tipo_elemento.jsp";
		HttpSession session = request.getSession();
		
		try {
			if(session.getAttribute("usuario")!=null) {
				System.out.println("sesion iniciada");
				session.setAttribute("aviso",null);
				
				if(request.getParameter("idTipo")!=null && !request.getParameter("idTipo").equals("0") && !request.getParameter("idTipo").equals("")){
					
					CtrlABMTipoElemento ctrlElem = new CtrlABMTipoElemento();
					int idTE = Integer.parseInt(request.getParameter("idTipo"));
					System.out.println(idTE);
					TipoElemento tipo = new TipoElemento();
					
					tipo = ctrlElem.getById(idTE);
					System.out.println("TIPO: "+tipo.getDescripcion());
				
					//session.setAttribute("tipo", tipo);	
					if(tipo.getDescripcion()==null){
						System.out.println("tiponulo - es nuevo");
						session.setAttribute("tipo", null);
						session.setAttribute("nuevo", request.getParameter("idTipo"));
						}else{
							session.setAttribute("tipo", tipo);
						}
				}else{
					session.setAttribute("tipo", null);
					session.setAttribute("nuevo", null);
				}
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
		// TODO Auto-generated method stub
		System.out.println(" POST - TIPO ELEMENTO");
				
		String pagina = "/tipo_elemento.jsp";
		HttpSession session = request.getSession();
		
		try {
			if (session.getAttribute("usuario")!=null) {
				System.out.println("sesion iniciada");
				session.setAttribute("aviso",null);
				if(request.getParameter("idTform")!=null && !request.getParameter("idTform").equals("0") && !request.getParameter("idTform").equals("")){
					CtrlABMTipoElemento ctrTE = new CtrlABMTipoElemento();
					
					int idTE = Integer.parseInt(request.getParameter("idTform"));
					System.out.println(idTE);
					String desc = request.getParameter("descripcion");
					int max = Integer.parseInt(request.getParameter("max"));
					int dias = Integer.parseInt(request.getParameter("dias"));
					
					TipoElemento tipo = new TipoElemento();
					TipoElemento tn = new TipoElemento();
					tipo = ctrTE.getById(idTE);
					
					tn.setCantMax(max);
					tn.setDescripcion(desc);
					tn.setDiasMaxAnt(dias);
					
					
					if(tipo.getDescripcion()==null){
						System.out.println("NUEVO - agrega");
						try {
							ctrTE.add(tn);
							session.setAttribute("tipo", null);
							session.setAttribute("nuevo", null);
							session.setAttribute("aviso", "Se ha agregado un nuevo tipo de elemento!");
							
						} catch (Exception e) {
							
							session.setAttribute("aviso", "Error! al agregar nuevo tipo de elemento");
						}
					}else{
						System.out.println("EXISTE - modifica");
						try {
							tn.setIdT(idTE);
							ctrTE.update(tn);
							session.setAttribute("tipo", null);
							session.setAttribute("nuevo", null);
							session.setAttribute("aviso", "Se ha modificado el tipo de elemento!");
						} catch (Exception e) {
							session.setAttribute("aviso", "Error! al modificar tipo de elemento");
					}
				}	
					
				
				}else{
					session.setAttribute("tipo", null);
					session.setAttribute("nuevo", null);
					
				}
				
			}else{
				pagina = "/login.jsp";	
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			RequestDispatcher dispatcher =  getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);  	
		}
		
		
	}

}
