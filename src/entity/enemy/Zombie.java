package entity.enemy;

import org.jbox2d.dynamics.BodyType;
import org.newdawn.slick.SlickException;

import component.CColidable;
import component.CHealth;
import component.CJBox2D;
import component.AI.CChaseAI;
import component.renderable.CAnimationRender;
import component.renderable.CHealthDisplay;

public class Zombie extends Enemy {

	public Zombie(float x, float y) throws SlickException {
		this.id = "Zombie";
		this.addComponent(new CAnimationRender("data/images/zombie_walk_sheet.png", 56, 94, 70, 180, -90));
		this.addComponent(new CHealthDisplay());
		this.addComponent(new CHealth());
		this.addComponent(new CColidable());
		this.addComponent(new CChaseAI());
		this.addComponent(new CJBox2D(x, y, BodyType.DYNAMIC, CJBox2D.CIRCLE));
		this.layer = 2;
	}
}