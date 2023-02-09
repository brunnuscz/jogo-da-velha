package model;


import view.InterfaceUsuario;

// JOGADA DO JOGADOR
public class Jogada extends ElementoDoJogo{
	// COMPOSITE
	public Jogada(int numInfo) {
		super(numInfo);
	}
	public int getNum() {
		return numeroInformado;
	}
	@Override
	public void exibir() {
		System.out.println("    - Jogada: "+ numeroInformado);
	}
	
	
	InterfaceUsuario iu = InterfaceUsuario.getInstancia();
	public Coordenada coordenada = new Coordenada();
	
	int jogadas = 0;
	boolean validacao;
	
	// METODO QUE INSERI NO CAMPO O SIMBOLO PASSANDO JUNTAMENTE COM AS COORDENADAS
	void realizarJogada(Jogador jogador, Tabuleiro t) {
		do {
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
		}while(validacao == false);
	}
}
