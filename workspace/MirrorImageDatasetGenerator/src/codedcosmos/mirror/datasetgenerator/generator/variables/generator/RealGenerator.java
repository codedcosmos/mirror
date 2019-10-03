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
package codedcosmos.mirror.datasetgenerator.generator.variables.generator;

import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import codedcosmos.mirror.datasetgenerator.context.MirrorContext;
import codedcosmos.mirror.datasetgenerator.generator.variables.RunTask;

public class RealGenerator implements Generator {
	private MirrorContext context;
	private ExecutorService service;
	
	private AtomicInteger progress = new AtomicInteger(0);
	private int totalProgress = 0;
	
	private Thread mainThread;
	
	private long startTime;
	
	private AtomicInteger imageID = new AtomicInteger(0);
	
	public RealGenerator(MirrorContext context) {
		this.context = context;
		service = Executors.newFixedThreadPool(context.inputs.getNumberOfThreads());
		
		mainThread = new Thread() {
			public void run() {
				startTime = System.currentTimeMillis();
				
				File folder = new File(context.inputs.getSourceDirectory());
				File[] listOfFiles = folder.listFiles();
				
				if (listOfFiles == null) {
					context.log.printErr("Source Folder is null");
					service.shutdownNow();
					return;
				}
				
				int total = 0;
				for (int i = 0; i < listOfFiles.length; i++) {
					if (listOfFiles[i].isFile()) {
						service.execute(new RunTask(context, listOfFiles[i]));
						total++;
					}
				}
				
				// Progress tracking
				totalProgress = total;
				context.start.startProgress(totalProgress);
				
				// Block until all the tasks finish
				service.shutdown();
		        try {
		            service.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		        context.start.finishProgress();
			}
		};
	}
	
	@Override
	public void start() {
		mainThread.start();
	}
	
	@Override
	public void forceStop() {
		List<Runnable> list = service.shutdownNow();
		System.err.println("Forced stop of image generation. " + list.size() + " tasks failed to execute!");
		System.err.println("There where a total of " + totalProgress + " tasks to complete.");
	}
	
	@Override
	public synchronized void addProgress() {
		int currentProgress = progress.incrementAndGet();
		
		long stopTime = System.currentTimeMillis();
		int seconds = (int) ((stopTime - startTime) / 1000F);
		
		context.start.updateProgress(currentProgress, seconds);
	}

	@Override
	public synchronized int getNewID() {
		return imageID.getAndIncrement();
	}
}