package appconsole;

import modelo.*;
import repositorio.*;

public class Teste {

	public static void main(String[] args) {
		
		Individual i1 = new Individual("Natinho", "123", true);
		Individual i2 = new Individual("Lucas", "213", false);
		Individual i3 = new Individual("Yago", "321", false);
		

		Individual i4 = new Individual("Pabo", "456", true);
		Individual i5 = new Individual("Mat", "546", false);
		Individual i6 = new Individual("Kramer", "645", false);
		
		System.out.println(i1 + " " + i2 + " " + i3);
		System.out.println(i4 + " " + i5 + " " + i6);
		
		Grupo g1 = new Grupo("NYL");
		Grupo g2 = new Grupo("PKM");
		
		g1.adicionar(i1);
		g1.adicionar(i2);
		g1.adicionar(i3);
		
		g2.adicionar(i4);
		g2.adicionar(i5);
		g2.adicionar(i6);
		
		System.out.println(g1 + " " + g2);
		
		/* FAVOR REVISAR A LÓGICA DE ENVIO E ARMAZENAMENTO DAS MENSAGENS ATRAVÉS DO MODELO, 
		 * CREIO QUE PELO MENOS A ARMAZENAÇÃO DE GRUPOS & INDIVÍDUOS ESTEJA OK !!! - Lucas*/
		
	}
	
}
