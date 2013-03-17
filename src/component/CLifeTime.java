package component;

import message.CMessage;
import message.Message;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class CLifeTime extends Component {
	
	private float lifetime;
	private float timeleft;
	
	public CLifeTime(float lifetime) {
		this.id = "LifeTime";
		this.lifetime = lifetime;
		this.timeleft = lifetime;
	}

	@Override
	public void setDependencies() {
		// TODO Auto-generated method stub
		
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
	public void update(GameContainer gc, StateBasedGame sb, int delta)
			throws SlickException {
		timeleft -= delta;
		if (timeleft < 0) owner.destroy();
	}

	public float getLifetime() {
		return lifetime;
	}

	public float getTimeleft() {
		return timeleft;
	}

}
