package component;

import message.Message;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

public class CDisposable extends Component {
	
	public CDisposable(String id){
		this.id = id;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		float width = gc.getWidth();
		float height = gc.getHeight();
		Vector2f position = owner.getPosition();
		
		if (position.x < 0 || position.x > width || position.y < 0 || position.y > height){
			owner.destroy();
		}
	}

	@Override
	public void readMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

}
