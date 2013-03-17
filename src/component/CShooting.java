package component;

import message.CMessage;
import message.Message;

import org.jbox2d.common.Vec2;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import entity.Bullet;
import entity.EntityContainer;

public class CShooting extends Component {
	
	int weapon = 1;
	CJBox2D jboxPlayer;
	float speed;
	float direction;
	
	public CShooting(float speed) {
        this.id = "Shooting";
        this.speed = speed;
    }

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) throws SlickException {
		Input input = gc.getInput();
		
		if (input.isKeyPressed(Input.KEY_1)) weapon = 1;
		if (input.isKeyPressed(Input.KEY_2)) weapon = 2;
		
		if (weapon == 1){
			if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
				addBullet();
			}
		} else {
			if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
				addBullet();
			}
		}
		
	}
	
	private void addBullet() throws SlickException {
		Bullet bullet = new Bullet(-100, -100, 1f, owner.getRotation());
		CJBox2D jbox = (CJBox2D) bullet.getComponent("JBox2D");
		
		jbox.getBody().setBullet(true);
		jbox.getBody().getPosition().x = (float) ((owner.getCenter().x + (1/2f) * owner.getWidth() * Math.sin(Math.toRadians(owner.getRotation()))) - bullet.getWidth()/2f)*EntityContainer.SlickToJBox2D;
		jbox.getBody().getPosition().y = (float) ((owner.getCenter().y - (1/2f) * owner.getHeight() * Math.cos(Math.toRadians(owner.getRotation()))) - bullet.getHeight()/2f)*EntityContainer.SlickToJBox2D;
		jbox.getBody().setLinearVelocity(new Vec2( (float) (speed*Math.sin(Math.toRadians(owner.getRotation())))*EntityContainer.SlickToJBox2D, (float) -(speed*Math.cos(Math.toRadians(owner.getRotation())))*EntityContainer.SlickToJBox2D));
		EntityContainer.addEntity(bullet);
	}

	@Override
	public void readMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readMessage(CMessage message) {
		if (message.getText() == "ComponentAdded") {
			if (message.getSource().getId() == "JBox2D") {
				jboxPlayer = (CJBox2D) message.getSource();
			}
		}
		
	}

	@Override
	public void setDependencies() {
		if (owner.getComponent("JBox2D") != null) jboxPlayer = (CJBox2D) owner.getComponent("JBox2D");
	}

}