package game;

import java.awt.Color;
import java.awt.Graphics;

public class Bullets {
	public int bullet_x;
	public int bullet_y;
	public int bullet_radius;
	private int speed = 1;
	private String bullet_dir;
	public Bullets(String bullet_dir,int bullet_x,int bullet_y,int bullet_radius) {
		this.bullet_dir = bullet_dir;
		this.bullet_x = bullet_x;
		this.bullet_y = bullet_y;
		this.bullet_radius = bullet_radius;
		
	}
	//µe¤l¼u
	public void drawBullets(Graphics g) {
		g.setColor(Color.blue);
		if(bullet_dir.equals("UP")){
			g.drawOval(bullet_x, bullet_y-=speed, bullet_radius*2, bullet_radius*2);
			g.fillOval(bullet_x, bullet_y-=speed, bullet_radius*2, bullet_radius*2);
		}
		else if(bullet_dir.equals("DOWN")) {
			g.drawOval(bullet_x, bullet_y+=speed, bullet_radius*2, bullet_radius*2);
			g.fillOval(bullet_x, bullet_y+=speed, bullet_radius*2, bullet_radius*2);
		}
		else if(bullet_dir.equals("LEFT")) {
			g.drawOval(bullet_x-=speed, bullet_y, bullet_radius*2, bullet_radius*2);
			g.fillOval(bullet_x-=speed, bullet_y, bullet_radius*2, bullet_radius*2);
		}
		else if(bullet_dir.equals("RIGHT")) {
			g.drawOval(bullet_x+=speed, bullet_y, bullet_radius*2, bullet_radius*2);
			g.fillOval(bullet_x+=speed, bullet_y, bullet_radius*2, bullet_radius*2);
		}
	}
}
