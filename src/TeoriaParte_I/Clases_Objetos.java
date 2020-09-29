package TeoriaParte_I;

import javax.swing.JOptionPane;

public class Clases_Objetos {

	public static void main(String[] args) {
		// PRIMERA CLASE: POO ------>  CLASES Y  OBJETOS 									29/09/2020

		//CLASE: es una plantilla donde se recogen las características comunes de un grupo de objetos.
		
		/*OBJETO: ejemplar o instancia de una clase. 
			Tienen: 
				*Propiedades: (ATRIBUTOS)
				*Comportamientos: (MÉTODOS)		 */
		
		/*PASOS:
		 * 1. Creación de la clase "Card". Será la "plantilla". Se crea fuera del main (en este caso lo creamos todo en un único fichero fuente). IMP: al crear la clase no crearla como public (solo puede haber un public, en este caso el main).
		 * 2. Dentro de la clase Card, definimos las variables de esta plantilla (edad, nombre, id, saldos final y mensual, ciudad cliente nuevo...)..
		 * 3. Dentro de la clase Card, Creamos el método constructor y damos valor inicial a las variables definidas ( a todas o solo a algunas).
		 * 4. Instanciamos la clase en el main (fuera de la clase Card). El programa se empieza a ejecutar según el orden del main.
		 * 5. Creamos los métodos setters (modifican/crean el valor de una variable) y getters (devuelven el valor de una variable, para que parezca el resultado por pantalla tiene que ser llamado desde System.out.println) de la clase Card (primero en la clase Card y luego los llamamos/usamos en el main).
		 * */	
		
		
		/*4. Instanciamos tres objetos de la clase Tarjeta*/
		//OPCIÓN 1 uno a uno:
		/*Card client_1= new Card("Sarai Olcina",27, "Valencia");
		Card client_2=new Card ("Dolores Gonzalez", 58, "Cuenca");
		Card client_3= new Card ("Marina Olcina", 26, "Madrid");*/		
		//OPCIÓN 2 con un array:
		Card [] clients= new Card[3];
		clients[0]=new Card("Sarai Olcina",27, "Valencia");
		clients[1]= new Card("Dolores Gonzalez", 58, "Cuenca");
		clients [2]= new Card ("Marina Olcina", 26, "Madrid");	
		
		//System.out.println(clients[1].age);			//podíamos ver algunos datos de as instancias creadas pero al poner la palabra "private" en la variable, ya no nos deja a menos que sea con un método.
		
		/*5. Segundo: llamamos/usamos los getters/setters:*/
		//System.out.println(clients[0].InitialData());			esta forma de solicitar los datos aplica para todos los métodos
		//o:
		for (Card c:clients) {
			System.out.println(c.InitialData());
		}		
		
		
		//Setter y getter de new_client:
		for (Card c:clients) {
			c.ask_new_client(JOptionPane.showInputDialog("Is new client? (Answer yes/no)"));
		}
		/*for(Card c:clients) {
			System.out.println(c.answer_new_client());
		}*/
		
		//Setter y getter de other products:
		for( Card c:clients){
			c.ask_other_products(JOptionPane.showInputDialog("Client has other products? (Answer yes/no)"));
		}
		/*for (Card c:clients) {
			System.out.println(c.answer_other_products());
		}*/
		
		
		//setter y getter de total balance:
		for(Card c:clients) {
			c.ask_monthly_balance(Integer.parseInt(JOptionPane.showInputDialog("Introduce monthly balance: ")),Integer.parseInt(JOptionPane.showInputDialog("Introduce number of months: ")));
		}
		/*for (Card c:clients) {
			System.out.println(c.answer_monthly_balance());
		}*/
		
		//GETTER FINAL
		for(Card c:clients) {
			System.out.println(c.FinalData());
		}
		
		
		
		
>>>>>>> copiamaster
	}

}

/*1. Creamos la clase Card (no ponemos public ya que al estar en el mismo fichero fuente, solo puede haber una clase con public, y es el main.*/

class Card{
	
	/*2. Definimos las variables de la clase Tarjeta. Podemos (o no) inicializarlas. Las creamos con "private" para que no se puedan modificar*/
	private int id;
	private String name;
	private String city;
	private int age;
	private boolean new_client;
	private boolean other_products;
	private int total_balance;
	private int monthly_balance;
	private static int idSiguiente=1;		//la creamos aquí para empezar a usarla desde el constructor. Queremos que la variable id vaya cambiando pero en base a una que sea fija (idSiguiente), por eso le ponemos static
	
	/*3. Creamos el método constructor de la clase Card:
	 	*Lleva el mismo nombre que la clase SIEMPRE.
	 	*Puede recibir parámetros, cuando instanciemos, deberemos pedir al usuario dichos parámetros para poder crear una instancia.
	 	*Si recibe parámetros, éstos pueden (o no) llamarse como las variables de clase (las creada previamente para la clase). Diferenciaremos a las variables de clase con this.variable_de_clase.
	 	*Al crear una nueva instancia, se pedirá el nombre y la edad, y el constructor en automático dará valor al resto de variables que estén dentro de él con los valores que le pidamos.*/
	public Card(String name, int age, String city) {								
		this.name=name;
		this.age=age;
		this.city=city;	
		id=idSiguiente;
		idSiguiente++;
	}
	
	
	/*5. Primero: Creamos los métodos setters y getters de la clase Card.
	 * Crearemos :
	 	*2 getters: uno con el estado inicial y otro con el final (este último después de haber aplicado los setters). Siempre llevan return --> get.
	 	*4 setters: para definir el id, new_client, total_balance y monthly_balance (de momento). Siempre llevan void --->definen, no devuelven*/
	
	/*GETTER INICIAL:*/
	public String InitialData() {
		return "Client name: " + name + ", id: " + id + ", age: " +age + " , city: " + city;
	}
	
	/*SETTER NEW CLIENT Y GETTER NEW CLIENT (para ver el resultado de un setter hay que hacer un getter. RECO: hacer un getter final con todos los setters y así te ahorras cada setter)*/
	public void ask_new_client(String new_client) {
		if(new_client.equalsIgnoreCase("yes")) {
			this.new_client=true;
		}
		else {
			this.new_client=false;
		}
	}
	
	public boolean answer_new_client() {
		if (new_client==true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/*SETTER Y GETTER DE NEW PRODUCT*/
	public void ask_other_products(String other_products) {
		if (other_products.equalsIgnoreCase("yes")) {
			this.other_products=true;
		}
		else {
			this.other_products=false;
		}
	}
	
	public String answer_other_products() {
		if (other_products==true) {
			return "Yes, client has other products.";
		}
		else {
			return "No, client has not other products.";
		}
	}
	
	//SETTER Y GETTER DE TOTAL BALANCE. Primero pediremos el ingreso mensual y los meses de ingresos para luego computarlos
	public void ask_monthly_balance(int monthly_balance, int months) {
		if(monthly_balance<1) {
			this.monthly_balance=0;
		}
		else {
			this.monthly_balance=monthly_balance;
			total_balance=this.monthly_balance*months;
		}
		
	}
	public String answer_monthly_balance() {
		return "Total client´s balance: " + total_balance;
	}
	
	//GETTER FINAL (podemos evitar todos los getter anteriores (o mo)):
	public String FinalData() {
		return "\nIs new client? " + this.new_client + "\n Client has other products? " + this.answer_other_products() + "\n Total balance of the client: " + this.total_balance;
	}
	
	
	
}
