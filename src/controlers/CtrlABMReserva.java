package controlers;

import java.util.ArrayList;

import data.DataElemento;
import data.DataReserva;
import data.DataTipoElemento;
import entity.Elemento;
import entity.Reserva;
import entity.TipoElemento;

public class CtrlABMReserva {
	
	private DataReserva dataRes=new DataReserva();
	private DataTipoElemento dataTipo=new DataTipoElemento();
	private DataElemento dataElem=new DataElemento();
	
	public void add(Reserva r) throws Exception{
		dataRes.add(r);
	}
	
	public Reserva getById(Reserva r) throws Exception{
		return this.dataRes.getById(r);		
	}
	
	public ArrayList<Reserva> getById(int idP) throws Exception{
		return this.dataRes.getById(idP);		
	}
	
	public void delete(Reserva r) throws Exception{
		dataRes.delete(r);
	}
	
	public ArrayList<TipoElemento> getTipos() throws Exception{
		return dataTipo.getAll();
	}
	
	public void update(Reserva r)throws Exception{
		dataRes.update(r);
	}

	public ArrayList<Elemento> getElementos() throws Exception{
		return dataElem.getAll();
	}
	public void cancelRes(Reserva r) throws Exception {
		dataRes.cancelRes(r);
	}

}