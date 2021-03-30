package Graficas;

public class Cuadrado {
	private double lado;
	private double area;
	private double perimetro;

	public double getLado(){
		return lado;
	}
	public double setLado(double lado){
		return this.lado = lado;
		
	}
	public double getArea (){
		return area;
	}
	public void setArea (){
		this.area=this.lado*this.lado;
	}
	public double getPerimetro(){
		return perimetro;
		}
	public void setPerimetro(){
		this.perimetro=this.lado*4;
	}
}
