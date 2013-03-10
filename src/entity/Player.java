package entity;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import component.ImageRenderComponent;
import component.ShootingComponent;
import component.TopDownMovement;

public class Player extends Entity {
	
	public Player(String id) throws SlickException {
		super(id);
		this.addComponent(new ImageRenderComponent("image", new Image("data/images/player.png")));
		this.addComponent(new TopDownMovement("movement"));
		this.addComponent(new ShootingComponent("shooting"));
		this.setPosition(new Vector2f(300f, 400f));
	}
}