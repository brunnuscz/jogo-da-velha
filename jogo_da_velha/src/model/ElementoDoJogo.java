package model;

public abstract class ElementoDoJogo {
	String descricao;
	public ElementoDoJogo(String desc) {
		this.descricao = desc;
	}
	public abstract void exibir();
}
