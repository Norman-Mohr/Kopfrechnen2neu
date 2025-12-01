package keyhandler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

	public boolean keyPressed;
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_ENTER) {
			keyPressed = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_ENTER) {
			keyPressed = false;
		}
		
	}

}
