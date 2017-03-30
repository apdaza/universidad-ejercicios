package Graficas;

public class Circulo {
private double radio;
private double area;
private double perimetro;

public double getRadio(){
	return radio;
}
public void setRadio(double radio){
	this.radio = radio;
	
}
public double getArea (){
	return area;
}
public void setArea (){
	this.area=Math.PI*Math.pow(this.radio,2);
}
public double getPerimetro(){
	return perimetro;
	}
public void setPerimetro(){
	this.perimetro=2*Math.PI*this.radio;
}
}
