package model;

import view.InterfaceUsuario;

// JOGADA DO JOGADOR
public class Jogada{
	public InterfaceUsuario iu = new InterfaceUsuario();
	public Coordenada coordenada = new Coordenada();
	
	public int jogadas = 0;
	public boolean validacao;
	
	// METODO QUE INSERI NO CAMPO O SIMBOLO PASSANDO JUNTAMENTE COM AS COORDENADAS
	void realizarJogada(Jogador jogador, Tabuleiro t) {
		
		coordenada = iu.pegarCoordenada(jogador, t);
		
		// VERIFICAR SE O CAMPO TA PREENCHIDO
		if(t.campo[coordenada.x][coordenada.y] == null) {
			t.campo[coordenada.x][coordenada.y] = jogador.simbolo;
			jogadas++;
			validacao = true;
		}else {
			System.out.println("-------- Campo ja preenchido -------\n");
			validacao = false;
		}
	}
}
