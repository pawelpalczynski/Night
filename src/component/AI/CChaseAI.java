package component.AI;

import org.jbox2d.common.Vec2;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class CChaseAI extends CAI {
	
	Vector2f direction = new Vector2f();
	Vector2f center;
	float speed = 3f;
	
	public CChaseAI(){
		this.id = "AIChase";
		this.velocity = new Vector2f(0, 0);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta){
		center = owner.getCenter();
		direction.set(player.getPosition().x - center.x, player.getPosition().y - center.y);
		
		owner.setRotation((float) direction.getTheta() + 180);
		
		velocity.set(1f, 1f);
		velocity.setTheta(direction.getTheta());
		velocity.scale(speed);
		
		jbox.getBody().setLinearVelocity(new Vec2(velocity.x, velocity.y));
	}
}
