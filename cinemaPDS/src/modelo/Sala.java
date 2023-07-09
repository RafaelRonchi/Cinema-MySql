package modelo;

import Interfaces.ISala;

public class Sala {
	private String Nome;
	private String Time;
	
	public Sala(String nome, String time) {
		setNome(nome);
		setTime(time);
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		this.Nome = nome;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	
}
