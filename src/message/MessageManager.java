package message;

import entity.EntityContainer;

public class MessageManager {
	
	public static void broadcastMessageInternally(Message message){
		message.getSource().sendMessage(message);
	}
	
	public static void broadcastMessageExternally(Message message){
		EntityContainer.sendMessage(message);
	}
}
