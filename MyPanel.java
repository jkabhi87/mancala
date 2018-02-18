/**
 * MyPanel.java
 */

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	
	@Override
	protected void paintComponent(Graphics g) {
		Image image = (new ImageIcon("wood-texture.jpg")).getImage();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		setOpaque(false);
		super.paintComponent(g);
		setOpaque(true);
	}
}
