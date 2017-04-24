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
public class Jogo {
    private Jogador jogador1;
    private Jogador jogador2;
    private Tabuleiro tab;

    public Jogo(Jogador jogador1, Jogador jogador2, Tabuleiro tab) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.tab = tab;
    }

    public Jogador getJogador1() {
        return jogador1;
    }

    public void setJogador1(Jogador jogador1) {
        this.jogador1 = jogador1;
    }

    public Jogador getJogador2() {
        return jogador2;
    }

    public void setJogador2(Jogador jogador2) {
        this.jogador2 = jogador2;
    }

    public Tabuleiro getTab() {
        return tab;
    }

    public void setTab(Tabuleiro tab) {
        this.tab = tab;
    }
    
    
}
