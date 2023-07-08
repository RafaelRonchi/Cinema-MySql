package main;

import modelo.Funcionario;
import view.JFrameMain;

public class Main {

	private static Funcionario FuncionarioLogado;
	
	public static void main(String[] args) {

		var JMain = new JFrameMain();
		JMain.main(args);
	}

	public static Funcionario getFuncionarioLogado() {
		return FuncionarioLogado;
	}

	public static void setFuncionarioLogado(Funcionario funcionarioLogado) {
		FuncionarioLogado = funcionarioLogado;
	}
	public static void setVendas(Double venda) {
		FuncionarioLogado.setVendasDouble((FuncionarioLogado.getVendasDouble() + venda));
	}

}
