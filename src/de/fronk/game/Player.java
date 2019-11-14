package de.fronk.game;

import java.awt.*;

public class Player extends GameObject {
    public Player(int x, int y, ID id) {
        super(x, y, id);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        x = Game.clamp(x, 0, Game.WIDTH - 48);
        y = Game.clamp(y, 0, Game.HEIGHT - 70);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.BLUE);
        graphics.fillRect(x, y, 32, 32);
    }
}
