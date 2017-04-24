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
public class Tabuleiro {
    private Peca[][] pecas = new Peca[3][3];
    
    public Tabuleiro(){
        compoeTabuleiro();
    }

    public Peca[][] getTabuleiro() {
        return pecas;
    }

    public void setTabuleiro(Peca[][] tabuleiro) {
        this.pecas = tabuleiro;
    }

    private void compoeTabuleiro(){
        int c = 1;
        
        for (int i = 0; i < pecas.length; i++) {
            for (int j = 0; j < pecas.length; j++) {
                pecas[i][j] = new Peca(null, c);
                c++;
            
            }
            
        }
    }
    
    public boolean estaCheio(){
        int c = 0;
        
        for (int i = 0; i < pecas.length; i++) {
            for (int j = 0; j < pecas.length; j++) {
                if(pecas[i][j].getSimbolo() != null){
                    c++;
                }
                
            }
            
        }
        
        return c == 9;
    }
    
    
    
}
