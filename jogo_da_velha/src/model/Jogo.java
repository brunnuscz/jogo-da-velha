package model;

import java.util.ArrayList;

public class Jogo {
	public ArrayList<Partida> partidas = new ArrayList<Partida>();
	public Jogador[] jogadores = new Jogador[2];
	public int[] pontGeral = new int[2];
	
	public void novaPartida(Jogador j1, Jogador j2) {
		Partida partida = new Partida();
		
		// INICIANDO PARTIDA COM AS INFORMAÇÕES PASSADAS
		partida.iniciarPartida(j1, j2, pontGeral);
		partidas.add(partida);
	}
	public void salvarJogador(Jogador j1, Jogador j2) {
		jogadores[0] = j1;
		jogadores[1] = j2;
	}
}
