package controlers;

import java.util.ArrayList;

import data.DataCategoria;
import data.DataPersona;
import entity.Categoria;
import entity.Persona;
import util.AppDataException;

public class CtrlABMPersona {

	private DataPersona dataPer;
	private DataCategoria dataCat;	
	private ArrayList<Persona> pers;
	
	public CtrlABMPersona(){
		dataPer = new DataPersona();
		dataCat = new DataCategoria();
		pers= new ArrayList<Persona>();
	}
	
	public void add(Persona p) throws Exception {
		if(p.getDni().length()!=0){
			dataPer.add(p);
		}else{
			throw new Exception("DNI erroneo");
		}		
	}
	
	public void delete(Persona p)throws Exception{
		try{
			dataPer.remove(p);
		}catch (Exception e) {
			throw e;
		}				
	}
	
	public void update(Persona p)throws Exception{
		if(p.getDni().length()!=0){
			dataPer.update(p);
		}else{
			throw new Exception("DNI erroneo");
		}	
	}
	
	public Persona login(Persona per) throws Exception{
		return dataPer.getLogedUser(per);
	}	
	
	public Persona getByUss(Persona p) throws Exception{
		return dataPer.getByUss(p);
	}
	
	public Persona getByDni(Persona p) throws Exception{
		return this.dataPer.getByDni(p);
	}
	
	public Persona getByDni(String dni)throws Exception{
		Persona p=new Persona();
		p.setDni(dni);
		return getByDni(p);
	}
	
	public ArrayList<Persona> getAll()throws Exception{
		return dataPer.getAll();
	}
	
	public ArrayList<Categoria> getCategorias() throws Exception{
		return dataCat.getAll();
	}
	
	public Categoria getCat(int c) throws Exception{
		System.out.println("Ctrl getcat");
		return dataCat.getById(c);
	}
	
}
