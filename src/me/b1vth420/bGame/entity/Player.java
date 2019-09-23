package me.b1vth420.bGame.entity;

import me.b1vth420.bGame.graphics.Animation;
import me.b1vth420.bGame.graphics.Sprite;
import me.b1vth420.bGame.utils.KeyHandler;
import me.b1vth420.bGame.utils.MouseHandler;
import me.b1vth420.bGame.utils.Vector2f;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity{

    private BufferedImage[] standing = {Sprite.getSprite(0, 0), Sprite.getSprite(1, 0), Sprite.getSprite(2, 0), Sprite.getSprite(3, 0), Sprite.getSprite(4, 0), Sprite.getSprite(5, 0), Sprite.getSprite(6, 0), Sprite.getSprite(7, 0), Sprite.getSprite(8, 0), Sprite.getSprite(9, 0),Sprite.getSprite(10, 0), Sprite.getSprite(11, 0), Sprite.getSprite(12, 0), Sprite.getSprite(13, 0), Sprite.getSprite(14, 0)};
    private BufferedImage[] rightRunning = {Sprite.getSprite(0, 1), Sprite.getSprite(1, 1), Sprite.getSprite(2, 1), Sprite.getSprite(3, 1), Sprite.getSprite(4, 1), Sprite.getSprite(5, 1), Sprite.getSprite(6, 1)};
    private BufferedImage[] leftRunning = {Sprite.getSprite(6, 2), Sprite.getSprite(5, 2), Sprite.getSprite(4, 2), Sprite.getSprite(3, 2), Sprite.getSprite(2, 2), Sprite.getSprite(1, 2), Sprite.getSprite(0, 2)};

    private Animation standingAnim = new Animation(standing, 5);
    private Animation rightRunningAnim = new Animation(rightRunning, 5);
    private Animation leftRunningAnim = new Animation(leftRunning, 5);

    private Animation animation;

    public Player(Sprite sprite, Vector2f orgin, int size) {
        super(sprite, orgin, size);
        pos.x += dx;
        pos.y += dy;
    }

    public void move(){
        if(up){
            dy-= acceleration;
            if(dy < -maxSpeed) dy = -maxSpeed;
        } else {
            if(dy < 0) {
                dy += deacc;
                if (dy > 0) dy = 0;
            }
        }
        if(down){
            dy+= acceleration;
            if(dy < maxSpeed) dy = maxSpeed;
        } else {
            if(dy > 0) {
                dy  -= deacc;
                if (dy < 0) dy = 0;
            }
        }
        if(left){
            dx-= acceleration;
            if(dx < -maxSpeed) dx = -maxSpeed;
        } else {
            if(dx < 0) {
                dx += deacc;
                if (dx > 0) dx = 0;
            }
        }
        if(right){
            dx+= acceleration;
            if(dx > -maxSpeed) dx = maxSpeed;
        } else {
            if(dx > 0) {
                dx -= deacc;
                if (dx < 0) dx = 0;
            }
        }
    }

    public void update(){
        move();
        animation.update();
    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(animation.getSprite(), (int) (pos.x), (int) (pos.y), size, size, null);
    }

    public void input(MouseHandler mouse, KeyHandler key){
        if(!isMoving()) {
            animation = standingAnim;
            animation.start();
        }

        if(key.up.down){
            up = true;
        } else up = false;
        if(key.down.down){
            down = true;
        } else down = false;
        if(key.left.down){
            left = true;
            animation = leftRunningAnim;
            animation.start();
        } else left = false;
        if(key.right.down){
            right = true;
            animation = rightRunningAnim;
            animation.start();
        } else right = false;
        if(key.attack.down){
            attack = true;
        } else attack =false;
    }

    public boolean isMoving(){
        return up && down && left && right;
    }
}
