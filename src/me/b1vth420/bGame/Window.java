package me.b1vth420.bGame;

import me.b1vth420.bGame.data.Config;

import javax.swing.JFrame;

public class Window extends JFrame{

    public Window(){
        setTitle("bGame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new GamePanel(Config.WIDTH, Config.HEIGHT));
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}
