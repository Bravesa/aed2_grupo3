package defaultpackage;

public class Pessoa {
	
	private boolean prioridade; //Pessoas com uma prioridade e uma senha
	private int senha;
	private int senhaprio;
	private int ordem;    //Uso no heap
	private String nome;
	
	//Todos possuem uma senha normal e uma senha prioritaria, pessoas normais tem a senha prioritaria 0
	
	//==================================================GETTERS SETTERS====================================
	
	
	
	public boolean isPrioridade() {
		return prioridade;
	}
	
	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}

	public int getSenhaprio() {
		return senhaprio;
	}

	public void setSenhaprio(int senhaprio) {
		this.senhaprio = senhaprio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPrioridade(boolean prioridade) {
		this.prioridade = prioridade;
	}
	
	public int getSenha() {
		return senha;
	}
	
	public void setSenha(int senha) {
		this.senha = senha;
	}
	
	
}
