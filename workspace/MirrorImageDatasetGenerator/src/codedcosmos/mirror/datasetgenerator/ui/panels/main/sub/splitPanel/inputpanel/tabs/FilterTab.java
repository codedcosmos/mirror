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

import javax.swing.JPanel;

import codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.splitPanel.inputpanel.InputPanel;

public class FilterTab extends JPanel {
	/*
	 * Makes images black and white or blurry, etc
	 */
	
	// Context
	private InputPanel inputPanel;
	
	public FilterTab(InputPanel inputPanel) {
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
	}
}
