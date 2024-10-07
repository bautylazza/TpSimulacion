package modeloejemplo.estadodelsistema;

/* Solicitud que busca bebida o panaderia. */

public class Solicitud {
	
	String tipo;

	public Solicitud(String s) {
		super();
		this.tipo = s;
	}

	public String getTipo(){
		return this.tipo;
	}

	public void setTipo(String t){
		this.tipo = t;
	}

}
