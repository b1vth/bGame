package me.b1vth420.bGame.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;


public class Sprite {

    private static BufferedImage SPRITESHEET;
    private static final int TILE_SIZE = 64;

    public Sprite(String file){
        SPRITESHEET = loadSprite(file);
    }

    private BufferedImage loadSprite(String file) {
        BufferedImage sprite = null;
        try {
            sprite = ImageIO.read(new FileInputStream(file));
        } catch (Exception e) {
            System.out.println(e);
        }
        return sprite;
    }

    public static BufferedImage getSprite(int xGrid, int yGrid) {
        return SPRITESHEET.getSubimage(xGrid*TILE_SIZE, yGrid*TILE_SIZE, TILE_SIZE, TILE_SIZE);
    }
}
