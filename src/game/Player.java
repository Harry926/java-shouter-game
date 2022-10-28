package game;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
	public int player_hp=3;
	public int player_x;
	public int player_y;
	public int player_radius;
	private int player_speed=5;
	private GameInterface game;
	public boolean dir_up=false,dir_down=false,dir_left=false,dir_right=false;
	
	
	public Player(GameInterface game,int player_x, int player_y, int player_radius) {
		this.game = game;
		this.player_x = player_x;
		this.player_y = player_y;
		this.player_radius = player_radius;
	}
	public void drawPlayer(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawOval(player_x, player_y, player_radius*2, player_radius*2);
		g.fillOval(player_x, player_y, player_radius*2, player_radius*2);
		
		if(dir_up) {
			g.drawRect(player_x+player_radius-2, player_y-player_radius, 4, 50);
			g.fillRect(player_x+player_radius-2, player_y-player_radius, 4, 50);
		}
		else if(dir_down) {
			g.drawRect(player_x+player_radius-2, player_y+player_radius, 4, 50);
			g.fillRect(player_x+player_radius-2, player_y+player_radius, 4, 50);
		}
		else if(dir_left) {
			g.drawRect(player_x-player_radius, player_y+player_radius-2, 50, 4);
			g.fillRect(player_x-player_radius, player_y+player_radius-2, 50, 4);
		}
		else if(dir_right) {
			g.drawRect(player_x+player_radius, player_y+player_radius-2, 50, 4);
			g.fillRect(player_x+player_radius, player_y+player_radius-2, 50, 4);
		}
		
	}
	
	// 玩家的移動
	public void move() {
		if(dir_up) {
			this.player_y-=player_speed;
		}
		else if(dir_down) {
			this.player_y+=player_speed;
		}
		else if(dir_left) {
			this.player_x-=player_speed;
		}
		else if(dir_right) {
			this.player_x+=player_speed;
		}
	}
	//發射子彈
	public void shootBullets() {
		if(dir_up) {
			addBullets("UP");
		}
		else if(dir_down) {
			addBullets("DOWN");
		}
		else if(dir_left) {
			addBullets("LEFT");
		}
		else if(dir_right) {
			addBullets("RIGHT");
		}
	}
	//增加子彈
	public void addBullets(String dir) {
		if(dir.equals("UP")) {
			Bullets bullet = new Bullets(dir, player_x+player_radius-5/2, player_y, 5);
			this.game.bullets.add(bullet);
		}
		else if(dir.equals("DOWN")) {
			Bullets bullet = new Bullets(dir, player_x+player_radius-5/2, player_y, 5);
			this.game.bullets.add(bullet);
		}
		else if(dir.equals("LEFT")) {
			Bullets bullet = new Bullets(dir, player_x, player_y+player_radius-5/2, 5);
			this.game.bullets.add(bullet);
		}
		else if(dir.equals("RIGHT")) {
			Bullets bullet = new Bullets(dir, player_x, player_y+player_radius-5/2, 5);
			this.game.bullets.add(bullet);
		}
	}
}
