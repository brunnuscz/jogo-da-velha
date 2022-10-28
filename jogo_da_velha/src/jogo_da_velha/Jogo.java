package jogo_da_velha;

public class Jogo {
	
	void novoJogo(Jogador j1, Jogador j2) {
		Tabuleiro tabuleiro = new Tabuleiro();
		Coordenada coordenada = new Coordenada();
		Jogada jogada = new Jogada();
		Resultado r = new Resultado();
		InterfaceUsuario iu = new InterfaceUsuario();
		
		while(r.verificarVencedor(j1, j2, tabuleiro) == false && r.verificarEmpate(jogada) == false) {
			if(jogada.jogadas % 2 == 0) {// VEZ DO JOGADOR 1
				// ENQUANTO NÃO PASSAR COORDENADAS VALIDAS
				do {
					tabuleiro.imprimirTabuleiro();
					coordenada = iu.pegarCoordenada(j1, tabuleiro);
					jogada.realizarJogada(coordenada, j1, tabuleiro);					
				}while(jogada.validacao == 0);
			}else { // VEZ DO JOGADOR 2
				// ENQUANTO NÃO PASSAR COORDENADAS VALIDAS
				do {
					tabuleiro.imprimirTabuleiro();
					coordenada = iu.pegarCoordenada(j2, tabuleiro);
					jogada.realizarJogada(coordenada, j2, tabuleiro);					
				}while(jogada.validacao == 0);
			}
		}
		// IMPRIME O TABULEIRO UMA ULTIMA VEZ
		tabuleiro.imprimirTabuleiro();
		System.out.println("\n____________________________________\n");
	}
}
