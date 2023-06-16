package repositorio;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.TreeMap;

import modelo.Grupo;
import modelo.Individual;
import modelo.Mensagem;
import modelo.Participante;

public class Repositorio {
	
	private TreeMap<String, Participante> participantes = new TreeMap<String, Participante>();
	private TreeMap<Integer, Mensagem> mensagens = new TreeMap<Integer, Mensagem>();
	
	public Repositorio() {
		carregarObjetos();
	}
	
	public void carregarObjetos() {
		try {
			// caso os arquivos nao existam, serao criados vazios
			File grupos = new File(new File(".\\grupos.csv").getCanonicalPath());
			File mensagens = new File(new File(".\\mensagens.csv").getCanonicalPath());
			File individuos = new File(new File(".\\individuos.csv").getCanonicalPath());
			
			if (!grupos.exists() || !mensagens.exists() || !individuos.exists()) {
				
				FileWriter arquivoGrupos = new FileWriter(grupos);
				arquivoGrupos.close();
				
				FileWriter arquivoMensagens = new FileWriter(mensagens);
				arquivoMensagens.close();
				
				FileWriter arquivoIndividuos = new FileWriter(individuos);
				arquivoIndividuos.close();
				
				return;
			}
			
		} catch (Exception ex) {
			throw new RuntimeException("Criacao dos arquivos vazios: " + ex.getMessage());
		}
		
		String linha;
		String[] colunasDoCsv;

		try {
			String nome, senha, administrador;
			File caminhoArquivoIndividuos = new File(new File(".\\individuos.csv").getCanonicalPath());
			
			Scanner arquivoIndividuos = new Scanner(caminhoArquivoIndividuos); // pasta do projeto
			
			while (arquivoIndividuos.hasNextLine()) {
				linha = arquivoIndividuos.nextLine().trim();
				colunasDoCsv = linha.split(";");
				//System.out.println(Arrays.toString(partes));
				
				nome = colunasDoCsv[0];
				senha = colunasDoCsv[1];
				administrador = colunasDoCsv[2];
				
				Individual individuo = new Individual(nome, senha, Boolean.parseBoolean(administrador));
				
				this.adicionar(individuo);
			}
			arquivoIndividuos.close();
			
		} catch (Exception ex) {
			throw new RuntimeException("leitura arquivo de individuos:" + ex.getMessage());
		}
		
		try	{
			String nome;
			Grupo grupo;
			Individual individuo;
			File caminhoArquivoGrupos = new File( new File(".\\grupos.csv").getCanonicalPath())  ;
			
			Scanner arquivoGrupos = new Scanner(caminhoArquivoGrupos); // pasta do projeto
			
			while (arquivoGrupos.hasNextLine()) {
				linha = arquivoGrupos.nextLine().trim();	
				colunasDoCsv = linha.split(";");
				//System.out.println(Arrays.toString(partes));
				
				nome = colunasDoCsv[0];
				grupo = new Grupo(nome);
				if (colunasDoCsv.length > 1)
					for (int i = 1; i < colunasDoCsv.length; i++) {
						individuo = this.localizarIndividual(colunasDoCsv[i]);
						grupo.adicionar(individuo);
					}
				this.adicionar(grupo);
			}
			arquivoGrupos.close();

		} catch(Exception ex) {
			throw new RuntimeException("leitura arquivo de grupos:" + ex.getMessage());
		}
		
		try	{
			String id, nomeEmitente, nomeDestinatario, texto;
			Mensagem mensagem;
			Participante emitente, destinatario;
			File caminhoArquivoMensagens = new File( new File(".\\mensagens.csv").getCanonicalPath() )  ;
			
			Scanner arquivoMensagens = new Scanner(caminhoArquivoMensagens);	 //  pasta do projeto

			while (arquivoMensagens.hasNextLine()) {
				linha = arquivoMensagens.nextLine().trim();		
				colunasDoCsv = linha.split(";");
				//System.out.println(Arrays.toString(partes));
				
				id = colunasDoCsv[0];
				nomeEmitente = colunasDoCsv[1];
				nomeDestinatario = colunasDoCsv[2];
				texto = colunasDoCsv[3];
				
				emitente = this.localizarParticipante(nomeEmitente);
				destinatario = this.localizarParticipante(nomeDestinatario);
				mensagem = new Mensagem(Integer.parseInt(id), emitente, destinatario, texto);

				this.adicionar(mensagem);
			} 
			arquivoMensagens.close();
		}
		catch(Exception ex)		{
			throw new RuntimeException("leitura arquivo de mensagens:"+ex.getMessage());
		}
	}
	
	public void salvarObjetos() {
		
	}
	
	/**
	 * Este método adiciona um participante ao TreeMap de participantes do repositório
	 * 
	 * @param participante um objeto do tipo 'Participante' a ser adicionado
	 * 
	 * @return void
	 */
	public void adicionar(Participante participante) {
		participantes.put(participante.getNome(), participante);
	}
	
	/**
	 * Este método adiciona uma mensagem ao TreeMap de mensagens do repositório
	 * 
	 * @param mensagem um objeto do tipo 'Mensagem' a ser adicionado
	 * 
	 * @return void
	 */
	public void adicionar(Mensagem mensagem) {
		mensagens.put(mensagem.getId(), mensagem);
	}
	
	/**
	 * Este método remove um participante do TreeMap de mensagens
	 * 
	 * @param participante um objeto do tipo 'Participante' a ser removido
	 * 
	 * @return void
	 */
	public void remover(Participante participante) {
		participantes.remove(participante.getNome());
	}
	
	/**
	 * Este método remove uma mensagem do TreeMap de mensagens
	 * 
	 * @param mensagem um objeto do tipo 'mensagem' a ser removido
	 * 
	 * @return void
	 */
	public void remover(Mensagem mensagem) {
		mensagens.remove(mensagem.getId());
	}
	
	/**
	 * Este método localiza um participante no TreeMap de participantes dado
	 * o seu nome, isto é, a chave de cada objeto 'Participante'.
	 * 
	 * @param nome um objeto do tipo 'String' que representa o nome do
	 * participante a ser localizado
	 * 
	 * @return Participante
	 */
	public Participante localizarParticipante(String nome){
		return participantes.get(nome);
	}
	
	/**
	 * Este método localiza uma mensagem no TreeMap de mensagens dado
	 * o seu id, isto é, a chave de cada objeto 'Mensagem'.
	 * 
	 * @param id um literal do tipo 'int' referente à mensagem a ser localizada
	 * 
	 * @return Mensagem
	 */
	public Mensagem localizarMensagem(int id){
		return mensagens.get(id);
	}
	
	/**
	 * Este método localiza um indivíduo no TreeMap de participantes dado
	 * o seu nome, isto é, a chave de cada objeto 'Participante'.
	 * 
	 * @param nome um objeto do tipo 'String' referente ao indivíduo a ser
	 * localizado
	 * 
	 * @return Individual
	 */
	public Individual localizarIndividual(String nome){
		Participante participante = participantes.get(nome);
		if (participante != null && participante instanceof Individual)
			return (Individual) participante;
		return null;
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
