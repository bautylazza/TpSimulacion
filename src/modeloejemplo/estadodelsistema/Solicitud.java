package modeloejemplo.estadodelsistema;

/* Solicitud que busca bebida o panaderia. */

public class Solicitud {
	
	String tipo = new String();

	public Solicitud() {
		super();
	}

	public String getTipo(){
		return this.tipo;
	}

	public void setTipo(String t){
		this.tipo = t;
	}

}
