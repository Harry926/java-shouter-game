package game;

import java.awt.event.*;

public class ListerPlayer extends KeyAdapter{
	
	public GameInterface game;
	
	public ListerPlayer(GameInterface game) {
		this.game = game;
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			this.game.player.dir_up = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			this.game.player.dir_down = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			this.game.player.dir_left = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			this.game.player.dir_right = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			this.game.player.dir_up = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			this.game.player.dir_down = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			this.game.player.dir_left = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			this.game.player.dir_right = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			this.game.player.shootBullets();
		}
	}
}
