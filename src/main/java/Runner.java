import characters.Player;
import handlers.GamePanel;

import javax.swing.*;
import java.awt.*;

public class Runner {

    static GamePanel gamePanel;



    public static void main(String[] args) {
        JFrame window = new JFrame();
//        panel = new JPanel(new GridLayout(2, 2));
//        button1 = new JButton("Button1");

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("NotPokemon");

        gamePanel = new GamePanel();
        window.add(gamePanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);


        gamePanel.setupGame();
        gamePanel.startGameThread();
    }
}


