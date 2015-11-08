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

	public static Sprite grass = new Sprite(0, 1, 16, SpriteSheet.spriteSheet);
	public static Sprite brick = new Sprite(1, 0, 16, SpriteSheet.spriteSheet);
	public static Sprite debug = new Sprite(16, 0xFF00FF);

	public int[] pixels;
	public final int SIZE;

	private int x, y;
	private SpriteSheet spriteSheet;

	public Sprite(int x, int y, int size, SpriteSheet spriteSheet) {
		this.x = x;
		this.y = y;
		this.SIZE = size;
		this.spriteSheet = spriteSheet;
		this.pixels = new int[SIZE * SIZE];
		load();
	}

	public Sprite(int size, int color) {
		this.SIZE = size;
		this.pixels = new int[SIZE * SIZE];
		setColor(color);
	}

	private void load() {
		for(int y = 0; y < SIZE; y++)
			for(int x = 0; x < SIZE; x++)
				pixels[x + y * SIZE] = spriteSheet.pixels[(x + this.x * SIZE) + (y + this.y * SIZE) * spriteSheet.SIZE];
	}

	private void setColor(int color) {
		for(int i = 0; i < pixels.length; i++)
			pixels[i] = color;
	}

}