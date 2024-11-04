package ProjetoProgramacao;

import java.util.ArrayList;
import java.util.List;

abstract class Jogador {
    String nome;
    public int vida;
    public int manaInicial;
    public int turno = 0;

    ArrayList<Cartas> deck;
    ArrayList<Cartas> mao;
    ArrayList<Cartas> cemiterio;
    public Jogador(String nome) {
        this.nome = nome;
        this.vida = 200; // Vida inicial
        this.turno = 0;
        this.deck = new ArrayList<Cartas>();
        this.mao = new ArrayList<Cartas>();
        this.cemiterio= new ArrayList<Cartas>();
    }
    
    public void setVida(int vida) {
        this.vida = vida;
    }
    
    public int getVida() {
        return this.vida;
    }

    
    public int danoVida(int dano, int vida) {
        // Se o dano recebido for maior que a resistência, a criatura é destruída
        if (danoRecebido >= vida) {
            return 0; // tem que fazer o jogo acabar
        } else {
            return this.vida = vida - dano // Vida restante
        }
    }
    
    public int getDanoCriatura() {
        return this.dano;
    }

    
    public int danoRecebidoJogador(int getDanoCriatura(), int vida) { //Criatura -> jogador//
    	
    	return danoRecebidoJogador = this.vida - getDanoCriatura()
    		
    }
    
    public int danoRecebidoCriatura(int dano, int resist) { //Criatura -> Criatura
    	
    	return danoRecebidoCriatura = resist - dano
    }
    
    
    //public int alvoEscolher() { //O Alvo a sofrer dano será escolhido dependendo se tiver cartas em jogo ou não, 
    							//se não tiver, chamar o metodo danoRecebidoJogador(); se tiver, usar o metodo danoRecebidoCriatura();
    	//if() {
    		//}
    	
    }
    public int getTurno(){
        return this.turno;
    }

    // Método para ganhar mana no início do turno
    public void ganharMana() {
        if (getTurno() == 0) {
            this.manaInicial = 3;
        } else {
            this.mana = manaInicial + getTurno();
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

