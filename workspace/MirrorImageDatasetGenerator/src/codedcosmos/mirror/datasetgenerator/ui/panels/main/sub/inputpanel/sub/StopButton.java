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
package codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.inputpanel.sub;

import javax.swing.JButton;

import codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.inputpanel.tabs.RunTab;

public class StopButton extends JButton {
	private static final long serialVersionUID = 5854015211732326491L;

	private RunTab runTab;
	
	public StopButton(RunTab runTab) {
		super("Stop");
		
		this.runTab = runTab;
	}
}
