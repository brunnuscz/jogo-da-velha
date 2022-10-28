package jogo_da_velha;

public class JogoDaVelha {
	public static void main(String[] args) {
		// INSTANCIANDO DOIS OBJETOS DA CLASSE JOGADOR
		Jogador jogadorUm = new Jogador();
		Jogador jogadorDois = new Jogador();
		
		// PEGANDO AS INFORMAÇÕES DO JOGADOR
		InterfaceUsuario iu = new InterfaceUsuario();
		jogadorUm = iu.pegarInfo(jogadorUm);
		jogadorDois = iu.pegarInfo(jogadorUm);
		
		// VENCEDORES
		
		// MONSTRANDO INFORMAÇÕES DOS JOGADORES
		iu.infoJogador(jogadorUm, jogadorDois);
		
		// INSTANCIANDO TABULEIRO, COORDENADA, JOGADA, RESULTADO
		Jogo jogo = new Jogo();
		
		// ENQUANTO NÃO HAVER GANHADOR OU NÃO PREENCHER O TABULEIRO POR COMPLETO
		jogo.novoJogo(jogadorUm, jogadorDois);
		
		Partida partida = new Partida();
		
		// ENQUANTO A OPÇÃO NÃO FOR SAIR
		int op;
		do {
			partida.numPartida++;
			op = iu.pegarOpcao();
			switch (op) {
			case 1: { // CONTINUAR O JOGO
				System.out.print("========= CONTINUAR JOGANDO ========\n");
				
				iu.infoJogador(jogadorUm, jogadorDois); // INFORMAÇÕES JOGADORES
				
				Tabuleiro tabuleiro = new Tabuleiro(); // TABULEIRO
				Jogada jogada = new Jogada(); // JOGADA
				
				tabuleiro.zerarTabuleiro(); // ZERAR TABULEIRO
				jogada.jogadas = 0; // ZERO JOGADA
				jogo.novoJogo(jogadorUm, jogadorDois); // CONTINUAR JOGANDO
				break;
			}
			case 2:{ // NOVO JOGO
				System.out.println("========== NOVO JOGO ===========");
				jogadorUm = iu.pegarInfo(jogadorUm);
				jogadorDois = iu.pegarInfo(jogadorDois);
				
				iu.infoJogador(jogadorUm, jogadorDois); // MONSTRANDO O MENU
				
				Jogo umNovoJogo = new Jogo();
				umNovoJogo.novoJogo(jogadorUm, jogadorDois); // CONTINUAR JOGANDO
				break;
			}
			case 3:{ // RANKING
				iu.imprimirRanking(partida);
			}
			case 4:{ // SAIR
				break;
			}
			default: // NENHUMA OPÇÃO
				System.out.println("---------- Opcao invalida ----------\n");
				break;
			}
		}while(op != 4);

		System.out.println("-------- Ate Logo Jogadores --------");
	}
}