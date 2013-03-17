package entity;

import org.jbox2d.dynamics.BodyType;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import component.CColidable;
import component.CHealth;
import component.CJBox2D;
import component.CLifeTime;
import component.renderable.CImageRender;

public class Bullet extends Entity {

	float direction;
	float speed;
	
	public Bullet(float x, float y, float speed, float direction) throws SlickException {
		this.id = "Bullet";
		
		this.speed = speed;
		this.direction = direction;
		this.rotation = direction;
		
		this.addComponent(new CImageRender(new Image("data/images/shot.png")));
		this.addComponent(new CColidable(10f));
		this.addComponent(new CHealth(1));
		this.addComponent(new CLifeTime(1500));
		
		this.addComponent(new CJBox2D(x, y, BodyType.DYNAMIC, CJBox2D.CIRCLE, -1));
	}

	public float getSpeed() {
		return speed;
	}


	public float getDirection() {
		return direction;
	}

}