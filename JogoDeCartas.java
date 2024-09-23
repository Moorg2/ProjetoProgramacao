package ProjetoProgramacao;

import java.util.Collections;
import java.util.Random;

public class JogoDeCartas {

    
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
