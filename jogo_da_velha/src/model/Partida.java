package model;

import java.util.ArrayList;

import view.InterfaceUsuario;

public class Partida extends ElementoDoJogo{
	ArrayList<ElementoDoJogo> elementos = new ArrayList<ElementoDoJogo>();
	public Partida(int numInfo) {
		super(numInfo);
	}
	public void adicionar(ElementoDoJogo ele) {
		elementos.add(ele);
	}
	public int getNum() {
		return numeroInformado;
	}
	@Override
	public void exibir() {
		System.out.println("  + Partida: "+numeroInformado);
		for(ElementoDoJogo e: elementos) {
			e.exibir();
		}
	}
	
	
	Resultado r = new Resultado();
	InterfaceUsuario iu = InterfaceUsuario.getInstancia();
	public Tabuleiro tabuleiro = new Tabuleiro();
	
	public ArrayList<Jogada> jogadas = new ArrayList<Jogada>();
	
	public int[] pontDaPartida = new int[2];
	
	int numeroJogada = 0;
	public void iniciarPartida(Jogador j1, Jogador j2, int[] pontGeral, Partida partida) {
		
		while(r.verificarVencedor(j1, j2, tabuleiro, pontGeral, pontDaPartida) == false && 
			  r.verificarEmpate(jogadas, j1, j2, pontGeral, pontDaPartida) == false) {
			
			// COMPOSITE
			Jogada jogada = new Jogada(numeroJogada+1);
			partida.adicionar(jogada);
			
			
			tabuleiro.imprimirTabuleiro();
				
			if((9-jogadas.size()) % 2 == 0) {// VEZ DO JOGADOR 2
				jogada.realizarJogada(j2, tabuleiro);					
			}else { // VEZ DO JOGADOR 1
				jogada.realizarJogada(j1, tabuleiro);				
			}
			jogadas.add(jogada);
			numeroJogada++;
		}
		
		// IMPRIME O TABULEIRO UMA ULTIMA VEZ
		tabuleiro.imprimirTabuleiro();
		iu.linhaSeguida();	
	}
}
