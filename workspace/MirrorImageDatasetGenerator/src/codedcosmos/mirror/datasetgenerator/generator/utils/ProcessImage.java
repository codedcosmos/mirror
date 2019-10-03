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
package codedcosmos.mirror.datasetgenerator.generator.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;

import javax.imageio.ImageIO;

import codedcosmos.mirror.datasetgenerator.context.MirrorContext;
import codedcosmos.mirror.datasetgenerator.generator.processing.ImageOverfittingProtection;
import codedcosmos.mirror.datasetgenerator.generator.processing.ImageResizer;
import codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.splitPanel.inputpanel.InputPanel;

public class ProcessImage {
	public static void processImage(MirrorContext context, BufferedImage image) throws Exception {
		if (image == null) return;
		
		InputPanel inputPanel = context.inputs;
		
		LinkedList<BufferedImage> images = new LinkedList<BufferedImage>();
		
		boolean hasResized = false;
		if (inputPanel.shouldResizeSimple()) {
			images.add(ImageResizer.resizeImageToSize(image, inputPanel.getImageWidth(), inputPanel.getImageHeight()));
			hasResized = true;
		}
		if (inputPanel.shouldResizeAutoCrop()) {
			images.addAll(ImageResizer.resizeImageUntilSize(image, inputPanel.getImageWidth(), inputPanel.getImageHeight()));
			hasResized = true;
		}
		
		if (!hasResized) {
			images.add(image);
		}
		
		// Apply overfitting counter measures
		images = ImageOverfittingProtection.processImages(context, images);
		
		saveImage(context, images);
	}
	
	public static void saveImage(MirrorContext context, LinkedList<BufferedImage> images) {
		for (Iterator<BufferedImage> iter = images.iterator(); iter.hasNext(); ) {
			saveImage(context, iter.next());
		}
	}
	
	public static void saveImage(MirrorContext context, BufferedImage image) {
		String extension = "png";
		
		String filename = context.generator.getNewID()+"."+extension;
		
		String path = context.inputs.getDestinationDirectory();
		if (path.endsWith(File.separatorChar+"")) {
			path = path.substring(0, path.length()-1);
			System.out.println(path);
		}
		
		String fullpath = context.inputs.getDestinationDirectory()+File.separatorChar+filename;
		
		File outputfile = new File(fullpath);
		try {
			ImageIO.write(image, extension, outputfile);
			System.out.println("Saved " + fullpath);
		} catch (Throwable e) {
			context.log.printErr("Failed to save image " + filename);
			e.printStackTrace();
		}
	}
}
