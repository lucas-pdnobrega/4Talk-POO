package modelo;

import java.util.ArrayList;

public class Participante {

	private String nome;
	private ArrayList<Mensagem> recebidas;
	
	public Participante(String nome) {
		this.nome = nome;
		this.recebidas = new ArrayList<Mensagem>();
	}
	
	public void adicionar(Mensagem m){
		recebidas.add(m);
	}
	public void remover(Mensagem m){
		recebidas.remove(m);
	}
	
	public Mensagem localizar(int id){
		for(Mensagem m: recebidas){
			if(m.getId() == id)
				return m;
		}
		return null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Mensagem> getRecebidas() {
		return recebidas;
	}

	public void setRecebidas(ArrayList<Mensagem> recebidas) {
		this.recebidas = recebidas;
	}
	
	@Override
	public String toString() {
		return String.format("Participante%nnome : %s%nrecebidas = %s", 
				this.nome, 
				this.recebidas);
	}
	
}
