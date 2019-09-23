package me.b1vth420.bGame.graphics;

import me.b1vth420.bGame.GameLauncher;
import me.b1vth420.bGame.utils.Vector2f;

import java.awt.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.File;
import java.nio.Buffer;

public class FontLoader {

    private static Font FONTSHEET;

    public FontLoader(String file) {
        System.out.println("Loading " + file + " font!");
        FONTSHEET = loadFont(file);
    }

    private Font loadFont(String file) {
        Font f = null;
        try {
            InputStream stream = new BufferedInputStream(new FileInputStream(file));
            f = Font.createFont(Font.TRUETYPE_FONT, stream);
            f = f.deriveFont(24F);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(f);
        } catch (Exception e) {
            System.out.println(e);
        }
        return f;
    }

    public static void drawArray(Graphics2D g, String word, Vector2f pos, int fontSize) {
        float x = pos.x;
        float y = pos.y;
        if (FONTSHEET != null) {
            g.setFont(new java.awt.Font(FONTSHEET.getFontName(), Font.PLAIN, fontSize));
            g.setColor(Color.WHITE);
            g.drawString(word, x, y);
        }
    }
}
