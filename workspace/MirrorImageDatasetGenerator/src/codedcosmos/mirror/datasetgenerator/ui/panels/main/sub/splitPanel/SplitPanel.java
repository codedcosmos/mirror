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
package codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.splitPanel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import codedcosmos.mirror.datasetgenerator.context.MirrorContext;

public class SplitPanel extends JPanel {
	private static final long serialVersionUID = -3309633285584377506L;

	// SubComponents
	private MirrorContext context;
	
	// Scale
	public static int RIGHT_WIDTH = 340;
	
	public SplitPanel(MirrorContext context) {
		this.context = context;
		setBackground(new Color(0.239f, 0.239f, 0.239f));
		
		
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.BOTH;
		
		// Input Panel
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0;
		c.weighty = 1;
		c.anchor = GridBagConstraints.NORTH;
		
		add(context.inputs, c);
		
		// Start Panel
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 0;
		c.weighty = 1;
		c.anchor = GridBagConstraints.SOUTH;
		
		add(context.start, c);
		
	}
}