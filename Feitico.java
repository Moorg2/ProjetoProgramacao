package ProjetoProgramacao;

public class Feitico extends Cartas {

    private String efeito;

    public Feitico( String nomes, int custoMana, String efeito){
        super(nomes, custoMana);
        this.efeito = efeito;
    }
    @Override
    public void usar(Jogador jogadorAtivo) {
        // Implementação do efeito do feitiço
        System.out.println(jogadorAtivo.nome + " lançou o feitiço: " + nome);
    }

    public void aplicarEfeito(String efeito){

        }
}    






