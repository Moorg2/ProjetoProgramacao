package ProjetoProgramacao;

import java.util.Collections;
import java.util.Random;

public class JogoDeCartas {

    

    public static void main(String[] args) {
        
        Jogador jogador1 = new Jogador("Jogador 1");
        Jogador jogador2 = new Jogador("Jogador 2");

        Jogo jogo = new Jogo(jogador1, jogador2);
        jogo.iniciar();
    }

    }
