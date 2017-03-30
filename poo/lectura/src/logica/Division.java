package logica;

public class Division {

	int a,b,r;
	void setA(int l){
		this.a=l;
	}
	void setB(int m){
		this.b=m;
	}
	void CalcularDivision(){
		this.r=this.a/this.b;
	}
	int getA(){
		return this.a;
	}
	int getB(){
		return this.b;
	}
	int getR(){
		return this.r;
	}
}
