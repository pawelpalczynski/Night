package component;

import message.CMessage;
import message.Message;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

import entity.Entity;
 
public abstract class Component {
     
    protected String id;
    protected Entity owner;
    
    public abstract void setDependencies();
     
    public String getId() {
        return id;
    }
 
    public void setOwnerEntity(Entity owner){
        this.owner = owner;
    }
    
    public Entity getOwnerEntity(){
    	return this.owner;
    }
    
    public abstract void readMessage(Message message);
    
    public abstract void readMessage(CMessage message);
 
    public abstract void update(GameContainer gc, StateBasedGame sb, int delta);
}