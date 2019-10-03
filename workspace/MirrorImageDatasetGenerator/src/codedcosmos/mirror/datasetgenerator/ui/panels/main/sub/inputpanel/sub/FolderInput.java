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

import java.awt.Color;
import java.io.File;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class FolderInput extends JTextField {
	public FolderInput() {
		getDocument().addDocumentListener(new DocumentListener() {
			// This is used to prevent "Attempt to mutate notification" exception.
			private Runnable textChange = new Runnable() {
				@Override
				public void run() {
					onTextChange(getText());
				}
			};
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				SwingUtilities.invokeLater(textChange);
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				SwingUtilities.invokeLater(textChange);
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				SwingUtilities.invokeLater(textChange);
			}
		});
	}
	
	public void onTextChange(String text) {
		File file = new File(text);
		if (file.exists() && file.isDirectory()) {
			setForeground(Color.green.darker().darker());
		} else {
			setForeground(Color.red.darker());
		}
	}
}
