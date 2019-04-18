package defaultpackage;

import java.util.ArrayList;

public class ArrayCaixas {
	
	private ArrayList<Caixa> ArrayCaixas; //Assim como as pessoas tem um fila, as caixas tem um array de caixas
	//Poderia ter sido criado 3 caixas individualmente, mas esta assim para uma possibilidade de mais caixas e para simplificar um pouco

	ArrayCaixas(){
		this.ArrayCaixas = new ArrayList<Caixa>();  //Inicializacao do array
	}
	
	public void addCaixa(Caixa caixa){
		this.ArrayCaixas.add(caixa);
	}
	
	//==================================================GETTERS SETTERS====================================
	
	public ArrayList<Caixa> getArrayCaixas() {
		return ArrayCaixas;
	}

	public void setArrayCaixas(ArrayList<Caixa> arrayCaixas) {
		ArrayCaixas = arrayCaixas;
	}
	
	
}
