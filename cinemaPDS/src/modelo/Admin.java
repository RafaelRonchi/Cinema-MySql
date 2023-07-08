package modelo;


public class Admin {
	private String Login;
	private String Pass;
	
	public Admin(String l, String p) {
		setLogin(l);
		setPass(p);
	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getPass() {
		return Pass;
	}

	public void setPass(String pass) {
		Pass = pass;
	}
	
}
