package model;

import java.util.ArrayList;

import view.InterfaceUsuario;

// JOGADA DO JOGADOR
public class Jogada extends ElementoDoJogo{
	ArrayList<ElementoDoJogo> elementos = new ArrayList<ElementoDoJogo>();

	public Jogada(String descricao) {
		super(descricao);
	}
	public void adicionar(ElementoDoJogo ele) {
		elementos.add(ele);
	}

	@Override
	public void exibir() {
		System.out.println("Jogada: "+descricao);
		for(ElementoDoJogo e: elementos) {
			e.exibir();
		}
	}
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
