package jogo_da_velha;

import java.util.ArrayList;
import java.util.Scanner;

public class InterfaceUsuario {
	Scanner sc = new Scanner(System.in);
	
	// METODO QUE PEGA AS INFORMAÇÕES DO JOGADOR NO TECLADO
	public Jogador pegarInfo(Jogador jogador) {
		System.out.print("\n- Nome do Jogador(a): ");
		jogador.nome = sc.next().toUpperCase();
		System.out.print("- Simbolo do Jogador(a): ");
		jogador.simbolo = sc.next();	
		
		return jogador;
	}
	
	// METODO PARA PEGAR AS COORDENADAS DO TECLADO
	public Coordenada pegarCoordenada(Jogador j, Tabuleiro t) {
		Coordenada coordenada = new Coordenada();
		
		// CONTROLE DE COORDENADAS < 0, > 2
		do{
			System.out.println("\n-> Vez do Jogador(a): "+j.nome+" ("+j.simbolo+")");
			System.out.println("-> Linhas e Colunas de (0 a 2)\n");
			System.out.print("- Linha: ");
			coordenada.x = sc.nextInt();
			System.out.print("- Coluna: ");
			coordenada.y = sc.nextInt();
			
			System.out.println();
			if((coordenada.x < 0 || coordenada.x > 2) || (coordenada.y < 0 || coordenada.y > 2)) {
				System.out.println("------- Coordenadas invalidas ------\n");
				t.imprimirTabuleiro();
			}
		}while((coordenada.x < 0 || coordenada.x > 2) || (coordenada.y < 0 || coordenada.y > 2));
		
		return coordenada;
	}
	
	// METODO PARA PEGAR A OPCAO DO MENU
	public int pegarOpcao() {
		menuOpcaoJogador();
		System.out.print("- Digite a opcao: ");
		int op = sc.nextInt();
		System.out.println();
		return op;
	}
	// METODO PARA MOSTRAR OS HISTORIA
	public void imprimirRanking(ArrayList<Jogo> j) {
		System.out.println("============== RANKING =============");
		for(int i=0; i<j.size(); i++) {
			System.out.println("____________________________________\n");
			System.out.println("O Jogo "+(i+1)+" Teve "+j.get(i).partida.numPartida+" Partida(s).");
			System.out.println("> Resultado:");
			System.out.println("\t "+j.get(i).r.jogadores[0].nome+" "+j.get(i).r.jogadores[0].pontuacao+" vs "+j.get(i).r.jogadores[1].pontuacao+" "+j.get(i).r.jogadores[1].nome);				
			
			if(j.get(i).r.jogadores[0].pontuacao > j.get(i).r.jogadores[1].pontuacao) {
				System.out.println("> Ganhador: "+j.get(i).r.jogadores[0].nome);
			}else if(j.get(i).r.jogadores[0].pontuacao < j.get(i).r.jogadores[1].pontuacao){
				System.out.println("> Ganhador: "+j.get(i).r.jogadores[1].nome);
			}else {
				System.out.println("> Esta Empate");				
			}
			System.out.println("____________________________________");
		}
		System.out.println("\n====================================\n");
	}
	// MENU DOS JOGADORES
	public void infoJogador(Jogador jogadorUm, Jogador jogadorDois) {
		System.out.println("\n============== Jogadores ===========");
		System.out.println();
		System.out.println(" "+jogadorUm.nome+" ("+jogadorUm.simbolo+") vs ("+jogadorDois.simbolo+") "+jogadorDois.nome);
		System.out.println();
		System.out.println("====================================\n");
	}
	// MENU DE OPÇÕES
	public void menuOpcaoJogador() {
		System.out.println("=============== MENU ===============");
		System.out.println("=                                  =");
		System.out.println("=          1 - Continuar           =");
		System.out.println("=          2 - Novo Jogo           =");
		System.out.println("=     3 - Escolher Jogo da Lista   =");
		System.out.println("=          4 - Ranking             =");
		System.out.println("=           5 - Sair               =");
		System.out.println("=                                  =");
		System.out.println("====================================\n");
	}
	// LISTA DE JOGOS ANTERIORES E ESCOLHA DO JOGO
	public int menuJogoAnterior(ArrayList<Jogo> j) {
		int op;
		System.out.println("==== LISTA DE JOGOS ANTERIORES =====");
		for(int i=0; i<j.size(); i++) {
			System.out.println("____________________________________\n");
			System.out.println("O Jogo "+(i+1)+" - "+j.get(i).r.jogadores[0].nome+" "+j.get(i).r.jogadores[0].pontuacao+" vs "+j.get(i).r.jogadores[1].pontuacao+" "+j.get(i).r.jogadores[1].nome);
		}
		System.out.println("____________________________________");
		
		System.out.print("\n- Escolher jogo: ");
		op = sc.nextInt() - 1;
		System.out.println();
		
		return op;
	}
}
