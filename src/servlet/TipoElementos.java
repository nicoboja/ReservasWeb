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
 * Servlet implementation class TipoElementos
 */
@WebServlet({ "/TipoElementos", "/tipoelementos", "/TIPOELEMENTOS" })
public class TipoElementos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TipoElementos() {
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
				
				CtrlABMTipoElemento ctrlTipo = new CtrlABMTipoElemento();
				ArrayList<TipoElemento> tipos = ctrlTipo.getAll();
				request.setAttribute("tipos", tipos);
				
				
				
				if(request.getParameter("idTipo")!=null && !request.getParameter("idTipo").equals("0") && !request.getParameter("idTipo").equals("")){
					System.out.println("ENTRO A LAS OPCIONES");
					
					if(request.getParameter("idTipo").equals("Nuevo")){
						request.setAttribute("nuevo", "nuevo");
						
					}else{
						int idTE = Integer.parseInt(request.getParameter("idTipo"));
						System.out.println(idTE);
						
						TipoElemento tipo = new TipoElemento();
						
						tipo = ctrlTipo.getById(idTE);
						session.setAttribute("te", tipo);
						session.setAttribute("modfica", "modifica");
						System.out.println("TIPO: "+tipo.getDescripcion());
					}

				}
			}else{
			pagina = "/login.jsp";
			}
		
		} catch (Exception e) {
			pagina = "/440.jsp";
			request.setAttribute("aviso", "Error: "+e);
			
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
							request.setAttribute("aviso", "Se ha agregado el tipo de elemento:<b> "+tn.getDescripcion()+"</b>");
							
						} catch (Exception e) {
							//request.setAttribute("aviso", "Error! al agregar nuevo tipo de elemento");
							request.setAttribute("aviso", e);
						}
					}else{
						System.out.println("EXISTE - modifica");
						try {
							tn.setIdT(idTE);
							ctrTE.update(tn);
							request.setAttribute("aviso", "Se ha modificado el tipo de elemento!");
						} catch (Exception e) {
							request.setAttribute("aviso", e);
					}
				}	
					
				
				}
				
			}else{
				pagina = "/login.jsp";	
			}
			
		} catch (Exception e) {
			request.setAttribute("aviso", e);
		}finally {
			RequestDispatcher dispatcher =  getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response); 
		}
		
		
	}

}