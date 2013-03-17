package entity;

import org.jbox2d.dynamics.BodyType;
import org.newdawn.slick.SlickException;

import component.CColidable;
import component.CHealth;
import component.CJBox2D;
import component.CShooting;
import component.movement.CTopDownMovement;
import component.renderable.CAnimationRender;
import component.renderable.CHealthDisplay;

public class Player extends Entity {
	
	public Player() throws SlickException {
		this.id = "Player";
		this.addComponent(new CAnimationRender("data/images/player_walk_sheet.png", 30, 46, 20, 30, 0));
		this.addComponent(new CHealthDisplay());
		this.addComponent(new CTopDownMovement());
		this.addComponent(new CShooting(2000f));
		this.addComponent(new CColidable());
		this.addComponent(new CHealth());
		
		this.addComponent(new CJBox2D(512f, 384f, BodyType.DYNAMIC, CJBox2D.CIRCLE, -1));
		
		this.layer = 3;
	}
}