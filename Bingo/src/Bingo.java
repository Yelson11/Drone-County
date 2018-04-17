import java.util.ArrayList;
import java.util.Collections;

public class Bingo {
	ArrayList<Carton> cartones;
	ArrayList<Integer> tombola;
	
	Bingo(){
		cartones = new ArrayList<Carton>();
		tombola = new ArrayList<Integer>();
	}
	
	public void jugar(int cantidadCartones) {
		
		tombola = generarTombola();
		
		for(int i = 0; i < cantidadCartones; i++) {
			cartones.add(generarCarton());
		}
		
		//Saca uno a uno los numeros de la tombola hasta que evaluarGanador sea true
		int contTomb = 0;
		long INICIO_MS = System.currentTimeMillis();
		while(evaluarGanador() == false) {
			long DURACION_MS = System.currentTimeMillis() - INICIO_MS;
			System.out.println("Tiempo: " + DURACION_MS);
			sacarNumero(contTomb);
			contTomb++;
			System.out.println(contTomb + "-" +  tombola.get(contTomb));
		}
		
	}
	
	public void sacarNumero(int num) {
		for (int i = 0; i < this.cartones.size(); i++ ) {
			this.cartones.get(i).revisarNumero(num);
		}
	}
	
	public boolean evaluarGanador() {
		int ganadores = 0;
		for (int i = 0; i<this.cartones.size(); i++) {
			if (this.cartones.get(i).numeros.size()==0) {
				ganadores++;
			}
			else {
				if (this.cartones.get(i).premioDiagonal == true) {
					System.out.println("El cartón " + i + " ha ganado premio diagonal");
					this.cartones.get(i).premioDiagonal = false;
				}
				if (this.cartones.get(i).premioVertical == true) {
					System.out.println("El cartón " + i + " ha ganado premio vertical");
					this.cartones.get(i).premioVertical = false;
				}
				if (this.cartones.get(i).premioHorizontal == true) {
					System.out.println("El cartón " + i + " ha ganado premio horizontal");
					this.cartones.get(i).premioHorizontal = false;
				}
			}
		}
		if (ganadores > 0) { 
			System.out.println("Ha habido " + ganadores +  " ganador(es)");
			return true;
		}
		return false;
	}
	
	public ArrayList<Integer> generarTombola(){
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (int i = 0; i<100; i++) {
			temp.add(i);
		}
		Collections.shuffle(temp);
		return temp;
	}
	public Carton generarCarton() {
		//Guardar numeros para poder usar en la creacion del carton
		ArrayList<Integer> a = new ArrayList<Integer>();
		//Será la matriz que se le pase por parametro al nuevo carton
		ArrayList<ArrayList<Integer>> carton = new ArrayList<ArrayList<Integer>>();
		
		//Agrega los 100 posibles numeros a una lista
		for (int i = 0; i<100; i++) {
			a.add(i);
		}
		//Los desacomoda
		Collections.shuffle(a);
		
		//Genera la matriz para el carton
		int cont = 0;
		for (int i = 0; i<5; i++) {
			ArrayList<Integer> temp  = new ArrayList<Integer>();
			for (int j = 0; j<5; j++) {
				temp.add(a.get(j+cont));
			}
			carton.add(temp);
			cont += 5;
		}
		return new Carton(carton);
	}
	
	public void imprimirCartones() {
		for (int i = 0; i<cartones.size(); i++) {
			cartones.get(i).imprimir();
			System.out.println("----------------");
		}
	}
}
