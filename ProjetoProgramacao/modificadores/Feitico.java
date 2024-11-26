package modificadores;

import deck.Carta;
import individuos.Jogador;

public class Feitico extends Carta {

    private String efeito;

    public Feitico( String nomes, int custoMana, String efeito){
        super(nomes, custoMana);
        this.efeito = efeito;
    }
    public String getEfeito(){
        return this.efeito;
    }

    public void ativarFeitico(Jogador jogador) {
        // Implementação da lógica do feitiço
        System.out.println("Feitiço ativado para " + jogador.getNome());
    }

}








