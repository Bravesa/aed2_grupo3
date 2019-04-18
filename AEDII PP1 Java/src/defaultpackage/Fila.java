package defaultpackage;

import java.util.ArrayList;

public class Fila {
	
	private ArrayList<Pessoa> filaPessoas;
	private ArrayList<Pessoa> saidaPessoas;
	private Pessoa proximo;
	private HeapSort hs;
	private int numeroSenha;
	private int numeroSenhaPrio;
	private int numeroOrdem;
	
	public void novaFila(HeapSort hs) {
		this.filaPessoas = new ArrayList<Pessoa>();
		this.saidaPessoas = new ArrayList<Pessoa>();
		this.hs = hs;
		this.numeroSenha = 1;
		this.numeroSenhaPrio = 1;
		this.numeroOrdem = 1;
	}
	
	public void criarPessoa(boolean prioridade, String nome) {
		Pessoa p = new Pessoa();

		p.setNome(nome);
		p.setPrioridade(prioridade);
		if(prioridade == false) {
			p.setSenhaprio(0);
			p.setSenha(retirarSenha()); //Isso pegara o numero da senha posterior ao da pessoa a frente dela
			
		}
		else {
			p.setSenhaprio(retirarSenhaPrio()); //Isso pegara o numero da senha posterior ao da pessoa a frente dela
			p.setSenha(0); 
		}
		p.setOrdem(this.numeroOrdem);
		this.numeroOrdem += 1;
		
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
	
	public void definirProximo(int ultimoFoiNPrio, int mudanca) {
		if(ultimoFoiNPrio == mudanca) {
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
		
		if(proximo != null) {                     //se a fila estiver vazia
			if(this.proximo.isPrioridade() == true) {  //se tiver prioridade
				st += this.proximo.getNome() + "(O)[" + this.proximo.getSenhaprio() + "],";
			}
			else {                                    //se nao tiver prioridade
				st += this.proximo.getNome() + "(X)[" + this.proximo.getSenha() + "],";
			}
		}
		
		if(this.filaPessoas.isEmpty() == false) {              //se a fila estiver com gente           
			for(int i = 0; i < this.filaPessoas.size(); i++) {       //laço com a quantidade de pessoas
				if(this.filaPessoas.get(i).isPrioridade() == true) { //ver se tem prioridade
					st += this.filaPessoas.get(i).getNome() + "(O)[" + this.filaPessoas.get(i).getSenhaprio() + "],";
				}
				else{                                                //se não tiver prioridade
					st += this.filaPessoas.get(i).getNome() + "(X)[" + this.filaPessoas.get(i).getSenha() + "],";
				}
			}
		}
		
		return st;
	}
	
	
	public String getGrandeSaida(){ //Printar uma fila, representando os prioritarios com O e os nao com X
		String st = "Saida: ";
		for(int i = 0; i < this.saidaPessoas.size(); i++) {
			if(this.saidaPessoas.get(i).isPrioridade() == true) {
				st += this.saidaPessoas.get(i).getNome() + "(O)[" + this.saidaPessoas.get(i).getSenhaprio() + "],";
			}
			if(this.saidaPessoas.get(i).isPrioridade() == false) {
				st += this.saidaPessoas.get(i).getNome() + "(X)[" + this.saidaPessoas.get(i).getSenha() + "],";
			}
		}
		
		return st;
	}
	
	
	private int retirarSenha() {
		this.numeroSenha = this.numeroSenha + 1; //Isso pegara o numero da senha posterior
		return this.numeroSenha - 1;
	}
	
	private int retirarSenhaPrio() {
		this.numeroSenhaPrio = this.numeroSenhaPrio + 1; //Isso pegara o numero da senha posterior
		return this.numeroSenhaPrio - 1;
	}
	
	//==================================================GETTERS SETTERS====================================
	
	public int getNumeroSenhaPrio() {
		return numeroSenhaPrio;
	}

	public void setNumeroSenhaPrio(int numeroSenhaPrio) {
		this.numeroSenhaPrio = numeroSenhaPrio;
	}
	
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
