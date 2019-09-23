package me.b1vth420.bGame.entity;

import me.b1vth420.bGame.graphics.Animation;
import me.b1vth420.bGame.graphics.Sprite;
import me.b1vth420.bGame.utils.AABB;
import me.b1vth420.bGame.utils.KeyHandler;
import me.b1vth420.bGame.utils.MouseHandler;
import me.b1vth420.bGame.utils.Vector2f;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {

    private final int UP = 0;
    private final int DOWN = 1;
    private final int RIGHT =2;
    private final int LEFT =3;
    protected int currentAnimation;

    protected Animation ani;
    protected Sprite sprite;
    protected Vector2f pos;
    protected int size;

    protected boolean up;
    protected boolean down;
    protected boolean right;
    protected boolean left;
    protected boolean attack;
    protected int attackSpeed;
    protected int attackDuration;

    protected float dx;
    protected float dy;

    protected float maxSpeed;
    protected float acceleration;

    protected float deacc;

    protected AABB hitBounds;
    protected AABB bounds;

    public Entity(Sprite sprite, Vector2f orgin, int size){
        this.sprite = sprite;
        pos = orgin;
        this.size = size;

        bounds = new AABB(orgin, size, size);
        hitBounds = new AABB(new Vector2f(orgin.x + (size /2), orgin.y), size, size);
    }

    public void setSprite(Sprite s){this.sprite = s;}
    public void setSize(int i){this.size =i;}
    public void setMaxSpeed(float f){this.maxSpeed = f;}
    public void setAcc(float f){this.acceleration = f;}
    public void setDeacc(float f){this.deacc =f;}

    public AABB getBounds(){return this.bounds;}
    public int getSize(){
        return this.size;
    }
    public Animation getAnimation(){return ani;}

    public void setAnimation(int i, BufferedImage[] frames, int delay){
        currentAnimation = 1;
    }

    private void setHitBoxDirection(){
        if(up){
            hitBounds.setyOffset(-size/2);
            hitBounds.setxOffset(-size/2);
        }
        else if (down){
            hitBounds.setyOffset(size/2);
            hitBounds.setxOffset(-size/2);
        }
        else if (left){
            hitBounds.setxOffset(-size);
            hitBounds.setyOffset(0);
        }
        else if (right){
            hitBounds.setyOffset(0);
            hitBounds.setyOffset(0);
        }
    }

    public void update(){
        setHitBoxDirection();
        ani.update();
    }

    public abstract void render(Graphics2D g);
    public void input(KeyHandler key, MouseHandler mouse){
    }
}
