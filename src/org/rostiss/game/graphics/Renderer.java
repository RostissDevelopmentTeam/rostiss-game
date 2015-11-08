package org.rostiss.game.graphics;

import org.rostiss.game.levels.tiles.Tile;

import java.util.Random;

/**
 * File: Renderer.java
 * Created by Atlas IND on 9/26/2015 at 12:13 AM.
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

public class Renderer {

	private static final Random random = new Random();

	public final int MAP_SIZE = 8, MAP_SIZE_MASK = MAP_SIZE - 1;
	public int[] pixels, tiles;
	public int width, height;

	private int xOffset, yOffset;

	public Renderer(int width, int height) {
		this.width = width;
		this.height = height;
		this.pixels = new int[width * height];
		tiles = new int[MAP_SIZE * MAP_SIZE];
		for (int i = 0; i < tiles.length; i++) {
			tiles[i] = random.nextInt(0xFFFFFF);
		}
	}

	public void renderTile(int xOffset, int yOffset, Tile tile) {
		xOffset = xOffset << 4;
		yOffset = yOffset << 4;
		xOffset -= this.xOffset;
		yOffset -= this.yOffset;
		for (int y = 0; y < tile.sprite.SIZE; y++) {
			int yp = y + yOffset;
			for (int x = 0; x < tile.sprite.SIZE; x++) {
				int xp = x + xOffset;
				if (xp < -tile.sprite.SIZE || xp >= width || yp < 0 || yp >= height) break;
				if(xp < 0) xp = 0;
				pixels[xp + yp * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
			}
		}
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++)
			pixels[i] = 0;
	}

	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
}