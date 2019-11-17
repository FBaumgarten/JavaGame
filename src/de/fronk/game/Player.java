package de.fronk.game;

import java.awt.*;

public class Player extends GameObject {

    Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        x = Game.clamp(x, 0, Game.WIDTH - 48);
        y = Game.clamp(y, 0, Game.HEIGHT - 70);

        collision();
    }

    private void collision() {
        for (GameObject object : handler.objects) {
            //überprüft nur ob BasicEnemy mit Player überschneidet, später ändern auf != ID.Player ?
            if (object.getId() == ID.BasicEnemy) {
                if (getBounds().intersects(object.getBounds())) {
                    HUD.health -= 2;
                }
            }
        }
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.BLUE);
        graphics.fillRect(x, y, 32, 32);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }
}
