package jogo_da_velha;
import java.util.Scanner;

public class InterfaceUsuario {
	Scanner sc = new Scanner(System.in);
	
	// METODO QUE PEGA AS INFORMAÇÕES DO JOGADOR NO TECLADO
	public Jogador pegarInfo(Jogador um) {
		Jogador jogador = new Jogador();

		System.out.print("\n- Nome do Jogador(a): ");
		jogador.setNome(sc.next().toUpperCase());
		System.out.print("- Simbolo do Jogador(a): ");
		jogador.setSimbolo(sc.next());		
					
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
			coordenada.setX(sc.nextInt());
			System.out.print("- Coluna: ");
			coordenada.setY(sc.nextInt());						
			System.out.println();
			if((coordenada.getX() < 0 || coordenada.getX() > 2) || (coordenada.getY() < 0 || coordenada.getY() > 2)) {
				System.out.println("------- Coordenadas invalidas ------\n");
				t.imprimirTabuleiro();
			}
		}while((coordenada.getX() < 0 || coordenada.getX() > 2) || (coordenada.getY() < 0 || coordenada.getY() > 2));
		
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
	// METODO PARA MOSTRAR O RANKING
	public void imprimirRanking(Partida p) {
		System.out.println("============== RANKING =============\n");
		System.out.println("-------------- JOGO 1 --------------");
		for(int i=0; i<p.numPartida; i++) {
			System.out.println("-> Partida "+(i+1)+": Bruno ("+2+") vs ("+0+") Pedro");
		}
		System.out.println("\n====================================\n");
	}
	// MENU DOS JOGADORES
	public void infoJogador(Jogador jogadorUm, Jogador jogadorDois) {
		System.out.println("\n============== Jogadores ===========");
		System.out.println();
		System.out.println(" "+jogadorUm.getNome()+" ("+jogadorUm.getSimbolo()+") vs ("+jogadorDois.simbolo+") "+jogadorDois.getNome());
		System.out.println();
		System.out.println("====================================\n");
	}
	// MENU DE OPÇÕES
	public void menuOpcaoJogador() {
		System.out.println("=============== MENU ===============");
		System.out.println("=                                  =");
		System.out.println("=          1 - Continuar           =");
		System.out.println("=          2 - Novo Jogo           =");
		System.out.println("=          3 - Ranking             =");
		System.out.println("=          4 - Sair                =");
		System.out.println("=                                  =");
		System.out.println("====================================\n");
	}
}
