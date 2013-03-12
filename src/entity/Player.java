package entity;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import component.CColidable;
import component.CHealth;
import component.CPhysics;
import component.CShooting;
import component.movement.CTopDownMovement;
import component.renderable.CAnimationRender;

public class Player extends Entity {
	
	public Player() throws SlickException {
		this.id = "Player";
		this.addComponent(new CAnimationRender("data/images/player_walk_sheet.png", 30, 46, 20, 30, 0));
		this.addComponent(new CPhysics());
		this.addComponent(new CTopDownMovement());
		this.addComponent(new CShooting());
		this.addComponent(new CColidable());
		this.addComponent(new CHealth());
		this.setPosition(new Vector2f(300f, 400f));
		this.layer = 3;
	}
}