/** 
	This file is part of Mirror Image Dataset Generator.

    Mirror is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License 3 as published by
    the Free Software Foundation.

    Mirror is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License 3 for more details.

    You should have received a copy of the GNU General Public License 3
    along with Mirror.  If not, see <https://www.gnu.org/licenses/>.
 * 
 */
package codedcosmos.mirror.datasetgenerator.generator.processing;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class ImageResizer {
	// Simple
	public static BufferedImage resizeImageToSize(BufferedImage image, int width, int height) throws Exception {
		BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2D = newImage.createGraphics();
		g2D.setBackground(Color.WHITE);
		g2D.setPaint(Color.WHITE);
		g2D.fillRect(0, 0, width, height);
		g2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2D.drawImage(image, 0, 0, width, height, null);
		return newImage;
	}
	
	// Auto Crop
	public static LinkedList<BufferedImage> resizeImageUntilSize(BufferedImage image, int boundWidth, int boundHeight) throws Exception {
		LinkedList<BufferedImage> images = new LinkedList<BufferedImage>();
		
		// Get maximum
		float maxa = (float)boundWidth/(float)image.getWidth();
		float maxb = (float)boundHeight/(float)image.getHeight();
		
		float scale;
		
		if (maxa > maxb) {
			scale = maxa;
		} else {
			scale = maxb;
		}
		
		// Multiply by scale
		int newWidth = (int) ((float)image.getWidth()*(float)scale);
		int newHeight = (int) ((float)image.getHeight()*(float)scale);
		
		BufferedImage croppableImage = resizeImageToSize(image, newWidth, newHeight);
		
		int x = 0;
		int y = 0;
		
		if (newHeight > boundHeight) {
			// Height is larger
			for (; y < newHeight; y += boundHeight) {
				
				if (y+boundHeight >= newHeight) {
					images.add(cropImage(croppableImage, x, newHeight-boundHeight, boundWidth, boundHeight));
				} else {
					images.add(cropImage(croppableImage, x, y, boundWidth, boundHeight));
				}
				
			}
		} else if (newWidth > boundWidth) {
			// Width is larger
			for (; x < newWidth; x += boundWidth) {
				
				if (x+boundWidth > newWidth) {
					images.add(cropImage(croppableImage, newWidth-boundWidth, y, boundWidth, boundHeight));
				} else {
					images.add(cropImage(croppableImage, x, y, boundWidth, boundHeight));
				}
				
			}
		} else {
			// Same size
			images.add(croppableImage);
			return images;
		}
		
		return images;
	}
	
	private static BufferedImage cropImage(BufferedImage image, int x, int y, int width, int height) {
		return image.getSubimage(x, y, width, height);
	}
}
