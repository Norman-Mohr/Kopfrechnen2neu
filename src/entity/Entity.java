package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import kopfrechnen2.OutputPanel;

public class Entity {

OutputPanel op;
	
	BufferedImage image, imageLinks, imageRechts, imageMitte;
	BufferedImage imageSchnecke;
	public int spritecounter;
	public double x=20, y=360;
	public boolean collisionEntity = false;
	
	public Entity(OutputPanel op) {
		this.op = op;
		getImage();
	}
	
	public void drawSchnecke(Graphics2D d2g) {
		 
	}
	
	public void drawSchildkröte(Graphics2D d2g) {
		d2g.drawImage(image, (int) x,(int) y, 100, 50, this.op);
	}
	
	public void getImage() {
		try {
			 
			imageLinks = ImageIO.read(getClass().getResourceAsStream("/picture/SchildkröteLinks.png"));
			imageRechts = ImageIO.read(getClass().getResourceAsStream("/picture/SchildkröteRechts.png"));
			imageMitte = ImageIO.read(getClass().getResourceAsStream("/picture/SchildkröteMitte.png"));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	public void update() {
		if(x == 600) {    x = 20;    }
		if(op.entityStep) {
		x+=0.1;
		spriteCounter();  }
		
		if(collisionEntity) {
		op.live.livesPlayer--;
		op.entity.x = 20;
		collisionEntity = false;
		}
	}

	public void spriteCounter() {
		if(this.op.aufgabe) {
		spritecounter++;
		if (spritecounter < 20) {
			image = imageLinks;
		}
		if (spritecounter > 40 & spritecounter < 60) {
			image = imageMitte;
		}
		if (spritecounter > 60 & spritecounter < 80) {
			image = imageRechts;
		}
		if (spritecounter > 80 & spritecounter < 100) {
			image = imageMitte;
		}
		
		if (spritecounter > 100) {
			spritecounter = 0;
		}
	 }
	}
}
