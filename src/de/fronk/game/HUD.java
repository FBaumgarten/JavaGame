package de.fronk.game;

import java.awt.*;

public class HUD {
    public static int health = 100;

    public void tick() {

        health = Game.clamp(health, 0, 100);
    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.GRAY);
        graphics.fillRect(15, 15, 200, 32);
        graphics.setColor(Color.GREEN);
        graphics.fillRect(15, 15, health * 2, 32);
        graphics.setColor(Color.WHITE);
        graphics.drawRect(15, 15, 200, 32);
    }
}
