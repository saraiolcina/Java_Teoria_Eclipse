package ejercicios;
//https://www.discoduroderoer.es/ejercicios-propuestos-y-resueltos-programacion-orientado-a-objetos-java/
public class Ejercicio1DDR {

	public static void main(String[] args) {
		
		Cuenta titular1=new Cuenta("sarai", 200);
		Cuenta titular2=new Cuenta("marina");
		Cuenta titular3=new Cuenta("loli",-100);
		
		titular2.ingresar(200);	
		titular1.ingresar(-50);
		System.out.println(titular2.getCantidad());
		System.out.println(titular1.getCantidad());
		
		System.out.println(titular1);
		System.out.println(titular2);
		System.out.println(titular3);

	}

}

class Cuenta{
	
	String titular;
	double cantidad;
	
	public Cuenta(String titular) {
		this(titular,0);
	}
	
	public Cuenta(String titular, double cantidad) {
		this.titular=titular;
		ingresar(cantidad);
	}
	
	public String getTitular() {
		return "El titular es: " + titular;
	}
	
	public String getCantidad() {
		return "La cantidad de la cuenta es: " + cantidad;
	}
	
	public void setTitular(String titular) {
		this.titular=titular;
	}
	
	public void setCantidad(double cantidad) {
		ingresar(cantidad);
	}
	
	public String toString() {
		return "El titular es: " + titular + " y la cantidad de la cuenta es: " + cantidad + " euros.";
	}
	
	public void ingresar(double cantidad)
	{
		if(cantidad<0) {
			this.cantidad+=0;
		}
		else {
			this.cantidad+=cantidad;
		}
	}
	
	public void retirar(double cantidad) {
		if(this.cantidad-cantidad<0) {
			this.cantidad=0;
		}
		else {
			this.cantidad-=cantidad;
		}
	}
	
	
	
}









