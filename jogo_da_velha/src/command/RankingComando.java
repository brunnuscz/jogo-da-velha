package command;
import view.InterfaceUsuario;

import java.util.ArrayList;

import model.Jogador;
import model.Jogo;
public class RankingComando implements Comando{
	InterfaceUsuario iu = InterfaceUsuario.getInstancia();
	@Override
	// CALCULAR PONTUACAO
	public void executar(ArrayList<Jogo> jogos) {
		// LISTA DE JOGOS
		ArrayList<Jogo> jo = new ArrayList<Jogo>();
		for(int i=0; i<jogos.size(); i++) {
			jo.add(jogos.get(i));
		}
		
		int[] pontVit = new int[jo.size()];
		int[] pontPer = new int[jo.size()];
		Jogador[] jogVit = new Jogador[jo.size()];
		Jogador[] jogPer = new Jogador[jo.size()];
		
		// VERIFICAR OS 2 JOGADORES DO JOGO QUEM GANHOU
		for(int i=0; i<jo.size(); i++) {
			if(jo.get(i).pontGeral[0] > jo.get(i).pontGeral[1]) {
				// SALVAR EM UM VETOR O JOGADOR VENCEDOR E A PONTUAÇÃO MAIOR
				jogVit[i] = jo.get(i).jogadores[0];
				pontVit[i] = jo.get(i).pontGeral[0];
				// SALVAR EM UM VETOR O JOGADOR PERDEDOR E A PONTUAÇÃO MENOR
				jogPer[i] = jo.get(i).jogadores[1];
				pontPer[i] = jo.get(i).pontGeral[1];
			}else {
				jogVit[i] = jo.get(i).jogadores[1];
				jogPer[i] = jo.get(i).jogadores[0];
				pontVit[i] = jo.get(i).pontGeral[1];
				pontPer[i] = jo.get(i).pontGeral[0];
			}
		}
		// CALCULAR QUAL A PONTUAÇÃO MAIOR E QUAL JOGADOR TEM ESSA PONTUAÇÃO
		for(int p=0; p<pontVit.length; p++) {
			for(int q=0; q<pontVit.length; q++) {
				int aux1V = pontVit[p];
				int aux1P = pontPer[p];
				Jogador aux2V = jogVit[p];
				Jogador aux2P = jogPer[p];
				
				if(pontVit[p] > pontVit[q]) {
					pontVit[p] = pontVit[q];
					jogVit[p] = jogVit[q];
					
					pontPer[p] = pontPer[q];
					jogPer[p] = jogPer[q];
					
					pontVit[q] = aux1V;
					jogVit[q] = aux2V;
					
					pontPer[q] = aux1P;
					jogPer[q] = aux2P;
				}
			}
		}
		iu.imprimirRanking(pontVit, pontPer, jogVit, jogPer, jo);
	}
}
