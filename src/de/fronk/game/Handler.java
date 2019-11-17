package de.fronk.game;

import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Handler {
    //CopyOnWriteArrayList wegen Treads? gibt Runtime Error beim foreach Loop sonst, evtl auf for loop ändern?
    CopyOnWriteArrayList<GameObject> objects = new CopyOnWriteArrayList<>();

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
