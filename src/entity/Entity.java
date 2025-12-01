package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import kopfrechnen2.OutputPanel;

public class Entity {

OutputPanel op;
	
	BufferedImage image, SchildkroeteLinks, SchildkroeteRechts, SchildkroeteMitte;
	BufferedImage Schnecke1, Schnecke2, Schnecke3;
	BufferedImage imageSchnecke;
	int width = 100;
	int heigth = 50;
	public int spritecounter;
	public double x=20, y=360;
	public boolean collisionEntity = false;
	
	public Entity(OutputPanel op) {
		this.op = op;
		getImage();
	}
	
	 
	public void drawEntity(Graphics2D d2g) {
		d2g.drawImage(image, (int) x,(int) y, width, heigth, this.op);
	}
	
	public void getImage() {
		try {
			 
			SchildkroeteLinks = ImageIO.read(getClass().getResourceAsStream("/picture/SchildkröteLinks.png"));
			SchildkroeteRechts = ImageIO.read(getClass().getResourceAsStream("/picture/SchildkröteRechts.png"));
			SchildkroeteMitte = ImageIO.read(getClass().getResourceAsStream("/picture/SchildkröteMitte.png"));
			
			Schnecke1 = ImageIO.read(getClass().getResourceAsStream("/picture/Schnecke1.png"));
			Schnecke2 = ImageIO.read(getClass().getResourceAsStream("/picture/Schnecke2.png"));
			Schnecke3 = ImageIO.read(getClass().getResourceAsStream("/picture/Schnecke3.png"));
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
		
	if(op.level==1) {	 
		if (spritecounter < 20) {
			image = Schnecke1; 
		}
		if (spritecounter > 40 & spritecounter < 60) {
			image = Schnecke2;
		}
		if (spritecounter > 60 & spritecounter < 80) {
			image = Schnecke3;
		}
		if (spritecounter > 80 & spritecounter < 100) {
			image = Schnecke2;
		}
		
		if (spritecounter > 100) {
			spritecounter = 0;
		}
	   }
	if(op.level==2) {	
		if (spritecounter < 20) {
			image = SchildkroeteLinks;
		}
		if (spritecounter > 40 & spritecounter < 60) {
			image = SchildkroeteMitte;
		}
		if (spritecounter > 60 & spritecounter < 80) {
			image = SchildkroeteRechts;
		}
		if (spritecounter > 80 & spritecounter < 100) {
			image = SchildkroeteMitte;
		}
		
		if (spritecounter > 100) {
			spritecounter = 0;
		}
	}
 }
	}
}
