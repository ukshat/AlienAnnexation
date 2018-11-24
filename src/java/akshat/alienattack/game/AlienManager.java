package akshat.alienattack.game;

import java.awt.Graphics;

import akshat.alienattack.Coordinator;
import akshat.alienattack.game.alien.*;

public class AlienManager {

	private static Alien[] aliens = new Alien[10];

	public static void create(Ship target){
		if(Math.random()>0.05) return; 

		for(int i=0; i<aliens.length; i++){
			if(aliens[i]==null){
				int x = (int)(Math.random()*Coordinator.SCREEN_WIDTH);
				int y = 0;
				int vx = (int)(Math.random()*11-5);
				int vy = (int)(Math.random()*5+3);
				//Color bodyColor = new Color((int)(Math.random()*200), (int)(Math.random()*200), (int)(Math.random()*200));
				//int grayScale = (int)(Math.random()*150);
				//Color eyeColor = new Color(grayScale, grayScale, grayScale);
//				int rand = (int)(Math.random()*images.length);

//				aliens[i] = new CloningAlien(x, y, vx, vy, target);

				double rand2 = Math.random();

				if(rand2>8.0/9) aliens[i] = new MultiShootAlien(x, y, vx, vy, target);
				else if(rand2>7.0/9) aliens[i] = new InvisibleAlien(x, y, vx, vy, target);
				else if(rand2>6.0/9) aliens[i] = new CloakAlien(x, y, vx, vy, target);
				else if(rand2>5.0/9) aliens[i] = new CloningAlien(x, y, vx, vy, target);
				else if(rand2>4.0/9) aliens[i] = new RealNastyAlien(x, y, vx, vy, target);
				else if(rand2>3.0/9) aliens[i] = new NastyAlien(x, y, vx, vy, target);
				else if(rand2>2.0/9) aliens[i] = new ImmortalAlien(x, y, vx, vy, target);
				else aliens[i] = new SimpleAlien(x, y, vx, vy, null, target);

				break;
			}
		}

	}


	public static void remove(Alien alien){ 
		for(int i=0; i<aliens.length; i++){
			if(aliens[i]==alien){
				aliens[i] = null;
				break;
			}
		}
	}


	public static boolean isHit(Torpedo torpedo){
		
		for(int i=0; i<aliens.length; i++){
			if(aliens[i]!=null && aliens[i].isHit(torpedo)) return true;
		}
		return false;
	}


	public static void move(){
		for(int i=0; i<aliens.length; i++){ 
			if(aliens[i]!=null) aliens[i].move();
		}

	}


	public static void draw(Graphics canvas){
		for(int i=0; i<aliens.length; i++){ 
			if(aliens[i]!=null) aliens[i].draw(canvas); 
		}
	}


	public static void add(Alien alien) {

		for(int i=0; i<aliens.length; i++){
			if(aliens[i]==null){
				aliens[i] = alien;
				break;
			}
		}
	}
}
