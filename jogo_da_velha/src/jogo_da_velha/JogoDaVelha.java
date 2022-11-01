package jogo_da_velha;

import java.util.ArrayList;

public class JogoDaVelha {
	public static void main(String[] args) {
		// INSTANCIANDO DOIS OBJETOS DA CLASSE JOGADOR
		Jogador jogadorUm = new Jogador();
		Jogador jogadorDois = new Jogador();
		
		// IU
		InterfaceUsuario iu = new InterfaceUsuario();
		
		// PEGAR AS INFORMAÇÕES DO JOGADOR
		jogadorUm = iu.pegarInfo(jogadorUm);
		jogadorDois = iu.pegarInfo(jogadorDois);
		
		// MONSTRANDO INFORMAÇÕES DOS JOGADORES
		iu.infoJogador(jogadorUm, jogadorDois);
		
		// INSTANCIANDO TABULEIRO, COORDENADA, JOGADA, RESULTADO
		Jogo jogo = new Jogo();

		// CRIANDO UM NOVO JOGO E JÁ INICIALIZANDO UM PARTIDA
		jogo.novaPartida(jogadorUm, jogadorDois);
		
		// ARRAY DE JOGOS
		ArrayList<Jogo> jogos = new ArrayList<Jogo>();
		jogos.add(jogo);
		
		// ENQUANTO A OPÇÃO NÃO FOR SAIR
		int op;
		do {
			op = iu.pegarOpcao();
			switch (op) {
			case 1: { // CONTINUAR JOGO
				System.out.print("========= CONTINUAR JOGANDO ========\n");
				
				int posicao = jogos.size(); // TAMANHO DO ARRAY
				// PEGANDO OS JOGADORES ULTIMO JOGO QUE FORAM SALVOS NO RESULTADO
				Jogador j1 = jogos.get(posicao-1).r.jogadores[0]; 
				Jogador j2 = jogos.get(posicao-1).r.jogadores[1];
				
				// MOSTRAR NA TELA OS JOGADORES QUE VÃO JOGAR NOVAMENTE
				iu.infoJogador(j1, j2); 
				
				jogos.get(posicao-1).tabuleiro.zerarTabuleiro();; // ZERAR TABULEIRO
				jogos.get(posicao-1).jogada.jogadas = 0; // ZERO JOGADA
				
				jogos.get(posicao-1).novaPartida(j1, j2); // CONTINUAR JOGANDO

				break;	
			}
			case 2:{ // NOVO JOGO
				System.out.println("========== NOVO JOGO ===========");
				Jogador um = new Jogador();
				Jogador dois = new Jogador();
				
				um = iu.pegarInfo(um);
				dois = iu.pegarInfo(dois);
				
				iu.infoJogador(um,dois); // MONSTRANDO O MENU
				
				Jogo umNovoJogo = new Jogo();
				umNovoJogo.novaPartida(um, dois); // CONTINUAR JOGANDO
				
				jogos.add(umNovoJogo);
				break;
			}
			case 3: { // CONTINUAR JOGO ESCOLHIDO
				int opicao = iu.menuJogoAnterior(jogos);
				if(opicao < jogos.size() && opicao >= 0) {
					System.out.print("========= CONTINUANDO JOGO =========\n");
					// PEGANDO OS JOGADORES ULTIMO JOGO QUE FORAM SALVOS NO RESULTADO
					Jogador j1 = jogos.get(opicao).r.jogadores[0]; 
					Jogador j2 = jogos.get(opicao).r.jogadores[1];
					
					// MOSTRAR NA TELA OS JOGADORES QUE VÃO JOGAR NOVAMENTE
					iu.infoJogador(j1, j2); 
					
					jogos.get(opicao).tabuleiro.zerarTabuleiro();; // ZERAR TABULEIRO
					jogos.get(opicao).jogada.jogadas = 0; // ZERO JOGADA
					
					jogos.get(opicao).novaPartida(j1, j2); // CONTINUAR JOGANDO					
				}else {
					System.out.println("------- Este Jogo nao Existe -------\n");
				}

				break;	
			}
			case 4:{ // RANKING
				iu.imprimirRanking(jogos);
				break;
			}
			case 5:{ // SAIR
				break;
			}
			default: // NENHUMA OPÇÃO
				System.out.println("---------- Opcao Invalida ----------\n");
				break;
			}
		}while(op != 5);

		System.out.println("-------- Ate Logo Jogadores --------");
	}
}