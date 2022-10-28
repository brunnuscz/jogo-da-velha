package jogo_da_velha;

// DADOS DO JOGADOR
public class Jogador {
	String nome;
	String simbolo;
	
	public void setNome(String novoNome){
		this.nome = novoNome;
	}
	public void setSimbolo(String novoSimbolo){
		this.simbolo = novoSimbolo;
	}
	public String getNome(){
		return this.nome;
	}
	public String getSimbolo(){
		return this.simbolo;
	}
	
}
