package view;

import java.util.ArrayList;

import command.Comando;
import command.ContinuarComando;
import command.JogoListaComando;
import command.NovoJogoComando;
import command.RankingComando;
import model.Jogador;
import model.Jogo;

/*
 * Singleton - Usado na InterfaceUsuario
 * Command   - Usado nos comandos do Menu
 * Composite - Usado no Jogo(blocoRaiz)/Partida(bloco)/Jogada(folha)
 */

public class JogoDaVelha {
	public static void main(String[] args) {
		InterfaceUsuario iu = InterfaceUsuario.getInstancia();
		
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
		//ArrayList<Comando> comandos = new ArrayList<Comando>();
		
		// ENQUANTO A OPÇÃO NÃO FOR SAIR
		int op;
		do {
			op = iu.pegarOpcao();
			switch (op) {
			case 1: { // CONTINUAR JOGO
				Comando continuarComando = new ContinuarComando();
				continuarComando.executar(jogos);
				break;
			}
			case 2:{ // NOVO JOGO
				Comando novoJogoComando = new NovoJogoComando();
				novoJogoComando.executar(jogos);
				//comandos.add(novoJogoComando);
				//jogos.add(umNovoJogo);
				break;
			}
			case 3: { // CONTINUAR JOGO ESCOLHIDO
				Comando jogoDaListaComando = new JogoListaComando();
				jogoDaListaComando.executar(jogos);
				break;
			}
			case 4:{ // RANKING
				Comando rankingComando = new RankingComando();
				rankingComando.executar(jogos);
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
				iu.opcaoInvalidaMsg();
				break;
			}
		}while(op != 8);
		iu.saindoDoJogoMsg();
	}
}