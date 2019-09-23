package me.b1vth420.bGame.data;

import me.b1vth420.bGame.graphics.FontLoader;

import java.awt.*;

public class Config {

    public static int WIDTH = 800;
    public static int HEIGHT = 600;
    private static FontLoader fontLoader = new FontLoader("font/ARCADECLASSIC.TTF");;

    public static FontLoader getFontLoader() {
        return fontLoader;
    }

    public static void setFontLoader(FontLoader fontLoader) {
        Config.fontLoader = fontLoader;
    }
}