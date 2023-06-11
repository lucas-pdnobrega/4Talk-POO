package repositorio;

import java.util.TreeMap;

import modelo.Mensagem;
import modelo.Participante;

public class Repositorio {
	
	private TreeMap<String, Participante> participantes;
	private TreeMap<Integer, Mensagem> mensagens;
	
	public Repositorio() {
		this.participantes = new TreeMap<String, Participante>();
		this.mensagens = new TreeMap<Integer, Mensagem>();
	}
	
	public void adicionarParticipante(Participante participante) {
		participantes.put(participante.getNome(), participante);
	}
	
	public void removerParticipante(Participante participante) {
		participantes.remove(participante.getNome());
	}
	
	public Participante localizarParticipante(String nome){
		return participantes.get(nome);
	}
	
	public void adicionarMensagem(Mensagem mensagem) {
		mensagens.put(mensagem.getId(), mensagem);
	}
	
	public void removerMensagem(Mensagem mensagem) {
		mensagens.remove(mensagem.getId());
	}
	
	public Mensagem localizarMensagem(int id){
		return mensagens.get(id);
	}

	public TreeMap<String, Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(TreeMap<String, Participante> participantes) {
		this.participantes = participantes;
	}

	public TreeMap<Integer, Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(TreeMap<Integer, Mensagem> mensagens) {
		this.mensagens = mensagens;
	}
	
	@Override
	public String toString() {
		return String.format("Repositorio%nparticipantes = %s%nmensagens = %s%n", 
				this.participantes, 
				this.mensagens);
	}

}
