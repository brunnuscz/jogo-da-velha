package command;

import view.InterfaceUsuario;

import java.util.ArrayList;

import model.Jogador;
import model.Jogo;

public class ContinuarComando implements Comando{
	InterfaceUsuario iu = InterfaceUsuario.getInstancia();
	@Override
	public void executar(ArrayList<Jogo> jogos) {
		iu.continuarJogando();
		int posicao = jogos.size(); // TAMANHO DO ARRAY
		// PEGANDO OS JOGADORES ULTIMO JOGO QUE FORAM SALVOS NO RESULTADO
		Jogador j1 = jogos.get(posicao-1).jogadores[0]; 
		Jogador j2 = jogos.get(posicao-1).jogadores[1];
		
		// MOSTRAR NA TELA OS JOGADORES QUE VÃO JOGAR NOVAMENTE
		iu.infoJogador(j1, j2); 
		jogos.get(posicao-1).novaPartida(j1, j2); // CONTINUAR JOGANDO
		
	}
}
