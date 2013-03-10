package component;

import message.MTakeDamage;
import message.Message;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public class CHealth extends Component {
	
	private float health = 100f;

	public CHealth(String id){
		this.id = id;
	}
	
	public CHealth(String id, float health){
		this.id = id;
		this.health = health;
	}
	
	public void takeDamage(MTakeDamage message){
		health -= message.getDamage();
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		if (health < 0) owner.destroy();
	}

	@Override
	public void readMessage(Message message) {
		if (message.getText() == "TakeDamage"){
			takeDamage((MTakeDamage) message);
		}
	}

}
