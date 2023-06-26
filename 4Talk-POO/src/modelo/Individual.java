package modelo;

import java.util.ArrayList;

public class Individual extends Participante {

	private String senha;
	private boolean administrador;
	private ArrayList<Grupo> grupos;
	
	public Individual(String nome, String senha, boolean administrador) {
		super(nome);
		this.senha = senha;
		this.administrador = administrador;
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
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean getAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}


	public ArrayList<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(ArrayList<Grupo> grupos) {
		this.grupos = grupos;
	}

	@Override
	public String toString() {
		ArrayList<String> nomeGrupos = new ArrayList<>();

		if (grupos.size() > 0) {
			for (Grupo g : grupos) {
				nomeGrupos.add(g.getNome());
			}
		}
		return "Individual [nome=" + super.getNome() + 
				", senha=" + senha + 
				", administrador=" + administrador + 
				", recebidas =" + super.getRecebidas() +
				", enviadas =" + super.getEnviadas() +
				", grupos=" + nomeGrupos + "]";
	}
	
	/*@Override
	public String toString() {
		ArrayList<String> nomeGrupos = new ArrayList<>();

		if (grupos.size() > 0) {
			for (Grupo g : grupos) {
				nomeGrupos.add(g.getNome());
			}
		}
		
		return String.format("Individual%nnome = %s%nsenha = %s%nadministrador = %s%nrecebidas = %s%nenviadas = %s%ngrupos = %s%n",
				super.getNome(),
				this.senha,
				this.administrador,
				super.getRecebidas(),
				super.getEnviadas(),
				nomeGrupos);
	}*/
	
}
