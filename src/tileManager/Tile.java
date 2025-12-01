package tileManager;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import kopfrechnen2.OutputPanel;

public class Tile {

	OutputPanel op;
	
	BufferedImage imageStart, imageZiel;
	
	public Tile(OutputPanel op) {
		this.op = op;
		getImage();
	}
	
	public void drawTile(Graphics2D d2g) {
		drawStart(d2g);
		drawZiel(d2g);
	}
	
	public void drawStart(Graphics2D d2g) {
		d2g.drawImage(imageStart, 20, 390, imageStart.getWidth(), imageStart.getHeight(), op);
	}
	
	public void drawZiel(Graphics2D d2g) {
		d2g.drawImage(imageZiel, 400, 320, imageZiel.getWidth(), imageZiel.getHeight(), op);
	}
	
	public void getImage() {
		try {
			imageStart = ImageIO.read(getClass().getResourceAsStream("/picture/Start.png"));
			imageZiel = ImageIO.read(getClass().getResourceAsStream("/picture/Ziel3.png"));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
  