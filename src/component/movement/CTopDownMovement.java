package component.movement;

import message.CMessage;
import message.Message;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import component.CPhysics;
  
public class CTopDownMovement extends CMovement {
	
	CPhysics physics = new CPhysics();
    
    public CTopDownMovement() {
        this.id = "TopDownMovement";
        this.velocity = new Vector2f(0, 0);
    }
    
    public void setDependencies(){
    	this.physics = (CPhysics) owner.getComponent("Physics");
    }
     
    @Override
    public void update(GameContainer gc, StateBasedGame sb, int delta) {
    	
    	this.velocity = physics.getVelocity();
        float rotation = owner.getRotation();
        Vector2f position = owner.getPosition();
        Vector2f center = owner.getCenter();
        float width = gc.getWidth();
        float height = gc.getHeight();
                 
        Input input = gc.getInput();
        
        /**
         * Movement control
         */
        if (input.isKeyDown(Input.KEY_A)) {
            velocity.x -= 0.4f;
        } else if(input.isKeyDown(Input.KEY_D)) {
        	velocity.x += 0.4f;
        }

        if (input.isKeyDown(Input.KEY_W)) {
            velocity.y -= 0.4f;
        } else if (input.isKeyDown(Input.KEY_S)) {
            velocity.y += 0.4f;
        }
        
        rotation = (float) Math.toDegrees(Math.atan2(-(input.getMouseX() - center.getX()), (input.getMouseY() - center.getY()))) + 180;
        
        /**
         * Boundary conditions
         */
        if (position.x < 0){
        	position.x = width;
        } else if (position.x > width){
        	position.x = 0;
        }
        
        if (position.y < 0){
        	position.y = height;
        } else if (position.y > height){
        	position.y = 0;
        }
  
        owner.setPosition(position);
        owner.setRotation(rotation);
    }

	@Override
	public void readMessage(Message message) {
		
	}

	@Override
	public void readMessage(CMessage message) {
		if (message.getText() == "ComponentAdded"){
			if (message.getSource().getId() == "Physics"){
				this.physics = (CPhysics) message.getSource();
			}
		}
		
	}
 
}