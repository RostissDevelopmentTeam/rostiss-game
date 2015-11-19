package org.rostiss.game.graphics;

/**
 * File: Sprite.java
 * Created by Atlas IND on 11/7/2015 at 11:42 PM.
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

public class Sprite {

	public static Sprite grass1 = new Sprite(0, 1, 16, SpriteSheet.spriteSheet);
	public static Sprite grass2 = new Sprite(0, 2, 16, SpriteSheet.spriteSheet);
	public static Sprite dirt1 = new Sprite(1, 1, 16, SpriteSheet.spriteSheet);
	public static Sprite dirt2 = new Sprite(2, 1, 16, SpriteSheet.spriteSheet);
	public static Sprite dirt3 = new Sprite(3, 1, 16, SpriteSheet.spriteSheet);
	public static Sprite debug = new Sprite(16, 0xabc);

	public static Sprite player_forward0 = new Sprite(1, 0, 16, 18, SpriteSheet.playerSheet);
	public static Sprite player_forward1 = new Sprite(0, 0, 16, 18, SpriteSheet.playerSheet);
	public static Sprite player_forward2 = new Sprite(2, 0, 16, 18, SpriteSheet.playerSheet);
	public static Sprite player_back0 = new Sprite(1, 2, 16, 18, SpriteSheet.playerSheet);
	public static Sprite player_back1 = new Sprite(0, 2, 16, 18, SpriteSheet.playerSheet);
	public static Sprite player_back2 = new Sprite(2, 2, 16, 18, SpriteSheet.playerSheet);
	public static Sprite player_left0 = new Sprite(1, 3, 16, 18, SpriteSheet.playerSheet);
	public static Sprite player_left1 = new Sprite(0, 3, 16, 18, SpriteSheet.playerSheet);
	public static Sprite player_left2 = new Sprite(2, 3, 16, 18, SpriteSheet.playerSheet);
	public static Sprite player_right0 = new Sprite(1, 1, 16, 18, SpriteSheet.playerSheet);
	public static Sprite player_right1 = new Sprite(0, 1, 16, 18, SpriteSheet.playerSheet);
	public static Sprite player_right2 = new Sprite(2, 1, 16, 18, SpriteSheet.playerSheet);

	public int[] pixels;
	public final int size, width, height;

	private int x, y;
	private SpriteSheet spriteSheet;

	public Sprite(int x, int y, int size, SpriteSheet spriteSheet) {
		this.x = x * size;
		this.y = y * size;
		this.size = size;
		this.width = this.height = size;
		this.spriteSheet = spriteSheet;
		this.pixels = new int[size * size];
		load();
	}

	public Sprite(int x, int y, int width, int height, SpriteSheet spriteSheet) {
		this.x = x * width;
		this.y = y * height;
		this.size = width;
		this.width = width;
		this.height = height;
		this.spriteSheet = spriteSheet;
		this.pixels = new int[width * height];
		load();
	}

	public Sprite(int size, int color) {
		this.size = size;
		this.width = this.height = size;
		this.pixels = new int[size * size];
		setColor(color);
	}

	private void load() {
		for(int y = 0; y < height; y++)
			for(int x = 0; x < width; x++)
				pixels[x + y * width] = spriteSheet.pixels[(x + this.x) + (y + this.y) * spriteSheet.width];
	}

	private void setColor(int color) {
		for(int i = 0; i < pixels.length; i++)
			pixels[i] = color;
	}

}