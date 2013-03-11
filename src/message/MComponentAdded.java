package message;

import component.Component;

public class MComponentAdded extends CMessage {
	
	public MComponentAdded(Component source){
		this.text = "ComponentAdded";
		this.source = source;
	}
}
