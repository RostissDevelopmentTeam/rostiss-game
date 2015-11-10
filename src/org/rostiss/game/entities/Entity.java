package org.rostiss.game.entities;

import org.rostiss.game.graphics.Renderer;
import org.rostiss.game.levels.Level;
import org.rostiss.game.levels.RandomLevel;

import java.util.Random;

/**
 * File: Entity.java
 * Created by Atlas IND on 11/8/2015 at 2:20 PM.
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

public class Entity {

	protected static final Random random = new Random();

	public int x, y;

	private boolean isRemoved = false;

	protected Level level;

	public void update() {}

	public void render(Renderer renderer) {}

	public void remove() {
		isRemoved = true;
	}

	public boolean isRemoved() {
		return isRemoved;
	}
}