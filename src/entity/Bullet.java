package entity;

import component.CColidable;
import component.CDisposable;
import component.CFlyStraight;
import component.renderable.CPrimitiveRender;

public class Bullet extends Entity {

	float direction;
	float speed;
	
	public Bullet(String id){
		super(id);

		this.addComponent(new CPrimitiveRender("render"));
	}
	
	public Bullet(String id, float speed, float direction) {
		super(id);
		
		setSpeed(speed);
		setDirection(direction);
		
		this.addComponent(new CPrimitiveRender("render"));
		this.addComponent(new CFlyStraight("flying", this.getDirection(), this.speed));
		this.addComponent(new CDisposable("disposable"));
		this.addComponent(new CColidable());
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