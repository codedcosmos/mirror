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
package codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.inputpanel.tabs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import codedcosmos.mirror.datasetgenerator.context.MirrorContext;
import codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.inputpanel.InputPanel;
import codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.inputpanel.sub.FolderInput;
import codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.inputpanel.sub.StartButton;
import codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.inputpanel.sub.StopButton;
import codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.inputpanel.sub.ThreadSlider;
import codedcosmos.mirror.datasetgenerator.utils.JUIGenerator;

public class RunTab extends JPanel {
	// Folder inputs
	private JLabel labelSource = JUIGenerator.generateLabel("Source");
	private FolderInput fieldSource = new FolderInput();
	
	private JLabel labelDestination = JUIGenerator.generateLabel("Destination");
	private FolderInput fieldDestination = new FolderInput();
	
	// Start Stop buttons
	private StartButton buttonStart = new StartButton(this);
	private StopButton buttonStop = new StopButton(this);
	
	// Number of threads slider
	private JLabel labelThreadCount = JUIGenerator.generateLabel("Number of Threads");
	private ThreadSlider sliderThreadCount = new ThreadSlider(this);
	public JLabel labelThreadNum = JUIGenerator.generateLabel("0");
	
	// Context
	private InputPanel inputPanel;
	
	public RunTab(InputPanel inputPanel) {
		this.inputPanel = inputPanel;
		
		setBackground(new Color(0.239f, 0.239f, 0.239f));
		
		int width = 340;
		int height = 220;
		Dimension dimension = new Dimension(width, height);
		Dimension min = new Dimension(width, 220);
		Dimension max = new Dimension(width, 1080);
		
		setSize(dimension);
		setMinimumSize(min);
		setPreferredSize(dimension);
		setMaximumSize(max);
		
		// Layout
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.insets = new Insets(4, 4, 4, 4);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTH;
		c.weightx = 0;
		c.weighty = 0;
		
		// Source
		c.gridx = 0; c.gridy = 0;
		add(labelSource, c);
		
		c.gridx = 0; c.gridy = 1;
		add(fieldSource, c);
		
		// Destination
		c.gridx = 0; c.gridy = 2;
		add(labelDestination, c);
		
		c.gridx = 0; c.gridy = 3;
		add(fieldDestination, c);
		
		// Number of threads slider
		c.gridx = 0; c.gridy = 4;
		add(labelThreadCount, c);
		
		c.gridx = 1; c.gridy = 5;
		add(labelThreadNum, c);
		
		c.gridx = 0; c.gridy = 5;
		add(sliderThreadCount, c);
		
		// Start button
		c.gridx = 0; c.gridy = 6;
		add(buttonStart, c);
		
		// Stop button
		c.gridx = 1; c.gridy = 6;
		add(buttonStop, c);
		
		// Padding
		c.gridx = 0; c.gridy = 7;
		c.weighty = 1;
		add(JUIGenerator.generatePadding(), c);
		
		
		
		// Set Defaults
		sliderThreadCount.setValue(4);
	}
	
	public MirrorContext getContext() {
		return inputPanel.getContext();
	}
	
	public int getNumberOfThreads() {
		return sliderThreadCount.getValue();
	}
	
	public String getSourceDirectory() {
		return fieldSource.getText();
	}
	
	public String getDestinationDirectory() {
		return fieldDestination.getText();
	}
}
