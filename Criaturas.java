package ProjetoProgramacao;

public class Criaturas extends Cartas {

    private int dano;
    private int resist;

    public  Criaturas(String nomes, int custoMana, int dano, int resist){
        super(nomes, custoMana);
        this.dano = dano;
        this.resist= resist;
    }
}
