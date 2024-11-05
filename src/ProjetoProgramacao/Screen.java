package src.ProjetoProgramacao;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Screen extends JFrame {

    private JogoDeCartas jogo; // Instância de Game

    public Screen(JogoDeCartas jogo) {
        this.jogo = jogo;
        setTitle("Crônicas de Arcana");
        setVisible(true);
        setSize(900,900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLocationRelativeTo(null);
        setLayout(null);
        JButton jButton = new JButton("Iniciar");
        jButton.setBounds(325, 400, 250, 70); // Centralizando o botão
        jButton.setFont(new Font("Arial", Font.PLAIN, 30));
        jButton.setBackground(Color.LIGHT_GRAY); // Cor de fundo
        jButton.setForeground(Color.BLACK); // Cor do texto
        
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chama o método iniciarJogo da instância de Game
                jogo.iniciar();
            }
        });

        add(jButton);
        setVisible(true); // Tornar visível após adicionar componentes
    }
    public static void main(String[] args) {
        // Cria uma instância de Game
        JogoDeCartas jogo = new JogoDeCartas();
        
        // Passa essa instância para a classe Screen
        SwingUtilities.invokeLater(() -> new Screen(jogo)); // Para thread-safety
    }

}


