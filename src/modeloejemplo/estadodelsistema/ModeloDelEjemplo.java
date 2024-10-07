package modeloejemplo.estadodelsistema;

import des.EstadoDelSistema;

/* Colección de variables de estado necesarias para describir  el sistema en un punto en el tiempo. */

public class ModeloDelEjemplo extends EstadoDelSistema {
	
	private ColaDeSolicitudes cola;
	private Servidor servidor1, servidor2;
	
	public void inicializar() {
		cola = new ColaDeSolicitudes();
		servidor1 = new Servidor(false);
	}

	public void encolarSolicitud(Solicitud solicitudParaAgregar) {		
		System.out.println("\t\t-- El MODELO encola una solicitud del tipo" + solicitudParaAgregar.getTipo() + " ya que el servidor está ocupado.");
		cola.encolarSolicitud(solicitudParaAgregar);
	}

	public boolean estaServidorOcupado() {
		return servidor1.getEstaOcupado();
	}

	public void atenderSolicitud(Solicitud solicitudParaAgregar) {
		System.out.println("\t\t-- El MODELO atiende una solicitud del tipo " + solicitudParaAgregar.getTipo());
		servidor1.pasarAOcupado(solicitudParaAgregar);
	}

	public boolean haySolicitudesEnEspera() {
		return (cola.getCantSolicitudesEsperando()>0);
	}

	public Solicitud obtenerSolicitudPrioritaria() {
		return cola.solicitudPrioritaria();
	}

	public void actualizarServidorDisponible() {
		servidor1.setEstaOcupado(false);
	}
	
}
