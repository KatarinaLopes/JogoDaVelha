/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;
/**
 *
 * @author Katarina
 */
public class Jogador {
    private int pontuacao;
    private String simbolo;
    private boolean vencedor;

    public Jogador(int pontuacao, String simbolo) {
        this.pontuacao = pontuacao;
        this.simbolo = simbolo;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
    
    public Peca escolherPeca(int coordenada){
        return new Peca(this.getSimbolo(), coordenada);
    }
   
}
