package ProjetoProgramacao;

abstract class Criaturas extends Cartas {

    public int dano;
    public int resist;
    public String habilidadeEspecial;

    public  Criaturas(String nomes, int custoMana, int dano, int resist, String habilidadeEspecial){
        super(nomes, custoMana);
        this.dano = dano;
        this.resist= resist;
    }
    public int ataque(int danoRecebido) {
        // Se o dano recebido for maior que a resistência, a criatura é destruída
        if (danoRecebido >= resist) {
            return 0; // Criatura destruída
        } else {
            return resist - danoRecebido; // Vida restante
        }
    }

    // Getters para dano e resistência, caso você precise
    public int getDano() {
        return dano;
    }
    public void setResist(int vida){
        this.resist = resist;
    }

    public int getResist() {
        return this.resist;
    }

    public String GetHabilidade(){
        return this.habilidadeEspecial;
    }

    public void aplicarHabilidade(){
        if (GetHabilidade().equals(/* nome Habilidade base 1 */)){
            /*aplica Habilidade 1 */
        } else if (GetHabilidade().equals(/*nome Habilidade base 2 */)){
            /*aplica Habilidade 2 */
        } else if (GetHabilidade().equals(/*nome Habilidade base 3 */)){
             /*aplica Habilidade 2 */
        }

        }
   
    @Override
    public void usar(Jogador jogadorAtivo) {
        // Implementação para colocar a criatura no campo
        System.out.println(jogadorAtivo.nome + " jogou a criatura: " + nome);
    }
}
