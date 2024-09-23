package ProjetoProgramacao;

public class Encantamento extends Cartas {

    public String encantar;

    public Encantamento( String nomes, int custoMana, String encantar){
        super(nomes, custoMana);
        this.encantar = encantar;
    }
    
    @Override
    public void usar(Jogador jogadorAtivo) {
        // Implementação para colocar o encantamento no campo
        System.out.println(jogadorAtivo.nome + " jogou o encantamento: " + nome);
    }
}
