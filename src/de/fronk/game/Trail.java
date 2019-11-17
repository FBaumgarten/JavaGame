package de.fronk.game;

import java.awt.*;

public class Trail extends GameObject {

    private float alpha = 1;
    private float life;
    private Handler handler;
    private Color color;
    private int width, height;

    public Trail(int x, int y, ID id, Color color, int width, int height, float life, Handler handler) {
        super(x, y, id);
        this.color = color;
        this.height = height;
        this.width = width;
        this.life = life;
        this.handler = handler;
    }

    @Override
    public void tick() {
        if (alpha > life) {
            alpha -= life;
        } else handler.remove(this);
    }

    @Override
    public void render(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setComposite(fade(alpha));
        graphics.setColor(color);
        graphics.fillRect(x, y, width, height);
        graphics2D.setComposite(fade(1));
    }

    private AlphaComposite fade(float alpha) {
        int type = AlphaComposite.SRC_OVER;
        return AlphaComposite.getInstance(type, alpha);
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
