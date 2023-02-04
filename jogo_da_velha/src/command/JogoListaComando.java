package command;

import view.InterfaceUsuario;

import java.util.ArrayList;

import model.Jogador;
import model.Jogo;
public class JogoListaComando implements Comando{
	InterfaceUsuario iu = InterfaceUsuario.getInstancia();
	@Override
	public void executar(ArrayList<Jogo> jogos) {
		int opicao = iu.menuJogoAnterior(jogos);
		if(opicao < jogos.size() && opicao >= 0) {
			iu.continuandoJogo();
			// PEGANDO OS JOGADORES ULTIMO JOGO QUE FORAM SALVOS NO RESULTADO
			
			Jogador j1 = jogos.get(opicao).jogadores[0]; 
			Jogador j2 = jogos.get(opicao).jogadores[1];
			
			// MOSTRAR NA TELA OS JOGADORES QUE VÃO JOGAR NOVAMENTE
			iu.infoJogador(j1, j2);
			
			jogos.get(opicao).novaPartida(j1, j2); // CONTINUAR JOGANDO	
	
			jogos.add(jogos.get(opicao));
			
			jogos.remove(opicao);
		}else {
			iu.jogoInexistenteMsg();
		}
	}
}
