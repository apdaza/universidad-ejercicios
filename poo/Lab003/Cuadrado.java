/** Clase Cuadrado
 * 
 * creada en el laboratorio 002
 * 
 * ejemplo de una clase plana que luego sera instaciada por una clase ejecutable
 * @author alejo
 *
 */
class Cuadrado {
	int lado;
	int area;
	
	public void setLado(int lado) {
		this.lado = lado;
	}
	
	public int getLado() {
		return lado;
	}
	public void calcularArea(){
		this.area = this.lado*this.lado;
	}
	public int getArea() {
		return area;
	}
	
	

}
