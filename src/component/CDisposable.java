package component;

import message.CMessage;
import message.Message;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import entity.EntityContainer;

public class CDisposable extends Component {
	
	public CDisposable(){
		this.id = "Disposable";
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		float width = EntityContainer.getBoundX();
		float height = EntityContainer.getBoundY();
		Vector2f position = owner.getPosition();
		
		if (position.x < 0 || position.x > width || position.y < 0 || position.y > height){
			owner.destroy();
		}
	}

	@Override
	public void readMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readMessage(CMessage message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDependencies() {
		// TODO Auto-generated method stub
		
	}

}
