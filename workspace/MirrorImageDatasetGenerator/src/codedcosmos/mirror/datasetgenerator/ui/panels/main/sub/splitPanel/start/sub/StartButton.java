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
package codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.splitPanel.start.sub;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import codedcosmos.mirror.datasetgenerator.generator.variables.generator.Generator;
import codedcosmos.mirror.datasetgenerator.generator.variables.generator.RealGenerator;
import codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.splitPanel.start.subpanels.RunPanel;

public class StartButton extends JButton {
	private static final long serialVersionUID = 8382892875685531451L;
	
	private RunPanel runPanel;
	
	public StartButton(RunPanel runPanel) {
		super("Start");
		this.runPanel = runPanel;
		
		addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Generator generator = new RealGenerator(runPanel.getContext());
				runPanel.getContext().generator = generator;
				generator.start();
			}
		});

	}
	
	
}
