package component.movement;

import message.CMessage;
import message.Message;

import org.jbox2d.common.Vec2;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import component.CJBox2D;
import entity.EntityContainer;
  
public class CTopDownMovement extends CMovement {
	
	CJBox2D jbox;
	private float speed = 10f;
    
    public CTopDownMovement() {
        this.id = "TopDownMovement";
    }
    
    @Override
	public void setDependencies(){
    	if (owner.getComponent("JBox2D") != null) this.jbox = (CJBox2D) owner.getComponent("JBox2D");
    }
     
    @Override
    public void update(GameContainer gc, StateBasedGame sb, int delta) {
    	Vector2f center = owner.getCenter();
    	                 
        Input input = gc.getInput();
        
        
        /**
         * Movement control
         */
        jbox.getBody().setLinearVelocity(new Vec2(0f, 0f));
        if (input.isKeyDown(Input.KEY_A)) {
        	jbox.getBody().m_linearVelocity.x = -speed;
        } else if(input.isKeyDown(Input.KEY_D)) {
        	jbox.getBody().m_linearVelocity.x = +speed;
        }

        if (input.isKeyDown(Input.KEY_W)) {
        	jbox.getBody().m_linearVelocity.y = -speed;
        } else if (input.isKeyDown(Input.KEY_S)) {
        	jbox.getBody().m_linearVelocity.y = +speed;
        }
        
        if (input.isKeyDown(Input.KEY_E)) jbox.getBody().applyTorque(2f);
        
        float rotation = (float) Math.toDegrees(Math.atan2(-(input.getMouseX() + EntityContainer.ViewX - center.getX()), (input.getMouseY() + EntityContainer.ViewY - center.getY()))) + 180;
        owner.setRotation(rotation);
    }

	@Override
	public void readMessage(Message message) {
		
	}

	@Override
	public void readMessage(CMessage message) {
		if (message.getText() == "ComponentAdded"){
			if (message.getSource().getId() == "JBox2D"){
				this.jbox = (CJBox2D) message.getSource();
			}
		}
		
	}
 
}