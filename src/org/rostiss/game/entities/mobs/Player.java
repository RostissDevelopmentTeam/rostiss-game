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
	private int animation = 0;

	public Player(Keyboard keyboard) {
		this.x = 0;
		this.y = 0;
		this.keyboard = keyboard;
		this.sprite = Sprite.player_forward0;
	}

	public Player(int x, int y, Keyboard keyboard) {
		this.x = x;
		this.y = y;
		this.keyboard = keyboard;
		sprite = Sprite.player_forward0;
	}

	public void update() {
		int dx, dy;
		dx = dy = 0;
		animation++;
		if(keyboard.up) dy--;
		if(keyboard.down) dy++;
		if(keyboard.left) dx--;
		if(keyboard.right) dx++;
		if(dx != 0 || dy != 0) {
			move(dx, dy);
			isMoving = true;
		} else isMoving = false;
	}

	public void render(Renderer renderer) {
		if(direction == Direction.FORWARD) {
			if(animation % 20 > 10 && isMoving) sprite = Sprite.player_forward1;
			else if(isMoving) sprite = Sprite.player_forward2;
			else sprite = Sprite.player_forward0;
		}
		if(direction == Direction.BACK) {
			if(animation % 20 > 10 && isMoving) sprite = Sprite.player_back1;
			else if(isMoving) sprite = Sprite.player_back2;
			else sprite = Sprite.player_back0;
		}
		if(direction == Direction.LEFT) {
			if(animation % 20 > 10 && isMoving) sprite = Sprite.player_left1;
			else if(isMoving) sprite = Sprite.player_left2;
			else sprite = Sprite.player_left0;
		}
		if(direction == Direction.RIGHT) {
			if(animation % 20 > 10 && isMoving) sprite = Sprite.player_right1;
			else if(isMoving) sprite = Sprite.player_right2;
			else sprite = Sprite.player_right0;
		}
		renderer.renderPlayer(x - 8, y - 8, sprite);
	}
}