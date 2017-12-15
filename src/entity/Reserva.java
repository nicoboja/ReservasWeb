package entity;

import java.sql.Date;
import java.sql.Time;

public class Reserva {
	private int id;
	private java.sql.Date fecha;//= new SimpleDateFormat("dd/MM/yyyy HH:mm");
	private java.sql.Time hora;
	private String detalle;
	private Elemento elem;
	private Persona per;
	private int cantHoras;
	private String estado;
	
	public Reserva(){};
	
	public Reserva(int id, Date fecha, Time hora, String detalle, Elemento elem, Persona per, int cantHoras, String estado) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.detalle = detalle;
		this.elem = elem;
		this.per = per;
		this.cantHoras = cantHoras;
		this.estado = estado;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getCantHoras() {
		return cantHoras;
	}
	public void setCantHoras(int cantHoras) {
		this.cantHoras = cantHoras;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(java.sql.Date dateInicio) {
		this.fecha = dateInicio;
		
	}
	public Time getHora() {
		return hora;
	}
	public void setHora(java.sql.Time hora) {
		this.hora = hora;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public Elemento getElem() {
		return elem;
	}
	public void setElem(Elemento elem) {
		this.elem = elem;
	}
	public Persona getPer() {
		return per;
	}
	public void setPer(Persona per) {
		this.per = per;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Reserva))
			return false;
		Reserva other = (Reserva) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
}
