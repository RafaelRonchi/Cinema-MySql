package modelo;

import java.time.LocalDate;

public class Funcionario {
	private Long Cpf;
	private String Nome;
	
	public Funcionario(long cpf, String nome) {
		Cpf = cpf;
		Nome = nome;
	}
	public Funcionario() {
		
	}

	public Long getCpf() {
		return Cpf;
	}

	public void setCpf(Long cpf) {
		Cpf = cpf;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}
	
}
	
	
	
	
	
	
	

