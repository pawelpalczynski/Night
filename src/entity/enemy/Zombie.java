package entity.enemy;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Vector2f;

import component.CColidable;
import component.CHealth;
import component.CPhysics;
import component.AI.CChaseAI;
import component.renderable.CAnimationRender;
import component.renderable.CImageRender;

public class Zombie extends Enemy {

	public Zombie() throws SlickException {
		this.id = "Zombie";
		//SpriteSheet sheet = new SpriteSheet("data/images/zombie_walk_sheet.png", 56, 94, 70);
		this.addComponent(new CImageRender(new Image("data/images/zombie.png")));
		//this.addComponent(new CAnimationRender(sheet));
		this.addComponent(new CPhysics());
		this.addComponent(new CHealth());
		this.addComponent(new CColidable());
		this.addComponent(new CChaseAI());
		this.setPosition(new Vector2f(500f, 300f));
		this.layer = 2;
	}
}