package modeloejemplo.eventos;

import des.ContadoresEstadisticos;
import des.EstadoDelSistema;
import des.Evento;
import des.ListaDeEventos;
import modeloejemplo.componentespropios.LibreriaDeRutinasEjemplo;
import modeloejemplo.estadodelsistema.ModeloDelEjemplo;
import modeloejemplo.estadodelsistema.Solicitud;

public class EventoArribarACola extends Evento {

	public EventoArribarACola(double tiempoDeOcurrencia) {
		super(tiempoDeOcurrencia);
	}

	@Override
	public void rutinaDeEvento(EstadoDelSistema modelo, ContadoresEstadisticos contadores, ListaDeEventos eventos,
			LibreriaDeRutinasEjemplo libreria) {
				
		ModeloDelEjemplo modeloActual = (ModeloDelEjemplo) modelo;
		
		//Agendar el próximo arribo de solicitud.
		EventoArribarACola nuevoEvento = new EventoArribarACola(libreria.tiempoEntreArribosSolicitudes());	
		eventos.agregar(nuevoEvento);
		
		Solicitud solicitudParaAgregar = new Solicitud(libreria.tipoServicio());

		if(modeloActual.estaServidorOcupado()) {
			modeloActual.encolarSolicitud(solicitudParaAgregar);
		}
		else {
			modeloActual.atenderSolicitud(solicitudParaAgregar);
			double duracionDelProcesamiento = libreria.tiempoDeServicio(solicitudParaAgregar);
			EventoTerminaProcesamiento nuevoEventoAdicional = new EventoTerminaProcesamiento(duracionDelProcesamiento);	
			eventos.agregar(nuevoEventoAdicional);
		}
	}

}
