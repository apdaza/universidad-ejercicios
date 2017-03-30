class A{
	static int x[]={1,2};
	int y[];
	void f(int z[]){z[1]+=2;}
	void g(){
		A a = new A();
		a.x[0]++;
	}
}
public class B {
	public static void main(String[] args) {
		A b = new A();
		b.y = b.x;
		b.f(b.y);
		b.g();
		System.out.println(b.x[0]+" "+b.x[1]);
		System.out.println(b.y[0]+" "+b.y[1]);

	}

}
