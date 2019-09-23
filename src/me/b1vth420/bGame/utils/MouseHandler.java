package me.b1vth420.bGame.utils;

import me.b1vth420.bGame.GamePanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseListener, MouseMotionListener {

    private static int mouseX = -1;
    private static int mouseY = -1;
    private static int mouseB = -1;

    public MouseHandler(GamePanel game){
        game.addMouseListener(this);
        game.addMouseMotionListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseB = e.getButton();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseB = -1;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    public static int getMouseX() {
        return mouseX;
    }

    public static void setMouseX(int mouseX) {
        MouseHandler.mouseX = mouseX;
    }

    public static int getMouseY() {
        return mouseY;
    }

    public static void setMouseY(int mouseY) {
        MouseHandler.mouseY = mouseY;
    }

    public static int getMouseB() {
        return mouseB;
    }

    public static void setMouseB(int mouseB) {
        MouseHandler.mouseB = mouseB;
    }
}
