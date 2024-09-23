package ProjetoProgramacao;

abstract class Cartas {

    public String nomes;
    public int custoMana;

    public Cartas(String nomes, int custoMana) {
        this.nomes = nomes;
        this.custoMana = custoMana;
    }
    
    public abstract void usar(Jogador jogadorAtivo);

}
