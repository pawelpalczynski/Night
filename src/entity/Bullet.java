package entity;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import component.CColidable;
import component.CDisposable;
import component.CHealth;
import component.movement.CFlyStraight;
import component.renderable.CImageRender;

public class Bullet extends Entity {

	float direction;
	float speed;
	
	public Bullet(float speed, float direction) throws SlickException {
		this.id = "Bullet";
		
		this.speed = speed;
		this.direction = direction;
		this.rotation = direction;
		
		this.addComponent(new CImageRender(new Image("data/images/shot.png")));
		this.addComponent(new CFlyStraight(this.getDirection(), this.speed));
		this.addComponent(new CDisposable());
		this.addComponent(new CColidable());
		this.addComponent(new CHealth(1));
	}

	public float getSpeed() {
		return speed;
	}


	public float getDirection() {
		return direction;
	}

}