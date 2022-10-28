package jogo_da_velha;

public class Resultado {
	
	public boolean verificarVencedor(Jogador um, Jogador dois, Tabuleiro t) {
		Dimensao d = t.dimensaoDoTabuleiro;
		// VERIFICAR TODAS AS LINHAS
		for(int l = 0; l < d.linhas; l++){
			if(t.campo[l][0] == um.simbolo && t.campo[l][1] == um.simbolo && t.campo[l][2] == um.simbolo){
				System.out.println("____________________________________\n");
				System.out.println("-> VENCEDOR "+um.nome+" LINHA "+l+"\n");
				return true;
			}else if(t.campo[l][0] == dois.simbolo && t.campo[l][1] == dois.simbolo && t.campo[l][2] == dois.simbolo){
				System.out.println("____________________________________\n");
				System.out.println("-> VENCEDOR "+dois.nome+" LINHA "+l+"\n");
				return true;
			}
		}
		// VERIFICAR TODAS AS COLUNAS
		for(int c = 0; c < d.colunas; c++){
			if(t.campo[0][c] == um.simbolo && t.campo[1][c] == um.simbolo && t.campo[2][c] == um.simbolo){
				System.out.println("____________________________________\n");
				System.out.println("-> VENCEDOR "+um.nome+" COLUNA "+c+"\n");
				return true;
			}else if(t.campo[0][c] == dois.simbolo && t.campo[1][c] == dois.simbolo && t.campo[2][c] == dois.simbolo){
				System.out.println("____________________________________\n");
				System.out.println("-> VENCEDOR "+dois.nome+" COLUNA "+c+"\n");
				return true;
			}
		}
		// VERIFICAR DIAGONAL PRINCIPAL
		if(t.campo[0][0] == um.simbolo && t.campo[1][1] == um.simbolo && t.campo[2][2] == um.simbolo){
			System.out.println("____________________________________\n");
			System.out.println("-> VENCEDOR "+um.nome+" DIAGONAL PRINCIPAL\n");
			return true;
		}else if(t.campo[0][0] == dois.simbolo && t.campo[1][1] == dois.simbolo && t.campo[2][2] == dois.simbolo) {
			System.out.println("____________________________________\n");
			System.out.println("-> VENCEDOR "+dois.nome+" DIAGONAL PRINCIPAL\n");
			return true;
		}
		// VERIFICAR DIAGONAL SECUNDARIA
		if(t.campo[0][2] == um.simbolo && t.campo[1][1] == um.simbolo && t.campo[2][0] == um.simbolo){
			System.out.println("____________________________________\n");
			System.out.println("-> VENCEDOR "+um.nome+" DIAGONAL SECUNDARIA\n");
			return true;
		}else if(t.campo[0][2] == dois.simbolo && t.campo[1][1] == dois.simbolo && t.campo[2][0] == dois.simbolo) {
			System.out.println("____________________________________\n");
			System.out.println("-> VENCEDOR "+dois.nome+" DIAGONAL SECUNDARIA\n");
			return true;
		}
		return false;
	}
	public boolean verificarEmpate(Jogada j) {
		if(j.jogadas < 9) {
			System.out.println("-------- Faltam "+(9-j.jogadas)+" Jogada(s) --------\n");
			return false;
		}else {
			System.out.println("____________________________________\n");
			System.out.println("->  DEU EMPATE\n");
			return true;
		}
	}
}
