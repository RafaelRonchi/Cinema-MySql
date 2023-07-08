package modelo;

import java.time.LocalDate;

public class Funcionario {
	private Long Cpf;
	private String Nome;
	private Double vendasDouble;
	
	public Funcionario(long cpf, String nome) {
		Cpf = cpf;
		Nome = nome;
		vendasDouble = 0.00;
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
	public Double getVendasDouble() {
		return vendasDouble;
	}
	public void setVendasDouble(Double vendasDouble) {
		this.vendasDouble = vendasDouble;
	}
	
}
	
	
	
	
	
	
	

