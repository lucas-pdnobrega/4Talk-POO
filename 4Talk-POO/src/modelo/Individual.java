package modelo;

import java.util.ArrayList;

public class Individual extends Participante {

	private String senha;
	private boolean administrador;
	private ArrayList<Mensagem> enviadas;
	private ArrayList<Grupo> grupos;
	
	public Individual(String nome, String senha, boolean administrador) {
		super(nome);
		this.senha = senha;
		this.administrador = administrador;
		this.enviadas = new ArrayList<Mensagem>();
		this.grupos = new ArrayList<Grupo>();
	}
	
}
