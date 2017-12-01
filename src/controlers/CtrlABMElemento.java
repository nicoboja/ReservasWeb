package controlers;

import java.util.ArrayList;

import data.DataElemento;
import data.DataTipoElemento;
import entity.Elemento;
import entity.Persona;
import entity.TipoElemento;

public class CtrlABMElemento {

	private DataElemento dataElem=new DataElemento();
	private DataTipoElemento dataTipo=new DataTipoElemento();
	
	
	public CtrlABMElemento(DataElemento dataElem, DataTipoElemento dataTipo) {
		super();
		this.dataElem = dataElem;
		this.dataTipo = dataTipo;
	}

	public void add(Elemento e) throws Exception{
		dataElem.add(e);
	}
	
	public ArrayList<Elemento> getAll()throws Exception{
		return dataElem.getAll();
	}
	
	public Elemento getByNombre(Elemento e) throws Exception{
		return this.dataElem.getByNombre(e);		
	}
	
	public void delete(Elemento e) throws Exception{
		dataElem.delete(e);
	}
	
	public ArrayList<TipoElemento> getTipos() throws Exception{
		return dataTipo.getAll();
	}
	public void update(Elemento e)throws Exception{
		dataElem.update(e);
	}
}
