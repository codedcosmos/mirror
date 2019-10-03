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
package codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.inputpanel.tabs.resize;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JSpinner;

import codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.inputpanel.InputPanel;
import codedcosmos.mirror.datasetgenerator.utils.JUIGenerator;

public class ImageSizeSliders extends JComponent {
	private JSpinner spinnerWidth = generateImageSizeSpinner();
	private JSpinner spinnerHeight = generateImageSizeSpinner();
	
	public ImageSizeSliders() {
		setLayout(new GridLayout(1, 2));
		add(spinnerWidth);
		add(spinnerHeight);
	}
	
	
	private JSpinner generateImageSizeSpinner() {
		JSpinner spinner = JUIGenerator.generateSpinner(128f, 1f, 16384f, 1f);
		
		Dimension dimension = new Dimension(InputPanel.WIDTH/5, 20);
		
		spinner.setSize(dimension);
		spinner.setPreferredSize(dimension);
		spinner.setMinimumSize(dimension);
		spinner.setMaximumSize(dimension);
		
		return spinner;
	}
	
	public int getImageWidth() {
		Object obj = spinnerWidth.getValue();
		double num = (double)obj;
		int integer = (int)num;
		return integer;
	}
	
	public int getImageHeight() {
		Object obj = spinnerHeight.getValue();
		double num = (double)obj;
		int integer = (int)num;
		return integer;
	}
}	
