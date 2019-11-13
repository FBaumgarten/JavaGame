package de.fronk.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent keyEvent) {
        int key = keyEvent.getKeyCode();
        for (GameObject object : handler.objects) {
            if (object.getId() == ID.Player) {
                if (key == KeyEvent.VK_O) object.setVelY(-5);
                if (key == KeyEvent.VK_A) object.setVelX(-5);
                if (key == KeyEvent.VK_E) object.setVelY(5);
                if (key == KeyEvent.VK_I) object.setVelX(5);
            }
        }
    }

    public void keyReleased(KeyEvent keyEvent) {
        int key = keyEvent.getKeyCode();
        for (GameObject object : handler.objects) {
            if (object.getId() == ID.Player) {
                if (key == KeyEvent.VK_O) object.setVelY(0);
                if (key == KeyEvent.VK_A) object.setVelX(0);
                if (key == KeyEvent.VK_E) object.setVelY(0);
                if (key == KeyEvent.VK_I) object.setVelX(0);
            }
        }
    }
}
