package modeloejemplo.componentespropios;

import des.LibreriaDeRutinas;
import java.util.Random;

/* Subprogramas usados para generar observaciones aleatorias desde las distribuciones de 
 * probabilidad asociadas al modelo. */

public class LibreriaDeRutinasEjemplo extends LibreriaDeRutinas {

	private Random random = new Random();

	public int tiempoEntreArribosSolicitudes() {
		double randomValue = random.nextDouble();
		double tiempo = -4 * Math.log(1 - randomValue);
		return (int) Math.round(tiempo);
	}
	//borrar este cuando acomode su uso
	public int tiempoDeProcesamiento() {
		// Aca se debería programar el método de generación de variables que corresponde.
		return 1;
	}
	//aca van los t de servicio de cada tipo de servicio 
	public int tiempoDeServicioBebidaSaludable(){
		double randomValue = random.nextDouble();
		double tiempo = -2.4 * Math.log(1 - randomValue);
        return (int) Math.round(tiempo);
	}
	public int tiempoDeServicioPanaderia(){
		double randomValue = random.nextDouble();
		double tiempo = -3.5 * Math.log(1 - randomValue);
        return (int) Math.round(tiempo);
	}

}
