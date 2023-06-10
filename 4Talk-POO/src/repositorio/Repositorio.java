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

}
