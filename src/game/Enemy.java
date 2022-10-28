package game;

import java.awt.*;
import java.util.Random;

public class Enemy {
	int enemy_x;
	int enemy_y;
	int enemy_width;
	int enemy_length;
	int enemy_speed;

	public Enemy() {
		
		Random  rd = new Random();
		enemy_width = 30;
		enemy_length = 30;
		enemy_x = rd.nextInt(800-30);
		enemy_y = 0;
		enemy_speed = 8;
	}
	
	public void addEnemy() {
		
	}
	
	public void drawEnemy(Graphics g) {
		g.setColor(Color.yellow);
		g.drawOval(enemy_x, enemy_y, enemy_width, enemy_length);
		g.fillOval(enemy_x, enemy_y, enemy_width, enemy_length);
	}

	public void move(Player py) {
		if(py.player_x > enemy_x && py.player_y < enemy_y) {
			enemy_y -= enemy_speed;
			enemy_x += enemy_speed;
		}
		else if(py.player_x > enemy_x && py.player_y > enemy_y) {
			enemy_y += enemy_speed;
			enemy_x += enemy_speed;
		}
		else if(py.player_x < enemy_x && py.player_y > enemy_y) {
			enemy_y += enemy_speed;
			enemy_x -= enemy_speed;
		}
		else if(py.player_x < enemy_x && py.player_y < enemy_y) {
			enemy_y -= enemy_speed;
			enemy_x -= enemy_speed;
		}
		else if(py.player_x == enemy_x && py.player_y > enemy_y) {
			enemy_y -= enemy_speed;
		}
		else if(py.player_x == enemy_x && py.player_y < enemy_y) {
			enemy_y += enemy_speed;
		}
		else if(py.player_x > enemy_x && py.player_y == enemy_y) {
			enemy_x += enemy_speed;
		}
		else if(py.player_x < enemy_x && py.player_y == enemy_y) {
			enemy_x -= enemy_speed;
		}
	}
	public boolean shootBy(Bullets f) {
		boolean hit = (f.bullet_x + 10 >= enemy_x &&
				      enemy_x + enemy_width >= f.bullet_x) &&
				      (f.bullet_y <= enemy_y + enemy_width &&
				      f.bullet_y + f.bullet_radius >= enemy_y);
		//System.out.println(f.bullet_x+ " " + f.bullet_y + " " + f.bullet_radius);
		//boolean hit = Math.sqrt(Math.pow(bullet.Bullets_x() + bullet.Bullets_w() - enemy_x + 15, 2) + Math.pow(bullet.Bullets_y() + bullet.Bullets_w() -  enemy_y + 15, 2)) <= 15 + bullet.Bullets_w();
		return hit;
	}

	public boolean hitBy(Player f) {
		boolean hit = (f.player_x + f.player_radius >= enemy_x &&
			      enemy_x + enemy_width >= f.player_x) &&
			      (f.player_y <= enemy_y + enemy_width &&
			      f.player_y + f.player_radius >= enemy_y);
		//boolean hit = Math.sqrt(Math.pow(bullet.Bullets_x() + bullet.Bullets_w() - enemy_x + 15, 2) + Math.pow(bullet.Bullets_y() + bullet.Bullets_w() -  enemy_y + 15, 2)) <= 15 + bullet.Bullets_w();
		return hit;
	}
}