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
public class Peca {
    private String simbolo;
    private int coordenada;

    public Peca(String simbolo, int coordenada) {
        this.simbolo = simbolo;
        this.coordenada = coordenada;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public int getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(int coordenada) {
        this.coordenada = coordenada;
    }
    
    
}
