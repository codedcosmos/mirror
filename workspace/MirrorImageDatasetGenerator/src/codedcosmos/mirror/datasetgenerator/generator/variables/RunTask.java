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
package codedcosmos.mirror.datasetgenerator.generator.variables;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;

import codedcosmos.mirror.datasetgenerator.context.MirrorContext;
import codedcosmos.mirror.datasetgenerator.generator.utils.LoadGif;
import codedcosmos.mirror.datasetgenerator.generator.utils.LoadImage;
import codedcosmos.mirror.datasetgenerator.generator.utils.LoadVideo;
import codedcosmos.mirror.datasetgenerator.generator.utils.ProcessImage;
import codedcosmos.mirror.datasetgenerator.ui.panels.main.MainPanel;

public class RunTask implements Runnable {
	private File file;
	private MirrorContext context;
	
	public RunTask(MirrorContext context, File file) {
		this.context = context;
		
		this.file = file;
	}
	
	@Override
	public void run() {
		try {
			if (LoadImage.isImage(file)) {
				LoadImage.processImage(context, file);
			} else if (LoadGif.isGif(file)) {
				LoadGif.processGif(context, file);
			} else if (LoadVideo.isVideo(file)) {
				LoadVideo.processVideo(context, file);
			}
			
			
			context.log.printStd("Processed " + file.getName());
			
			context.generator.addProgress();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
