package de.fronk.game;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {
    public Window (int width, int heigth, String titel, Game game){
        JFrame frame = new JFrame(titel);
        frame.setPreferredSize(new Dimension(width, heigth));
        frame.setMaximumSize(new Dimension(width, heigth));
        frame.setMinimumSize(new Dimension(width, heigth));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();

    }
}
