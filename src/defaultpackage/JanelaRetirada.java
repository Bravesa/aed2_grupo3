package defaultpackage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JanelaRetirada implements ActionListener{
	private JanelaSenha janelasenha;
	private JanelaFilaCaixa janelafilacaixa; //Essas duas linhas ligam uma janela a outra
	
	JFrame Janela;
	JPanel senha, adicionar;
    JButton addPrio, addNPrio;
    JLabel NumeroSenha, TextoSenha;
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
        this.fila = fila;
    } 
    
    public void criarJanela() 
    { 
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //Pegar o tamanho da janela
    	
    	//====================Layout da janela=============================
    	
    	adicionar.setLayout(new GridLayout(1, 2));
    	adicionar.add(addPrio);
    	addPrio.setFont(addPrio.getFont().deriveFont(30.0f));
        adicionar.add(addNPrio);
        addNPrio.setFont(addNPrio.getFont().deriveFont(30.0f));
    	
        //====================Layout da demonstracao de senha=============================
        
        senha.setLayout(new GridLayout(2, 1));
        senha.setSize(screenSize.width, 144);
        senha.add(TextoSenha, BorderLayout.CENTER);
        TextoSenha.setFont(TextoSenha.getFont().deriveFont(45.0f));
        TextoSenha.setText("SENHA: ");
        senha.add(NumeroSenha, BorderLayout.CENTER);
        NumeroSenha.setFont(NumeroSenha.getFont().deriveFont(60.0f));
        
        //====================Layout da janela=============================
        
        Janela.setSize(720, 480);
        Janela.add(adicionar, BorderLayout.NORTH);
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
        	contador += 1;
        	NumeroSenha.setText("O" + Integer.toString(contador));
        }
        
        else if ((cmd).equals("Senha: Nao Prioritario")) {  //Comando do botao de tirar uma senha nao prioritaria
        	contador += 1;
        	NumeroSenha.setText("X" + Integer.toString(contador));
        }  
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
