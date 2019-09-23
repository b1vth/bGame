package me.b1vth420.bGame.states;

import me.b1vth420.bGame.utils.KeyHandler;
import me.b1vth420.bGame.utils.MouseHandler;

import java.awt.*;

public abstract class GameState {

    private GameStatesManager gsm;

    public GameState(GameStatesManager gsm){
        this.gsm = gsm;
    }

    public abstract void update();

    public abstract void render(Graphics2D g);

    public abstract void input(MouseHandler mouse, KeyHandler key);

}
