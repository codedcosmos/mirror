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
package codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.splitPanel.start.subpanels;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import codedcosmos.mirror.datasetgenerator.context.MirrorContext;
import codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.splitPanel.start.sub.StartButton;
import codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.splitPanel.start.sub.StopButton;
import codedcosmos.mirror.datasetgenerator.utils.JUIGenerator;

public class RunPanel extends JPanel {
	// Start Stop buttons
	private StartButton buttonStart = new StartButton(this);
	private StopButton buttonStop = new StopButton(this);
	
	// Progress
	private JProgressBar progressBar = generateGenericBar();
	private JLabel percentageCounter = generatePercentCounter();
	
	private MirrorContext context;
	
	public RunPanel(MirrorContext context) {
		this.context = context;
		
		setBackground(new Color(0.239f, 0.239f, 0.239f));
		
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
		
		// Start button
		c.gridx = 0; c.gridy = 2;
		add(buttonStart, c);
		
		// Stop button
		c.gridx = 1; c.gridy = 2;
		add(buttonStop, c);
		
		// Progress Bar
		c.gridx = 2; c.gridy = 2;
		c.weightx = 1;
		add(progressBar, c);
		c.weightx = 0;
		
		// Progress Percentage
		c.gridx = 3; c.gridy = 2;
		add(percentageCounter, c);
	}
	
	public JProgressBar generateGenericBar() {
		JProgressBar progressBar = new JProgressBar();
		
		return progressBar;
	}
	
	public void initalUpdateProgressBar(int maximum) {
		progressBar.setMinimum(0);
		progressBar.setMaximum(maximum-1);
		progressBar.setValue(0);
	}
	
	// Progress Label
	private JLabel generatePercentCounter() {
		JLabel label = new JLabel();
		
		label = adjustPercentCounter(label, -1);
		label.setForeground(Color.white);
		
		return label;
	}
	
	private JLabel adjustPercentCounter(JLabel label, int percentage) {
		if (percentage < 0) label.setText("    ");
		else if (percentage == 100) label.setText("100%");
		else label.setText(" "+percentage+"%");
		
		return label;
	}

	// Get context
	public MirrorContext getContext() {
		return context;
	}
	
	// Update progress
	public void updateProgress(int value) {
		progressBar.setValue(value);
		percentageCounter = adjustPercentCounter(percentageCounter, (int)(100f*progressBar.getPercentComplete()));
	}
	
	public void finishProgress() {
		percentageCounter = adjustPercentCounter(percentageCounter, -1);
		initalUpdateProgressBar(0);
	}
}
