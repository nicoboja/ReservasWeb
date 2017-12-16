package controlers;

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
	
	public ArrayList<Elemento> getDisponibles(int t, Reserva r) throws Exception{
		ArrayList<Elemento> elemDisp=new ArrayList<Elemento>();
		ArrayList<Reserva> res=new ArrayList<Reserva>();
		res=dataRes.getByFecTipo(r.getFecha(), t);
		int horaIni;
		int horaFin;
		horaIni=r.getHora().getHours();
		horaFin=r.getHora().getHours()+r.getCantHoras();
		System.out.println(horaFin);
		elemDisp=dataElem.getByTipo(t);
		for (int i=0; i<res.size();i++){
			int hIniRes;
			int hFinRes;
			hIniRes=res.get(i).getHora().getHours();
			hFinRes=res.get(i).getHora().getHours()+res.get(i).getCantHoras();
		
			if ((horaIni<hIniRes && hIniRes<horaFin) || (horaIni<hFinRes && hFinRes<horaFin)){
								
				elemDisp.remove(res.get(i).getElem());
				
			}
		}				
		return elemDisp;
	}
	public void add(Reserva r) throws Exception{
		java.sql.Date fechaActual=null;		
		fechaActual=dataRes.getFecActual();
		
		if(fechaActual.before(r.getFecha())){
			if(r.getElem().getTipoElem().getCantMax()>dataRes.getTotalByTipo(r)){
				
					dataRes.add(r);
							
			}else{
				String e="Supero la cantidad de reservas para el tipo de elemento";
				throw new AppDataException(e);
			}
		}else{
			String e="Se debe reservar en una fecha posterior a la actual";
			throw new AppDataException(e);
		}
	}
	
	public void cancelRes(Reserva r) throws Exception {
		dataRes.cancelRes(r);
		
	}
	
	public Reserva getById(Reserva r) throws Exception{
		return this.dataRes.getById(r);		
	}
	
	public ArrayList<Reserva> getById(int idP) throws Exception{
		return this.dataRes.getById(idP);		
	}
	
	public ArrayList<TipoElemento> getTipos() throws Exception{
		return dataTipo.getAll();
	}
	
	public ArrayList<Elemento> getElementos() throws Exception{
		return dataElem.getAll();
	}

}