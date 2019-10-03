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
package codedcosmos.mirror.datasetgenerator.core;

import codedcosmos.mirror.datasetgenerator.context.MirrorContext;

public class Mirror {
	public static final String version = "0 - beta";
	
	public static boolean doTests = false;
	
	public static void main(String[] args) {
		System.out.println("Starting Mirror - version " + version);
		
		// Create new context and thus a new window
		new MirrorContext();
	}
}
