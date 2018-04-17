import java.util.ArrayList;

public class Carton {
	
	ArrayList<Integer> numeros;
	private ArrayList<ArrayList<Integer>> diagonales;
	private ArrayList<ArrayList<Integer>> verticales;
	private ArrayList<ArrayList<Integer>> horizontales;
	boolean premioDiagonal;
	boolean premioHorizontal;
	boolean premioVertical;
	
	Carton(ArrayList<ArrayList<Integer>> matriz){
		crear(matriz);
		crearListaPremios(matriz);
		this.horizontales = matriz;
	}
	
	
	public void crear(ArrayList<ArrayList<Integer>> pMatriz) {
		this.numeros = new ArrayList<Integer>();	
		for (int i = 0; i < pMatriz.size(); i++) {
			for (int j = 0; j < pMatriz.get(i).size(); j++) {
				numeros.add(pMatriz.get(i).get(j));
			}
		}
	}
	
	
	public void crearListaPremios(ArrayList<ArrayList<Integer>> pMatriz) {
		crearVerticales(pMatriz);
		crearDiagonales(pMatriz);
	}
	
	public void crearVerticales(ArrayList<ArrayList<Integer>> pMatriz) {
		this.verticales = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> vert1 = new ArrayList<Integer>();
		ArrayList<Integer> vert2 = new ArrayList<Integer>();
		ArrayList<Integer> vert3 = new ArrayList<Integer>();
		ArrayList<Integer> vert4 = new ArrayList<Integer>();
		ArrayList<Integer> vert5 = new ArrayList<Integer>();
		
		for (int i = 0; i>5; i++) {
			for (int j = 0; j>5; j++) {
				if (j == 0) {
					vert1.add(pMatriz.get(i).get(j));
				}
				if (j == 1) {
					vert2.add(pMatriz.get(i).get(j));
				}
				if (j == 2) {
					vert3.add(pMatriz.get(i).get(j));
				}
				if (j == 3) {
					vert4.add(pMatriz.get(i).get(j));
				}
				if (j == 4) {
					vert5.add(pMatriz.get(i).get(j));
				}
			}
		}
	}
	
	public void crearDiagonales(ArrayList<ArrayList<Integer>> pMatriz) {
		this.diagonales = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> diag1 = new ArrayList<Integer>();
		for (int i = 0; i<5; i++) {
			for (int j = 0; j<5; j++) {
				if (j == i) {
					diag1.add(pMatriz.get(i).get(j));
				}
			}
		}
		
		ArrayList<Integer> diag2 = new ArrayList<Integer>();
		diag2.add(pMatriz.get(0).get(4));
		diag2.add(pMatriz.get(1).get(3));
		diag2.add(pMatriz.get(2).get(2));
		diag2.add(pMatriz.get(3).get(1));
		diag2.add(pMatriz.get(4).get(0));
		
	}
	
	public void revisarNumero(int num) {
		for (int i = 0 ; i<numeros.size(); i++) {
			if (numeros.get(i) == num) {
				numeros.remove(i);
				borrarDiagonales(num);
				borrarVerticales(num);
				borrarHorizontales(num);
			}
		}
					
		
	}
	
	public void borrarDiagonales(int num) {
		for (int i = 0; i < diagonales.size(); i++) {
			for (int j = 0; j < diagonales.get(i).size(); j++) {
				if (diagonales.get(i).get(j) == num) {
					if (diagonales.get(i).size() == 1) {
						premioDiagonal = true;
					}
					diagonales.get(i).remove(j);
				}
			}
		}
	}
	
	public void borrarVerticales(int num) {
		for (int i = 0; i < verticales.size(); i++) {
			for (int j = 0; j < verticales.get(i).size(); j++) {
				if (verticales.get(i).get(j) == num) {
					if (verticales.get(i).size() == 1) {
						premioVertical = true;
					}
					verticales.get(i).remove(j);
				}
			}
		}
	}
	
	public void borrarHorizontales(int num) {
		for (int i = 0; i < horizontales.size(); i++) {
			for (int j = 0; j < horizontales.get(i).size(); j++) {
				if (horizontales.get(i).get(j) == num) {
					if (horizontales.get(i).size() == 1) {
						premioHorizontal = true;
					}
					horizontales.get(i).remove(j);
				}
			}
		}
	}
	
	public void imprimir(){
		for (int i = 0; i<5; i++) {
				System.out.println(horizontales.get(i).get(0)+"-"+horizontales.get(i).get(1)+"-"+horizontales.get(i).get(2)+"-"+horizontales.get(i).get(3)+"-"+horizontales.get(i).get(4));
		}
	};
	
}
