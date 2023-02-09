package model;

public abstract class ElementoDoJogo {
	int numeroInformado;
	public ElementoDoJogo(int numInfo) {
		this.numeroInformado = numInfo;
	}
	public abstract void exibir();
}
