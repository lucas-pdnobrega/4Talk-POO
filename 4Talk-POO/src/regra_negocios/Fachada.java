package regra_negocios;

import java.util.ArrayList;

import modelo.Grupo;
import modelo.Individual;
import modelo.Mensagem;
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
	
	public static void criarAdministrador(String nomeAdministrador, String senha) throws Exception{
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
	
	public static void inserirGrupo(String nomeIndividuo, String nomeGrupo) {
		
	}
	
	public static ArrayList<Individual> listarIndividuos() {
		return repositorio.getIndividuos();	
	}
		
	public static ArrayList<Grupo> listarGrupos() {
		return repositorio.getGrupos();
	}

/*
	public static void criarIndividuo(nomeindivíduo, senha) – cria um indivíduo no repositório, caso inexista no

	repositório

	public static boolean validarIndividuo(nomeindivíduo,senha) – retorna true se o indivíduo existir no repositório
	public static void criarAdministrador(nomeadministrador, senha) – cria um administrador no repositório, caso
	inexista no repositório

	2

	public static void criarGrupo(nomegrupo) – cria um grupo no repositório, caso inexista no repositório
	public static void inserirGrupo(nomeindividuo, nomegrupo) – localiza o indivíduo e o grupo no repositório e cria
	o relacionamento entre eles

	public static void removerGrupo(nomeindividuo, nomegrupo) – localiza o indivíduo e o grupo no repositório e

	remove o relacionamento entre eles

	public static void criarMensagem(nomeindivíduo, nomedestinatario, texto) – localiza o indivíduo e o participante

	destinatário no repositório, cria a mensagem e a relaciona com eles dois

	public static void

	obterConversa(nomeindivíduo, nomedestinatario) – localiza o indivíduo e o participante
	destinatário no repositório e retorna todas as mensagens enviadas e recebidas entre eles, em
	ordem cronológica

	public static void

	apagarMensagem(nomeindivíduo, id) – localiza no repositório o indivíduo e o id da mensagem
	emitida por ele, remove os relacionamentos entre mensagem, emitente e destinatário e exclui a
	mensagem do repositório

	public static
	ArrayList<Mensagem>

	listarMensagensEnviadas(nomeindivíduo) - localiza no repositório o indivíduo e retorna as
	mensagens enviadas por ele

	public static
	ArrayList<Mensagem>

	listarMensagensRecebidas(nomeparticipante) - localiza no repositório o participante e retorna
	as mensagens recebidas por ele

	public static
	ArrayList<String>

	listarIndividuos() - retorna o nome dos indivíduos do repositório, com o nome dos grupos
	relacionados (informar individuo ativo/não ativo e grupo ativo/não ativo)

	public static
	ArrayList<String>

	listarGrupos() - retorna o nome dos grupos do repositório juntamente com o nome dos
	indivíduos relacionados (informar grupo ativo/não ativo e individuo ativo/não ativo)

	public static ArrayList<Mensagem>

	espionarMensagens(nomeadministrador, termo) - localiza no repositório o administrador e
	retorna as mensagens do sistema, contendo o termo fornecido (termo vazio retorna todas as
	mensagens do sistema)

	public static
	ArrayList <String>

	ausentes(nomeadministrador) – localiza no repositório o administrador e retorna os nomes dos
	participantes que não criaram mensagens
*/
}
