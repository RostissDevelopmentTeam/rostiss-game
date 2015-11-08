package org.rostiss.game.levels.tiles;

import org.rostiss.game.graphics.Renderer;
import org.rostiss.game.graphics.Sprite;

/**
 * File: DebugTile.java
 * Created by Atlas IND on 11/8/2015 at 1:34 PM.
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

public class DebugTile extends Tile {

	public DebugTile() {
		super(Sprite.debug);
	}

	public void render(int x, int y, Renderer renderer) {
		renderer.renderTile(x, y, this);
	}

	public boolean isSolid() {
		return true;
	}
}