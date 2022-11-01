package jogo_da_velha;

// JOGADA DO JOGADOR
public class Jogada{
	// NUMERO DE JOGADAS FEITAS
	int jogadas = 0;
	// VALIDAÇÃO
	int validacao = 0;
	// METODO QUE INSERI NO CAMPO O SIMBOLO PASSANDO JUNTAMENTE COM AS COORDENADAS
	void realizarJogada(Coordenada coordenada, Jogador jogador, Tabuleiro t) {
		// VERIFICAR SE O CAMPO TA PREENCHIDO
		if(t.campo[coordenada.x][coordenada.y] == null) {
			t.campo[coordenada.x][coordenada.y] = jogador.simbolo;
			validacao = 1;
			jogadas++;
		}else {
			System.out.println("-------- Campo ja preenchido -------\n");
			validacao = 0;
		}
	}
}
