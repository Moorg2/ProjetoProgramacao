package ProjetoProgramacao;

import java.util.ArrayList;
import java.util.List;

abstract class Jogador {
    String nome;
    public int vida;
    public int mana;
    public int manaInicial;
    public int turno =0;

    ArrayList<Cartas> deck;
    ArrayList<Cartas> mao;
    ArrayList<Cartas> cemiterio;
    public Jogador(String nome) {
        this.nome = nome;
        this.vida = 200; // Vida inicial
        this.mana = 3; // Mana inicial
        this.turno = 0;
        this.deck = new ArrayList<Cartas>();
        this.mao = new ArrayList<Cartas>();
        this.cemiterio= new ArrayList<Cartas>();
    }

    public int danoVida(int danoRecebido) {
        // Se o dano recebido for maior que a resistência, a criatura é destruída
        if (danoRecebido >= vida) {
            return 0; // tem que fazer o jogo acabar
        } else {
            return vida - danoRecebido; // Vida restante
        }
    }
    public int getTurno(){
        return this.turno;
    }

    // Método para ganhar mana no início do turno
    public void ganharMana() {
        if (turno == 0) {
            this.manaInicial = 3;
        } else {
            this.mana= this.manaInicial + 1;
        }
        if (this.mana > 10) {
            this.mana = 10;
        }
    }        
    public void comprarCarta() {
            if (!deck.isEmpty()) {
                Carta carta = deck.remove(0);
                mao.add(carta);
            } else if(mao.isEmpty()){
                /*Acaba o jogo */
            }
    }
    public void adicionarCartaAoDeck(Cartas carta) {
    }
}

