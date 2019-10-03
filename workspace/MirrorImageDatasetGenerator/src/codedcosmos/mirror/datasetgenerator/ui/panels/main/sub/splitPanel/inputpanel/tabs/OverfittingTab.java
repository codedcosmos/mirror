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
package codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.splitPanel.inputpanel.tabs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.splitPanel.inputpanel.InputPanel;
import codedcosmos.mirror.datasetgenerator.utils.JUIGenerator;

public class OverfittingTab extends JPanel {
	// Radio Buttons & Labels
	private JLabel labelHFlip = JUIGenerator.generateLabel("Flips images horizontally");
	private JRadioButton radioHFlip = JUIGenerator.generateRadioButton("H Flip");
	
	private JLabel labelVFlip = JUIGenerator.generateLabel("Flips images vertically");
	private JRadioButton radioVFlip = JUIGenerator.generateRadioButton("V Flip");
	
	private JLabel labelHJitter = JUIGenerator.generateLabel("Shifts pixels horizontally slightly");
	private JRadioButton radioHJitter = JUIGenerator.generateRadioButton("H Jitter");
	
	private JLabel labelVJitter = JUIGenerator.generateLabel("Shifts pixels vertically slightly");
	private JRadioButton radioVJitter = JUIGenerator.generateRadioButton("V Jitter");
	
	// Context
	private InputPanel inputPanel;
	
	public OverfittingTab(InputPanel inputPanel) {
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
		
		// H Flip
		c.gridx = 0; c.gridy = 4;
		add(labelHFlip, c);
		
		c.gridx = 1; c.gridy = 4;
		add(radioHFlip, c);
		
		// V Flip
		c.gridx = 0; c.gridy = 5;
		add(labelVFlip, c);
		
		c.gridx = 1; c.gridy = 5;
		add(radioVFlip, c);
		
		// H Jitter
		c.gridx = 0; c.gridy = 6;
		add(labelHJitter, c);
		
		c.gridx = 1; c.gridy = 6;
		add(radioHJitter, c);
		
		// V Jitter
		c.gridx = 0; c.gridy = 7;
		add(labelVJitter, c);
		
		c.gridx = 1; c.gridy = 7;
		add(radioVJitter, c);
		
		// Padding
		c.gridx = 0; c.gridy = 8;
		c.weighty = 1;
		add(JUIGenerator.generatePadding(), c);
	}
	
	public boolean shouldFlipH() {
		return radioHFlip.isSelected();
	}
	
	public boolean shouldFlipV() {
		return radioVFlip.isSelected();
	}
	
	public boolean shouldJitterH() {
		return radioHJitter.isSelected();
	}
	
	public boolean shouldJitterV() {
		return radioVJitter.isSelected();
	}
}
