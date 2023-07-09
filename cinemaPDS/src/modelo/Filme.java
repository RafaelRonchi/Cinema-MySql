package modelo;

public class Filme {
	private String NomeFilme;

	public Filme(String nomeFilme) {
		setNomeFilme(nomeFilme);
	}

	public String getNomeFilme() {
		return NomeFilme;
	}

	public void setNomeFilme(String nomeFilme) {
		NomeFilme = nomeFilme;
	}
}
