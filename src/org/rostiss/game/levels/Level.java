package org.rostiss.game.levels;

import org.rostiss.game.graphics.Renderer;
import org.rostiss.game.levels.tiles.Tile;

/**
 * File: Level.java
 * Created by Atlas IND on 11/8/2015 at 10:14 AM.
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

public class Level {

	protected int[] tiles;
	protected int width, height;

	public Level(String file) {
		loadLevel(file);
		generateLevel();
	}

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		generateLevel();
	}

	public void update() {}

	public void render(int xOffset, int yOffset, Renderer renderer) {
		renderer.setOffset(xOffset, yOffset);
		int x0 = xOffset >> 4;
		int x1 = (xOffset + renderer.width + 16) >> 4;
		int y0 = yOffset >> 4;
		int y1 = (yOffset + renderer.height + 16) >> 4;
		for(int y = y0; y < y1; y++) {
			for(int x = x0; x < x1; x++) {
				if (x + y * 16 < 0 || x + y * 16 >= 256) {
					Tile.debugTile.render(x, y, renderer);
					continue;
				}
				getTile(x, y).render(x, y, renderer);
			}
		}
	}

	public Tile getTile(int x, int y) {
		if(x < 0 || x >= width || y < 0 || y >= height) return Tile.debugTile;
		if(tiles[x + y * width] == 0xff11ff11) return Tile.grass1Tile;
		if(tiles[x + y * width] == 0xff22ff22) return Tile.grass2Tile;
		if(tiles[x + y * width] == 0xff500000) return Tile.dirt1Tile;
		if(tiles[x + y * width] == 0xff600000) return Tile.dirt2Tile;
		if(tiles[x + y * width] == 0xff700000) return Tile.dirt3Tile;
		return Tile.debugTile;
	}

	protected void generateLevel() {}

	protected void loadLevel(String file) {

	}
}