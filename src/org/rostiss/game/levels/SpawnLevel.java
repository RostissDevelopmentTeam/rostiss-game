package org.rostiss.game.levels;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * File: SpawnLevel.java
 * Created by Atlas IND on 11/16/2015 at 10:40 PM.
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

public class SpawnLevel extends Level {

	private int[] tiles;

	public SpawnLevel(String file) {
		super(file);
	}

	protected void loadLevel(String file) {
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(file));
			int width = image.getWidth();
			int height = image.getHeight();
			tiles = new int[width * height];
			image.getRGB(0, 0, width, height, tiles, 0, width);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}