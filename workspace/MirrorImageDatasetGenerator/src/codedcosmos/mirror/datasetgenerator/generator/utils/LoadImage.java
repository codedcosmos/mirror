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
import java.io.IOException;

import javax.imageio.ImageIO;

import codedcosmos.mirror.datasetgenerator.context.MirrorContext;
import codedcosmos.mirror.datasetgenerator.ui.panels.main.MainPanel;
import codedcosmos.mirror.datasetgenerator.utils.FileUtils;

public class LoadImage {
	public static boolean isImage(File file) {
		String ext = FileUtils.getFileExtension(file);
		
		if (ext.equals("tif")) return true;
		if (ext.equals("tiff")) return true;
		if (ext.equals("bmp")) return true;
		if (ext.equals("jpeg")) return true;
		if (ext.equals("jpg")) return true;
		if (ext.equals("png")) return true;
		return false;
	}
	
	public static void processImage(MirrorContext context, File file) {
		try {
			BufferedImage image = ImageIO.read(file);
			ProcessImage.processImage(context, image);
		} catch (IOException e) {
			context.log.printErr("File returned null " + file.getName());
		} catch (Exception e) {
			System.err.println("Exception occured with Image file");
			System.err.println("File: " + file.getAbsoluteFile());
			e.printStackTrace();
		}
	}
}
