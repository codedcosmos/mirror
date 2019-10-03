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
package codedcosmos.mirror.datasetgenerator.utils;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class JUIGenerator {
	public static JRadioButton generateRadioButton(String text) {
		JRadioButton button = new JRadioButton(text);
		button.setBackground(new Color(0.239f, 0.239f, 0.239f));
		button.setForeground(Color.white);
		
		return button;
	}
	
	public static JLabel generateLabel(String text) {
		JLabel label = new JLabel(text);
		label.setForeground(Color.white);
		
		return label;
	}
	
	public static JPanel generatePadding() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0.239f, 0.239f, 0.239f));
		return panel;
	}
	
	public static JSpinner generateSpinner(float value, float min, float max, float step) {
		SpinnerModel model = new SpinnerNumberModel(value, min, max, step);     
		JSpinner spinner = new JSpinner(model);
		return spinner;
	}
}
