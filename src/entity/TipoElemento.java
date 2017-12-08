package entity;

public class TipoElemento {

	private int idT;
	private String descripcion;
	private int diasMaxAnt;
	private int cantMax;
	
	
	
	
	public int getIdT() {
		return idT;
	}
	public void setIdT(int idT) {
		this.idT = idT;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getDiasMaxAnt() {
		return diasMaxAnt;
	}
	public void setDiasMaxAnt(int diasMaxAnt) {
		this.diasMaxAnt = diasMaxAnt;
	}
	public int getCantMax() {
		return cantMax;
	}
	public void setCantMax(int cantMax) {
		this.cantMax = cantMax;
	}
		
	@Override
	public int hashCode() {
		return Integer.hashCode(this.idT);
	}
	
	@Override
	public boolean equals(Object obj) {
		return ((obj instanceof TipoElemento) &&((TipoElemento)obj).getIdT()==this.idT);
	}
	@Override
	public String toString() {
		return String.valueOf(idT) + descripcion;
	}	
}
