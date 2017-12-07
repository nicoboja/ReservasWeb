package entity;


public class TipoElemento {
	private int id;
	private String nombre;
	private int cantMax;
	private Boolean encargado;
	private int limiteHoras;
	private int diasMax;
	
	public TipoElemento(){}
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getCantMax() {
		return cantMax;
	}



	public void setCantMax(int cantMax) {
		this.cantMax = cantMax;
	}



	public Boolean getEncargado() {
		return encargado;
	}



	public void setEncargado(Boolean encargado) {
		this.encargado = encargado;
	}



	public int getLimiteHoras() {
		return limiteHoras;
	}



	public void setLimiteHoras(int limiteHoras) {
		this.limiteHoras = limiteHoras;
	}



	public int getDiasMax() {
		return diasMax;
	}



	public void setDiasMax(int diasMax) {
		this.diasMax = diasMax;
	}



	@Override
	public String toString()
	{
//		return	this.getNombre();
		return (this.id + " - " + this.getNombre());
	}
	
	@Override
	public boolean equals(Object tp)
	{
		return (tp instanceof TipoElemento) && ((TipoElemento) tp).getId()==(this.getId());
	}
}
