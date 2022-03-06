package com.ivory.TesteEstagio.CampoMinado;


public class Program {
	
	public void executar() {
		
		CampoMinado campoMinado = new CampoMinado();
		
		System.out.println("Início do jogo\n=======");
		System.out.println(campoMinado.Tabuleiro());
		
		// Realize sua codificação a partir deste ponto, boa sorte!

		char[][] tabuleiroMat = new char[SIZE][SIZE];
		tabuleiroMat =  matrizTabuleiro(campoMinado.Tabuleiro());//Tabuleiro auxiliar no formato de matriz e com as provaveis localizações das bombas dadas por 'p'(pra ficar parecido com a bandeira do jogo de verdade)
		System.out.println(contaAbertas(4,7,tabuleiroMat));
		while(campoMinado.JogoStatus().equals(StatusTipo.Aberto)){
			break;
		}
	}

	private static final int SIZE = 9;

	//função que converte a string do tabuleiro em uma matriz
	public char[][] matrizTabuleiro(String tab){
		char[][] tabuleiroMat = new char[SIZE][SIZE];
		for(int i = 0; i < SIZE; i ++){
			for(int j = 0; j < SIZE; j++){
				tabuleiroMat[i][j] = tab.charAt((SIZE+2)*i + j);
			}
		}
		return tabuleiroMat;
	}

	//Conta a quantidade de casas abertas no arredores de uma posicao especifica
	public int contaAbertas(int linha, int coluna, char[][] tabuleiroMat){
		int contagem = 0;

		if(linha > 0){
			//adjacente acima
			if(tabuleiroMat[linha -1][coluna] == '-')
				contagem++;

			if(coluna > 0){
				//adjacente superior esquerdo
				if(tabuleiroMat[linha-1][coluna-1] == '-')
					contagem++;
			}
			
			if(coluna < SIZE-1){
				//adjacente superior direito
				if(tabuleiroMat[linha-1][coluna+1] == '-')
					contagem++;
			}
		}

		if(linha < SIZE-1){
			//adjacente abaixo
			if(tabuleiroMat[linha +1][coluna] == '-')
				contagem++;

			if(coluna > 0){
				//adjacente inferior esquerdo
				if(tabuleiroMat[linha+1][coluna-1] == '-')
					contagem++;
			}
			
			if(coluna < SIZE-1){
				//adjacente inferior direito
				if(tabuleiroMat[linha+1][coluna+1] == '-')
					contagem++;
			}
		}

		//adjacente esquerdo
		if(coluna > 0){
			if(tabuleiroMat[linha][coluna-1]== '-')
				contagem++;
		}

		//adjacente direto
		if(coluna < SIZE-1){
			if(tabuleiroMat[linha][coluna+1]== '-')
				contagem++;
		}
		return contagem;
	}
}