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
package codedcosmos.mirror.datasetgenerator.ui.windows.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

import codedcosmos.mirror.datasetgenerator.core.Mirror;
import codedcosmos.mirror.datasetgenerator.ui.panels.main.MainPanel;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 7497469490660154949L;
	
	public MainWindow(MainPanel panel) {
		getContentPane().setBackground(Color.white);
		setTitle("Mirror - v " + Mirror.version + " - from codedcosmos");
		
		setMinimumSize(new Dimension(500, 400));
		setMaximumSize(new Dimension(1080, 1080));
		
		setContentPane(panel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		pack();
	}
}
