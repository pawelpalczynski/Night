package entity;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import component.ImageRenderComponent;

public class Zombie extends Entity {

	public Zombie(String id) throws SlickException {
		super(id);
		this.addComponent(new ImageRenderComponent("image", new Image("data/images/zombie.png")));
		this.setPosition(new Vector2f(500f, 600f));
	}

}
