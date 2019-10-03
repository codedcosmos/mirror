package codedcosmos.mirror.datasetgenerator.ui.panels.main.sub.splitPanel.start.subpanels;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import codedcosmos.mirror.datasetgenerator.utils.JUIGenerator;

public class InfoPanel extends JPanel {
	
	// Time elapsed
	private JLabel timeElapsed = createTimeElapsedLabel();
	
	public InfoPanel() {
		setBackground(new Color(0.239f, 0.239f, 0.239f));
		
		// Layout
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.insets = new Insets(4, 4, 4, 4);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.WEST;
		c.weightx = 0;
		c.weighty = 0;
		
		
		// Padding
		c.gridx = 1; c.gridy = 0;
		c.weighty = 1;
		add(JUIGenerator.generatePadding(), c);
		c.weighty = 0;
		
		// Add Time elapsed
		c.gridx = 0; c.gridy = 1;
		add(timeElapsed, c);
	}
	
	// Time elapased Label
	public JLabel createTimeElapsedLabel() {
		JLabel label = new JLabel();
		
		label.setText("");
		label.setForeground(Color.white);
		
		return label;
	}
	
	/*
	 * Progress is measured in seconds
	 */
	public void updateTimeElapsedLabel(int progress) {
		String text = "Time elapsed: ";
		
		float time = progress;
		
		if (progress < 60) {
			
			text += progress + " seconds";
			
		} else if (progress < 3600) {
			
			int minutes = (int) (time / 60f);
			int seconds = (int) (time - (float)minutes * 60f);
			text += minutes + " min, ";
			text += seconds + " sec";
			
		} else {
			
			int hours = (int) (time / 3600f);
			int remainder = (int) progress - hours * 3600;
			int minutes = remainder / 60;
			remainder = remainder - minutes * 60;
			int seconds = remainder;
			
			text += hours + " h, ";
			text += minutes + " m, ";
			text += seconds + " s";
			
		}
		
		timeElapsed.setText(text);
	}
}
