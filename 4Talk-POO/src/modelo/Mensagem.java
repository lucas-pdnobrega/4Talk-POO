package modelo;

import java.time.LocalDateTime;

public class Mensagem {

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

	public LocalDateTime getDatahora() {
		return datahora;
	}

	public void setDatahora(LocalDateTime datahora) {
		this.datahora = datahora;
	}
	
	@Override
	public String toString() {
		return String.format("Mensagem%nid = %s%ntexto = %s%nemitente = %s%ndestinatario = %s%ndatahora = %s%n", 
				this.id, 
				this.texto, 
				emitente.getNome(), 
				destinatario.getNome());
	}
	
}
