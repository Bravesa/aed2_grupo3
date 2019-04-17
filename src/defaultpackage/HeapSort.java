package defaultpackage;

import java.util.ArrayList;
import java.util.Collections;

public class HeapSort 
{ 
    
  //==============================SORT HEAPFY Prioridade=============================================================

	//Ao contrario do sort usando senha, o sort de prioridade foi deixado apenas a funcao de heapfy(fazer os prioritarios subirem a arvore)
	//Aproveitando o fato que o heapfy eh estavel, os prioritarios que chegarem ao topo da arvore serao os com menor senha
	//
	
    public void sortPrioridade(ArrayList<Pessoa> fila) //Sort prioridade(1 passada)
    { 
        int n = fila.size(); 
        
        // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--) {  
            heapifyPrioridade(fila, n, i);     
        }
  
    } 
  
    // Funcao heapfy, jogar prioridade pra cima
    void heapifyPrioridade(ArrayList<Pessoa> fila, int n, int i) 
    { 
        int prioritario = i; // Initialize largest as root 
        int l = 2*i + 1; // left = 2*i + 1 
        int r = 2*i + 2; // right = 2*i + 2 
  
        // Se o filho da esqueda tiver prioridade sobre o pai
        if (l < n && fila.get(l).isPrioridade() == true && fila.get(prioritario).isPrioridade() == false) 
        	prioritario = l; 
  
        // Se o filho da direita tiver prioridade sobre o pai
        if (r < n && fila.get(r).isPrioridade() == true && fila.get(prioritario).isPrioridade() == false) 
        	prioritario = r; 
  
        // Se o pai nao for prioritario
        if (prioritario != i) 
        { 
        	Collections.swap(fila, i, prioritario); //trocar os valores do heap
            // Usar heapfy
            heapifyPrioridade(fila, n, prioritario); 
        } 
    } 
    
    
  //==============================SORT HEAPFY Senha=============================================================

    //O sort por senha esta completo, ira organizar os numeros em ordem crescente de senha 
	
    public void sortSenha(ArrayList<Pessoa> fila) 
    { 
        int n = fila.size(); 
        
        // Aplicar heapfy uma vez
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapifySenha(fila, n, i); 
  
        // Tirar o ultimo valor do range do heapfy
        for (int i=n-1; i>=0; i--) 
        { 
            // Trocar o primeiro e o ultimo
        	Collections.swap(fila, 0, i);
  
            // usar heapfy na arvore reduzida
            heapifySenha(fila, i, 0); 
        } 
    } 
  
    // Funcao heapfy, jogar senha para cima
    void heapifySenha(ArrayList<Pessoa> fila, int n, int i) 
    { 
        int prioritario = i; // Initialize largest as root 
        int l = 2*i + 1; // left = 2*i + 1 
        int r = 2*i + 2; // right = 2*i + 2 
  
        // Se o filho da esqueda tiver prioridade sobre o pai
        if (l < n && fila.get(l).getSenha() > fila.get(prioritario).getSenha()) 
        	prioritario = l; 
  
        // Se o filho da direita tiver prioridade sobre o pai
        if (r < n && fila.get(r).getSenha() > fila.get(prioritario).getSenha()) 
        	prioritario = r; 
  
        // Se o pai nao for prioritario
        if (prioritario != i) 
        { 
        	Collections.swap(fila, prioritario, i);
  
            // Usar heapfy
            heapifySenha(fila, n, prioritario); 
        } 
    } 
    
} 