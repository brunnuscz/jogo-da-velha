package jogo_da_velha;

import java.util.ArrayList;

public class Jogo {
	ArrayList<Partida> partidas = new ArrayList<Partida>();
	Jogador[] jogadores = new Jogador[2];
	int[] pontGeral = new int[2];
	
	void novaPartida(Jogador j1, Jogador j2) {
		Partida partida = new Partida();
		
		// INICIANDO PARTIDA COM AS INFORMAÇÕES PASSADAS
		partida.iniciarPartida(j1, j2, pontGeral);
		partidas.add(partida);
	}
	void salvarJogador(Jogador j1, Jogador j2) {
		jogadores[0] = j1;
		jogadores[1] = j2;
	}
}
