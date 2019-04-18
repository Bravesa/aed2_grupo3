package defaultpackage;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class JanelaFilaCaixa implements ActionListener{
	private JanelaSenha janelasenha;
	private JanelaRetirada janelaretirada;    //Essas duas linhas ligam uma janela a outra
	
	private ArrayCaixas ArrayCaixas;          //Array de caixas
	
	JFrame Janela;
	JButton Caixa1Entrada, Caixa1Saida, Caixa2Entrada, Caixa2Saida, Caixa3Entrada, Caixa3Saida, Chamada;
    JPanel botoes, filas, caixa, chamada;
    JLabel grandefila, grandesaida;
    JTextField tcaixa1, tcaixa2, tcaixa3;
    Fila fila;
    int ordemprio = 0;
    
    //========ESSA VARIAVEL MUDANÇA MUDA A QUANTIDADE DE VEZES QUE ENTRA UM NÃO PRIORITARIO PARA DEPOIS ENTRAR UM PRIORITARIO========
    int mudanca = 1;
    
    JanelaFilaCaixa(Fila fila, ArrayCaixas ArrayCaixa) //Criação dos atributos, janelas e botoes
    { 
        Janela = new JFrame("Fila e Caixa");
        botoes = new JPanel();
        filas = new JPanel();
        caixa = new JPanel();
        chamada = new JPanel();
        grandefila = new JLabel("Entrada");
        grandesaida = new JLabel("Saida");
        tcaixa1 = new JTextField();
        tcaixa2 = new JTextField();
        tcaixa3 = new JTextField();
        Caixa1Entrada = new JButton("Entrada1");
        Caixa1Saida = new JButton("Saida1");
        Caixa2Entrada = new JButton("Entrada2");
        Caixa2Saida = new JButton("Saida2");
        Caixa3Entrada = new JButton("Entrada3");
        Caixa3Saida = new JButton("Saida3");
        Chamada = new JButton("Chamada");
        this.ArrayCaixas = ArrayCaixa;
        this.fila = fila;
    } 
    
    public void criarJanela() 
    { 
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //Pegar o tamanho da janela
    	
        //Layout para os botoes================================
    	
    	botoes.setLayout(new GridLayout(6,1));                     //layout para os botoes
    	botoes.add(Caixa1Entrada);
    	botoes.add(Caixa1Saida);
    	botoes.add(Caixa2Entrada);
    	botoes.add(Caixa2Saida);
    	botoes.add(Caixa3Entrada);
    	botoes.add(Caixa3Saida);
    	Caixa1Entrada.setEnabled(true);                         //comeca-se com entrada habilitada e saida nao habilitada, vai alternando com o clique
    	Caixa1Saida.setEnabled(false);
    	Caixa2Entrada.setEnabled(true);
    	Caixa2Saida.setEnabled(false);
    	Caixa3Entrada.setEnabled(true);
    	Caixa3Saida.setEnabled(false);
    	
    	//Layout para a grandefila e grande saida=================================
    	
    	filas.setLayout(new GridLayout(2,1));                        //layout das duas filas, de entrada e de saidaa
    	filas.add(grandefila);
    	filas.setSize(screenSize.width, 200);
    	grandefila.setFont(grandefila.getFont().deriveFont(30.0f));
    	filas.add(grandesaida);
    	filas.setSize(screenSize.width, 200);
    	grandesaida.setFont(grandesaida.getFont().deriveFont(30.0f));
    	
    	//Layout para a chamada=================================
    	
    	chamada.add(Chamada);                                   //botao de chamada, para atualizar a janela de senha
    	chamada.setSize(400, screenSize.height);
    	
    	//Layout para a Caixa================================
    	
    	caixa.setLayout(new GridLayout(3,1));
    	caixa.add(tcaixa1);
    	tcaixa1.setFont(tcaixa1.getFont().deriveFont(60.0f));
        tcaixa1.setText("[C1]");             //Inicializar as caixas
        tcaixa1.setBackground(Color.GREEN);
    	caixa.add(tcaixa2);
    	tcaixa2.setFont(tcaixa2.getFont().deriveFont(60.0f));
        tcaixa2.setText("[C2]");
        tcaixa2.setBackground(Color.GREEN);
    	caixa.add(tcaixa3);
    	tcaixa3.setFont(tcaixa3.getFont().deriveFont(60.0f));
        tcaixa3.setText("[C3]");
        tcaixa3.setBackground(Color.GREEN);
    	
    	//Layout para a Janela================================
    	
    	Janela.add(botoes, BorderLayout.EAST);  //Interface para a janela
    	Janela.add(filas, BorderLayout.SOUTH);
    	Janela.add(caixa, BorderLayout.CENTER);
    	Janela.add(chamada, BorderLayout.WEST);
    	Janela.setSize(1080, 720);
    	Janela.setVisible(true);
    	
        Caixa1Entrada.addActionListener(this); //Funcoes de escuta, escutam quando os botoes sao clicados
        Caixa1Saida.addActionListener(this); 
        Caixa2Entrada.addActionListener(this);
        Caixa2Saida.addActionListener(this);
        Caixa3Entrada.addActionListener(this);
        Caixa3Saida.addActionListener(this);
        this.janelaretirada.addNPrio.addActionListener(this);
        this.janelaretirada.addPrio.addActionListener(this);
        
    } 
    
    public void actionPerformed(ActionEvent e)  //Os comandos de dentro dessa funcao so serao feitas quando for escutado o clicar de um botao
    { 
        String cmd = new String(e.getActionCommand()); 
        
        if ((cmd).equals("Entrada1")) { //Comando do Botao entrada caixa 1
        	
        	if(ArrayCaixas.getArrayCaixas().get(0).isDisponivel() == true && fila.getProximo() != null) { //So faz o comando se estiver disponivel e existir um proximo
	        	ArrayCaixas.getArrayCaixas().get(0).setDisponivel(false); //Caixa se bota como indisponivel
	        	if(fila.getProximo().isPrioridade() == true) { //Caixa ve a prioridade da pessoa e faz a interface correta
	        		tcaixa1.setText("[C1]" + fila.getProximo().getNome() + "[" + fila.getProximo().getSenhaprio() + "](O)");
	        		tcaixa1.setBackground(Color.RED);
	        	}
	        	if(fila.getProximo().isPrioridade() == false) {
	        		tcaixa1.setText("[C1]" + fila.getProximo().getNome() + "[" + fila.getProximo().getSenha() + "](X)");
	        		tcaixa1.setBackground(Color.RED);
	            	ordemprio += 1;
	        	}
	        	ArrayCaixas.getArrayCaixas().get(0).setPessoa(fila.getProximo()); //Pegar o proximo e colocar na caixa
	        	fila.definirProximo(ordemprio, mudanca);                                   //definir um novo proximo
	        	if(ordemprio == mudanca) {          //Quando isso e 1, o proximo sera um prioritario, reseta quando o prioritario passa
	        		ordemprio = 0;
	        	}
	        	grandefila.setText(fila.getGrandeFila());   //Atualiza o texto da fila de entrada
	        	Caixa1Entrada.setEnabled(false);
	        	Caixa1Saida.setEnabled(true);
        	}
        	
        }
        
        else if ((cmd).equals("Saida1")) { //Comando do botao saida caixa 1
        	if(ArrayCaixas.getArrayCaixas().get(0).isDisponivel() == false) {
	        	ArrayCaixas.getArrayCaixas().get(0).setDisponivel(true); //Caixa se bota como disponivel
	        	tcaixa1.setText("[C1]");
	    		tcaixa1.setBackground(Color.GREEN);
	        	fila.saidaPessoa(ArrayCaixas.getArrayCaixas().get(0).getPessoa()); //Adicionar uma pessoa ao vetor da saida
	        	ArrayCaixas.getArrayCaixas().get(0).setPessoa(null);      //Retirar pessoa da caixa
	        	grandesaida.setText(fila.getGrandeSaida());
	        	Caixa1Entrada.setEnabled(true);
	        	Caixa1Saida.setEnabled(false);
        	}
        	
        }
        
        else if ((cmd).equals("Entrada2")) { //Comando do Botao entrada caixa 2
        	
        	if(ArrayCaixas.getArrayCaixas().get(1).isDisponivel() == true && fila.getProximo() != null) { //So faz o comando se estiver disponivel e existir um proximo
	        	ArrayCaixas.getArrayCaixas().get(1).setDisponivel(false); //Caixa se bota como indisponivel
	        	if(fila.getProximo().isPrioridade() == true) { //Caixa ve a prioridade da pessoa e faz a interface correta
	        		tcaixa2.setText("[C2]" + fila.getProximo().getNome() + "[" + fila.getProximo().getSenhaprio() + "](O)");
	        		tcaixa2.setBackground(Color.RED);
	        	}
	        	if(fila.getProximo().isPrioridade() == false) {
	        		tcaixa2.setText("[C2]" + fila.getProximo().getNome() + "[" + fila.getProximo().getSenha() + "](X)");
	        		tcaixa2.setBackground(Color.RED);
	            	ordemprio += 1;
	        	}
	        	ArrayCaixas.getArrayCaixas().get(1).setPessoa(fila.getProximo()); //Pegar o primeiro da fila e colocar na caixa
	        	fila.definirProximo(ordemprio, mudanca);                                   //definir um novo proximo
	        	if(ordemprio == mudanca) { //Quando isso e 1, o proximo sera um prioritario, reseta quando o prioritario passa
	        		ordemprio = 0;
	        	}
	        	grandefila.setText(fila.getGrandeFila());    //Atualiza o texto da fila de entrada
	        	Caixa2Entrada.setEnabled(false);
	        	Caixa2Saida.setEnabled(true);
        	}
        	
        }
        
        else if ((cmd).equals("Saida2")) { //Comando do botao saida caixa 2
        	
        	if(ArrayCaixas.getArrayCaixas().get(1).isDisponivel() == false) {
	        	ArrayCaixas.getArrayCaixas().get(1).setDisponivel(true); //Caixa se bota como disponivel
	        	tcaixa2.setText("[C2]");
	    		tcaixa2.setBackground(Color.GREEN);
	        	fila.saidaPessoa(ArrayCaixas.getArrayCaixas().get(1).getPessoa()); //Adicionar uma pessoa ao vetor da saida
	        	ArrayCaixas.getArrayCaixas().get(1).setPessoa(null);      //Retirar pessoa da caixa
	        	grandesaida.setText(fila.getGrandeSaida());
	        	Caixa2Entrada.setEnabled(true);
	        	Caixa2Saida.setEnabled(false);
        	}
        	
        }  
        
        else if ((cmd).equals("Entrada3")) { //Comando do Botao entrada caixa 3
        	
        	if(ArrayCaixas.getArrayCaixas().get(2).isDisponivel() == true && fila.getProximo() != null) { //So faz o comando se estiver disponivel e existir um proximo
	        	ArrayCaixas.getArrayCaixas().get(2).setDisponivel(false); //Caixa se bota como indisponivel
	        	if(fila.getProximo().isPrioridade() == true) { //Caixa ve a prioridade da pessoa e faz a interface correta
	        		tcaixa3.setText("[C3]" + fila.getProximo().getNome() + "[" + fila.getProximo().getSenhaprio() + "](O)");
	        		tcaixa3.setBackground(Color.RED);
	        	}
	        	if(fila.getProximo().isPrioridade() == false) {
	        		tcaixa3.setText("[C3]" + fila.getProximo().getNome() + "[" + fila.getProximo().getSenha() + "](X)");
	        		tcaixa3.setBackground(Color.RED);
	            	ordemprio += 1;
	        	}
	        	ArrayCaixas.getArrayCaixas().get(2).setPessoa(fila.getProximo()); //Pegar o primeiro da fila e colocar na caixa
	        	fila.definirProximo(ordemprio, mudanca);                                   //definir um novo proximo
	        	if(ordemprio == mudanca) { //Quando isso e 1, o proximo sera um prioritario, reseta quando o prioritario passa
	        		ordemprio = 0;
	        	}
	        	grandefila.setText(fila.getGrandeFila()); //Atualiza o texto da fila de entrada
	        	Caixa3Entrada.setEnabled(false);
	        	Caixa3Saida.setEnabled(true);
        	}
        	
        }
        
        else if ((cmd).equals("Saida3")) { //Comando do botao saida caixa 3
        	
        	if(ArrayCaixas.getArrayCaixas().get(2).isDisponivel() == false) { //So ativa quando caixa esta disponivel
	        	ArrayCaixas.getArrayCaixas().get(2).setDisponivel(true); //Caixa se bota como disponivel
	        	tcaixa3.setText("[C3]");
	    		tcaixa3.setBackground(Color.GREEN);
	        	fila.saidaPessoa(ArrayCaixas.getArrayCaixas().get(2).getPessoa()); //Adicionar uma pessoa ao vetor da saida
	        	ArrayCaixas.getArrayCaixas().get(2).setPessoa(null);      //Retirar pessoa da caixa
	        	grandesaida.setText(fila.getGrandeSaida()); //Atualiza o texto da fila de entrada
	        	Caixa3Entrada.setEnabled(true);
	        	Caixa3Saida.setEnabled(false);
        	}
        	
        }
        
        else if ((cmd).equals("Senha: Prioritario")) { //Quando se clica no botao de senha prioritario
        	fila.criarPessoa(true, janelaretirada.inserirnome.getText()); 
            grandefila.setText(fila.getGrandeFila()); //Adicionar uma pessoa prioritaria a fila e atualizar o texto da fila
            
        } 
        
        else if ((cmd).equals("Senha: Nao Prioritario")) {  //Quando se clica no botao de senha nao prioritario
        	fila.criarPessoa(false, janelaretirada.inserirnome.getText()); 
        	grandefila.setText(fila.getGrandeFila()); //Adicionar uma pessoa nao prioritaria a fila e atualizar o texto da fila
        	
        }
        
    }

	//==================================================GETTERS SETTERS====================================
    
	public ArrayCaixas getArrayCaixas() {
		return ArrayCaixas;
	}

	public void setArrayCaixas(ArrayCaixas arrayCaixas) {
		ArrayCaixas = arrayCaixas;
	}

	public JanelaSenha getJanelasenha() {
		return janelasenha;
	}
	
	public void setJanelasenha(JanelaSenha janelasenha) {
		this.janelasenha = janelasenha;
	}
	
	public JanelaRetirada getJanelaretirada() {
		return janelaretirada;
	}
	
	public void setJanelaretirada(JanelaRetirada janelaretirada) {
		this.janelaretirada = janelaretirada;
	}
	
}
