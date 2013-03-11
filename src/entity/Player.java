package entity;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import component.CHealth;
import component.CPhysics;
import component.CShooting;
import component.movement.CTopDownMovement;
import component.renderable.CImageRender;

public class Player extends Entity {
	
	public Player(String id) throws SlickException {
		super(id);
		this.addComponent(new CImageRender("image", new Image("data/images/player.png")));
		this.addComponent(new CPhysics());
		this.addComponent(new CTopDownMovement());
		this.addComponent(new CShooting());
		this.addComponent(new CHealth());
		this.setPosition(new Vector2f(300f, 400f));
	}
}