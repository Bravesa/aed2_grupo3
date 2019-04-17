package defaultpackage;

import java.util.ArrayList;

public class Fila {
	
	private ArrayList<Pessoa> filaPessoas;
	private ArrayList<Pessoa> saidaPessoas;
	private Pessoa proximo;
	private HeapSort hs;
	private int numeroSenha;
	
	public void novaFila(HeapSort hs) {
		this.filaPessoas = new ArrayList<Pessoa>();
		this.saidaPessoas = new ArrayList<Pessoa>();
		this.hs = hs;
		this.numeroSenha = 1;
	}
	
	public void criarPessoa(boolean prioridade) {
		Pessoa p = new Pessoa();
		p.setPrioridade(prioridade);
		p.setSenha(retirarSenha()); //Isso pegara o numero da senha posterior ao da pessoa a frente dela
		
		addPessoa(p);
	}
	
	public void addPessoa(Pessoa p) {
		if(proximo == null) {
			this.proximo = p;
		}
		else {
			this.filaPessoas.add(p);
		}
	}
	
	public void saidaPessoa(Pessoa p) {
		this.saidaPessoas.add(p);
	}
	
	/*public void retirarFila(){
		this.filaPessoas.remove(0);
	}*/
	
	public void definirProximo(int ultimoFoiNPrio) {
		if(ultimoFoiNPrio == 1) {
			hs.sortPrioridade(filaPessoas);
			this.proximo = null;
			if(this.getFilaPessoas().size() != 0) {
				this.proximo = filaPessoas.get(0);
				this.filaPessoas.remove(0);
			}
			ultimoFoiNPrio = 0;
		}
		else {
			hs.sortSenha(filaPessoas);
			this.proximo = null;
			if(this.getFilaPessoas().size() != 0) {
				this.proximo = filaPessoas.get(0);
				this.filaPessoas.remove(0);
			}
		}
	}
	
	public String getFila(){
		String st = "";
		st += "Prioridade: " + this.proximo.isPrioridade() + ", Senha: " 
		+ this.proximo.getSenha() + "\n";
		for(int i = 0; i < this.filaPessoas.size(); i++) {
			st += "Prioridade: " + this.filaPessoas.get(i).isPrioridade() + ", Senha: " 
			+ this.filaPessoas.get(i).getSenha() + "\n";
		}
		
		return st;
	}
	
	public String getGrandeFila(){ //Printar uma fila, representando os prioritarios com O e os nao com X
		String st = "Entrada: ";
		if(this.filaPessoas.size() > 0) {
			if(this.proximo.isPrioridade() == true) {
				st += "O[" + this.proximo.getSenha() + "],";
			}
			else {
				st += "X[" + this.proximo.getSenha() + "],";
			}
			for(int i = 0; i < this.filaPessoas.size(); i++) {
				if(this.filaPessoas.get(i).isPrioridade() == true) {
					st += "O[" + this.filaPessoas.get(i).getSenha() + "],";
				}
				if(this.filaPessoas.get(i).isPrioridade() == false) {
					st += "X[" + this.filaPessoas.get(i).getSenha() + "],";
				}
			}
		}
		else if(proximo != null) {
			st += "X[" + this.proximo.getSenha() + "],";
		}
		
		return st;
	}
	
	
	public String getGrandeSaida(){ //Printar uma fila, representando os prioritarios com O e os nao com X
		String st = "Saida: ";
		for(int i = 0; i < this.saidaPessoas.size(); i++) {
			if(this.saidaPessoas.get(i).isPrioridade() == true) {
				st += "O[" + this.saidaPessoas.get(i).getSenha() + "],";
			}
			if(this.saidaPessoas.get(i).isPrioridade() == false) {
				st += "X[" + this.saidaPessoas.get(i).getSenha() + "],";
			}
		}
		
		return st;
	}
	
	
	private int retirarSenha() {
		this.numeroSenha = this.numeroSenha + 1; //Isso pegara o numero da senha posterior
		return this.numeroSenha - 1;
	}
	
	//==================================================GETTERS SETTERS====================================
	
	public Pessoa getProximo() {
		return proximo;
	}

	public void setProximo(Pessoa proximo) {
		this.proximo = proximo;
	}

	public int getNumeroSenha() {
		return numeroSenha;
	}

	public void setNumeroSenha(int numeroSenha) {
		this.numeroSenha = numeroSenha;
	}

	public ArrayList<Pessoa> getFilaPessoas() {
		return filaPessoas;
	}

	public void setFilaPessoas(ArrayList<Pessoa> filaPessoas) {
		this.filaPessoas = filaPessoas;
	}

	public ArrayList<Pessoa> getSaidaPessoas() {
		return saidaPessoas;
	}

	public void setSaidaPessoas(ArrayList<Pessoa> saidaPessoas) {
		this.saidaPessoas = saidaPessoas;
	}

	public void cadastrarTempo(){
		
	}
	
	public int getTamanho() {
		return this.filaPessoas.size();
	}

	
	
}
