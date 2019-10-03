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
package codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.inputpanel;

import java.awt.Dimension;

import javax.swing.JTabbedPane;

import codedcosmos.mirror.datasetgenerator.context.MirrorContext;
import codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.inputpanel.tabs.FilterTab;
import codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.inputpanel.tabs.OverfittingTab;
import codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.inputpanel.tabs.RunTab;
import codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.inputpanel.tabs.resize.ImageSizeSliders;
import codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.inputpanel.tabs.resize.ResizeTab;

public class InputPanel extends JTabbedPane {
	private static final long serialVersionUID = -5610070566932755201L;
	
	public static int WIDTH = 340;
	
	// Tabs
	private OverfittingTab overfittingTab = new OverfittingTab(this);
	private RunTab runTab = new RunTab(this);
	private FilterTab filterTab = new FilterTab(this);
	private ResizeTab resizeTab = new ResizeTab(this);
	
	// Context
	private MirrorContext context;
	
	public InputPanel(MirrorContext context) {
		this.context = context;
		
		//setBackground(new Color(0.239f, 0.239f, 0.239f));
		
		int height = 220;
		Dimension dimension = new Dimension(WIDTH, height);
		Dimension min = new Dimension(WIDTH, 220);
		Dimension max = new Dimension(WIDTH, 1080);
		
		setSize(dimension);
		setMinimumSize(min);
		setPreferredSize(dimension);
		setMaximumSize(max);
		
		add("Run", runTab);
		add("Overfitting", overfittingTab);
		add("Filters", filterTab);
		add("Resize", resizeTab);
	}
	
	public MirrorContext getContext() {
		return context;
	}
	
	// Getters
	public int getNumberOfThreads() {
		return runTab.getNumberOfThreads();
	}
	
	public String getSourceDirectory() {
		return runTab.getSourceDirectory();
	}
	
	public String getDestinationDirectory() {
		return runTab.getDestinationDirectory();
	}
	
	public boolean shouldResizeSimple() {
		return resizeTab.shouldResizeSimple();
	}
	
	public boolean shouldResizeAutoCrop() {
		return resizeTab.shouldResizeAutoCrop();
	}
	
	public int getImageWidth() {
		return resizeTab.getSliders().getImageWidth();
	}
	
	public int getImageHeight() {
		return resizeTab.getSliders().getImageHeight();
	}
	
	public boolean shouldFlipH() {
		return overfittingTab.shouldFlipH();
	}
	
	public boolean shouldFlipV() {
		return overfittingTab.shouldFlipV();
	}
	
	public boolean shouldJitterH() {
		return overfittingTab.shouldJitterH();
	}
	
	public boolean shouldJitterV() {
		return overfittingTab.shouldFlipV();
	}
}
