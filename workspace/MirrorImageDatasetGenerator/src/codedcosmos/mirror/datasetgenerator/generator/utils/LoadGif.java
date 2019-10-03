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
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import codedcosmos.mirror.datasetgenerator.context.MirrorContext;
import codedcosmos.mirror.datasetgenerator.utils.FileUtils;

public class LoadGif {
	public static boolean isGif(File file) {
		String ext = FileUtils.getFileExtension(file);
		
		if (ext.equals("gif")) return true;
		return false;
	}
	
	public static void processGif(MirrorContext context, File file) {
		LinkedList<BufferedImage> images = new LinkedList<BufferedImage>();

		try {
			ImageReader reader = ImageIO.getImageReadersByFormatName("gif").next();
			ImageInputStream stream = ImageIO.createImageInputStream(file);
			reader.setInput(stream);
			
			int count = reader.getNumImages(true);
			for (int index = 0; index < count; index++) {
				images.add(reader.read(index));
			}
		
			for (Iterator<BufferedImage> iter = images.iterator(); iter.hasNext(); ) {
					ProcessImage.processImage(context, iter.next());
			}
		} catch (Exception e) {
			System.err.println("Exception occured with GIF file");
			System.err.println("File: " + file.getAbsoluteFile());
			e.printStackTrace();
		}
	}
}
