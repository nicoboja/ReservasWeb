package controlers;

import java.util.ArrayList;
import data.DataElemento;
import data.DataTipoElemento;
import entity.Elemento;
import entity.TipoElemento;
import util.AppDataException;

public class CtrlABMElemento {

	private DataElemento dataElem=new DataElemento();
	private DataTipoElemento dataTipo=new DataTipoElemento();
		
	public CtrlABMElemento(DataElemento dataElem, DataTipoElemento dataTipo) {
		super();
		this.dataElem = dataElem;
		this.dataTipo = dataTipo;
	}

	public void add(Elemento elem) throws Exception{
		try{
			dataElem.add(elem);
		}
		catch (Exception e){
			throw new AppDataException(e,"tipo de elemento");
		}
	}
	
	public void delete(Elemento elem) throws Exception{
		try {
			dataElem.delete(elem);
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public void update(Elemento elem)throws Exception{
		if(elem.getNombre().length()!=0){ 
			try{
				dataElem.update(elem);		
				}
			catch (Exception e){
				throw new AppDataException(e,"tipo de elemento");
			}
		}else{
			throw new Exception("nombre");
		}		
			
	}			
	
	public ArrayList<Elemento> getAll()throws Exception{
		return dataElem.getAll();
	}
	
	public Elemento getByNombre(Elemento e) throws Exception{
		return this.dataElem.getByNombre(e);		
	}
	
	public ArrayList<TipoElemento> getTipos() throws Exception{
		return dataTipo.getAll();
	}
	
}
