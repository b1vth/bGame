package me.b1vth420.bGame;

import me.b1vth420.bGame.data.Config;
import me.b1vth420.bGame.graphics.FontLoader;
import me.b1vth420.bGame.states.GameStatesManager;
import me.b1vth420.bGame.utils.KeyHandler;
import me.b1vth420.bGame.utils.MouseHandler;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements Runnable{

    private Thread thread;
    private boolean running = false;

    private BufferedImage img;
    private Graphics2D gr;
    private static FontLoader fl;

    private MouseHandler mouse;
    private KeyHandler key;

    private GameStatesManager gsm;

    public GamePanel(int width, int height){
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        requestFocus();
    }

    public void addNotify(){
        super.addNotify();
        if (thread == null) {
            thread = new Thread(this, "GameThread");
            thread.start();
        }
    }

    public void init(){
        running = true;
        Toolkit.getDefaultToolkit();

        img = new BufferedImage(Config.WIDTH, Config.HEIGHT, BufferedImage.TYPE_INT_ARGB);
        gr = (Graphics2D) img.getGraphics();
        fl = new FontLoader("resources/font/ARCADECLASSIC.TTF");

        mouse = new MouseHandler(this);
        key = new KeyHandler(this);
        gsm = new GameStatesManager();

    }

    @Override
    public void run() {
        init();

        final double GAME_FPS = 60.0;
        final double TBU = 1000000000/GAME_FPS; //Czas przed update

        final int MUBR = 5; //Update przed render

        double lastUpdateTime = System.nanoTime();
        double lastRenderTime;

        final double TARGET_FPS = 60.0;
        final double TTBR = 1000000000/TARGET_FPS; //Czas przed render'em

        int frameCount = 0;
        int lastSecondTime = (int) (lastUpdateTime/1000000000);
        int oldFrameCount = 0;

        while(running){
            double now = System.nanoTime();
            int updateCount = 0;
            while(((now-lastUpdateTime) > TBU) && (updateCount < MUBR)) {
                update();
                input(mouse, key);
                lastUpdateTime += TBU;
                updateCount++;
            }

            if(now - lastUpdateTime > TBU) {
                lastUpdateTime = now -TBU;
            }

            input(mouse, key);
            render();
            draw();

            lastRenderTime = now;
            frameCount++;

            int thisSecond = (int) (lastUpdateTime/1000000000);
            if(thisSecond > lastSecondTime){
                if(frameCount != oldFrameCount){
                    System.out.println("FPS: " + frameCount);
                    oldFrameCount = frameCount;
                }
                frameCount =0;
                lastSecondTime = thisSecond;
            }

            while(now - lastRenderTime < TTBR && now -lastUpdateTime < TBU){
                Thread.yield();

                try {
                    Thread.sleep(1);
                } catch(Exception e){
                    System.out.println("Error: Yealding thread!" + e);
                }
                now = System.nanoTime();
            }
        }
    }

    public void update(){
        gsm.update();
    }

    public void input(MouseHandler mouse, KeyHandler key){
        gsm.input(mouse, key);
   }

    public void render(){
        if(gr != null){
            gr.setColor(new Color(66 ,134, 244));
            gr.fillRect(0, 0, Config.WIDTH, Config.HEIGHT);
            gsm.render(gr);
        }
    }

    public void draw(){
        Graphics g2 = (Graphics) this.getGraphics();
        g2.drawImage(img, 0, 0, Config.WIDTH, Config.HEIGHT, null);
        g2.dispose();
    }

    public static FontLoader getFl(){
        return fl;
    }
}
