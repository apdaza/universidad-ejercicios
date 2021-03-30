package Graficas;

public class Rectangulo {
	private double lado1;
	private double lado2;
	private double area;
	private double perimetro;

	public double getLado1(){
		return lado1;
	}
	public double setLado1(double lado1){
		return this.lado1 = lado1;
		
	}
	public double getLado2(){
		return lado2;
	}
	public double setLado2(double lado2){
		return this.lado2 = lado2;
		
	}
	public double getArea (){
		return area;
	}
	public void setArea (){
		this.area=this.lado1*this.lado2;
	}
	public double getPerimetro(){
		return perimetro;
		}
	public void setPerimetro(){
		this.perimetro=(this.lado1+this.lado2)*2;
	}
}
