package ProjetoProgramacao;

abstract class Cartas extends Exception {

    public String nome;
    public int custoMana;

    public Cartas(String nome, int custoMana) {
        this.nome = nome;
        this.custoMana = custoMana;
    }
    
   
    
    public int getcustoMana(){
        return this.custoMana;
    }

   public void jogada() {
	   if(getcustoMana()< this.custoMana) {
		   try {
            throw new ManaInsuficienteException("Você não tem mana suficiente para jogar a carta"+ getNome());
        } catch (ManaInsuficienteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	   } 
   }
    
   public void setNome(String nome) {
       this.nome = nome;
   }
   
   public String getNome() {
       return this.nome;
   }
}
