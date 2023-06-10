package modelo;

import java.util.ArrayList;

public class Grupo extends Participante {

	private ArrayList<Individual> individuos;
	
	public Grupo(String nome) {
		super(nome);
		this.individuos = new ArrayList<Individual>();
	}
}
