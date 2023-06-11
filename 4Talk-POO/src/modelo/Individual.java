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
	
	public void adicionarGrupo(Grupo grupo) {
		grupos.add(grupo);
	}
	
	public void removerGrupo(Grupo grupo) {
		grupos.remove(grupo);
	}
	
	public Grupo localizarGrupo(String nome){
		for(Grupo g: grupos){
			if(g.getNome().equals(nome))
				return g;
		}
		return null;
	}
	
	public void adicionarMensagem(Mensagem mensagem) {
		enviadas.add(mensagem);
	}
	
	public void removerMensagem(Mensagem mensagem) {
		enviadas.remove(mensagem);
	}
	
	public Mensagem localizarMensagem(int id){
		for(Mensagem m: enviadas){
			if(m.getId() == id)
				return m;
		}
		return null;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}

	public ArrayList<Mensagem> getEnviadas() {
		return enviadas;
	}

	public void setEnviadas(ArrayList<Mensagem> enviadas) {
		this.enviadas = enviadas;
	}

	public ArrayList<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(ArrayList<Grupo> grupos) {
		this.grupos = grupos;
	}
	
	@Override
	public String toString() {
		return String.format("Individual%nnome = %s%nsenha = %s%nadministrador = %s%nrecebidas = %s%nenviadas = %s%ngrupos = %s%n",
				super.getNome(),
				this.senha,
				this.administrador,
				super.getRecebidas(),
				this.enviadas,
				this.grupos);
	}
	
}
