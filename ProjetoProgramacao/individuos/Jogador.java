package individuos;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import deck.Carta;
import ProjetoProgramacao.JogoDeCartas;
import erro.ManaInsuficienteException;
import modificadores.Encantamento;
import modificadores.Feitico;

public class Jogador {
    public static Jogador jogador1;
    public static Jogador jogador2;
  
    private String nome;
    private int vida;
    private static int mana;
    public ArrayList<Carta> deck;
    public ArrayList<Carta> mao;
    public static ArrayList<Carta> cemiterio;
    private static Jogador jogadorAtual;

    public void setVida(int vida) {
        this.vida = vida;
    }
    public int getVida() {return vida;}

    public Jogador(String nome, ArrayList<Carta> deckInicial) {
        this.nome = nome;
        this.vida = 200;
        mana = 0;
        this.deck = new ArrayList<>(deckInicial);
        this.mao = new ArrayList<>();
        this.cemiterio = new ArrayList<>();
        
    }
    public static void inicializarJogadores(ArrayList<Carta> deck1, ArrayList<Carta> deck2) {
        jogador1 = new Jogador("Jogador 1", deck1) {};
        jogador2 = new Jogador("Jogador 2", deck2) {};
    }

    public static int getManaDisponivel() {
        return mana;
    }

    public void danoVida(int dano) {
        this.vida = Math.max(0, this.vida - dano);

        if (this.vida == 0) {
            System.out.println(nome + " foi derrotado!");
        } else {
            System.out.println(nome + " recebeu " + dano + " de dano. Vida restante: " + this.vida);
        }
    }

    public String getNome() {
        return nome;
    }

    public void statusInicial() {
        comprarMaoInicial();
        jogador1.ganharMana();
        jogador2.ganharMana();
    }

    public void ganharMana() {
        if (JogoDeCartas.turno == 0) {
            mana = 3;
        } else {
            mana = Math.min(mana + 1, 10);
        }
    }

    public void comprarCarta() {
        if (!deck.isEmpty()) {
            Carta carta = deck.remove(0);
            mao.add(carta);
        } else {
            setVida(0); // Jogador perde se o deck acabar
        }
    }

    public static Jogador definirJogadorInicial() {
        Random random = new Random();
        jogadorAtual = random.nextBoolean() ? jogador1 : jogador2;
        System.out.println("Jogador inicial: " + jogadorAtual.getNome());
        return jogadorAtual;
    }

    public void mudarJogador() {
        jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
        System.out.println("Agora é a vez de " + jogadorAtual.getNome());
    }

    public void usarCarta() {
        if (mao.isEmpty()) {
            System.out.println(getNome() + " não tem cartas na mão.");
            return;
        }

        System.out.println("\nCartas na mão de " + getNome() + ":");
        for (int i = 0; i < mao.size(); i++) {
            Carta carta = mao.get(i);
            System.out.println(i + ": " + carta.getNome() + " (Custo de mana: " + carta.getCustoMana() + ")");
        }
        System.out.println("Escolha o índice da carta que deseja jogar:");
        int indiceEscolhido = Jogador.lerEntradaDoJogador(mao.size()); // Método para ler a escolha do jogador

        Carta cartaEscolhida = mao.get(indiceEscolhido);
        try {
            cartaEscolhida.jogar(); // Verifica mana suficiente
        } catch (ManaInsuficienteException e) {
            System.out.println(e.getMessage());
            return;
        }
        switch (cartaEscolhida) {
            case Criatura _ -> {
                mao.remove(cartaEscolhida);
                JogoDeCartas.board.add(cartaEscolhida);
                System.out.println(getNome() + " colocou a criatura " + cartaEscolhida.getNome() + " no campo de batalha.");
            }
            case Feitico feitico -> {
                mao.remove(cartaEscolhida);
                feitico.ativarFeitico(this);
                System.out.println(getNome() + " ativou o feitiço " + cartaEscolhida.getNome() + ".");
            }
            case Encantamento encantamento -> {
                mao.remove(cartaEscolhida);
                encantamento.ativarEncantamento(this);
                System.out.println(getNome() + " ativou o encantamento " + cartaEscolhida.getNome() + ".");
            }
            default -> System.out.println("O tipo da carta " + cartaEscolhida.getNome() + " não é reconhecido.");
        }
    }

    public static int lerEntradaDoJogador(int limite) {
        Scanner scanner = new Scanner(System.in);
        int escolha;

        while (true) {
            try {
                System.out.print("Escolha uma carta (0 a " + (limite - 1) + "): ");
                escolha = Integer.parseInt(scanner.nextLine());
                if (escolha >= 0 && escolha < limite) {
                    return escolha;
                }
                System.out.println("Escolha inválida. Tente novamente.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número.");
            }
        }
    }

    public static Criatura selecionarCriatura(ArrayList<Carta> tabuleiro) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecione uma criatura do tabuleiro:");

        for (int i = 0; i < tabuleiro.size(); i++) {
            Carta carta = tabuleiro.get(i);
            if (carta instanceof Criatura criatura) {
                System.out.println(i + " - " + criatura.getNome() + " (Dano: " + criatura.getDano() + ", Resistência: " + criatura.getResist() + ")");
            }
        }

        int escolha = scanner.nextInt();
        if (escolha >= 0 && escolha < tabuleiro.size() && tabuleiro.get(escolha) instanceof Criatura criatura) {
            return criatura;
        } else {
            System.out.println("Escolha inválida.");
            return null;
        }
    }

    public Jogador oponente() {
        if (this.equals(Jogador.jogador1)) {
            return Jogador.jogador2; // Retorna o jogador 2 como oponente
        } else {
            return Jogador.jogador1; // Retorna o jogador 1 como oponente
        }
    }

    public static Object selecionarAlvo(ArrayList<Carta> tabuleiro, Jogador oponente) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Selecione um alvo:");
        int index = 0;

        // Exibir criaturas no tabuleiro como possíveis alvos
        for (Carta carta : tabuleiro) {
            if (carta instanceof Criatura criatura) {
                System.out.println(index + " - Criatura: " + criatura.getNome() +
                        " (Dano: " + criatura.getDano() + ", Resistência: " + criatura.getResist() + ")");
                index++;
            }
        }
        System.out.println(index + " - Jogador: " + oponente.getNome() + " (Vida: " + oponente.getVida() + ")");
        int escolha = scanner.nextInt();
        if (escolha >= 0 && escolha < tabuleiro.size() && tabuleiro.get(escolha) instanceof Criatura criatura) {
            return criatura; // Retorna a criatura escolhida
        } else if (escolha == index) {
            return oponente; // Retorna o jogador adversário
        } else {
            System.out.println("Escolha inválida.");
            return null;
        }
    }

    public void faseCombate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Deseja atacar? (s/n)");
        String resposta = scanner.nextLine().trim().toLowerCase();

        if (resposta.equals("s")) {
            // Escolher a criatura atacante
            Criatura atacante = selecionarCriatura(JogoDeCartas.board);
            if (atacante != null) {
                // Escolher o alvo (outra criatura ou jogador)
                System.out.println("Escolha o alvo (outra criatura ou jogador adversário):");
                Object alvo = selecionarAlvo(JogoDeCartas.board, jogadorAtual.oponente());
                if (alvo != null) {
                    atacante.atacar(alvo);
                }
            }
        } else if (resposta.equals("n")) {
            System.out.println("Nenhum ataque foi realizado.");
        } else {
            System.out.println("Entrada inválida. Nenhum ataque foi realizado.");
        }
    }

    public void escolhaHabilidade() {
        // Selecionar criatura com habilidades
        Criatura criaturaSelecionada = selecionarCriatura(JogoDeCartas.board);
        if (criaturaSelecionada != null) {
            criaturaSelecionada.aplicarHabilidade(); // Delegar para a criatura
        } else {
            System.out.println("Nenhuma criatura selecionada para ativar habilidades.");
        }
    }
    public void comprarMaoInicial() {
        for (int i = 0; i < 5; i++) {
            jogador1.comprarCarta();
            jogador2.comprarCarta();
        }
    }
}
