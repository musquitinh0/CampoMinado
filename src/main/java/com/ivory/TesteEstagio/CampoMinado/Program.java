package com.ivory.TesteEstagio.CampoMinado;


public class Program {
	
	public void executar() {
		
		CampoMinado campoMinado = new CampoMinado();
		
		System.out.println("Início do jogo\n=======");
		System.out.println(campoMinado.Tabuleiro());

		
		// Realize sua codificação a partir deste ponto, boa sorte!
		boolean done = true;
		
		char[][] tabuleiroMat = new char[SIZE][SIZE];

		while(campoMinado.JogoStatus().ordinal() == 0 && done){
			//variavel de controle para saber se o algoritimo fez alguma coisa nessa iteração
			done = false;

			tabuleiroMat =  matrizTabuleiro(campoMinado.Tabuleiro());
			tabuleiroMat = colocaBombas(tabuleiroMat);
	
			for(int linha = 0; linha < SIZE; linha++){
				for(int coluna = 0; coluna < SIZE; coluna++){
					if(tabuleiroMat[linha][coluna] != 'p' && tabuleiroMat[linha][coluna] != '-'){
						if(contaBombas(linha, coluna, tabuleiroMat) == Character.getNumericValue(tabuleiroMat[linha][coluna])){
							//todas as casas ao redor dessa peça sao seguras
							if(linha > 0 && coluna > 0){
								if(tabuleiroMat[linha-1][coluna-1] == '-'){
									campoMinado.Abrir(linha, coluna);
									done = true;
								}
							}
							if(linha < SIZE-1 && coluna > 0){
								if(tabuleiroMat[linha+1][coluna-1] == '-'){
									campoMinado.Abrir(linha+2, coluna);
									done = true;
								}
							}
							if(linha > 0 && coluna < SIZE-1){
								if(tabuleiroMat[linha-1][coluna+1] == '-'){
									campoMinado.Abrir(linha, coluna+2);
									done = true;
								}
							}
							if(linha < SIZE-1 && coluna < SIZE-1){
								if(tabuleiroMat[linha+1][coluna+1] == '-'){
									campoMinado.Abrir(linha+2, coluna+2);
									done = true;
								}
							}
							if(linha > 0){
								if(tabuleiroMat[linha-1][coluna] == '-'){
									campoMinado.Abrir(linha, coluna+1);
									done = true;
								}
							}
							if(linha < SIZE-1){
								if(tabuleiroMat[linha+1][coluna] == '-'){
									campoMinado.Abrir(linha+2, coluna+1);
									done = true;
								}
							}
							if(coluna < SIZE-1){
								if(tabuleiroMat[linha][coluna+1] == '-'){
									campoMinado.Abrir(linha+1, coluna+2);
									done = true;
								}
							}
							if(coluna > 0){
								if(tabuleiroMat[linha][coluna-1] == '-'){
									campoMinado.Abrir(linha+1, coluna);
									done = true;
								}
							}
						}
					}
				}
			}
		}
		
		System.out.println("Final do jogo\n=======");
		System.out.println(campoMinado.Tabuleiro());
		System.out.println(campoMinado.JogoStatus().name());
	}

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

	//Conta a quantidade de bombas descobertas no arredores de uma posicao especifica
	public int contaBombas(int linha, int coluna, char[][] tabuleiroMat){
		int contagem = 0;

		if(linha > 0){
			//adjacente acima
			if(tabuleiroMat[linha -1][coluna] == 'p')
				contagem++;

			if(coluna > 0){
				//adjacente superior esquerdo
				if(tabuleiroMat[linha-1][coluna-1] == 'p')
					contagem++;
			}
			
			if(coluna < SIZE-1){
				//adjacente superior direito
				if(tabuleiroMat[linha-1][coluna+1] == 'p')
					contagem++;
			}
		}

		if(linha < SIZE-1){
			//adjacente abaixo
			if(tabuleiroMat[linha +1][coluna] == 'p')
				contagem++;

			if(coluna > 0){
				//adjacente inferior esquerdo
				if(tabuleiroMat[linha+1][coluna-1] == 'p')
					contagem++;
			}
			
			if(coluna < SIZE-1){
				//adjacente inferior direito
				if(tabuleiroMat[linha+1][coluna+1] == 'p')
					contagem++;
			}
		}

		//adjacente esquerdo
		if(coluna > 0){
			if(tabuleiroMat[linha][coluna-1]== 'p')
				contagem++;
		}

		//adjacente direto
		if(coluna < SIZE-1){
			if(tabuleiroMat[linha][coluna+1]== 'p')
				contagem++;
		}
		return contagem;
	}

	public char[][] colocaBombas (char[][] tabuleiroMat){

		for(int linha = 0; linha < SIZE; linha++){
			for(int coluna = 0; coluna < SIZE; coluna++){
				if(contaAbertas(linha, coluna, tabuleiroMat) + contaBombas(linha, coluna, tabuleiroMat) == Character.getNumericValue(tabuleiroMat[linha][coluna])){
					if(linha > 0 && coluna > 0){
						if(tabuleiroMat[linha-1][coluna-1] == '-'){
							tabuleiroMat[linha-1][coluna-1] = 'p';
						}
					}
					if(linha < SIZE-1 && coluna > 0){
						if(tabuleiroMat[linha+1][coluna-1] == '-'){
							tabuleiroMat[linha+1][coluna-1] = 'p';
						}
					}
					if(linha > 0 && coluna < SIZE-1){
						if(tabuleiroMat[linha-1][coluna+1] == '-'){
							tabuleiroMat[linha-1][coluna+1] = 'p';
						}
					}
					if(linha < SIZE-1 && coluna < SIZE-1){
						if(tabuleiroMat[linha+1][coluna+1] == '-'){
							tabuleiroMat[linha+1][coluna+1] = 'p';
						}
					}
					if(linha > 0){
						if(tabuleiroMat[linha-1][coluna] == '-'){
							tabuleiroMat[linha-1][coluna] = 'p';
						}
					}
					if(linha < SIZE-1){
						if(tabuleiroMat[linha+1][coluna] == '-'){
							tabuleiroMat[linha+1][coluna] = 'p';
						}
					}
					if(coluna < SIZE-1){
						if(tabuleiroMat[linha][coluna+1] == '-'){
							tabuleiroMat[linha][coluna+1] = 'p';
						}
					}
					if(coluna > 0){
						if(tabuleiroMat[linha][coluna-1] == '-'){
							tabuleiroMat[linha][coluna-1] = 'p';
						}
					}
				}
			}
		}
		return tabuleiroMat;
	}

	private static final int SIZE = 9;
}