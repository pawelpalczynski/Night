package entity;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import component.CHealth;
import component.CImageRender;
import component.CPhysics;

public class Zombie extends Entity {

	public Zombie(String id) throws SlickException {
		super(id);
		this.addComponent(new CImageRender("image", new Image("data/images/zombie.png")));
		this.addComponent(new CPhysics("physics"));
		this.addComponent(new CHealth("health"));
		this.setPosition(new Vector2f(500f, 600f));
	}

}