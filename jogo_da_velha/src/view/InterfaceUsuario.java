package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.Coordenada;
import model.Jogador;
import model.Jogo;
import model.Tabuleiro;

public class InterfaceUsuario {
	Scanner sc = new Scanner(System.in);
	private static InterfaceUsuario iu;
	private InterfaceUsuario() {}
	public static InterfaceUsuario getInstancia() {
		if(iu == null) {
			iu = new InterfaceUsuario();
		}
		return iu;
	}
	
	// METODO QUE PEGA AS INFORMAÇÕES DO JOGADOR NO TECLADO
	public Jogador pegarInfo() {
		Jogador jogador = new Jogador();
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
			System.out.println("\n-> Vez do Jogador(a): "+limitaString(j.nome)+"("+j.simbolo+")");
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
	// IMPRIMIR A PONTUACAO NO RANKING
	public void imprimirRanking(int[] pontVit, int[] pontPer, Jogador[] jogVit, Jogador[] jogPer, ArrayList<Jogo> jo) {
		System.out.println("======== VISUALIZAR RANKING ========\n");
		System.out.println("_____ VENCEDORES vs PERDEDORES _____");
		for(int i=0; i<jo.size(); i++) {
			if(pontVit[i] == pontPer[i]) {
				System.out.println("EMPATE > "+jogVit[i].nome+" "+pontVit[i]+" vs "+pontPer[i]+" "+jogPer[i].nome);				
			}else {
				System.out.println("\t "+jogVit[i].nome+" "+pontVit[i]+" vs "+pontPer[i]+" "+jogPer[i].nome);				
			}
		}
		
		System.out.println("\n====================================\n");		
	}
	// METODO PARA MOSTRAR OS HISTORICOS PARTIDAS
	public void imprimirHistoricoPartidas(ArrayList<Jogo> j) {
		System.out.println("======== HISTORICO PARTIDAS ========");
		for(int i=0; i<j.size(); i++) {
			System.out.println("____________________________________\n");
				System.out.println("Jogo: "+(i+1));
				System.out.println("Partidas:");
				for(int p=0; p < j.get(i).partidas.size(); p++) {
					System.out.println(" > Partida "+(p+1)+": "+limitaString(j.get(i).jogadores[0].nome)+" "+j.get(i).partidas.get(p).pontDaPartida[0]+" vs "+j.get(i).partidas.get(p).pontDaPartida[1]+" "+limitaString(j.get(i).jogadores[1].nome));
				}
				if(j.get(i).pontGeral[0] > j.get(i).pontGeral[1]) {
					System.out.println(" + Ganhador: "+j.get(i).jogadores[0].nome);
				}else if(j.get(i).pontGeral[0] < j.get(i).pontGeral[1]){
					System.out.println(" + Ganhador: "+j.get(i).jogadores[1].nome);
				}else {
					System.out.println(" + Esta Empate");				
				}
			System.out.println("____________________________________");
		}
		System.out.println("\n====================================\n");
	}
	// METODO PARA MOSTRAR OS HISTORICOS JOGADAS
	public void imprimirHistoricoJogadas(ArrayList<Jogo> j) {
		System.out.println("======== HISTORICO JOGADAS =========");
		for(int i=0; i<j.size(); i++) {
			System.out.println("____________________________________\n");
				System.out.println("Jogo: "+(i+1));
				for(int p=0; p < j.get(i).partidas.size(); p++) {
					System.out.println("\n > Partida "+(p+1)+"        Coordenada[x,y]\n");
					for(int g=0; g < j.get(i).partidas.get(p).jogadas.size(); g++) {
						if(g % 2 == 0) {
							System.out.print(" - Jogada "+(g+1)+": "+limitaString(j.get(i).jogadores[0].nome)+"("+j.get(i).jogadores[0].simbolo+") ");
							imprimirPontoPartida(limitaString(j.get(i).jogadores[0].nome));
							System.out.println(" ["+j.get(i).partidas.get(p).jogadas.get(g).coordenada.x+","+j.get(i).partidas.get(p).jogadas.get(g).coordenada.y+"]");							
						}else {
							System.out.print(" - Jogada "+(g+1)+": "+limitaString(j.get(i).jogadores[1].nome)+"("+j.get(i).jogadores[1].simbolo+") ");
							imprimirPontoPartida(limitaString(j.get(i).jogadores[1].nome));
							System.out.println(" ["+j.get(i).partidas.get(p).jogadas.get(g).coordenada.x+","+j.get(i).partidas.get(p).jogadas.get(g).coordenada.y+"]");							
						}
					}
				}
			System.out.println("____________________________________");
		}
		System.out.println("\n====================================\n");
	}
	void imprimirPonto(String n) {
		int v = 32 - 8 - n.length(); // 36 Nº de espaços, 9 Nº da palavra, n Nº do tamanho do nome
		
		for(int i=0; i < v; i++) {
			System.out.print(".");
		}
	}
	public static String limitaString(String texto){
	   if (texto.length() <= 6){
	      return texto+" ";
	   }else{
	      return texto.substring(0, 6)+".";
	   }
	}
	public void imprimirPontoPartida(String n){
		int v = 29 - 17 - n.length(); 

		for(int i=0; i < v; i++) {
			System.out.print(".");
		}
	}
	void imprimirPontoJogador(String n) {
		int v = 29 - n.length(); // 36 Nº de espaços, 9 Nº da palavra, n Nº do tamanho do nome
		
		for(int i=0; i < v; i++) {
			System.out.print(".");
		}
	}
	void imprimirTrofeu() {
		System.out.println("               _______");
		System.out.println(" _\\/_   .``\\  /       \\  /``.  ");
		System.out.println("  /\\    \\   \\|         |/  /  ");
		System.out.println("        /   /| VITORIA |\\  \\  ");
		System.out.println("        `../ |         | \\..`  ");
		System.out.println("              \\       /        ");
		System.out.println("  _\\/_        `\\     /`        ");
		System.out.println("   /\\           `| |`     _\\/_ ");
		System.out.println("                 | |       /\\   ");
		System.out.println("             ___/   \\___        ");
		System.out.println("            /___________\\       \n");
	}
	// METODO PARA MOSTRAR TABULEIRO
	public void imprimirHistoricoTabuleiro(ArrayList<Jogo> j) {
		System.out.println("======= HISTORICO TABULEIROS =======");
		for(int i=0; i<j.size(); i++) {
			System.out.println("____________________________________\n");
				System.out.println("Jogo: "+(i+1));
				System.out.println("> Partidas:");
				for(int p=0; p < j.get(i).partidas.size(); p++) {
					System.out.println("\n    Partida "+(p+1));
					j.get(i).partidas.get(p).tabuleiro.imprimirTabuleiro();
				}
			System.out.println("____________________________________");
		}
		System.out.println("\n====================================\n");
	}
	// MENU DOS JOGADORES
	public void infoJogador(Jogador jogadorUm, Jogador jogadorDois) {
		System.out.println("\n============== Jogadores ===========");
		System.out.println();
		System.out.print(" "+jogadorUm.nome+" ");
		imprimirPontoJogador(jogadorUm.nome);
		System.out.println(" ("+jogadorUm.simbolo+") ");

		System.out.print(" "+jogadorDois.nome+" ");
		imprimirPontoJogador(jogadorDois.nome);
		System.out.println(" ("+jogadorDois.simbolo+") ");

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
		System.out.println("=     5 - Historico de Partidas    =");
		System.out.println("=    6 - Historico de Tabuleiros   =");
		System.out.println("=      7 - Historico de Jogadas    =");
		System.out.println("=            8 - Sair              =");
		System.out.println("=                                  =");
		System.out.println("====================================\n");
	}
	// LISTA DE JOGOS ANTERIORES E ESCOLHA DO JOGO
	public int menuJogoAnterior(ArrayList<Jogo> j) {
		int op;
		System.out.println("==== LISTA DE JOGOS ANTERIORES =====");
		for(int i=0; i<j.size(); i++) {
			System.out.println("____________________________________\n");
			System.out.println("O Jogo "+(i+1)+" - "+j.get(i).jogadores[0].nome+" "+j.get(i).pontGeral[0]+" vs "+j.get(i).pontGeral[1]+" "+j.get(i).jogadores[1].nome);
		}
		System.out.println("____________________________________");
		
		System.out.print("\n- Escolher jogo: ");
		op = sc.nextInt() - 1;
		System.out.println();
		
		return op;
	}
	
	
	// MENSAGENS E TÍTULOS
	public void continuarJogando() {
		System.out.print("========= CONTINUAR JOGANDO ========\n");
	}
	public void novoJogo() {
		System.out.println("============ NOVO JOGO =============");
	}
	public void continuandoJogo() {
		System.out.print("========= CONTINUANDO JOGO =========\n");
	}
	public void jogoInexistenteMsg() {
		System.out.println("------- Este Jogo nao Existe -------\n");
	}
	public void opcaoInvalidaMsg() {
		System.out.println("---------- Opcao Invalida ----------\n");
	}
	public void saindoDoJogoMsg() {
		System.out.println("-------- Ate Logo Jogadores --------");
	}
	public void campoJaPreenchidoMsg() {
		System.out.println("-------- Campo ja preenchido -------\n");
	}
	public void linhaSeguida() {
		System.out.println("\n____________________________________\n");	
	}
	public void mostrarVencedorLinha(Jogador jogador, int l) {
		System.out.println("____________________________________\n");
		iu.imprimirTrofeu();
		System.out.print(" VENCEDOR ");
		iu.imprimirPonto(jogador.nome);
		System.out.print(" "+jogador.nome+"\n");
		System.out.println(" LOCAL .................... LINHA "+l+"\n");
	}
	public void mostrarVencedorColuna(Jogador jogador, int c) {
		System.out.println("____________________________________\n");
		iu.imprimirTrofeu();
		System.out.print(" VENCEDOR ");
		iu.imprimirPonto(jogador.nome);
		System.out.print(" "+jogador.nome+"\n");
		System.out.println(" LOCAL ................... COLUNA "+c+"\n");
	}
	public void mostrarVencedorDiagonalP(Jogador jogador) {
		System.out.println("____________________________________\n");
		iu.imprimirTrofeu();
		System.out.print(" VENCEDOR ");
		iu.imprimirPonto(jogador.nome);
		System.out.print(" "+jogador.nome+"\n");
		System.out.println(" LOCAL ......... DIAGONAL PRINCIPAL \n");
	}
	public void mostrarVencedorDiagonalS(Jogador jogador) {
		System.out.println("____________________________________\n");
		iu.imprimirTrofeu();
		System.out.print(" VENCEDOR ");
		iu.imprimirPonto(jogador.nome);
		System.out.print(" "+jogador.nome+"\n");
		System.out.println(" LOCAL ........ DIAGONAL SECUNDARIA \n");
	}
	public void mostrarQuantidadeJogadas(int i) {
		System.out.println("-------- Faltam "+i+" Jogada(s) --------\n");
	}
	public void empateMsg() {
		System.out.println("____________________________________\n");
		System.out.println("->  DEU EMPATE\n");
	}
	public void mostrarNumeracaoColuna() {
		System.out.println("\t       0   1   2");
	}
	public void mostrarNumerecaoLinha(int l) {
		System.out.print("\t    "+l+" ");
	}
	public void mostrarPosicaoVazia() {
		System.out.print("[ ] ");		
	}
	public void mostrarPosicaoPreenchida(String v) {
		System.out.print("["+v+"] ");	
	}
	public void pularLinha() {
		System.out.println(); 
	}
}
