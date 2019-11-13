package de.fronk.game;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {
    public Player(int x, int y, ID id) {
        super(x, y, id);
        Random random = new Random();
        velX = random.nextInt(10) - 4;
        velY = random.nextInt(10) - 4;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.BLUE);
        graphics.fillRect(x, y, 32, 32);
    }
}
