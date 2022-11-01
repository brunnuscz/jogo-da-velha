package jogo_da_velha;

public class Tabuleiro {
	// INSTANCIANDO A CLASSE DIMENSAO
	Dimensao dimensaoDoTabuleiro = new Dimensao(3,3); // PASSANDO VALORES PARA O CONSTRUTOR
	// CRIANDO UMA MATRIZ E INFORMANDO O TAMANHO DELA A PARTIR DA DIMENSAO
	String campo[][] = new String[dimensaoDoTabuleiro.linhas][dimensaoDoTabuleiro.colunas];
	// METODO QUE IMPRIME O TABULEIRO
	void imprimirTabuleiro() {	
		System.out.println("\t    0   1   2");
		for(int l=0; l<dimensaoDoTabuleiro.linhas; l++) { // VAI IMPRIMIR O NÚMERO DE LINHAS INFORMADO
			System.out.print("\t "+l+" ");
			for(int c=0; c<dimensaoDoTabuleiro.colunas; c++) {
				if(campo[l][c] == null) { // SE O CAMPO TIVER VAZIO
					System.out.print("[ ] ");								
				}else { // SE TIVER ALGUMA COISA NO CAMPO
					System.out.print("["+campo[l][c]+"] ");	
				}
			}
			System.out.println(); // PULAR LINHAS AO MOSTRAR 3 COLUNAS
		}
	}
	// MEOTODO QUE ZERA O TABULEIRO
	void zerarTabuleiro() {
		for(int l=0; l<dimensaoDoTabuleiro.linhas; l++) {
			for(int c=0; c<dimensaoDoTabuleiro.colunas; c++) {
				if(campo[l][c] != null) {
					campo[l][c] = null;								
				}
			}
		}
	}
}
