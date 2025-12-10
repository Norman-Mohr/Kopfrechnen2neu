package info;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import kopfrechnen2.MainPanel;
import kopfrechnen2.OutputPanel;

public class Lives {

	OutputPanel op;
	MainPanel mp;
	BufferedImage image;
	int x, y;
	public int livesPlayer = 5;
	public boolean gameover = false;
	private boolean weiter = true;
	private boolean runnable = false;

	public Lives(OutputPanel op, MainPanel mp) {
		this.op = op;
		this.mp = mp;

	}

	public Lives(int x, int y) {
		this.x = x;
		this.y = y;
		getImage();
	}

	public void drawLives(Graphics2D d2g) {
		for (int l = 0; l < op.live.livesPlayer; l++) {
			if (op.lives[l] != null) {
				op.lives[l].draw(d2g);
			}
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

		for (int col = 0; col < op.lives.length; col++) {
			this.x = col * 45 + 210;
			this.y = 20;
			op.lives[col] = new Lives(this.x, this.y);

		}
	}

	public void drawGameOver(Graphics2D d2g) {

		if (gameover) {
			d2g.setFont(new Font("Arial", 3, 100));
			d2g.setColor(Color.cyan);
			d2g.drawString("Game Over", 80, 200);
		}
	}

	public void update() {

		if(weiter) {
		if (op.live.livesPlayer == 0) {
			gameover = true;
			weiter = false;
			runnable = true;
			 
		 }
		}

		if (runnable) {
			runnable  = false;
			 
			Runnable myRunnable = new Runnable() {

				@Override
				public void run() {

					op.remove(op);
					op.removeAll();
					op.invalidate();
					op.punkteGesammt();
					op.entity.active = false;
					op.entity.x = 80;
					op.entity.y = 80;
					op.entity.width = 480;
					op.entity.heigth = 210;
				 
				 
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
					op.timer.stop();
                    
					op.setVisible(false);
					mp.ap.setVisible(true);
					op.live.livesPlayer = 5;
					weiter = true;
					gameover = false;
					 

				}

			};

			Thread thread = new Thread(myRunnable);
			thread.start();
		}
	}
}
