package modelo;

import java.util.ArrayList;

public class Grupo extends Participante {

	private ArrayList<Individual> individuos;
	
	public Grupo(String nome) {
		super(nome);
		this.setIndividuos(new ArrayList<Individual>());
	}
	
	public void adicionar(Individual i){
		individuos.add(i);
		i.adicionarGrupo(this);
	}
	public void remover(Individual i){
		individuos.remove(i);
		i.removerGrupo(this);
	}
	
	public Individual localizar(String nome){
		for(Individual i: individuos){
			if(i.getNome().equals(nome))
				return i;
		}
		return null;
	}
	
	public ArrayList<Individual> getIndividuos() {
		return individuos;
	}

	public void setIndividuos(ArrayList<Individual> individuos) {
		this.individuos = individuos;
	}
	
	@Override
	public String toString() {
		
		String nomes = "";
		
		for (Individual i : individuos) {
			nomes += " " + i.getNome();
		}
		
		return String.format("Grupo%nnome = %s%nmensagens = %s%nindividuos = %s%n", 
				super.getNome(), 
				super.getRecebidas(), 
				nomes);
	}
}
