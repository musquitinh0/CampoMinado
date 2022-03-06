package com.ivory.TesteEstagio.CampoMinado;


public class Program {
	
	public void executar() {
		
		CampoMinado campoMinado = new CampoMinado();
		
		System.out.println("Início do jogo\n=======");
		System.out.println(campoMinado.Tabuleiro());
		
		// Realize sua codificação a partir deste ponto, boa sorte!

		
		char[][] tabuleiroMat = new char[SIZE][SIZE];
		while(campoMinado.JogoStatus().equals(StatusTipo.Aberto)){
			tabuleiroMat =  matrixTabuleiro(campoMinado.Tabuleiro());

			break;
		}
	}

	private static final int SIZE = 9;


	public char[][] matrixTabuleiro(String tab){
		char[][] tabuleiroMat = new char[SIZE][SIZE];
		for(int i = 0; i < SIZE; i ++){
			for(int j = 0; j < SIZE; j++){
				tabuleiroMat[i][j] = tab.charAt((SIZE+2)*i + j);
			}
		}
		return tabuleiroMat;
	}
}
