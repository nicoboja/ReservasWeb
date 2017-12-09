package controlers;

import java.util.ArrayList;

import data.DataElemento;
import data.DataTipoElemento;
import entity.Elemento;
import entity.Persona;
import entity.TipoElemento;
import util.AppDataException;

public class CtrlABMElemento {

	private DataElemento dataElem=new DataElemento();
	private DataTipoElemento dataTipo=new DataTipoElemento();
	
	public CtrlABMElemento(){}
	
	public CtrlABMElemento(DataElemento dataElem, DataTipoElemento dataTipo) {
		this.dataElem = dataElem;
		this.dataTipo = dataTipo;
	}
	
	public void add(Elemento elem) throws Exception{
		
			dataElem.add(elem);
	}
	
	public void delete(Elemento elem) throws Exception{
		
			dataElem.delete(elem);
	}
	
	public void update(Elemento elem) throws Exception{
		if(elem.getNombre().length()!=0){ 
			
				dataElem.update(elem);		
				
		}else{
			throw new Exception("elemento vacio");
		}					
	}	
	
	public ArrayList<Elemento> getAll()throws Exception{
		return dataElem.getAll();
	}
	
	public Elemento getByNombre(Elemento e) throws Exception{
		return this.dataElem.getByNombre(e);		
	}


}
