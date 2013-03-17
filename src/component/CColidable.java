package component;

import message.CMessage;
import message.Message;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public class CColidable extends Component{
	
	CHealth health = new CHealth();
	CJBox2D jbox;
	float damage = 0;
	
	public CColidable(){
		this(0);
	}
	
	public CColidable(float damage){
		this.id = "Colidable";
		this.damage = damage;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sb, int delta) {
	}
	
	public void colide(){
		health.takeDamage(10f);
	}
	
	public void colide(CColidable collidable) {
		if (collidable.owner.getClass() != this.owner.getClass()) health.takeDamage(collidable.damage);
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
			} else if (message.getSource().getId() == "JBox2D") {
				this.jbox = (CJBox2D) message.getSource();
			}
		}
	}

	@Override
	public void setDependencies() {
		if (owner.getComponent("Health") != null) this.health = (CHealth) owner.getComponent("Health");
		if (owner.getComponent("JBox2D") != null) this.jbox = (CJBox2D) owner.getComponent("JBox2D");		
	}

	public float getDamage() {
		return damage;
	}

	public void setDamage(float damage) {
		this.damage = damage;
	}
}
