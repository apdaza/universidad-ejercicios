
public class Triangulo {
	int base;
	int altura;
	float area;
	public int getAltura() {
		return this.altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public float getArea() {
		return this.area;
	}
	public void calcularArea() {
		this.area = (this.base*this.altura)/2f;
	}
	public int getBase() {
		return this.base;
	}
	public void setBase(int base) {
		this.base = base;
	}
	
	

}
