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
package codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.splitPanel.inputpanel.sub;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.splitPanel.inputpanel.tabs.GeneralTab;

public class ThreadSlider extends JSlider {
	
	private GeneralTab generalTab;
	
	public ThreadSlider(GeneralTab generalTab) {
		
		this.generalTab = generalTab;
		
		//setMinorTickSpacing(1);
		setMajorTickSpacing(31);
		setPaintLabels(true);
		setPaintLabels(true);
		setMinimum(1);
		setMaximum(32);
		
		addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				generalTab.labelThreadNum.setText(Integer.toString(getValue()));
			}
		});
	}
}
