package ProjetoProgramacao;

abstract class Cartas extends Exception {

    public String nome;
    public int custoMana;

    public Cartas(String nomes, int custoMana) {
        this.nomes = nomes;
        this.custoMana = custoMana;
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
