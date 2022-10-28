package game;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class GameInterface extends JPanel {
	public GameInterface game ;
	public JFrame game_jfram = new JFrame();
	public Player player = new Player(this, 100, 100, 25);
	
	ArrayList<Enemy> enemys = new ArrayList<Enemy>();
	ArrayList<Bullets> bullets = new ArrayList<>();
	public int score;
	public boolean gameover;
	
	public void action() {
		new Thread() {
			public void run() {
				while(true) {
					if(!gameover) {
						addEnemy();
						EnemyMove();
						hitPlayer();
					}
					try {
						Thread.sleep(200-score*5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					repaint();
				}
			}
		}.start();
	}

	public GameInterface() {
		game_jfram.setSize(800, 600);
		game_jfram.setLayout(null);
		game_jfram.setLocationRelativeTo(null);
		game_jfram.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		game_jfram.setResizable(false);
		
		ListerPlayer listerplayer = new ListerPlayer(this);
		game_jfram.addKeyListener(listerplayer);
		
		this.setSize(800, 600);
		this.setLayout(null);
		this.setBackground(Color.pink);
		this.action();
		
		game_jfram.add(this);
		game_jfram.setVisible(true);
		
		MouseAdapter adapter = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(gameover) {
					gameover = false;
					player.player_hp=3;
					score = 0;
				}
			}
		};
		addMouseListener(adapter);
		
		new Thread() {
			public void run() {
				while(true) {
					try {
						player.move();
						sleep(20);
					} catch (Exception e) {
						
					}
				}
			}
		}.start();
		
		new Thread() {
			public void run() {
				while(true) {
					try {
						hitPlayer();
						shootEnemy();
						sleep(0);
					} catch (Exception e) {
						
					}
				}
			}
		}.start();
	}
	public void paint(Graphics g){
		super.paint(g);
		player.drawPlayer(g);
		
		for(int i=0;i<bullets.size();i++) {
			Bullets bullet = bullets.get(i);
			bullet.drawBullets(g);
		}
		for(int i=0;i<enemys.size();i++) {
			Enemy em = enemys.get(i);
			em.drawEnemy(g);
		}
		g.setColor(Color.white);
		g.setFont(new Font("標楷體",Font.BOLD,20));
		g.drawString("分數:"+score, 10, 30);
		
		for(int i=0;i<player.player_hp;i++) {
			g.setFont(new Font("標楷體",Font.BOLD,20));
			g.drawString("血量:", 10, 50);
			g.drawOval(65+i*15,40,10,10);
			g.fillOval(65+i*15,40,10,10);
		}
		
		
		if(gameover) {
			g.setColor(Color.red);
			g.setFont(new Font("標楷體",Font.BOLD,50));
			g.drawString("GAMEOVER", 275, 275);
		}
		repaint();
	}
	
	
	int addEnemy_index = 0;
	public void addEnemy() {
		addEnemy_index++;
		if(addEnemy_index>=10) {
			Enemy enemy = new Enemy();
			enemys.add(enemy);
			addEnemy_index = 0;
		}
	}
	public void EnemyMove() {
		for(int i=0;i<enemys.size();i++) {
			Enemy e = enemys.get(i);
			e.move(player);
		}
	}
	public void shootEnemy() {
		for(int i=0;i<bullets.size();i++) {
			Bullets bullet = bullets.get(i);
			Bang(bullet);
		}
	}
	public void Bang(Bullets bullet) {
		for(int i=0;i<enemys.size();i++) {
			Enemy en = enemys.get(i);
			if(en.shootBy(bullet)) {
				enemys.remove(en);
				bullets.remove(bullet);
				score +=1;
			}
		}
	}
	public void hitPlayer() {
		for(int i=0;i<enemys.size();i++) {
			Enemy ene = enemys.get(i);
			if(ene.hitBy(player)) {
				player.player_hp--;
				enemys.remove(ene);
				if(player.player_hp<=0) {
					gameover = true;
				}
			}
		}
	}
}
