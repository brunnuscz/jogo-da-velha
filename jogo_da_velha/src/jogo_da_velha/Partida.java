package jogo_da_velha;

public class Partida {
	int numPartida = 0;
	InterfaceUsuario iu = new InterfaceUsuario();
	public void iniciarPartida(Tabuleiro t, Coordenada c, Jogada j, Resultado r, InterfaceUsuario iu, Jogador j1, Jogador j2) {
		while(r.verificarVencedor(j1, j2, t) == false && r.verificarEmpate(j, j1, j2) == false) {
			if(j.jogadas % 2 == 0) {// VEZ DO JOGADOR 1
				// ENQUANTO NÃO PASSAR COORDENADAS VALIDAS
				do {
					t.imprimirTabuleiro();
					c = iu.pegarCoordenada(j1, t);
					j.realizarJogada(c, j1, t);					
				}while(j.validacao == 0);
			}else { // VEZ DO JOGADOR 2
				// ENQUANTO NÃO PASSAR COORDENADAS VALIDAS
				do {
					t.imprimirTabuleiro();
					c = iu.pegarCoordenada(j2, t);
					j.realizarJogada(c, j2, t);					
				}while(j.validacao == 0);
			}
		}
		numPartida++;
		// IMPRIME O TABULEIRO UMA ULTIMA VEZ
		t.imprimirTabuleiro();
		System.out.println("\n____________________________________\n");		
	}
}
