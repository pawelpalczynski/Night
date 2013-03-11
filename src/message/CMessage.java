package message;

import component.Component;

public abstract class CMessage {
	protected String text = "YOLO";
	protected Component source;
	
	public String getText(){
		return this.text;
	}
	
	public Component getSource(){
		return this.source;
	}
	
	public void setSource(Component c){
		this.source = c;
	}
}