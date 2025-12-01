package info;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import kopfrechnen2.OutputPanel;

public class Lives {

	OutputPanel op;
	BufferedImage image;
	int x,y;
	public int livesPlayer = 5;
	public boolean gameover = false;
	
	public Lives(OutputPanel op) {
		this.op = op;
	 
	}
	
	public Lives(int x, int y) {
		this.x = x;
		this.y = y;
		getImage();
	}
	
	public void drawLives(Graphics2D d2g) {
		 for(int l=0; l < op.live.livesPlayer; l++) {
			  if(op.lives[l]!=null) {
			 op.lives[l].draw(d2g);  }
		  }
		 drawGameOver(d2g);
	}
	
	public void draw(Graphics2D d2g) {
		d2g.drawImage(image, x, y, 30, 30, this.op);
	}
	
	public void getImage() {
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/picture/Herz.png"));
		} catch (IOException e) {
			 
			e.printStackTrace();
		}
	}
	
	public void livesErstellen() {
		 
		for(int col=0; col < op.lives.length; col++) {
			this.x = col * 45 + 210;
			this.y = 20;
			op.lives[col] = new Lives(this.x, this.y);
			
		}
	}
	public void drawGameOver(Graphics2D d2g) {
		 
		if(gameover) {
		d2g.setFont(new Font("Arial", 3, 100));
		d2g.setColor(Color.cyan);
		d2g.drawString("Game Over", 80, 200);
		}
	}
	public void update() {
		if(op.live.livesPlayer==0) { gameover = true; }
	}
}
