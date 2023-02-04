package model;

import java.util.ArrayList;

import view.InterfaceUsuario;

public class Resultado {
	// 36 ESPAÇOS
	InterfaceUsuario iu = InterfaceUsuario.getInstancia();
	public boolean verificarVencedor(Jogador um, Jogador dois, Tabuleiro t, int[] pontGeral, int[] pontDaPartida) {
		Dimensao d = t.dimensaoDoTabuleiro;
		// VERIFICAR TODAS AS LINHAS
		for(int l = 0; l < d.linhas; l++){
			if(t.campo[l][0] == um.simbolo && t.campo[l][1] == um.simbolo && t.campo[l][2] == um.simbolo){
				pontDaPartida[0] = pontGeral[0] + 1;
				pontDaPartida[1] = pontGeral[1];
				pontGeral[0]++;
				iu.mostrarVencedorLinha(um, l);
				return true;
			}else if(t.campo[l][0] == dois.simbolo && t.campo[l][1] == dois.simbolo && t.campo[l][2] == dois.simbolo){
				pontDaPartida[1] = pontGeral[1] + 1;
				pontDaPartida[0] = pontGeral[0];
				pontGeral[1]++;
				iu.mostrarVencedorLinha(dois, l);
				return true;
			}
		}
		// VERIFICAR TODAS AS COLUNAS
		for(int c = 0; c < d.colunas; c++){
			if(t.campo[0][c] == um.simbolo && t.campo[1][c] == um.simbolo && t.campo[2][c] == um.simbolo){
				pontDaPartida[0] = pontGeral[0] + 1;
				pontDaPartida[1] = pontGeral[1];
				pontGeral[0]++;
				iu.mostrarVencedorColuna(um, c);
				return true;
			}else if(t.campo[0][c] == dois.simbolo && t.campo[1][c] == dois.simbolo && t.campo[2][c] == dois.simbolo){
				pontDaPartida[1] = pontGeral[1] + 1;
				pontDaPartida[0] = pontGeral[0];
				pontGeral[1]++;
				iu.mostrarVencedorColuna(dois, c);
				return true;
			}
		}
		// VERIFICAR DIAGONAL PRINCIPAL
		if(t.campo[0][0] == um.simbolo && t.campo[1][1] == um.simbolo && t.campo[2][2] == um.simbolo){
			pontDaPartida[0] = pontGeral[0] + 1;
			pontDaPartida[1] = pontGeral[1];
			pontGeral[0]++;
			iu.mostrarVencedorDiagonalP(um);
			return true;
		}else if(t.campo[0][0] == dois.simbolo && t.campo[1][1] == dois.simbolo && t.campo[2][2] == dois.simbolo) {
			pontDaPartida[1] = pontGeral[1] + 1;
			pontDaPartida[0] = pontGeral[0];
			pontGeral[1]++;
			iu.mostrarVencedorDiagonalP(dois);
			return true;
		}
		// VERIFICAR DIAGONAL SECUNDARIA
		if(t.campo[0][2] == um.simbolo && t.campo[1][1] == um.simbolo && t.campo[2][0] == um.simbolo){
			pontDaPartida[0] = pontGeral[0] + 1;
			pontDaPartida[1] = pontGeral[1];
			pontGeral[0]++;
			iu.mostrarVencedorDiagonalS(um);
			return true;
		}else if(t.campo[0][2] == dois.simbolo && t.campo[1][1] == dois.simbolo && t.campo[2][0] == dois.simbolo) {
			pontDaPartida[1] = pontGeral[1] + 1;
			pontDaPartida[0] = pontGeral[0];
			pontGeral[1]++;
			iu.mostrarVencedorDiagonalS(dois);
			return true;
		}
		return false;
	}
	// SE DER EMPATE
	public boolean verificarEmpate(ArrayList<Jogada> jogadas, Jogador um, Jogador dois, int[] pontGeral, int[] pontDaPartida) {
		if(jogadas.size() < 9) {
			iu.mostrarQuantidadeJogadas(9-jogadas.size());
			return false;
		}else {
			pontDaPartida[1] = pontGeral[1];
			pontDaPartida[0] = pontGeral[0];
			iu.empateMsg();
			return true;
		}
	}
}
