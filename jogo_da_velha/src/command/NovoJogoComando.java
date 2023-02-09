package command;

import java.util.ArrayList;

import model.Jogador;
import model.Jogo;
import view.InterfaceUsuario;

public class NovoJogoComando implements Comando{
	InterfaceUsuario iu = InterfaceUsuario.getInstancia();
	
	@Override
	public void executar(ArrayList<Jogo> jogos) {
		iu.novoJogo();
		Jogador um = iu.pegarInfo();
		Jogador dois = iu.pegarInfo();
		iu.infoJogador(um,dois); // MONSTRANDO O MENU
		Jogo umNovoJogo = new Jogo(jogos.size()+1);
		umNovoJogo.salvarJogador(um, dois);
		umNovoJogo.novaPartida(um, dois, umNovoJogo); // CONTINUAR JOGANDO
		
		jogos.add(umNovoJogo);
	}
}
