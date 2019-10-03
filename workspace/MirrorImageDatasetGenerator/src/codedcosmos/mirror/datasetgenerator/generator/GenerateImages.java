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
package codedcosmos.mirror.datasetgenerator.generator;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import codedcosmos.mirror.datasetgenerator.context.MirrorContext;
import codedcosmos.mirror.datasetgenerator.generator.variables.RunTask;
import codedcosmos.mirror.datasetgenerator.ui.panels.main.MainPanel;

public class GenerateImages {
	public static void run(MirrorContext context) {
		ExecutorService service = Executors.newFixedThreadPool(context.inputs.getNumberOfThreads());
		
		File folder = new File(context.inputs.getSourceDirectory());
		File[] listOfFiles = folder.listFiles();
		
		if (listOfFiles == null) {
			context.log.printErr("Source Folder is null");
			service.shutdownNow();
			return;
		}
		
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				service.execute(new RunTask(context, listOfFiles[i]));
			}
		}
		
		
		// Block until all the tasks finish
		service.shutdown();
        try {
            service.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
}
