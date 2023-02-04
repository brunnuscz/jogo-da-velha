package command;

import java.util.ArrayList;

import model.Jogo;

public interface Comando {
	public void executar(ArrayList<Jogo> jogos);
}
