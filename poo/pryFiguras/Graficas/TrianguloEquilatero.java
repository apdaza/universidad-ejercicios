package Graficas;


public class TrianguloEquilatero {
	private double base;
	private double altura;
	private double area;
	private double perimetro;

	public double getBase(){
		return base;
	}
	public double setBase(double base){
		return this.base = base;
		
	}
	public double getAltura(){
		return altura;
	}
	public double setAltura(double altura){
		return this.altura = altura;
		
	}
	public double getArea (){
		return area;
	}
	public void setArea (){
		this.area=this.base*this.altura/2;
	}
	public double getPerimetro(){
		return perimetro;
		}
	public void setPerimetro(){
		this.perimetro=this.base*3;
	}
}