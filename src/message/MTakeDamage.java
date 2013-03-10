package message;

import entity.Entity;

public class MTakeDamage extends Message {
	float damage;
	
	public MTakeDamage(Entity source, float damage){
		this.text = "TakeDamage";
		this.damage = damage;
		this.source = source;
	}

	public float getDamage() {
		return damage;
	}
}
