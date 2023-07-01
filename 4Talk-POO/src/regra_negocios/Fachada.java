package regra_negocios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import modelo.Grupo;
import modelo.Individual;
import modelo.Mensagem;
import modelo.Participante;
import repositorio.Repositorio;

public class Fachada {
	
	private Fachada() {}
	
	private static Repositorio repositorio = new Repositorio();
	
	public static void criarIndividuo(String nomeIndividuo, String senha) throws Exception {
		
		nomeIndividuo = nomeIndividuo.trim();
		
		Individual individuo = repositorio.localizarIndividual(nomeIndividuo);
		
		if (individuo != null)
			throw new Exception("o indivíduo de nome '" + nomeIndividuo + "' já existe.");
		
		if (nomeIndividuo.isBlank())
			throw new Exception("o nome do indivíduo não pode ser vazio ou conter apenas espaços em branco.");
		
		if (senha.isBlank())
			throw new Exception("a senha do indivíduo não pode ser vazia ou conter apenas espaços em branco.");
		
		individuo = new Individual(nomeIndividuo, senha, false);
		repositorio.adicionar(individuo);
		repositorio.salvarObjetos();
	}
	
	public static Individual validarIndividuo (String nomeIndividuo, String senha) throws  Exception{
	    
		Individual individuo = repositorio.localizarIndividual(nomeIndividuo);
		if (individuo == null)
			throw new Exception("o indivíduo " + nomeIndividuo + "é inválido.");
		if (individuo.getSenha().equals(null)) 
			throw new Exception("Não é possível validar uma senha vazia.");
		else if (individuo.getSenha().equals(senha)) {
			return individuo;
		}
		
		return null;
		
	}
			
	public static void criarAdministrador(String nomeAdministrador, String senha) throws Exception {
		nomeAdministrador = nomeAdministrador.trim();
		
		Individual administrador = repositorio.localizarIndividual(nomeAdministrador);
		
		if (administrador != null)
			throw new Exception("o administrador de nome '" + nomeAdministrador + "' já existe.");
		
		if (nomeAdministrador.isBlank())
			throw new Exception("o nome do administrador não pode ser vazio ou conter apenas espaços em branco.");
		
		if (senha.isBlank())
			throw new Exception("a senha do administrador não pode ser vazia ou conter apenas espaços em branco.");
		
		administrador = new Individual(nomeAdministrador, senha, true);
		repositorio.adicionar(administrador);
		repositorio.salvarObjetos();
	}
	
	public static void criarGrupo(String nomeGrupo) throws Exception {
		nomeGrupo = nomeGrupo.trim();
		
		Grupo grupo = repositorio.localizarGrupo(nomeGrupo);
		
		if (grupo != null)
			throw new Exception("o grupo de nome '" + nomeGrupo + "' já existe.");
		
		if (nomeGrupo.isBlank())
			throw new Exception("o nome do grupo não pode ser vazio ou conter apenas espaços em branco.");
		
		grupo = new Grupo(nomeGrupo);
		repositorio.adicionar(grupo);
		repositorio.salvarObjetos();
	}
	
	public static void inserirGrupo(String nomeIndividuo, String nomeGrupo) throws Exception {
		nomeIndividuo = nomeIndividuo.trim();
		nomeGrupo = nomeGrupo.trim();
		
		Individual individuo = repositorio.localizarIndividual(nomeIndividuo);
		Grupo grupo = repositorio.localizarGrupo(nomeGrupo);
		
		if (individuo == null)
			throw new Exception("O indivíduo de nome '" + nomeIndividuo + "' não existe.");
		
		if (grupo == null)
			throw new Exception("O grupo de nome '" + nomeGrupo + "' não existe.");
		
		if (grupo.localizar(nomeIndividuo) != null)
			throw new Exception("O indivíduo de nome '" + nomeIndividuo + "' já está no grupo '" + nomeGrupo + "'.");
		
		grupo.adicionar(individuo);
		repositorio.salvarObjetos();
	}
	
	public static void removerGrupo(String nomeIndividuo, String nomeGrupo) throws Exception {
		nomeIndividuo = nomeIndividuo.trim();
		nomeGrupo = nomeGrupo.trim();
		
		Individual individuo = repositorio.localizarIndividual(nomeIndividuo);
		Grupo grupo = repositorio.localizarGrupo(nomeGrupo);
		
		if (individuo == null)
			throw new Exception("O indivíduo de nome '" + nomeIndividuo + "' não existe.");
		
		if (grupo == null)
			throw new Exception("O grupo de nome '" + nomeGrupo + "' não existe.");
		
		if (grupo.localizar(nomeIndividuo) == null)
			throw new Exception("O indivíduo de nome '" + nomeIndividuo + "' não está no grupo '" + nomeGrupo + "'.");
		
		grupo.remover(individuo);
		repositorio.salvarObjetos();
	}
	
	public static ArrayList<Individual> listarIndividuos() {
		return repositorio.getIndividuos();	
	}
		
	public static ArrayList<Grupo> listarGrupos() {
		return repositorio.getGrupos();
	}
  
	public static ArrayList<Mensagem> obterConversa(String nomeindividuo, String nomedestinatario) {
		
		Individual emitente = repositorio.localizarIndividual(nomeindividuo);
		Participante destinatario = repositorio.localizarParticipante(nomedestinatario);
		
		ArrayList<Mensagem> mensagensEmitidas = emitente.getEnviadas();
		ArrayList<Mensagem> aux = new ArrayList<>();
		
		for (Mensagem m : mensagensEmitidas) {
			if (m.getDestinatario().equals(destinatario)) {
				aux.add(m);
			}
		}
		
		Collections.sort(aux);
		
		return aux;
	}
  
	public static void criarMensagem(String nomeindividuo, String nomedestinatario, String texto) {

		Individual emitente = repositorio.localizarIndividual(nomeindividuo);
		Participante destinatario = repositorio.localizarParticipante(nomedestinatario);
		Mensagem mensagem = repositorio.criarMensagem(emitente, destinatario, texto);

		emitente.adicionarMensagem(mensagem);

		if (destinatario instanceof Grupo) {

			ArrayList<Individual> individuos = ((Grupo) destinatario).getIndividuos();

			for (Individual i : individuos) {
				if (!i.equals(emitente)) {
					i.adicionar(mensagem);
				}
			}
		} else {
			destinatario.adicionar(mensagem);
		}
	}
	
	public static ArrayList<Mensagem> espionarMensagens(String nomeAdministrador, String termo) throws Exception {
		nomeAdministrador = nomeAdministrador.trim();
		
		Individual administrador = repositorio.localizarIndividual(nomeAdministrador);
		
		if (administrador == null)
			throw new Exception("o indivíduo de nome '" + nomeAdministrador + "' não existe.");
		
		if (!administrador.getAdministrador())
			throw new Exception("o indivíduo de nome'" + nomeAdministrador + "' não é possui permissão para isso.");
		
		Collection<Mensagem> mensagens = repositorio.getMensagens().values();
		ArrayList<Mensagem> mensagensFiltradas = new ArrayList<>();
		
		if (termo.equals("")) {
			mensagensFiltradas.addAll(mensagens);
			return mensagensFiltradas;
		}
		
		for (Mensagem msg : mensagens)
			if (msg.getTexto().contains(termo))
				mensagensFiltradas.add(msg);
		
		return mensagensFiltradas;
	}
	
	public static ArrayList<Mensagem> listarMensagensEnviadas(String nomeindividuo) throws Exception {
		if (nomeindividuo == null)
			throw new Exception("O indivíduo de nome '" + nomeindividuo + "' não existe.");
		ArrayList<Mensagem> mensagensEnviadas = repositorio.localizarIndividual(nomeindividuo).getEnviadas();
		Collections.sort(mensagensEnviadas);
		return mensagensEnviadas;
	}
  
	
	public static ArrayList<Mensagem> listarMensagensRecebidas(String nomeparticipante)throws Exception {
		if (nomeparticipante == null)
			throw new Exception("O indivíduo de nome '" + nomeparticipante + "' não existe.");
		ArrayList<Mensagem> mensagensRecebidas = repositorio.localizarIndividual(nomeparticipante).getRecebidas();
		Collections.sort(mensagensRecebidas);
		return mensagensRecebidas;
	}
	
	public static ArrayList<String> ausentes(String nomeAdministrador) throws Exception {
		nomeAdministrador = nomeAdministrador.trim();
		
		Individual administrador = repositorio.localizarIndividual(nomeAdministrador);
		
		if (administrador == null)
			throw new Exception("o indivíduo de nome '" + nomeAdministrador + "' não existe.");
	
		if (!administrador.getAdministrador())
			throw new Exception("o indivíduo de nome'" + nomeAdministrador + "' não possui permissão para isso.");
		
		Collection<Participante> participantes = repositorio.getParticipantes().values();
		ArrayList<String> participantesFiltrados = new ArrayList<>();
		
		for (Participante part : participantes)
			if (part.getEnviadas().isEmpty())
				participantesFiltrados.add(part.getNome());
		
		return participantesFiltrados;
	}

	
}
