package de.fronk.game;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 800, HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    private boolean runnig = false;
    private Handler handler;
    private HUD hud;

    public Game() {
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        new Window(WIDTH, HEIGHT, "Java Game Project", this);
        hud = new HUD();
        handler.add(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player));
        handler.add(new BasicEnemy(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.BasicEnemy));
    }

    public static void main(String[] args) {
        new Game();
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        runnig = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            runnig = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int clamp(int value, int min, int max) {
        if (value <= min) return min;
        else if (value >= max) return max;
        else return value;
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while (runnig) {
            this.requestFocus();
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (runnig)
                render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                //iSystem.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void render() {
        BufferStrategy bufferStrategy = this.getBufferStrategy();
        if (bufferStrategy == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics graphics = bufferStrategy.getDrawGraphics();
        //background
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, WIDTH, HEIGHT);
        //renders all game objects
        handler.render(graphics);
        //render HUD
        hud.render(graphics);

        graphics.dispose();
        bufferStrategy.show();
    }

    private void tick() {
        handler.tick();
        hud.tick();
    }
}
