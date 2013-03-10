package message;

import entity.Entity;

public abstract class Message {
	protected String text = "YOLO";
	protected Entity source;
	
	public String getText(){
		return this.text;
	}
	
	public Entity getSource(){
		return this.source;
	}
	
	public void setSource(Entity e){
		this.source = e;
	}
}