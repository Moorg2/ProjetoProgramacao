package ProjetoProgramacao;

import java.util.ArrayList;
import java.util.List;

abstract class Jogador {
    String nome;
    int vida;
    int mana;
    public int turno;

    List<Carta> deck;
    List<Carta> mao;
    List<Carta> cemiterio;
    public Jogador(String nome) {
        this.nome = nome;
        this.vida = 200; // Vida inicial
        this.mana = 3; // Mana inicial
        this.turno = 0;
        this.deck = new ArrayList<>();
        this.mao = new ArrayList<>();
        this.cemiterio = new ArrayList<>();
    }

    public int danoVida(int danoRecebido) {
        // Se o dano recebido for maior que a resistência, a criatura é destruída
        if (danoRecebido >= vida) {
            return 0; // tem que fazer o jogo acabar
        } else {
            return vida - danoRecebido; // Vida restante
        }
    }


    // Método para ganhar mana no início do turno
    public void ganharMana() {
        if (turno == 0) {
            mana = 3;
        } else {
            mana += 2;
        }
        if (mana > 10) {
            mana = 10;
        }
        turno++; 
    }

    public String getNome(){
        return this.nome;
    }

    public void setVida(int vida){
        this.vida = vida;
    }
    public int getVida(){
        return this.vida;
    }

    public void setMana(int mana){
        this.mana = mana;
    }
    public int getMana(){
        return this.mana;
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

