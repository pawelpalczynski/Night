package entity;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import component.CHealth;
import component.CImageRender;
import component.CPhysics;
import component.CShooting;
import component.CTopDownMovement;

public class Player extends Entity {
	
	public Player(String id) throws SlickException {
		super(id);
		this.addComponent(new CImageRender("image", new Image("data/images/player.png")));
		this.addComponent(new CTopDownMovement("movement"));
		this.addComponent(new CPhysics("physics"));
		this.addComponent(new CShooting("shooting"));
		this.addComponent(new CHealth("health"));
		this.setPosition(new Vector2f(300f, 400f));
	}
}