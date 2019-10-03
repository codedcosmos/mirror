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

import java.io.File;
import java.io.IOException;

import org.jcodec.api.FrameGrab;
import org.jcodec.api.JCodecException;
import org.jcodec.awtutil.AWTUtil;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.model.Picture;

import codedcosmos.mirror.datasetgenerator.context.MirrorContext;
import codedcosmos.mirror.datasetgenerator.utils.FileUtils;

public class LoadVideo {
	public static boolean isVideo(File file) {
		String ext = FileUtils.getFileExtension(file);
		
		if (ext.equals("avi")) return true;
		if (ext.equals("webm")) return true;
		if (ext.equals("mp4")) return true;
		if (ext.equals("mov")) return true;
		return false;
	}
	
	public static void processVideo(MirrorContext context, File file) {
		try {
			FrameGrab grab = FrameGrab.createFrameGrab(NIOUtils.readableChannel(file));
			Picture picture;
			while (null != (picture = grab.getNativeFrame())) {
				ProcessImage.processImage(context, AWTUtil.toBufferedImage(picture));
			}
		} catch (Exception e) {
			System.err.println("Exception occured with Video file");
			System.err.println("File: " + file.getAbsoluteFile());
			e.printStackTrace();
		}
	}
}
