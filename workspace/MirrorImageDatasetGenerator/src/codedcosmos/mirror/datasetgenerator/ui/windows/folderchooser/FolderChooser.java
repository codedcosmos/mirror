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
package codedcosmos.mirror.datasetgenerator.ui.windows.folderchooser;

import java.io.File;

import javax.swing.JFileChooser;

public class FolderChooser {
	public static final String NULL_DIRECTORY = "!null?";
	
	private String chosenDirectory = NULL_DIRECTORY;
	
	public FolderChooser(File path) {
		init(new File(System.getProperty("user.home")), "Select a folder");
	}
	
	public FolderChooser(String title) {
		init(new File(System.getProperty("user.home")), title);
	}
	
	public FolderChooser(File path, String title) {
		init(path, title);
	}
	
	private void init(File path, String title) {
        JFileChooser chooser = new JFileChooser(path);
        chooser.setDialogTitle(title);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
        chooser.showSaveDialog(null);
        
        try {
	        chosenDirectory = chooser.getSelectedFile().getAbsolutePath();
		} catch (Exception e) {
			chosenDirectory = NULL_DIRECTORY;
		}
	}
	
	public boolean isDirectoryValid() {
		return (!chosenDirectory.contentEquals(NULL_DIRECTORY));
	}
	
	public String getChosenDirectory() {
		return chosenDirectory;
	}
}
