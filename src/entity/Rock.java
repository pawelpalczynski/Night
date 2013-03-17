package entity;

import org.jbox2d.dynamics.BodyType;

import component.CJBox2D;
import component.renderable.CPrimitiveRender;

public class Rock extends Entity {
	
	public Rock(float x, float y) {
		this.id = "Rock";
		this.width = 30f;
		this.height = 30f;
		this.addComponent(new CPrimitiveRender(true, CPrimitiveRender.CIRCLE));
		this.addComponent(new CJBox2D(x, y, BodyType.STATIC, CJBox2D.CIRCLE, 1, 1, 1, 0.8f));
		this.layer = 1;
	}
}