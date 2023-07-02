package modelo;

import java.util.ArrayList;

public class Participante {

	private String nome;
	private ArrayList<Mensagem> recebidas;
	private ArrayList<Mensagem> enviadas;
	
	
	public Participante(String nome) {
		this.nome = nome;
		this.recebidas = new ArrayList<Mensagem>();
		this.enviadas = new ArrayList<Mensagem>();
	}
	
	public void adicionar(Mensagem m){
		recebidas.add(m);
	}
	public void removerRecebida(Mensagem m){
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
	
	public ArrayList<Mensagem> getEnviadas() {
		return enviadas;
	}

	public void setEnviadas(ArrayList<Mensagem> enviadas) {
		this.enviadas = enviadas;
	}
	
	public void adicionarMensagem(Mensagem mensagem) {
		enviadas.add(mensagem);
	}
	
	public void removerEnviada(Mensagem mensagem) {
		enviadas.remove(mensagem);
	}
	
	public Mensagem localizarMensagem(int id){
		for(Mensagem m: enviadas){
			if(m.getId() == id)
				return m;
		}
		return null;
	}
	
	@Override
	public String toString() {
		return String.format("Participante%nnome : %s%nrecebidas = %s", 
				this.nome, 
				this.recebidas);
	}
	
}
