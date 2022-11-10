package jogo_da_velha;

import java.util.ArrayList;

public class Partida {
	
	Resultado r = new Resultado();
	InterfaceUsuario iu = new InterfaceUsuario();
	Tabuleiro tabuleiro = new Tabuleiro();
	
	ArrayList<Jogada> jogadas = new ArrayList<Jogada>();
	
	int[] pontDaPartida = new int[2];
	
	public void iniciarPartida(Jogador j1, Jogador j2, int[] pontGeral) {
	
		while(r.verificarVencedor(j1, j2, tabuleiro, pontGeral, pontDaPartida) == false && 
			  r.verificarEmpate(jogadas, j1, j2, pontGeral, pontDaPartida) == false) {
			Jogada jogada = new Jogada();
			do { // ENQUANTO NÃO PASSAR COORDENADAS VALIDAS
				tabuleiro.imprimirTabuleiro();
				
				if((9-jogadas.size()) % 2 == 0) {// VEZ DO JOGADOR 2
					jogada.realizarJogada(j2, tabuleiro);					
				}else { // VEZ DO JOGADOR 1
					jogada.realizarJogada(j1, tabuleiro);				
				}
				
				jogadas.add(jogada);
			}while(jogada.validacao == false);
		}
		
		// IMPRIME O TABULEIRO UMA ULTIMA VEZ
		tabuleiro.imprimirTabuleiro();
		System.out.println("\n____________________________________\n");		
	}
}
