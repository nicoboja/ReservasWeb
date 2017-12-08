package controlers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import data.DataElemento;
import data.DataReserva;
import data.DataTipoElemento;
import entity.Elemento;
import entity.Reserva;
import entity.TipoElemento;
import util.AppDataException;

public class CtrlABMReserva {
	
	private DataReserva dataRes=new DataReserva();
	private DataTipoElemento dataTipo=new DataTipoElemento();
	private DataElemento dataElem=new DataElemento();
	
	public void add(Reserva r) throws Exception{

		java.sql.Date fechaActual=null;
		
		fechaActual=dataRes.getFecActual();
		
		if(fechaActual.before(r.getFecha())){
			if(r.getElem().getTipoElem().getCantMax()>dataRes.getTotalByTipo(r)){
				try {
					dataRes.add(r);
				} catch (Exception e) {
					throw new AppDataException(e,"Error al cargar la reserva en la BD");
				}			
			}else{
				String e="Supero la cantidad de reservas para el tipo de elemento";
				throw new AppDataException(e);
			}
		}else{
			String e="Se debe reservar en una fecha posterior a la actual";
			throw new AppDataException(e);
		}
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