/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execucao;

import negocio.Jogador;
import negocio.Jogo;
import negocio.Peca;
import negocio.Tabuleiro;

/**
 *
 * @author Katarina
 */
public class ControladorDeJogo {

    private Jogo jogo;

    public ControladorDeJogo() {
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }
    
    

    public void setaSimboloJogador(int opcao) {
        Jogador j1, j2;

        if (opcao == 1) {
            j1 = new Jogador(0, "X");
            j2 = new Jogador(0, "O");
        } else {
            j1 = new Jogador(0, "O");
            j2 = new Jogador(0, "X");
        }

        jogo = new Jogo(j1, j2, new Tabuleiro());
    }

    public void geraTabuleiroImpresso() {
        Peca p;

        for (int i = 0; i < jogo.getTab().getTabuleiro().length; i++) {
            for (int j = 0; j < jogo.getTab().getTabuleiro().length; j++) {
                p = jogo.getTab().getTabuleiro()[i][j];

                if (p.getSimbolo() == null) {
                    System.out.print(p.getCoordenada() + " ");
                } else {
                    System.out.print(p.getSimbolo() + " ");
                }
            }
            System.out.println("\n");
        }
    }

    public boolean fezJogada(Peca p) {
        Peca[][] pecas = jogo.getTab().getTabuleiro();

        for (int i = 0; i < pecas.length; i++) {
            for (int j = 0; j < pecas.length; j++) {

                if (pecas[i][j].getCoordenada() == p.getCoordenada()) {

                    if (pecas[i][j].getSimbolo() != null) {
                        return false;
                    } else {
                        pecas[i][j].setSimbolo(p.getSimbolo());
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean verificaSeGanhou(String simbolo) {
        Peca[][] p = jogo.getTab().getTabuleiro();

        String d1 = p[0][0].getSimbolo();
        String d2 = p[0][2].getSimbolo();

        if (d1 != null && d1.equals(simbolo)) {
            if (d1.equals(p[1][1].getSimbolo()) && d1.equals(p[2][2].getSimbolo())) {
                return true;
            }
        }

        if (d2 != null && d2.equals(simbolo)) {
            if (d2.equals(p[1][1].getSimbolo()) && d2.equals(p[2][0].getSimbolo())) {
                return true;
            }
        }

        for (int i = 0; i < p.length; i++) {
            String c1 = p[0][i].getSimbolo();
            String c2 = p[i][0].getSimbolo();

            if (c1 != null && c1.equals(simbolo)) {
                if (c1.equals(p[1][i].getSimbolo()) && c1.equals(p[2][i].getSimbolo())) {
                    return true;
                }
            }

            if (c2 != null && c2.equals(simbolo)) {
                if (c2.equals(p[i][1].getSimbolo()) && c2.equals(p[i][2].getSimbolo())) {
                    return true;
                }
            }

        }

        return false;
    }

   /* public static void main(String[] args) {
        
    }*/
}
