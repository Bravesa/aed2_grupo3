package defaultpackage;

public class Principal {

	public static void inicializarPrograma() {
		
		//Inicializar um Sort
		HeapSort hs = new HeapSort(); 
		
		//Inicializar uma nova fila
		Fila fila = new Fila();
		fila.novaFila(hs);
        
		//Inicializar Caixas
		
		ArrayCaixas VetorCaixas = new ArrayCaixas(); //Um array de caixas, assim como uma fila eh um array de pessoas
		
		Caixa caixa1 = new Caixa(true);
		Caixa caixa2 = new Caixa(true); //Poderia ter sido criado 3 caixas individualmente, mas esta assim para uma possibilidade de mais caixas e para simplificar um pouco
		Caixa caixa3 = new Caixa(true);
		
		VetorCaixas.addCaixa(caixa1);
		VetorCaixas.addCaixa(caixa2);
		VetorCaixas.addCaixa(caixa3);
		
        //Inicializar as janelas
        
        JanelaRetirada janelaretirada = new JanelaRetirada(fila);
    	JanelaFilaCaixa janelafilacaixa = new JanelaFilaCaixa(fila, VetorCaixas); //inicializacao de cada tela
    	JanelaSenha janelasenha = new JanelaSenha(fila);
    	
    	janelaretirada.setJanelafilaCaixa(janelafilacaixa);
    	janelaretirada.setJanelasenha(janelasenha);
    	
    	janelafilacaixa.setJanelaretirada(janelaretirada);  //interligacao das telas, uma com a outra
    	janelafilacaixa.setJanelasenha(janelasenha);
    	
    	janelasenha.setJanelafilaCaixa(janelafilacaixa);
    	janelasenha.setJanelaretirada(janelaretirada);
    	
        janelasenha.criarJanela();
        janelaretirada.criarJanela(); //criar as telas
        janelafilacaixa.criarJanela();
	}
	
	public static void main(String[] args) {
		
		inicializarPrograma();
        
	}
}
