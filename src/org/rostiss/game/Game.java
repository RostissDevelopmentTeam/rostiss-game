package org.rostiss.game;

import org.rostiss.game.entities.mobs.Player;
import org.rostiss.game.graphics.Renderer;
import org.rostiss.game.input.Keyboard;
import org.rostiss.game.levels.Level;
import org.rostiss.game.levels.RandomLevel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import static java.lang.System.arraycopy;

/**
 * File: Game.java
 * Created by Atlas IND on 9/25/2015 at 11:09 PM.
 * [2014] - [2015] Rostiss Development
 * All rights reserved.
 * NOTICE:  All information contained herein is, and remains
 * the property of Rostiss Development and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to Rostiss Development
 * and its suppliers and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Rostiss Development.
 */

public class Game extends Canvas implements Runnable {

	public static final String TITLE = "Rostiss' Development Playground - ";
	public static int width = 300, height = width / 16 * 9, scale = 3;

	private Renderer renderer;
	private JFrame frame;
	private Thread thread;
	private BufferedImage image;
	private Keyboard keyboard;
	private Level level;
	private Player player;
	private int[] pixels;
	private boolean running = false;

	public Game() {
		setPreferredSize(new Dimension(width * scale, height * scale));
		renderer = new Renderer(width, height);
		frame = new JFrame();
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
		keyboard = new Keyboard();
		addKeyListener(keyboard);
		level = new RandomLevel(64, 64);
		player = new Player(0, 0, keyboard);
	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Game");
		thread.start();
	}

	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		final double frameTime = 1000000000.0 / 60.0;
		int frames = 0, updates = 0;
		double delta = 0.0;
		long previousTime = System.nanoTime(), currentTime = 0L, timer = System.currentTimeMillis();
		while (running) {
			currentTime = System.nanoTime();
			delta += (currentTime - previousTime) / frameTime;
			requestFocus();
			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			if (System.currentTimeMillis() - timer > 1000L) {
				timer += 1000L;
				System.out.println(updates + "ups, " + frames + "fps");
				frame.setTitle(TITLE + updates + "ups, " + frames + "fps");
				updates = frames = 0;
			}
			previousTime = currentTime;
		}
	}

	private void update() {
		keyboard.update();
		player.update();
	}

	private void render() {
		BufferStrategy strategy = getBufferStrategy();
		if (strategy == null) {
			createBufferStrategy(3);
			return;
		}
		renderer.clear();
		level.render(player.x - width / 2, player.y - height / 2, renderer);
		player.render(renderer);
		arraycopy(renderer.pixels, 0, pixels, 0, renderer.pixels.length);
		Graphics g = strategy.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		strategy.show();
	}

	public static void main(String... args) {
		Game game = new Game();
		game.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		game.frame.setLocation(new Point((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - Game.width * scale / 2), (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - Game.height * scale / 2)));
		game.frame.setTitle(TITLE);
		game.frame.setResizable(false);
		game.frame.setVisible(true);
		game.frame.add(game);
		game.frame.pack();
		game.start();
	}
}