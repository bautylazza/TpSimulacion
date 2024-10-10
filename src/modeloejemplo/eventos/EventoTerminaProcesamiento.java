package modeloejemplo.eventos;

import des.ContadoresEstadisticos;
import des.EstadoDelSistema;
import des.Evento;
import des.ListaDeEventos;
import modeloejemplo.componentespropios.ContadoresEstadisticosEjemplo;
import modeloejemplo.componentespropios.LibreriaDeRutinasEjemplo;
import modeloejemplo.estadodelsistema.ModeloDelEjemplo;
import modeloejemplo.estadodelsistema.Solicitud;

public class EventoTerminaProcesamiento extends Evento {

	public EventoTerminaProcesamiento(double tiempoDeOcurrencia) {
		super(tiempoDeOcurrencia);
	}

	@Override
	public void rutinaDeEvento(EstadoDelSistema modelo, ContadoresEstadisticos contadores, ListaDeEventos eventos,
			LibreriaDeRutinasEjemplo libreria) {
		

		
		ModeloDelEjemplo modeloActual = (ModeloDelEjemplo) modelo;
		
		if(modeloActual.haySolicitudesEnEspera()) {
			Solicitud solicitudAProcesar = modeloActual.obtenerSolicitudPrioritaria();
			modeloActual.atenderSolicitud(solicitudAProcesar);
			double duracionDelProcesamiento = libreria.tiempoDeServicio(solicitudAProcesar);
			
			EventoTerminaProcesamiento nuevoEvento = new EventoTerminaProcesamiento(duracionDelProcesamiento);
			ContadoresEstadisticosEjemplo contadoresEjemplo = (ContadoresEstadisticosEjemplo) contadores;
			contadoresEjemplo.actualizarCantProcesadas(solicitudAProcesar);	
			System.out.println(" LLEGA HAY SOLICITUD EN ESPERA");
			eventos.agregar(nuevoEvento);	
		}
		else {
			modeloActual.actualizarServidorDisponible();
		}

	}

}
