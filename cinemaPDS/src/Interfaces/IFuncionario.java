package Interfaces;

import java.util.ArrayList;

import modelo.Funcionario;

public interface IFuncionario {
	
	public boolean inserir(Funcionario p);
	public boolean remover(Funcionario f);
	public boolean alterar(Funcionario novoFuncionario);
	public boolean verificarLogin(Funcionario f);
	ArrayList<Funcionario> listarFuncionario();
}
