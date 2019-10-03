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
package codedcosmos.mirror.datasetgenerator.context;

import codedcosmos.mirror.datasetgenerator.generator.variables.generator.FakeGenerator;
import codedcosmos.mirror.datasetgenerator.generator.variables.generator.Generator;
import codedcosmos.mirror.datasetgenerator.ui.panels.main.MainPanel;
import codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.logging.Log;
import codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.splitPanel.SplitPanel;
import codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.splitPanel.inputpanel.InputPanel;
import codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.splitPanel.start.StartPanel;
import codedcosmos.mirror.datasetgenerator.ui.windows.main.MainWindow;

public class MirrorContext {
	// Components of mainpanel
	public Log log;
	public SplitPanel splitPanel;
	
	// Components of splitpanel
	public InputPanel inputs;
	public StartPanel start;
	
	// Main Window
	private MainWindow mainWindow;
	public MainPanel mainPanel;
	
	// Processing
	public Generator generator;
	
	public MirrorContext() {
		// UI
		log = new Log();
		inputs = new InputPanel(this);
		start = new StartPanel(this);
		
		splitPanel = new SplitPanel(this);
		
		mainPanel = new MainPanel(this);
		mainWindow = new MainWindow(mainPanel);
		
		// Generator
		generator = new FakeGenerator();
	}
	
	public void repaintAll() {
		mainWindow.repaint();
	}
}
