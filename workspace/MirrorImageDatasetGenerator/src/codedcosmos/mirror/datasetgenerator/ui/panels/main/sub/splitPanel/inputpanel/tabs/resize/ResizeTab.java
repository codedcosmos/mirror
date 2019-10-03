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
package codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.splitPanel.inputpanel.tabs.resize;

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

public class ResizeTab extends JPanel {
	// Radio Buttons & Labels
	private JLabel labelSimple = JUIGenerator.generateLabel("May disort images scale");
	private JRadioButton radioSimple = JUIGenerator.generateRadioButton("Simple");
	
	// Radio Buttons & Labels
	private JLabel labelAutoCrop = JUIGenerator.generateLabel("Resizes until larger, then crops");
	private JRadioButton radioAutoCrop = JUIGenerator.generateRadioButton("Auto-Crop");
	
	private JLabel labelImageSize = JUIGenerator.generateLabel("Image Size");
	private ImageSizeSliders sliders = new ImageSizeSliders();
	
	// Context
	private InputPanel inputPanel;
	
	public ResizeTab(InputPanel inputPanel) {
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

		
		
		// Simple
		c.gridx = 0; c.gridy = 0;
		add(labelSimple, c);
		
		c.gridx = 1; c.gridy = 0;
		add(radioSimple, c);
		
		// AutoCrop
		c.gridx = 0; c.gridy = 1;
		add(labelAutoCrop, c);
		
		c.gridx = 1; c.gridy = 1;
		add(radioAutoCrop, c);
		
		// Image Size
		c.gridx = 1; c.gridy = 2;
		add(labelImageSize, c);
		
		c.gridx = 0; c.gridy = 2;
		add(sliders, c);
		
		
		// Padding
		c.gridx = 0; c.gridy = 4;
		c.weighty = 1;
		add(JUIGenerator.generatePadding(), c);
	}
	
	public boolean shouldResizeSimple() {
		return radioSimple.isSelected();
	}
	
	public boolean shouldResizeAutoCrop() {
		return radioAutoCrop.isSelected();
	}
	
	public ImageSizeSliders getSliders() {
		return sliders;
	}
}
