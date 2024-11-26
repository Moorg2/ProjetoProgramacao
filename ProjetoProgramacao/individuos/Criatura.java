package individuos;

import deck.Carta;
import ProjetoProgramacao.JogoDeCartas;

import java.util.Scanner;

public class Criatura extends Carta {
    private int dano;
    private int resist;
    private String habilidade;

    public Criatura(String nome, int custoMana, int dano, int resist, String habilidade) {
        super(nome, custoMana);
        this.dano = dano;
        this.resist = resist;
        this.habilidade = habilidade;
    }

    public int getDano() {
        return this.dano;
    }
    public int getResist() {
        return this.resist;
    }
    public void setResist(int resist) {
        this.resist = resist;
    }

    public void executarHabilidade(int indice) {
        switch (indice) {
            case 0 -> {
                this.dano++;
                System.out.println("Queimadura! O dano de " + getNome() + " aumentou para " + this.dano);
            }
            case 1 -> {
                this.resist--;
                System.out.println("Medo! A resistência de " + getNome() + " diminuiu para " + this.resist);
            }
            case 2 -> {
                System.out.println("Final dance!");
                if (this.resist <= 5) {
                    this.dano *= 2; // Aumenta o dano em 20%
                    System.out.println("O dano de " + getNome() + " aumentou para " + this.dano);
                }
            }
            default -> System.out.println("Habilidade inválida.");
        }
    }

    public void aplicarHabilidade() {
        if (habilidade == null) {
            System.out.println(getNome() + " não possui habilidades.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println(getNome() + " possui a habilidade \"" + habilidade + "\". Deseja ativá-la? (s/n)");
        String resposta = scanner.nextLine().trim().toLowerCase();

        if (resposta.equals("s")) {
            switch (habilidade) {
                case "Queimadura" -> executarHabilidade(0);
                case "Medo" -> executarHabilidade(1);
                case "Final Dance" -> executarHabilidade(2);
                default -> System.out.println("Habilidade inválida.");
            }
        } else if (resposta.equals("n")) {
            System.out.println("Habilidade não foi ativada.");
        } else {
            System.out.println("Entrada inválida. Nenhuma habilidade foi ativada.");
        }
    }

    public void atacar(Object alvo) {
        if (alvo instanceof Criatura outraCriatura) {
            System.out.println(getNome() + " está interagindo com a criatura " + outraCriatura.getNome());
            outraCriatura.setResist(outraCriatura.getResist() - this.dano);
            setResist(this.resist - outraCriatura.getDano());
            if (outraCriatura.getResist() <= 0) {
                System.out.println(outraCriatura.getNome() + " foi destruída!");
                JogoDeCartas.board.remove(outraCriatura); // Remove do tabuleiro
                Jogador.cemiterio.add(outraCriatura); // Adiciona ao cemitério
            }
            if (getResist() <= 0) {
                System.out.println(getNome() + " foi destruída!");
                JogoDeCartas.board.remove(this); // Remove do tabuleiro
                Jogador.cemiterio.add(this); // Adiciona ao cemitério
            }
        } else if (alvo instanceof Jogador jogador) {
            System.out.println(getNome() + " está atacando o jogador " + jogador.getNome());
            jogador.danoVida(this.dano);
        } else {
            System.out.println("Alvo inválido para interação.");
        }
    }
}