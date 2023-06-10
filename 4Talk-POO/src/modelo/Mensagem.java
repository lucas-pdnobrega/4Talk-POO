package modelo;

import java.time.LocalDateTime;

public class Mensagem {

	private int id;
	private String texto;
	private Individual emitente;
	private Participante destinatario;
	private LocalDateTime datahora;
	
	public Mensagem(int id, String texto, Individual emitente, Participante destinatario) {
		this.id = id;
		this.texto = texto;
		this.emitente = emitente;
		this.destinatario = destinatario;
		this.datahora = LocalDateTime.now();
	}
	
}
