package component;

import message.CMessage;
import message.MTakeDamage;
import message.Message;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public class CHealth extends Component {
	
	private float health = 100f;

	public CHealth(){
		this.id = "Health";
	}
	
	public CHealth( float health){
		this.id = "health";
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

	@Override
	public void readMessage(CMessage message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDependencies() {
		// TODO Auto-generated method stub
		
	}

}
