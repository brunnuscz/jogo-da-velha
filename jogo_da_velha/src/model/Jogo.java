package model;

import java.util.ArrayList;

public class Jogo extends ElementoDoJogo{
	ArrayList<ElementoDoJogo> elementos = new ArrayList<ElementoDoJogo>();
	public Jogo(int numInfo) {
		super(numInfo);
	}
	public int getNum() {
		return numeroInformado;
	}
	public void adicionar(ElementoDoJogo ele) {
		elementos.add(ele);
	}
	@Override
	public void exibir() {
		System.out.println("* Jogo: "+numeroInformado);
		for(ElementoDoJogo e: elementos) {
			e.exibir();
		}
	}
	
	public ArrayList<Partida> partidas = new ArrayList<Partida>();
	public Jogador[] jogadores = new Jogador[2];
	public int[] pontGeral = new int[2];
	
	int numeroPartida = 0;
	public void novaPartida(Jogador j1, Jogador j2, Jogo jogo) {
		Partida partida = new Partida(numeroPartida+1);
		numeroPartida++;
		// INICIANDO PARTIDA COM AS INFORMAÇÕES PASSADAS
		partida.iniciarPartida(j1, j2, pontGeral, partida);
		partidas.add(partida);
		jogo.adicionar(partida);
	}
	public void salvarJogador(Jogador j1, Jogador j2) {
		jogadores[0] = j1;
		jogadores[1] = j2;
	}
}
