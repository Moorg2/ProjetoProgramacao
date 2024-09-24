package ProjetoProgramacao;

import java.util.Collections;
import java.util.Random;

public class JogoDeCartas {
    public Jogador jogador1;
    public Jogador jogador2;
    public Jogador jogadorAtual;

    public JogoDeCartas(Jogador jogador1, Jogador jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.jogadorAtual = null;
    }
    public void iniciar() {
        comprarMãoInicial();
        definirJogadorInicial();

    }

    public void definirJogadorInicial(Jogador jogador1, Jogador jogador2) {
        Random random = new Random();
        if (random.nextBoolean()) {
            jogadorAtual = jogador1;
        } else {
            jogadorAtual = jogador2;
        }
    }
    
    public void comprarMãoInicial() {
        for (int i = 0; i < 5; i++) {
            jogador1.comprarCarta();
            jogador2.comprarCarta();
        }
    }

    public void mudarJogador(){
        if (JogadorAtual == jogador1){
            JogadorAtual = jogador2;
        }else {
            JogadorAtual = jogador1;
        }
        JogadorAtual = null;
    }

    public static void main(String[] args) {
        
        Jogador jogador1 = new Jogador("Jogador 1");
        Jogador jogador2 = new Jogador("Jogador 2");

        Jogo jogo = new Jogo(jogador1, jogador2);
        jogo.iniciar();
    }

    }
