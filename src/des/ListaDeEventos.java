package des;

import java.util.List;

/* Lista que contiene el próximo tiempo en el cual ocurrirá cada tipo de evento. */

/***************************************/
/* NO MODIFICAR PARA USAR EL SIMULADOR */
/***************************************/

public abstract class ListaDeEventos {
	
	protected List<Evento> lista;

	public abstract void inicializar(LibreriaDeRutinas libreria, RelojDeSimulacion reloj);

	public Evento obtenerMasInminente() {
		if(!lista.isEmpty()) {			
			double menor = lista.get(0).getTiempoDeOcurrencia();
			int subindiceMenor=0;
			Evento masInminente = lista.get(0);
			
			for(int i=1;i<lista.size();i++) {
				if(lista.get(i).getTiempoDeOcurrencia()<menor) {
					subindiceMenor = i;
					menor = lista.get(i).getTiempoDeOcurrencia();
					masInminente = lista.get(i);
				}
			}
			lista.remove(subindiceMenor);
			this.actualizarListado(masInminente.getTiempoDeOcurrencia());
			return masInminente;
		}
		else {
			System.out.println("ERROR: Busqueda de evento mas inminente en lista de eventos vacia.");
			return null;			
		}
	}

	private void actualizarListado(double tiempoTranscurrido) {
		if(!lista.isEmpty()) {			
			for(int i=0;i<lista.size();i++) lista.get(i).refreshTiempo(tiempoTranscurrido);
		}
	}

	public void agregar(Evento nuevoEvento) { 
		System.out.println("\t\t-- El MODELO pide al SIMULADOR agregar un EVENTO a la LISTA DE EVENTOS " + nuevoEvento.getClass().getSimpleName() + " el cual tendrá lugar en " + nuevoEvento.getTiempoDeOcurrencia());
		lista.add(nuevoEvento);
	}

}
