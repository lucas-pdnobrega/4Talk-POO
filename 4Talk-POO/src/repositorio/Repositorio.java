package repositorio;

import java.io.File;
import java.io.FileWriter;
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
	
	public void carregarObjetos() {
		try {
			File grupos = new File(new File(".\\grupos.csv").getCanonicalPath());
			File mensagens = new File(new File(".\\mensagens.csv").getCanonicalPath());
			File individuos = new File(new File(".\\individuos.csv").getCanonicalPath());
			
			if (!grupos.exists() || !mensagens.exists() || !individuos.exists()) {
				FileWriter arquivo_grupos = new FileWriter(grupos);
				arquivo_grupos.close();
				
				FileWriter arquivo_mensagens = new FileWriter(mensagens);
				arquivo_mensagens.close();
				
				FileWriter arquivo_individuos = new FileWriter(individuos);
				arquivo_individuos.close();
				
				return;
			}
			
		} catch (Exception ex) {
			throw new RuntimeException("Criacao dos arquivos vazios: " + ex.getMessage());
		}
		
		String linha;
		String[] partes;
		
		// TODO - terminar este método
		
	}
	
	public void salvarObjetos() {
		
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
