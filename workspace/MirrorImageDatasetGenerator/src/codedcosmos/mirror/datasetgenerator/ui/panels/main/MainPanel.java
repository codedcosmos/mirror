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
package codedcosmos.mirror.datasetgenerator.ui.panels.main;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import codedcosmos.mirror.datasetgenerator.context.MirrorContext;

public class MainPanel extends JPanel {
	private static final long serialVersionUID = -3309633285584377506L;

	// SubComponents
	private MirrorContext context;
	
	// Scale
	public static int RIGHT_WIDTH = 340;
	
	public MainPanel(MirrorContext context) {
		this.context = context;
		setBackground(new Color(0.239f, 0.239f, 0.239f));
		
		
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.insets = new Insets(4, 4, 4, 4);
		c.fill = GridBagConstraints.BOTH;
		
		// Log
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 1;
		c.anchor = GridBagConstraints.NORTHWEST;
		
		add(context.log, c);
		
		// Input Panel
		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 0;
		c.weighty = 1;
		c.anchor = GridBagConstraints.NORTHEAST;
		
		add(context.splitPanel, c);
		
	}
}
