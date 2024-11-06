package com.example.javainscryption.Service; //no entiendo por que da error

import com.example.javainscryption.Entities.Carta;

import java.util.List;

public class GameState {

    private List<Carta> mano;
    private int vidaJugador;
    private int recursos;

    // Getters y Setters
    public List<Carta> getMano() {
        return mano;
    }

    public void setMano(List<Carta> mano) {
        this.mano = mano;
    }

    public int getVidaJugador() {
        return vidaJugador;
    }

    public void setVidaJugador(int vidaJugador) {
        this.vidaJugador = vidaJugador;
    }

    public int getRecursos() {
        return recursos;
    }

    public void setRecursos(int recursos) {
        this.recursos = recursos;
    }
}
