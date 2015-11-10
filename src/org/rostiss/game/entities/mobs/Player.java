package org.rostiss.game.entities.mobs;

import org.rostiss.game.graphics.Renderer;
import org.rostiss.game.graphics.Sprite;
import org.rostiss.game.input.Keyboard;

/**
 * File: Player.java
 * Created by Atlas IND on 11/8/2015 at 5:15 PM.
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

public class Player extends Mob {

	private Keyboard keyboard;

	public Player() {}

	public Player(int x, int y, Keyboard keyboard) {
		this.x = x;
		this.y = y;
		this.keyboard = keyboard;
		sprite = Sprite.player1;
	}

	public void update() {
		int dx, dy;
		dx = dy = 0;
		if(keyboard.up) dy--;
		if(keyboard.down) dy++;
		if(keyboard.left) dx--;
		if(keyboard.right) dx++;
		if(dx != 0 || dy != 0) move(dx, dy);
		if(direction == Direction.FORWARD) sprite = Sprite.player0;
		if(direction == Direction.BACK) sprite = Sprite.player1;
		if(direction == Direction.LEFT) sprite = Sprite.player2;
		if(direction == Direction.RIGHT) sprite = Sprite.player3;
	}

	public void render(Renderer renderer) {
		renderer.renderPlayer(x - 8, y - 8, sprite);
	}
}