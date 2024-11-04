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

    public getEfeito(){
        return this.efeito;
    }

    public void aplicarEfeito(){
        if (getEfeito().equals(/* nome efeito base 1 */)){
            /*aplica efeito 1 */
        } else if (getEfeito().equals(/*nome efeito base 2 */)){
            /*aplica efeito 2 */
        } else if (getEfeito().equals(/*nome efeito base 3 */)){
             /*aplica efeito 2 */
        }

        }
}    






