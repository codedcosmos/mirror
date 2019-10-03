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

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.LinkedList;

import codedcosmos.mirror.datasetgenerator.context.MirrorContext;

public class ImageOverfittingProtection {
	public static LinkedList<BufferedImage> processImages(MirrorContext context, LinkedList<BufferedImage> images) throws Exception {
		LinkedList<BufferedImage> newImages = new LinkedList<BufferedImage>();
		
		for (Iterator<BufferedImage> iter = images.iterator(); iter.hasNext(); ) {
			newImages.addAll(processImage(context, iter.next()));
		}
		
		return newImages;
	}
	
	public static LinkedList<BufferedImage> processImage(MirrorContext context, BufferedImage image) throws Exception {
		LinkedList<BufferedImage> newImages = new LinkedList<BufferedImage>();
		
		if (context.inputs.shouldFlipH()) {
			AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
			tx.translate(-image.getWidth(null), 0);
			AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
			newImages.add(op.filter(image, null));
		}
		
		if (context.inputs.shouldFlipV()) {
			AffineTransform tx = AffineTransform.getScaleInstance(1, -1);
			tx.translate(0, -image.getHeight(null));
			AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
			newImages.add(op.filter(image, null));
		}
		
		if (context.inputs.shouldJitterH()) {
			BufferedImage jitterImage = ImageResizer.resizeImageToSize(image, image.getWidth()+1, image.getHeight());
			newImages.addAll(ImageResizer.resizeImageUntilSize(jitterImage, image.getWidth(), image.getHeight()));
		}
		
		if (context.inputs.shouldJitterV()) {
			BufferedImage jitterImage = ImageResizer.resizeImageToSize(image, image.getWidth(), image.getHeight()+1);
			newImages.addAll(ImageResizer.resizeImageUntilSize(jitterImage, image.getWidth(), image.getHeight()));
		}
		
		newImages.add(image);
		
		return newImages;
	}
}
