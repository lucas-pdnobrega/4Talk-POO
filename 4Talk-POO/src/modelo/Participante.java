package modelo;

import java.util.ArrayList;

public class Participante {

	private String nome;
	private ArrayList<Mensagem> recebidas;
	
	public Participante(String nome) {
		this.nome = nome;
		this.recebidas = new ArrayList<Mensagem>();
	}
	
}
