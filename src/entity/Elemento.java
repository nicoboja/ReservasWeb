package entity;

public class Elemento {
	

	private int id;
	private String nombre;
	private String descrip;
	private TipoElemento tipo;
	
	public TipoElemento getTipoElem() {
		return tipo;
	}
	public void setTipoElem(TipoElemento tipo) {
		this.tipo = tipo;
	}
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
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	

	
	public Elemento(){}
	public Elemento(int id){
		this.id = id;
	}
	

	

	@Override
	public int hashCode() {
		return Integer.hashCode(this.id);
	}
	
	@Override
	public boolean equals(Object obj) {
		return ((obj instanceof Elemento) &&((Elemento)obj).getId()==this.id);
	}
	@Override
	public String toString() {
		return String.valueOf(id) + nombre;
	}	

	
}
