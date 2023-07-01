package modelo;

import java.time.LocalDateTime;

public class Mensagem implements Comparable<Mensagem> {

	private int id;
	private String texto;
	private Participante emitente;
	private Participante destinatario;
	private LocalDateTime datahora;
	
	public Mensagem(int id, Participante emitente, Participante destinatario, String texto) {
		this.id = id;
		this.texto = texto;
		this.emitente = emitente;
		this.destinatario = destinatario;
		this.datahora = LocalDateTime.now();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Participante getEmitente() {
		return emitente;
	}

	public void setEmitente(Individual emitente) {
		this.emitente = emitente;
	}

	public Participante getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Participante destinatario) {
		this.destinatario = destinatario;
	}

	public LocalDateTime getData() {
		return datahora;
	}

	public void setData(LocalDateTime datahora) {
		this.datahora = datahora;
	}
	
	@Override
	public String toString() {
		return "Mensagem [id=" + id + 
				", texto=" + texto + 
				", emitente=" + emitente.getNome() + 
				", destinatario=" + destinatario.getNome() + 
				", datahora=" + datahora + "]";
	}

	@Override
	public int compareTo(Mensagem o) {
		return this.datahora.compareTo(o.getData());
	}
	
}
