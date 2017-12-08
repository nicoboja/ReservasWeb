package controlers;

import java.util.ArrayList;

import data.DataTipoElemento;
import entity.TipoElemento;
import util.AppDataException;

public class CtrlABMTipoElemento {
	
	private DataTipoElemento dataTipo=new DataTipoElemento();
	
	public void add(TipoElemento te) throws Exception{
		if (te.getDescripcion().length() != 0){
			if (te.getCantMax() >= 0){	
				try{
					dataTipo.add(te);				
				
				}catch (Exception e){
					throw new AppDataException(e,"tipo de elemento");								
				}
			}else{
				throw new AppDataException("Maximo pendiente erroneo");
			}
		}else{
			throw new AppDataException("Descripcion erronea");
		}		
	}
	
	public void delete(TipoElemento te) throws Exception{
		try {
			dataTipo.delete(te);
		} catch (Exception e) {
			throw new AppDataException(e,"tipo de elemento");
		}	
	}	
	
	public void update(TipoElemento te)throws Exception{
		if (te.getDescripcion().length() != 0){
			if (te.getCantMax() >= 0){	
				try{
					dataTipo.update(te);
					
				}catch (Exception e){
					throw new AppDataException(e,"tipo de elemento");								
				}
			}else{
				throw new AppDataException("Maximo pendiente erroneo");
			}
		}else{
			throw new AppDataException("Descripcion erronea");
		}		
	}

	public TipoElemento getByNombre(TipoElemento te) throws Exception{
		return this.dataTipo.getByNombre(te);		
	}
	public TipoElemento getById(int idTE) throws Exception{
		return this.dataTipo.getById(idTE);		
	}
	
	public ArrayList<TipoElemento> getAll()throws Exception{
		return dataTipo.getAll();
	}
	
}
