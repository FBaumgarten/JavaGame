package de.fronk.game;

import java.awt.*;
import java.util.LinkedList;

public class Handler {
    LinkedList<GameObject> objects = new LinkedList<>();

    public void tick() {
        for (GameObject object : objects) {
            object.tick();
        }
    }

    public void render(Graphics graphics) {
        for (GameObject object : objects) {
            object.render(graphics);
        }
    }

    public void add(GameObject gameObject) {
        objects.add(gameObject);
    }

    public void remove(GameObject gameObject) {
        objects.remove(gameObject);
    }
}
