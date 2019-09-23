package me.b1vth420.bGame.states;

import me.b1vth420.bGame.GamePanel;
import me.b1vth420.bGame.entity.Player;
import me.b1vth420.bGame.graphics.FontLoader;
import me.b1vth420.bGame.graphics.Sprite;
import me.b1vth420.bGame.utils.KeyHandler;
import me.b1vth420.bGame.utils.MouseHandler;
import me.b1vth420.bGame.utils.Vector2f;

import java.awt.*;
import java.io.File;


public class PlayState extends GameState {

    private Player player;

    public PlayState(GameStatesManager gsm) {
        super(gsm);
        player = new Player(new Sprite("resources/entity/Knight/Knight.png"), new Vector2f(200, 200), 256);
    }

    @Override
    public void update() {
        player.update();
    }

    @Override
    public void render(Graphics2D g) {
        player.render(g);
    }

    @Override
    public void input(MouseHandler mouse, KeyHandler key) {
        //if(key.down.down) System.out.println("S is beeing pressed");
        player.input(mouse, key);
    }
}
