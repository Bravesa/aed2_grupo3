package defaultpackage;

public class Caixa {
	
	private boolean disponivel; //Caixas com disponibilidade e guardar uma pessoa
	private Pessoa pessoa;
	
	Caixa(boolean disponivel){
		this.disponivel = disponivel; //Inicializacao de caixa
	}
	
	//==================================================GETTERS SETTERS====================================
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public boolean isDisponivel() {
		return disponivel;
	}
	
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	
	
}
