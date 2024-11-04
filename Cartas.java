package ProjetoProgramacao;

abstract class Cartas extends Exception {

    public String nome;
    public int custoMana;

    public Cartas(String nome, int custoMana) {
        this.nome = nome;
        this.custoMana = custoMana;
    }
    
    public void jogarCarta(){
        Carta carta = mao.remove(0);
        jogada();
        board.add(carta);
        }

   public void jogada() {
	   if(getMana()< this.custoMana) {
		   throw new ErroManaInsuficiente("Você não tem mana suficiente para jogar a carta"+ getNome())
	   } else{
		   return 0;
		    }
   }
    
   public void setNome(String nome) {
       this.nome = nome;
   }
   
   public String getNome() {
       return this.nome;
   }
    
}