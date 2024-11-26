package ProjetoProgramacao;

import java.util.ArrayList;


import deck.Carta;
import individuos.Criatura;

import individuos.Jogador;

public class JogoDeCartas {
    public static ArrayList<Carta> board; // Agora é estático
    public static int turno;             // Agora é estático

    public JogoDeCartas() {
        board = new ArrayList<>();
        turno = 1;
    }

    public static void exibirTabuleiro() {
        System.out.println("=== Tabuleiro ===");
        for (Carta carta : board) {
            if (carta instanceof Criatura criatura) {
                System.out.println(criatura.getNome() + " - Dano: " + criatura.getDano() + ", Resistência: " + criatura.getResist());
            }
        }
    }
    public void iniciar(ArrayList<Carta> deck1, ArrayList<Carta> deck2) {
        Jogador.inicializarJogadores(deck1, deck2);
        System.out.println("Jogo iniciado!");
        turnos();
    }

    public void turnos() {
        for (turno = 1; Jogador.jogador1.getVida() > 0 && Jogador.jogador2.getVida() > 0; turno++) {
            System.out.println("\n=== Turno " + turno + " ===");
            exibirTabuleiro();

            if (turno == 1) {
                Jogador.jogador1.statusInicial();
                Jogador.jogador2.statusInicial();
            } else {
                Jogador jogadorAtual = Jogador.definirJogadorInicial();
                assert jogadorAtual != null;
                //FASE DE COMPRA
                jogadorAtual.comprarCarta();
                //FASE DE MANA
                jogadorAtual.ganharMana();
                //FASE PRINCIPAL
                jogadorAtual.usarCarta();
                jogadorAtual.escolhaHabilidade();
                //FASE DE COMBATE
                jogadorAtual.faseCombate();
                //FASE FINAL
                jogadorAtual.mudarJogador();
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Carta> deck1 = new ArrayList<>();
        ArrayList<Carta> deck2 = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            deck1.add(new Carta("Carta " + (i + 1), i % 5 + 1));
            deck2.add(new Carta("Carta " + (i + 1), i % 5 + 1));
        }
        JogoDeCartas jogo = new JogoDeCartas();
        jogo.iniciar(deck1, deck2);
    }
}