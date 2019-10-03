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
package codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.logging;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Log extends JScrollPane {
	private static final long serialVersionUID = 3752020500694602016L;
	
	private static JTextArea log = new JTextArea();
	
	public Log() {
		super(log);
		log.setBackground(new Color(0.901f, 0.901f, 0.901f));
	}
	
	public synchronized void printStd(String input) {
		log.append(">" + input + "\n");
	}
	
	public synchronized void printErr(String input) {
		log.append("Error>" + input + "\n");
	}
}
