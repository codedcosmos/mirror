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
package codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.splitPanel.start;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import codedcosmos.mirror.datasetgenerator.context.MirrorContext;
import codedcosmos.mirror.datasetgenerator.generator.variables.generator.FakeGenerator;
import codedcosmos.mirror.datasetgenerator.ui.panels.main.MainPanel;
import codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.splitPanel.start.sub.StartButton;
import codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.splitPanel.start.sub.StopButton;
import codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.splitPanel.start.subpanels.InfoPanel;
import codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.splitPanel.start.subpanels.RunPanel;
import codedcosmos.mirror.datasetgenerator.utils.JUIGenerator;

public class StartPanel extends JPanel {
	private static final long serialVersionUID = 8029551277288317593L;
	
	// Context
	private MirrorContext context;
	
	private static int HEIGHT = 130;
	
	// Panels
	private InfoPanel infoPanel = new InfoPanel();
	private RunPanel runPanel;
	
	public StartPanel(MirrorContext context) {
		this.context = context;
		runPanel = new RunPanel(context);
		
		setBackground(new Color(0.239f, 0.239f, 0.239f));
		
		Dimension dimension = new Dimension(MainPanel.RIGHT_WIDTH, HEIGHT);
		Dimension min = new Dimension(MainPanel.RIGHT_WIDTH, HEIGHT);
		Dimension max = new Dimension(MainPanel.RIGHT_WIDTH, HEIGHT);
		
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
		
		// Padding
		c.gridx = 0; c.gridy = 0;
		c.weighty = 1;
		add(JUIGenerator.generatePadding(), c);
		c.weighty = 0;
		
		// Info
		c.gridx = 0; c.gridy = 1;
		add(infoPanel, c);
		
		// Start Stop, progress
		c.weightx = 1;
		c.gridx = 0; c.gridy = 2;
		add(runPanel, c);
	}

	public MirrorContext getContext() {
		return context;
	}
	
	// Update Progress
	public void updateProgress(int value, int seconds) {
		runPanel.updateProgress(value);
		infoPanel.updateTimeElapsedLabel(seconds);
		
		context.repaintAll();
	}
	
	public void startProgress(int maximum) {
		runPanel.initalUpdateProgressBar(maximum);
	}
	
	public void finishProgress() {
		context.generator = new FakeGenerator();
		runPanel.finishProgress();
	}
}
