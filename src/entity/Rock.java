package entity;

import org.jbox2d.dynamics.BodyType;

import component.CJBox2D;
import component.renderable.CPrimitiveRender;

public class Rock extends Entity {
	
	public Rock() {
		this.id = "Rock";
		this.width = 30f;
		this.height = 30f;
		this.addComponent(new CPrimitiveRender(true, CPrimitiveRender.CIRCLE));
		this.addComponent(new CJBox2D(100f, 50f, BodyType.STATIC, CJBox2D.CIRCLE));
		this.layer = 1;
	}
}