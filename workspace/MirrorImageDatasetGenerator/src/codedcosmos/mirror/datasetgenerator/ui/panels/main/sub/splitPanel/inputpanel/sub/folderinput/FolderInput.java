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
package codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.splitPanel.inputpanel.sub.folderinput;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import codedcosmos.mirror.datasetgenerator.ui.windows.folderchooser.FolderChooser;
import codedcosmos.mirror.datasetgenerator.utils.JUIGenerator;

public class FolderInput extends JPanel {
	private static final long serialVersionUID = -4233901129163397169L;

	private FolderInputLabel input;
	private JButton button;
	
	private String fieldName;
	
	public FolderInput(String fieldName) {
		this.fieldName = fieldName;
		
		// Set color
		setBackground(new Color(0.239f, 0.239f, 0.239f));
		
		// Construct objects
		input = new FolderInputLabel(240, 23);
		button = generateButton();
		
		// Set layout
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.NORTH;
		c.weighty = 0;
		
		// Input
		c.weightx = 1;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0; c.gridy = 0;
		add(input, c);
		
		// Button
		c.weightx = 0;
		c.fill = GridBagConstraints.NONE;
		c.gridx = 1; c.gridy = 0;
		add(button, c);
	}
	
	public JButton generateButton() {
		JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FolderChooser chooser;
				
				if (input.isSelectedPathValid()) {
					chooser = new FolderChooser(input.getAsFile(), fieldName);
				} else {
					chooser = new FolderChooser(fieldName);
				}
				
				if (chooser.isDirectoryValid()) {
					input.updateSelection(chooser.getChosenDirectory());
				}
			}
		});
		button.setText("...");
		
		Dimension size = new Dimension(23, 23);
		button.setSize(size);
		button.setPreferredSize(size);
		button.setMinimumSize(size);
		button.setMaximumSize(size);
		
		return button;
	}
	
	public String getSelection() {
		return input.getText();
	}
}
