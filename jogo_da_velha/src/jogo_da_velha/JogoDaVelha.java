package jogo_da_velha;

import java.util.ArrayList;

public class JogoDaVelha {
	public static void main(String[] args) {
		// IU
		InterfaceUsuario iu = new InterfaceUsuario();
		
		// INSTANCIANDO DOIS OBJETOS DA CLASSE JOGADOR
		Jogador jogadorUm = iu.pegarInfo();
		Jogador jogadorDois = iu.pegarInfo();
		
		// MONSTRANDO INFORMAÇÕES DOS JOGADORES
		iu.infoJogador(jogadorUm, jogadorDois);
		
		// INSTANCIANDO TABULEIRO, COORDENADA, JOGADA, RESULTADO
		Jogo jogo = new Jogo();
		
		jogo.salvarJogador(jogadorUm, jogadorDois);
		
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
				Jogador j1 = jogos.get(posicao-1).jogadores[0]; 
				Jogador j2 = jogos.get(posicao-1).jogadores[1];
				
				// MOSTRAR NA TELA OS JOGADORES QUE VÃO JOGAR NOVAMENTE
				iu.infoJogador(j1, j2); 
				
				jogos.get(posicao-1).novaPartida(j1, j2); // CONTINUAR JOGANDO

				break;	
			}
			case 2:{ // NOVO JOGO
				System.out.println("============ NOVO JOGO =============");
				Jogador um = iu.pegarInfo();
				Jogador dois = iu.pegarInfo();

				iu.infoJogador(um,dois); // MONSTRANDO O MENU

				Jogo umNovoJogo = new Jogo();
				umNovoJogo.salvarJogador(um, dois);
				umNovoJogo.novaPartida(um, dois); // CONTINUAR JOGANDO
				
				jogos.add(umNovoJogo);
				break;
			}
			case 3: { // CONTINUAR JOGO ESCOLHIDO
				int opicao = iu.menuJogoAnterior(jogos);
				if(opicao < jogos.size() && opicao >= 0) {
					System.out.print("========= CONTINUANDO JOGO =========\n");
					// PEGANDO OS JOGADORES ULTIMO JOGO QUE FORAM SALVOS NO RESULTADO
					
					Jogador j1 = jogos.get(opicao).jogadores[0]; 
					Jogador j2 = jogos.get(opicao).jogadores[1];
					
					// MOSTRAR NA TELA OS JOGADORES QUE VÃO JOGAR NOVAMENTE
					iu.infoJogador(j1, j2);
					
					jogos.get(opicao).novaPartida(j1, j2); // CONTINUAR JOGANDO	

					jogos.add(jogos.get(opicao));
					
					jogos.remove(opicao);
				}else {
					System.out.println("------- Este Jogo nao Existe -------\n");
				}

				break;	
			}
			case 4:{ // RANKING
				iu.gerarRanking(jogos);
				break;
			}
			case 5:{ // HISTORICO DE PARTIDAS
				iu.imprimirHistoricoPartidas(jogos);
				break;
			}
			case 6:{ // HISTORICO TABULEIRO
				iu.imprimirHistoricoTabuleiro(jogos);
				break;
			}
			case 7:{ // HISTORICO JOGADA
				iu.imprimirHistoricoJogadas(jogos);
				break;
			}
			case 8:{ // SAIR
				break;
			}
			default: // NENHUMA OPÇÃO
				System.out.println("---------- Opcao Invalida ----------\n");
				break;
			}
		}while(op != 8);

		System.out.println("-------- Ate Logo Jogadores --------");
	}
}