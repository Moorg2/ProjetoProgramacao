package modificadores;

import deck.Carta;
import individuos.Jogador;

public class Encantamento extends Carta {

    public String encantamento;

    public Encantamento( String nomes, int custoMana, String encantamento){
        super(nomes, custoMana);
        this.encantamento = encantamento;
    }
    public String getEncantamento(){
        return this.encantamento;
    }

    public void ativarEncantamento(Jogador jogador) {
        // Implementação da lógica do encantamento
        System.out.println("Encantamento ativado para " + jogador.getNome());
    }

}
