package ProjetoProgramacao;

abstract class Criatura extends Cartas {
	public int 
    public int dano;
    public int resist;
    public String habilidadeEspecial;

    public  Criatura(String nomes, int custoMana, int dano, int resist, String habilidadeEspecial){
        super(nomes, custoMana);
        this.dano = dano;
        this.resist= resist;
    }
    public int getDanoCriatura() {
        return this.dano;
    }

    public int ataque(int danoRecebido, int resist) {
        // Se o dano recebido for maior que a resistência, a criatura é destruída
        if (danoRecebidoCriatura() >= resist) {
            return 0; // Criatura destruída
        } else {
            return resist - danoRecebido; // Vida restante
        }
    }
    
    public int danoRecebidoCriatura(int dano, int resist) { //Criatura -> Criatura
    	return danoRecebidoCriatura = resist - dano
    }
    

    public void aplicarHabilidade(){
        if (getHabilidade().equals(/* nome Habilidade base 1 */)){
            /*aplica Habilidade 1 */
        } else if (getHabilidade().equals(/*nome Habilidade base 2 */)){
            /*aplica Habilidade 2 */
        } else if (getHabilidade().equals(/*nome Habilidade base 3 */)){
             /*aplica Habilidade 2 */
        }

        }
   
    @Override
    public void usar(Jogador jogadorAtivo) {
        // Implementação para colocar a criatura no campo
        System.out.println(jogadorAtivo.nome + " jogou a criatura: " + nome);
    }
}
