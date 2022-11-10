package jogo_da_velha;

import java.util.ArrayList;

public class Resultado {
	// 36 ESPAÇOS
	InterfaceUsuario iu = new InterfaceUsuario();
	public boolean verificarVencedor(Jogador um, Jogador dois, Tabuleiro t, int[] pontGeral, int[] pontDaPartida) {
		Dimensao d = t.dimensaoDoTabuleiro;
		// VERIFICAR TODAS AS LINHAS
		for(int l = 0; l < d.linhas; l++){
			if(t.campo[l][0] == um.simbolo && t.campo[l][1] == um.simbolo && t.campo[l][2] == um.simbolo){
				pontDaPartida[0] = pontGeral[0] + 1;
				pontDaPartida[1] = pontGeral[1];
				pontGeral[0]++;
				System.out.println("____________________________________\n");
				iu.imprimirTrofeu();
				System.out.print(" VENCEDOR ");
				iu.imprimirPonto(um.nome);
				System.out.print(" "+um.nome+"\n");
				System.out.println(" LOCAL .................... LINHA "+l+"\n");
				return true;
			}else if(t.campo[l][0] == dois.simbolo && t.campo[l][1] == dois.simbolo && t.campo[l][2] == dois.simbolo){
				pontDaPartida[1] = pontGeral[1] + 1;
				pontDaPartida[0] = pontGeral[0];
				pontGeral[1]++;
				System.out.println("____________________________________\n");
				iu.imprimirTrofeu();
				System.out.print(" VENCEDOR ");
				iu.imprimirPonto(dois.nome);
				System.out.print(" "+dois.nome+"\n");
				System.out.println(" LOCAL .................... LINHA "+l+"\n");
				return true;
			}
		}
		// VERIFICAR TODAS AS COLUNAS
		for(int c = 0; c < d.colunas; c++){
			if(t.campo[0][c] == um.simbolo && t.campo[1][c] == um.simbolo && t.campo[2][c] == um.simbolo){
				pontDaPartida[0] = pontGeral[0] + 1;
				pontDaPartida[1] = pontGeral[1];
				pontGeral[0]++;
				System.out.println("____________________________________\n");
				iu.imprimirTrofeu();
				System.out.print(" VENCEDOR ");
				iu.imprimirPonto(um.nome);
				System.out.print(" "+um.nome+"\n");
				System.out.println(" LOCAL ................... COLUNA "+c+"\n");
				return true;
			}else if(t.campo[0][c] == dois.simbolo && t.campo[1][c] == dois.simbolo && t.campo[2][c] == dois.simbolo){
				pontDaPartida[1] = pontGeral[1] + 1;
				pontDaPartida[0] = pontGeral[0];
				pontGeral[1]++;
				System.out.println("____________________________________\n");
				iu.imprimirTrofeu();

				System.out.print(" VENCEDOR ");
				iu.imprimirPonto(dois.nome);
				System.out.print(" "+dois.nome+"\n");
				System.out.println(" LOCAL ................... COLUNA "+c+"\n");
				return true;
			}
		}
		// VERIFICAR DIAGONAL PRINCIPAL
		if(t.campo[0][0] == um.simbolo && t.campo[1][1] == um.simbolo && t.campo[2][2] == um.simbolo){
			pontDaPartida[0] = pontGeral[0] + 1;
			pontDaPartida[1] = pontGeral[1];
			pontGeral[0]++;
			System.out.println("____________________________________\n");
			iu.imprimirTrofeu();
			System.out.print(" VENCEDOR ");
			iu.imprimirPonto(um.nome);
			System.out.print(" "+um.nome+"\n");
			System.out.println(" LOCAL ......... DIAGONAL PRINCIPAL \n");
			return true;
		}else if(t.campo[0][0] == dois.simbolo && t.campo[1][1] == dois.simbolo && t.campo[2][2] == dois.simbolo) {
			pontDaPartida[1] = pontGeral[1] + 1;
			pontDaPartida[0] = pontGeral[0];
			pontGeral[1]++;
			System.out.println("____________________________________\n");
			iu.imprimirTrofeu();
			System.out.print(" VENCEDOR ");
			iu.imprimirPonto(dois.nome);
			System.out.print(" "+dois.nome+"\n");
			System.out.println(" LOCAL ......... DIAGONAL PRINCIPAL \n");
			return true;
		}
		// VERIFICAR DIAGONAL SECUNDARIA
		if(t.campo[0][2] == um.simbolo && t.campo[1][1] == um.simbolo && t.campo[2][0] == um.simbolo){
			pontDaPartida[0] = pontGeral[0] + 1;
			pontDaPartida[1] = pontGeral[1];
			pontGeral[0]++;
			System.out.println("____________________________________\n");
			iu.imprimirTrofeu();
			System.out.print(" VENCEDOR ");
			iu.imprimirPonto(um.nome);
			System.out.print(" "+um.nome+"\n");
			System.out.println(" LOCAL ........ DIAGONAL SECUNDARIA \n");
			return true;
		}else if(t.campo[0][2] == dois.simbolo && t.campo[1][1] == dois.simbolo && t.campo[2][0] == dois.simbolo) {
			pontDaPartida[1] = pontGeral[1] + 1;
			pontDaPartida[0] = pontGeral[0];
			pontGeral[1]++;
			System.out.println("____________________________________\n");
			iu.imprimirTrofeu();
			System.out.print(" VENCEDOR ");
			iu.imprimirPonto(dois.nome);
			System.out.print(" "+dois.nome+"\n");
			System.out.println(" LOCAL ........ DIAGONAL SECUNDARIA \n");
			return true;
		}
		return false;
	}
	// SE DER EMPATE
	public boolean verificarEmpate(ArrayList<Jogada> jogadas, Jogador um, Jogador dois, int[] pontGeral, int[] pontDaPartida) {
		if(jogadas.size() < 9) {
			System.out.println("-------- Faltam "+(9-jogadas.size())+" Jogada(s) --------\n");
			return false;
		}else {
			pontDaPartida[1] = pontGeral[1];
			pontDaPartida[0] = pontGeral[0];
			System.out.println("____________________________________\n");
			System.out.println("->  DEU EMPATE\n");
			return true;
		}
	}
}
