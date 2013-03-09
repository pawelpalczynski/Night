package entity;

import java.util.List;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import component.ImageRenderComponent;
import component.TopDownMovement;

public class Player extends Entity {

	List<Entity> bullets;
	
	public Player(String id) throws SlickException {
		super(id);
		this.addComponent(new ImageRenderComponent("image", new Image("data/images/player.png")));
		this.addComponent(new TopDownMovement("movement"));
		this.setPosition(new Vector2f(300f, 400f));
	}
	
	

}
