package Teoria_Otros;

public class Operadores {

	public static void main(String[] args) {
		//TIPOS DE OPERADORES:
		
		/*ASIGNACIÓN*/
		
		int n=6;
		int nn=-6;
		
		/*ARITMÉTICOS*/
		
		int suma= n+nn;
		int resta= n-nn;
		int producto=n*nn;
		int division=n/nn;
		int resto=n%nn;
		
		System.out.println(20%7);
		
		/*INCREMENTALES*/
		
		n++;
		nn--;
		--n;
		++nn;		/*este operador también puede ir delante, y por lo tanto se aplicaría antes de la ejecución*/
		
		/*COMBINADOS: combinan un operador aritmético con el de asignación*/
		n+=nn;		//n=n+nn
		n-=nn;		//n=n-nn
		n*=nn;		//n=n*nn
		n/=nn;		//n=n/nn
		n%=nn;		//n=n%nn
		
		/*DE RELACIÓN*/
		/* n==nn;
		 * n!=nn;
		 * n>=nn;
		 * n<=nn;
		 * */
		
		

	}

}
