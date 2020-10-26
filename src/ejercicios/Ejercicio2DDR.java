package ejercicios;

import java.util.Random;

public class Ejercicio2DDR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona ejemplo=new Persona();
		

	}

}

class Persona{
	
	private String nombre;
	private int edad;
	private String dni;
	private char sexo;
	private double peso;
	private double altura;
	
	private final static char SEXO_DEFAULT='H';
	
	public Persona() {
		this("", 0, SEXO_DEFAULT,0,0);
		generaDNI();
	}
	
	public Persona(String nombre, int edad, char sexo) {
		this (nombre, edad, sexo, 0, 0);
		comprobarSexo(sexo);
		generaDNI();
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
		System.out.println(numeroDni);
		
	}
	
	public String generaLetraDni(int numeroRandom) {
		char [] arrayLetras= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		char letraDni=arrayLetras[numeroRandom];
		String letra=Character.toString(letraDni);
		return letra;
	}
	
}