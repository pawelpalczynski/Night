package entity;

import component.CColidable;
import component.CDisposable;
import component.CHealth;
import component.movement.CFlyStraight;
import component.renderable.CPrimitiveRender;

public class Bullet extends Entity {

	float direction;
	float speed;
	
	public Bullet(String id, float speed, float direction) {
		super(id);
		
		setSpeed(speed);
		setDirection(direction);
		
		this.addComponent(new CPrimitiveRender());
		this.addComponent(new CFlyStraight(this.getDirection(), this.speed));
		this.addComponent(new CDisposable());
		this.addComponent(new CColidable());
		this.addComponent(new CHealth(1));
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}


	public float getDirection() {
		return direction;
	}


	public void setDirection(float direction) {
		this.direction = direction;
	}
}