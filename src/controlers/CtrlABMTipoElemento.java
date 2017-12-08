package controlers;

import java.util.ArrayList;

import data.DataTipoElemento;
import entity.TipoElemento;

public class CtrlABMTipoElemento {
	
	private DataTipoElemento dataTipo=new DataTipoElemento();
	
	public TipoElemento getByNombre(TipoElemento te) throws Exception{
		return this.dataTipo.getByNombre(te);		
	}
	public TipoElemento getById(int idTE) throws Exception{
		return this.dataTipo.getById(idTE);		
	}
	public void add(TipoElemento te) throws Exception{
		dataTipo.add(te);
	}
	public void update(TipoElemento te)throws Exception{
		dataTipo.update(te);
	}
	public void delete(TipoElemento te) throws Exception{
		dataTipo.delete(te);
	}	
	public ArrayList<TipoElemento> getAll()throws Exception{
		return dataTipo.getAll();
	}
	
}
