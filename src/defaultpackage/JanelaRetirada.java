package defaultpackage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JanelaRetirada implements ActionListener{
	private JanelaSenha janelasenha;
	private JanelaFilaCaixa janelafilacaixa; //Essas duas linhas ligam uma janela a outra
	
	JFrame Janela;
	JPanel senha, adicionar, adicionar2;
    JButton addPrio, addNPrio;
    JLabel NumeroSenha, TextoSenha, texto;
    JTextField inserirnome;
    Fila fila;
    int contador = 0;
    
    JanelaRetirada(Fila fila)  //Criação dos atributos, janelas e botoes
    { 
    	Janela = new JFrame("Retirada"); 
        addPrio = new JButton("Senha: Prioritario");
        addNPrio = new JButton("Senha: Nao Prioritario");
        NumeroSenha = new JLabel();
        TextoSenha = new JLabel();
        senha = new JPanel();
        adicionar = new JPanel();
        adicionar2 = new JPanel();
        texto = new JLabel();
        inserirnome = new JTextField();
        this.fila = fila;
    } 
    
    public void criarJanela() 
    { 
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //Pegar o tamanho da janela
    	
    	//====================Layout do botao de adicionar=============================
    	
    	adicionar.setLayout(new GridLayout(1, 2));
    	adicionar.add(addPrio);
    	addPrio.setFont(addPrio.getFont().deriveFont(30.0f));
        adicionar.add(addNPrio);
        addNPrio.setFont(addNPrio.getFont().deriveFont(30.0f));
        
        adicionar2.setLayout(new GridLayout(3, 1));
        adicionar2.add(adicionar);
        adicionar2.add(texto);
    	texto.setHorizontalAlignment(JLabel.CENTER);
        texto.setText("Nome:               (X para não prioritário e O para prioritário)");
        adicionar2.add(inserirnome);
        inserirnome.setText("");
        
    	
        //====================Layout da demonstracao de senha=============================
        
        senha.setLayout(new GridLayout(2, 1));
        senha.setSize(screenSize.width, 144);
        senha.add(TextoSenha);
    	TextoSenha.setHorizontalAlignment(JLabel.CENTER);
        TextoSenha.setFont(TextoSenha.getFont().deriveFont(30.0f));
        TextoSenha.setText("Senha emitida: ");
        senha.add(NumeroSenha);
    	NumeroSenha.setHorizontalAlignment(JLabel.CENTER);
        NumeroSenha.setFont(NumeroSenha.getFont().deriveFont(30.0f));
        
        //====================Layout da janela=============================
        
        Janela.setSize(720, 480);
        Janela.add(adicionar2, BorderLayout.NORTH);
        Janela.add(senha, BorderLayout.CENTER);
    	Janela.setVisible(true);
        addPrio.addActionListener(this); //Funcoes de escuta, escutam quando os botoes sao clicados
        addNPrio.addActionListener(this);
    } 
    
    
    public void actionPerformed(ActionEvent e)  //Os comandos de dentro dessa funcao so serao feitas quando for escutado o clicar de um botao
    { 
        String cmd = new String(e.getActionCommand()); 
        
        //Bota uma pessoa na fila, prioridade ou nao
        
        if ((cmd).equals("Senha: Prioritario")) {   //Comando do botao de tirar umaa senha prioritaria
        	
        	if(fila.getFilaPessoas().isEmpty() == true) { //Pegar ou nao do "proximo"
        		
        		NumeroSenha.setText("Prioritario, Senha: " + fila.getProximo().getSenhaprio()
    	        		+ ", Nome: " + fila.getProximo().getNome());
        		
        	}
        	else {
        		
        		NumeroSenha.setText("Prioritario, Senha: " + fila.getFilaPessoas().get(fila.getFilaPessoas().size() - 1).getSenhaprio()
    	                + ", Nome: " + fila.getFilaPessoas().get(fila.getFilaPessoas().size() - 1).getNome());
        		
        	}
        }
        
        else if ((cmd).equals("Senha: Nao Prioritario")) {  //Comando do botao de tirar uma senha nao prioritaria

        	if(fila.getFilaPessoas().isEmpty() == true) { //Pegar ou nao do "proximo"
        		
        		NumeroSenha.setText("Não Prioritario, Senha: " + fila.getProximo().getSenha() 
    	        		+ ", Nome: " + fila.getProximo().getNome());
        		
        	}
        	else {
        		
        		NumeroSenha.setText("Não Prioritario, Senha: " + fila.getFilaPessoas().get(fila.getFilaPessoas().size() - 1).getSenha() 
    	                + ", Nome: " + fila.getFilaPessoas().get(fila.getFilaPessoas().size() - 1).getNome());
        		
        	}
        }
        
        inserirnome.setText("");
        
    } 
	
    
  //==================================================GETTERS SETTERS====================================
    
	public JanelaSenha getJanelasenha() {
		return janelasenha;
	}
	
	public void setJanelasenha(JanelaSenha janelasenha) {
		this.janelasenha = janelasenha;
	}
	
	public JanelaFilaCaixa getJanelafilacaixa() {
		return janelafilacaixa;
	}
	
	public void setJanelafilaCaixa(JanelaFilaCaixa janelafilacaixa) {
		this.janelafilacaixa = janelafilacaixa;
	}
	
}
