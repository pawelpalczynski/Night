package component;

import message.CMessage;
import message.MTakeDamage;
import message.Message;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import entity.Entity;
import entity.EntityContainer;

public class CColidable extends Component{
	
	CHealth health;
	
	public CColidable(){
		this.id = "Colidable";
		this.health = new CHealth();
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		float size2 = (owner.getWidth() < owner.getHeight()) ? owner.getWidth() : owner.getHeight();
		for (Entity e : EntityContainer.getEntities()){
			if (e.getComponent("colidable") != null && e != this.owner){
				float size1 = (e.getWidth() < e.getHeight()) ? e.getWidth() : e.getHeight();
				if (e.getCenter().distanceSquared(owner.getCenter()) < size1*size1 + size2*size2){
					health.takeDamage(10f);
					e.sendMessage(new MTakeDamage(owner, 10f));
				}
			}
		}
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
