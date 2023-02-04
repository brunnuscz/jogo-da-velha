package model;

import view.InterfaceUsuario;

public class Tabuleiro {
	InterfaceUsuario iu = InterfaceUsuario.getInstancia();
	// INSTANCIANDO A CLASSE DIMENSAO
	Dimensao dimensaoDoTabuleiro = new Dimensao(3,3); // PASSANDO VALORES PARA O CONSTRUTOR
	// CRIANDO UMA MATRIZ E INFORMANDO O TAMANHO DELA A PARTIR DA DIMENSAO
	String campo[][] = new String[dimensaoDoTabuleiro.linhas][dimensaoDoTabuleiro.colunas];
	// METODO QUE IMPRIME O TABULEIRO
	public void imprimirTabuleiro() {
		iu.mostrarNumeracaoColuna();
		for(int l=0; l<dimensaoDoTabuleiro.linhas; l++) { // VAI IMPRIMIR O NÚMERO DE LINHAS INFORMADO
			iu.mostrarNumerecaoLinha(l);
			for(int c=0; c<dimensaoDoTabuleiro.colunas; c++) {
				if(campo[l][c] == null) { // SE O CAMPO TIVER VAZIO
					iu.mostrarPosicaoVazia();						
				}else { // SE TIVER ALGUMA COISA NO CAMPO
					iu.mostrarPosicaoPreenchida(campo[l][c]);
				}
			}
			iu.pularLinha(); // PULAR LINHAS AO MOSTRAR 3 COLUNAS
		}
	}
}