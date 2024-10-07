package modeloejemplo.componentespropios;

import des.LibreriaDeRutinas;
import modeloejemplo.estadodelsistema.Solicitud;

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

	public String tipoServicio(){
		double randomValue = random.nextDouble();
		if(randomValue < 0.7){
			return "Bebida Saludable";
		}else{
			return "Panaderia";
		}
	}

	public double tiempoDeServicio(Solicitud s){
		double t = 1.0;
		if(s.getTipo().equals("Bebida Saludable")){
			t = tiempoDeServicioBebidaSaludable();
		}else if(s.getTipo().equals("Panaderia")){
			t = tiempoDeServicioPanaderia();
		}
		return t;
	}


	public double tiempoDeServicioBebidaSaludable(){
		double randomValue = random.nextDouble();
		double tiempo = -2.4 * Math.log(1 - randomValue);
		
		double rdm = random.nextDouble();

		if(rdm >= 0.57 && rdm < 90 ){
			tiempo = tiempo * 1.10;
		}else if(rdm >= 0.90 && rdm <= 1.0){
			tiempo = tiempo * 1.13;
		}
        return tiempo;
	}
	public double tiempoDeServicioPanaderia(){
		double randomValue = random.nextDouble();
		double tiempo = -3.5 * Math.log(1 - randomValue);
		
		double rdm = random.nextDouble();
		if(rdm >= 0.27 && rdm < 52 ){
			tiempo = tiempo * 1.12;
		}else if(rdm >= 0.52 && rdm < 87 ){
			tiempo = tiempo * 1.15;
		}else if(rdm >= 0.87 && rdm < 1.0 ){
			tiempo = tiempo * 1.20;
		}
        return tiempo;
	}
}
