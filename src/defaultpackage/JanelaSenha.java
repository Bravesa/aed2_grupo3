package defaultpackage;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class JanelaSenha implements ActionListener {
	private JanelaRetirada janelaretirada;
	private JanelaFilaCaixa janelafilacaixa; //Essas duas linhas ligam uma janela a outra
	
    JFrame Janela;
    JPanel centro;
    JLabel numeracao;
    Fila fila;
    
    int senha;
    
    JanelaSenha(Fila fila)  //Criação dos atributos, janelas e botoes
    { 
        Janela = new JFrame("Senha");
        centro = new JPanel();
        numeracao = new JLabel(); 
        this.fila = fila;
    } 
    
    public void criarJanela() 
    { 
    	//==============Layout da senha maior, que chamara as pessoas
    	centro.add(numeracao);
    	numeracao.setFont(numeracao.getFont().deriveFont(72.0f));
    	
    	Janela.setSize(720, 480);
    	Janela.setVisible(true);
    	Janela.add(centro, BorderLayout.CENTER); 
    	
        this.janelafilacaixa.Caixa1Saida.addActionListener(this); //Funcoes de escuta, escutam quando os botoes sao clicados
        this.janelafilacaixa.Caixa2Saida.addActionListener(this);
        this.janelafilacaixa.Caixa3Saida.addActionListener(this);
        this.janelafilacaixa.Caixa1Entrada.addActionListener(this);
        this.janelafilacaixa.Caixa2Entrada.addActionListener(this);
        this.janelafilacaixa.Caixa3Entrada.addActionListener(this);
        this.janelaretirada.addNPrio.addActionListener(this);
        this.janelaretirada.addPrio.addActionListener(this);
        this.janelafilacaixa.Chamada.addActionListener(this);
        
    } 
    
    public void actionPerformed(ActionEvent e) //Os comandos de dentro dessa funcao so serao feitas quando for escutado o clicar de um botao
    { 
        
    	if(fila.getProximo() != null) {
        	numeracao.setText(Integer.toString(fila.getProximo().getSenha())); //Pega a senha da proxima pessoa, se qualquer escuta foi feita
    	}
    	
    }
  //==================================================GETTERS SETTERS====================================
    
	public JanelaRetirada getJanelaretirada() {
		return janelaretirada;
	}
	
	public void setJanelaretirada(JanelaRetirada janelaretirada) {
		this.janelaretirada = janelaretirada;
	}
	
	public JanelaFilaCaixa getJanelafilacaixa() {
		return janelafilacaixa;
	}
	
	public void setJanelafilaCaixa(JanelaFilaCaixa janelafilacaixa) {
		this.janelafilacaixa = janelafilacaixa;
	} 
    
}
