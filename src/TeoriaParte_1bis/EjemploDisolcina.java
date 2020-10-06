package TeoriaParte_1bis;

import javax.swing.JOptionPane;

public class EjemploDisolcina {

	public static void main(String[] args) {
		
		Cajonera cliente_uno = new Cajonera("blanco",2); 
		
		System.out.println(cliente_uno.DatosInicio());
		
		cliente_uno.preguntaEntrega(JOptionPane.showInputDialog("¿Se entega en su domicilio habitual?"));
		
		System.out.println(cliente_uno.respuestaEntrega());

	}

}



class Cajonera{
	
	private int alto;
	private int ancho;
	private int largo;
	private String color;
	private int cantidad_cajones;
	private boolean entrega;
	
	public Cajonera(String color, int cantidad_cajones) {
		alto=15;
		ancho=35;
		largo=55;
		this.color=color;
		this.cantidad_cajones=cantidad_cajones;
	}
	
	public String DatosInicio() {
		return "La cajonera mide " + alto + " de alto, " + ancho + " de ancho y " + largo + " de largo." ;
	}
	
	public void preguntaEntrega(String entrega) {
		if(entrega.equalsIgnoreCase("si")) {
			this.entrega=true;
		}
		else {
			this.entrega=false;
		}
	}
	
	public String respuestaEntrega() {
		if (entrega==true) {
			return "Se entrega en el domicilio del cliente";
		}
		else {
			return "Se entrega en otro domicilio";
		}
	}
	
	
}