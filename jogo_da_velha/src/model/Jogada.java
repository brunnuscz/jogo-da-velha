package model;

import view.InterfaceUsuario;

// JOGADA DO JOGADOR
public class Jogada{
	
	InterfaceUsuario iu = InterfaceUsuario.getInstancia();
	public Coordenada coordenada = new Coordenada();
	
	int jogadas = 0;
	boolean validacao;
	
	// METODO QUE INSERI NO CAMPO O SIMBOLO PASSANDO JUNTAMENTE COM AS COORDENADAS
	void realizarJogada(Jogador jogador, Tabuleiro t) {
		
		coordenada = iu.pegarCoordenada(jogador, t);
		
		// VERIFICAR SE O CAMPO TA PREENCHIDO
		if(t.campo[coordenada.x][coordenada.y] == null) {
			t.campo[coordenada.x][coordenada.y] = jogador.simbolo;
			jogadas++;
			validacao = true;
		}else {
			iu.campoJaPreenchidoMsg();
			validacao = false;
		}
	}
}
