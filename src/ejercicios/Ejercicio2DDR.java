package ejercicios;

import java.util.Random;

import javax.swing.JOptionPane;

public class Ejercicio2DDR {

	public static void main(String[] args) {
		
		String nombre=JOptionPane.showInputDialog("Introduce el nombre: ");
		int edad=Integer.parseInt(JOptionPane.showInputDialog("Introduce la edad: "));
		String sexoPedido=JOptionPane.showInputDialog("Introduce sexo (H/M):");
		char sexo=sexoPedido.charAt(0);
		double altura=Double.parseDouble(JOptionPane.showInputDialog("Introduce la altura (en metros): "));
		double peso=Double.parseDouble(JOptionPane.showInputDialog("Introduce el peso (en kilos): "));
		
		Persona persona1=new Persona(nombre, edad, sexo, peso, altura);
		Persona persona2=new Persona("Marina", 26, 'M');
		persona2.setPeso(49.2);
		persona2.setAltura(1.65);
		Persona persona3=new Persona();
		persona3.setNombre("Jose Manuel");
		persona3.setEdad(57);
		persona3.setSexo('j');
		persona3.setAltura(1.70);
		persona3.setPeso(75.2);		
		
		System.out.println(persona1);
		dimePeso(persona1);			//no nos pide el s.o.p xq ya viene en el mensaje de la función
		System.out.println(dimeMayoriaEdad(persona1));		//en este caso si lo saco por pantalla porque el método no lo lleva
		System.out.println(persona2);
		dimePeso(persona2);
		System.out.println(dimeMayoriaEdad(persona2));
		System.out.println(persona3);
		dimePeso(persona3);		
		System.out.println(dimeMayoriaEdad(persona3));

		
	}
	
	public static void dimePeso(Persona p) {
		int dimePeso=p.calcularIMC();
		switch(dimePeso) {
		case Persona.ALTO_PESO:
			System.out.println("Tiene sobrepeso");
			break;
		case Persona.BAJO_PESO:
			System.out.println("Tiene bajo peso");
			break;
		case Persona.PESO_IDEAL:
			System.out.println("Está en su peso ideal");
			break;
		}
	}
	
	/*Lo creo desde la clase del ejecutable pero fuera del main.
	 * Le paso como parámetro una variable de tipo persona xq es la única forma que tengo de vincular este método con los métodos de la clase persona que quiero usar
	 * a la variable p que creo le pido el método de la clase persona.
	 * Tiene que ser void xq no acepta switch con distintas opciones*/
	
	public static String dimeMayoriaEdad(Persona p) {
		boolean mayoriaEdad=p.esMayorDeEdad();
		if(mayoriaEdad) {
			return "Es mayor de edad";
		}
		else {
			return "No es mayor de edad";
		}
			
	}
	
	/*En este caso lo creo como String para que me retorne datos*/
	
}

class Persona{
	
	private String nombre;
	private int edad;
	private String dni;
	private char sexo;
	private double peso;
	private double altura;
	
	private final static char SEXO_DEFAULT='H';
	public final static int PESO_IDEAL=-1;
	public final static int BAJO_PESO=0;
	public final static int ALTO_PESO=1;
	
	/*a las constantes del imc las pongo public xq luego las tenemos que llamar desde el main. Los valores de -1,0 y 1 se refieren al valor qde la función que queremos 
	 * mostrar al usuario, xq el valor real oscila {20-25}*/
	
	public Persona() {
		this("", 0, SEXO_DEFAULT,0,0);
		//generaDNI();					//no es necesario que aquí llamemos nuevamente al método para generar dni, pues el constructor que hemos fijado como
										//"principal" (el que recibe todos los parámetros) ya se encarga de ello.
	}
	/*Con la instrucción this("", 0,...) se está invocando al constructor que recibe todos los parámetros para que sea él quién inicialice la variable, 
	 * la diferencia está en que en vez de meter sus valores, meterá los del paréntesis, pero el this() llama en automático al constructor que más parámetros
	 * recibe y asigna en automático los valores y métodos de esta constructor. para los valores del constructor que lo llama, en vez de ponerse los valores 
	 * que tiene este constructor predeterminado, se pondrán las que le pasemos por los paréntesis.*/
	
	public Persona(String nombre, int edad, char sexo) {
		this (nombre, edad, sexo, 0, 0);
		comprobarSexo(sexo);
		//generaDNI();
	}
	
	public Persona(String nombre, int edad, char sexo, double peso, double altura) {
		this.nombre=nombre;
		this.edad=edad;
		comprobarSexo(sexo);
		this.peso=peso;
		this.altura=altura;
		generaDNI();
	}
	
	private void comprobarSexo(char sexo) {
		if(sexo=='H'||sexo=='M') {
			this.sexo=sexo;
		}
		else {
			this.sexo=SEXO_DEFAULT;
		}
	}
	
	public boolean esMayorDeEdad() {		
		boolean mayorDeEdad=false;
		if(edad>18) 
			mayorDeEdad=true;		
		return mayorDeEdad;			
	}
	/*Este método no necesita ningún parámetro ya que siempre se le llama en algún otro método que usamos para fijar la edad (ya sea el set o cualquiera de 
	 * los otros dos constructores). Al no recibir parámetros es más sencillo para luego llamarlo desde el mai (si no, no nos dejaría)*/
	
	private void generaDNI() {
		Random r=new Random();		
		String numeroDni="";
		int contador=0;
		while (contador<8) {
			int numero=r.nextInt(10);
			numeroDni=numeroDni+Integer.toString(numero);
			contador++;
		}
		int numeroLetra=r.nextInt(25);
		String letraDni=generaLetraDni(numeroLetra);
		numeroDni=numeroDni+letraDni;
		this.dni=numeroDni;
		
	}
	
	public String generaLetraDni(int numeroRandom) {
		char [] arrayLetras= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		char letraDni=arrayLetras[numeroRandom];
		String letra=Character.toString(letraDni);
		return letra;
	}
	
	public int calcularIMC(){								//no necesita que le pasemos parámetros
		int pesoFuncion=(int)(peso/(altura*altura));
		if(pesoFuncion<20) {
			return PESO_IDEAL;
		}
		else if(pesoFuncion>=20 && pesoFuncion<=25) {
			return BAJO_PESO;
		}
		else {
			return ALTO_PESO;
		}		
	}
	
	/*public String dimePeso(Persona p) {				//Se ha intentado crear desde aquí el método que devuelva el peso pero no nos deja.
		int dimePeso=p.calcularIMC(peso, altura);
		switch(dimePeso) {
		case Persona.ALTO_PESO:
			return "Tiene sobrepeso";
			break;
		case Persona.BAJO_PESO:
			return "Está por debajo de su peso";
			break;
		case Persona.PESO_IDEAL:
			return "Está en su peso ideal";
			break;
		}		
	}*/
	
	public String toString() {
		return "Datos de la persona:\n" +
				"Nombre: " + nombre + " \n" +
				"Edad: " + edad + " \n" +
				"Sexo: " + sexo + " \n" +
				"DNI: " + dni + " \n" +
				"Peso: " + peso + " \n" +
				"Altura: " + altura + " \n";
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public void setEdad(int edad) {
		this.edad=edad;
	}
	
	public void setSexo(char sexo) {
		comprobarSexo(sexo);
	}
	
	public void setAltura(double altura) {
		this.altura=altura;
	}
	
	public void setPeso(double peso) {
		this.peso=peso;
	} 
	
	
}