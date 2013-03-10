package component;

import message.Message;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;
 
import component.Component;
 
public class CTopDownMovement extends Component {
 
    float direction;
    float speed;
    
    float rotation;
    Vector2f position;
    Vector2f velocity;
    float width;
    float height;
    
    public CTopDownMovement( String id ) {
        this.id = id;
        position = new Vector2f(0, 0);
        velocity = new Vector2f(0, 0);
        width = 1;
        height = 1;
        rotation = 0;
    }
     
    @Override
    public void update(GameContainer gc, StateBasedGame sb, int delta) {
         
        float rotation = owner.getRotation();
        float scale = owner.getScale();
        Vector2f position = owner.getPosition();
        Vector2f velocity = owner.getVelocity();
        float width = gc.getWidth();
        float height = gc.getHeight();
                 
        Input input = gc.getInput();
        
        /**
         * Movement control
         */
        if (input.isKeyDown(Input.KEY_A)) {
            rotation += -0.2f * delta;
        } else if(input.isKeyDown(Input.KEY_D)) {
            rotation += 0.2f * delta;
        }

        if (input.isKeyDown(Input.KEY_W)) {
  
            velocity.x += 0.4f * java.lang.Math.sin(java.lang.Math.toRadians(rotation));
            velocity.y -= 0.4f *java.lang.Math.cos(java.lang.Math.toRadians(rotation));
        } else if (input.isKeyDown(Input.KEY_S)) {
  
            velocity.x -= 0.4f * java.lang.Math.sin(java.lang.Math.toRadians(rotation));
            velocity.y += 0.4f *java.lang.Math.cos(java.lang.Math.toRadians(rotation));
        }
        
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
  
        getOwnerEntity().setPosition(position);
        getOwnerEntity().setRotation(rotation);
        getOwnerEntity().setScale(scale);
    }

	@Override
	public void readMessage(Message message) {
		
	}
	
	public float getSpeed() {
        return speed;
    }
     
    public float getDirection() {
        return direction;
    }

	public Vector2f getPosition() {
		return position;
	}

	public void setPosition(Vector2f position) {
		this.position = position;
	}

	public Vector2f getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2f velocity) {
		this.velocity = velocity;
	}

	public float getRotation() {
		return rotation;
	}

	public void setRotation(float rotation) {
		this.rotation = rotation;
	}
 
}