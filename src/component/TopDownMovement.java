package component;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;
 
import component.Component;
 
public class TopDownMovement extends Component {
 
    float direction;
    float speed;
     
    public TopDownMovement( String id ) {
        this.id = id;
    }
     
    public float getSpeed() {
        return speed;
    }
     
    public float getDirection() {
        return direction;
    }
     
    @Override
    public void update(GameContainer gc, StateBasedGame sb, int delta) {
         
        float rotation = getOwnerEntity().getRotation();
        float scale = getOwnerEntity().getScale();
        Vector2f position = getOwnerEntity().getPosition();
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
            float hip = 0.4f * delta;
  
            position.x += hip * java.lang.Math.sin(java.lang.Math.toRadians(rotation));
            position.y -= hip *java.lang.Math.cos(java.lang.Math.toRadians(rotation));
        } else if (input.isKeyDown(Input.KEY_S)) {
            float hip = 0.4f * delta;
  
            position.x -= hip * java.lang.Math.sin(java.lang.Math.toRadians(rotation));
            position.y += hip *java.lang.Math.cos(java.lang.Math.toRadians(rotation));
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
 
}