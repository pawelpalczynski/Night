package component;

import message.CMessage;
import message.Message;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public class CColidable extends Component{
	
	CHealth health;
	
	public CColidable(){
		this.id = "Colidable";
		this.health = new CHealth();
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
//		
	}
	
	public void colide(){
		health.takeDamage(10f);
	}

	@Override
	public void readMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readMessage(CMessage message) {
		if (message.getText() == "ComponentAdded"){
			if (message.getSource().getId() == "Health"){
				this.health = (CHealth) message.getSource();
			}
		}
	}

	@Override
	public void setDependencies() {
		this.health = (CHealth) owner.getComponent("Health");		
	}
}
