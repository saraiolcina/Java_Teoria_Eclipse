package Teoria_Otros;
import java.util.*;
public class Clase_Gregorian_Calendar {

	public static void main(String[] args) {
		
		/*CLASE GREGORIAN CALENDAR- TEORÍA*/
		
		/*
		 * 1. Importar paquete java.util.*, dentro van las clases a usar: Date y GregorianCalendar.
		 * 2. Se deben crear:
		 		- una instancia del tipo gregorian calendar.
		 		- una variable de tipo Date que será sobre la que se aplique la instancia del tipo Gregorian Calendar.
		   3. Si usáramos un método getter para ver el resultado, también éste tendría que ser del tipo Date.
		   
		 	**La clase GregorianCalendar inicia los meses en 0, por eso hay que darle -1.
		 	** Hay que darle los parámetros para que la pueda calcular.
		 */
		
		Ejemplo instancia1=new Ejemplo();
		System.out.println(instancia1.pideFecha(2020, 10, 06));
		

	}
	
	
}

class Ejemplo{

	
	public Ejemplo() {
		
	}
	
	public Date pideFecha (int ano, int mes, int dia) {		
		GregorianCalendar calendario=new GregorianCalendar(ano, mes-1, dia);
		Date fecha_hoy= calendario.getTime();		
		return fecha_hoy;
	}
	
}

/*En el método pidefecha, se piden unos parámetros que luego son los que se van a usar para alimentar la variable calendario del tipo Gregorian calendar
 * Sobre esta variable, luego creamos otra del tipo Date que es la que va a almacenar la fecha definitiva.*/
