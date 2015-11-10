package org.rostiss.game.entities.mobs;

import org.rostiss.game.entities.Entity;
import org.rostiss.game.graphics.Sprite;

/**
 * File: Mob.java
 * Created by Atlas IND on 11/8/2015 at 5:09 PM.
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

public abstract class Mob extends Entity {

	protected enum Direction { FORWARD, BACK, LEFT, RIGHT }

	protected Sprite sprite;
	protected Direction direction;
	protected boolean isMoving = false;

	public void move(int dx, int dy) {
		if(dx > 0) direction = Direction.RIGHT;
		if(dx < 0) direction = Direction.LEFT;
		if(dy > 0) direction = Direction.BACK;
		if(dy < 0) direction = Direction.FORWARD;
		if(!collision()) {
			x += dx;
			y += dy;
		}
	}

	public void update() {}

	private boolean collision() {
		return false;
	}
}