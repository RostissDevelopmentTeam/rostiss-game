package org.rostiss.game.levels.tiles;

import org.rostiss.game.graphics.Renderer;
import org.rostiss.game.graphics.Sprite;

/**
 * File: Tile.java
 * Created by Atlas IND on 11/8/2015 at 1:06 PM.
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

public class Tile {

	public static Tile grass1Tile = new GroundTile(Sprite.grass1);
	public static Tile grass2Tile = new GroundTile(Sprite.grass2);
	public static Tile dirt1Tile = new GroundTile(Sprite.dirt1);
	public static Tile dirt2Tile = new GroundTile(Sprite.dirt2);
	public static Tile dirt3Tile = new GroundTile(Sprite.dirt3);
	public static Tile debugTile = new DebugTile();

	public Sprite sprite;
	public int x, y;

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public void render(int x, int y, Renderer renderer) {}

	public boolean isSolid() {
		return false;
	}
}