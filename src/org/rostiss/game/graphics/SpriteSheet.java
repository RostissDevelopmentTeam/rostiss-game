package org.rostiss.game.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * File: SpriteSheet.java
 * Created by Atlas IND on 11/7/2015 at 11:37 PM.
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

public class SpriteSheet {

	public static SpriteSheet spriteSheet = new SpriteSheet("/spritesheets/spriteSheet.png", 128);
	public static SpriteSheet playerSheet = new SpriteSheet("/spritesheets/ninja.png", 48, 72);

	public final int size, width, height;
	public int[] pixels;

	private String file;

	public SpriteSheet(String file, int size) {
		this.file = file;
		this.size = size;
		this.width = this.height = size;
		pixels = new int[width * height];
		load();
	}

	public SpriteSheet(String file, int width, int height) {
		this.file = file;
		this.size = width;
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		load();
	}

	private void load() {
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(file));
			int width = image.getWidth();
			int height = image.getHeight();
			image.getRGB(0, 0, width, height, pixels, 0, width);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}