package ProjetoProgramacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class JogoDeCartas{
    public Jogador jogador1;
    public Jogador jogador2;
    public Jogador jogadorAtual;
    ArrayList<Cartas> board;
    
    public JogoDeCartas(Jogador jogador1, Jogador jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.jogadorAtual = null;
        this.board = new ArrayList<Cartas>();
    }
    
    public void definirJogadorInicial(Jogador jogador1, Jogador jogador2) {
        Random random = new Random();
        if (random.nextBoolean()) {
            jogadorAtual = jogador1;
        } else {
            jogadorAtual = jogador2;
        }
    }
    
    public void comprar(){
        jogadorAtual.comprarCarta();
    }
    
    public void comprarMãoInicial() {
        for (int i = 0; i < 5; i++) {
            jogador1.comprarCarta();
            jogador2.comprarCarta();
        }
    }

    public void mudarJogador(){
        if (jogadorAtual == jogador1){
            jogadorAtual = jogador2;
        }else {
            jogadorAtual = jogador1;
        }
        jogadorAtual = null;
        this.turno += 1;
    }
    
    public void iniciar() {
        definirJogadorInicial();
        turnos();
    }

    public void turnos(){
        while (true) {
            if (getTurno() == 0){
                statusInicial();
                /*Um metodo para jogar cartas */
                /*Um metodo para concretizar a interação do jogar com as cartas no campo, poder atacar e ativar as habilidades */
                mudarJogador();
        }else{
                comprar();
                ganharMana();
                mudarJogador();
        }
        }
    }
    
    public void escolherAlvo(Object alvo) {
        if (alvo instanceof Jogador) {
            Jogador jogadorAlvo = (Jogador) alvo;
            danoRecebidoJogador(jogadorAlvo);
        } else if (alvo instanceof Criatura) {
            Criatura criaturaAlvo = (Criatura) alvo;
            danoRecebidoCriatura(criaturaAlvo);
        }
    }
    
   // public void danoRecebidojogador() {
    	
    //	this.vida = vida - dano 
   // }
    
    
    public void jogarCarta(){
        Cartas carta = mao.remove(carta);
        jogada();
        board.add(carta);
    }
    public void statusInicial() {
    	comprarMãoInicial();
    	ganharMana();
    }
    
    public static void main(String[] args) {
        
        Jogador jogador1 = new Jogador("Jogador 1"){};
        Jogador jogador2 = new Jogador("Jogador 2"){};
        JogoDeCartas jogo = new JogoDeCartas(jogador1, jogador2);
        jogo.iniciar();
    }
}