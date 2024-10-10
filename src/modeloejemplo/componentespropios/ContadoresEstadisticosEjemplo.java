package modeloejemplo.componentespropios;

import des.ContadoresEstadisticos;
import modeloejemplo.estadodelsistema.Solicitud;

/* Variables que almacenan información estadística referida al comportamiento del sistema. */

public class ContadoresEstadisticosEjemplo extends ContadoresEstadisticos {
	
	private int cantSolicitudesPanaderia;
	private int cantSolicitudesBebida;

	public ContadoresEstadisticosEjemplo() {
		super();
	}

	public void inicializar() {
		cantSolicitudesPanaderia = 0;
		cantSolicitudesBebida = 0;	
	}

	public int getCantSolicitudesPanaderia() {
		return cantSolicitudesPanaderia;
	}
	public int getCantSolicitudesBebida() {
		return cantSolicitudesBebida;
	}
	public void actualizarCantProcesadas(Solicitud s) {
		if(s.getTipo().equals("Panaderia")){
			cantSolicitudesPanaderia++;
		}else if(s.getTipo().equals("Bebida Saludable")){
			cantSolicitudesBebida++;
		}
		
	}

}
