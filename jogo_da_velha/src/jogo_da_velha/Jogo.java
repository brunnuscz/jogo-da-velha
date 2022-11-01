package jogo_da_velha;

public class Jogo {
	
	Tabuleiro tabuleiro = new Tabuleiro();
	Coordenada coordenada = new Coordenada();
	Jogada jogada = new Jogada();
	Resultado r = new Resultado();
	InterfaceUsuario iu = new InterfaceUsuario();
	Partida partida = new Partida();
	int contador;
	
	void novaPartida(Jogador j1, Jogador j2) {
		// INICIANDO PARTIDA COM AS INFORMAÇÕES PASSADAS
		partida.iniciarPartida(tabuleiro, coordenada, jogada, r, iu, j1, j2);
	}
}
