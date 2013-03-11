package component;

import message.CMessage;
import message.MTakeDamage;
import message.Message;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import entity.Entity;
import entity.EntityContainer;

public class CColidable extends Component{
	
	public CColidable(){
		this.id = "Colidable";
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
		float size2 = (owner.getWidth() < owner.getHeight()) ? owner.getWidth() : owner.getHeight();
		for (Entity e : EntityContainer.getEntities()){
			if (e.getComponent("colidable") != null && e != this.owner){
				float size1 = (e.getWidth() < e.getHeight()) ? e.getWidth() : e.getHeight();
				if (e.getPosition().distanceSquared(owner.getPosition()) < size1*size1 + size2*size2){
					System.out.println("TakeDamage");
					owner.sendMessage(new MTakeDamage(owner, 10f));
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDependencies() {
		// TODO Auto-generated method stub
		
	}
}
