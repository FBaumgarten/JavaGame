package de.fronk.game;

import java.awt.*;

public class BasicEnemy extends GameObject {

    public BasicEnemy(int x, int y, ID id) {
        super(x, y, id);
        velX = 1;
        velY = 5;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        if (x <= 0 || x >= Game.WIDTH - 32) velX *= -1;
        if (y <= 0 || y >= Game.HEIGHT - 48) velY *= -1;

    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.fillRect(x, y, 16, 16);
    }
}
