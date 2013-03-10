package entity;

import component.DisposableComponent;
import component.FlyStraightComponent;
import component.PrimitiveRenderComponent;

public class Bullet extends Entity {

	float direction;
	float speed;
	
	public Bullet(String id){
		super(id);

		this.addComponent(new PrimitiveRenderComponent("render"));
	}
	
	public Bullet(String id, float speed, float direction) {
		super(id);
		
		setSpeed(speed);
		setDirection(direction);
		
		this.addComponent(new PrimitiveRenderComponent("render"));
		this.addComponent(new FlyStraightComponent("flying", this.getDirection(), this.speed));
		this.addComponent(new DisposableComponent("disposable"));
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