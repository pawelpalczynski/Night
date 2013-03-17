package message;

import org.jbox2d.callbacks.ContactImpulse;
import org.jbox2d.callbacks.ContactListener;
import org.jbox2d.collision.Manifold;
import org.jbox2d.dynamics.contacts.Contact;

import component.CColidable;

public class ContactListenerSlick implements ContactListener {

	@Override
	public void beginContact(Contact contact) {
		// Pass one colidable module to the other
		((CColidable) contact.getFixtureA().getBody().getUserData()).colide(((CColidable)contact.getFixtureB().getBody().getUserData()));
		((CColidable) contact.getFixtureB().getBody().getUserData()).colide(((CColidable)contact.getFixtureA().getBody().getUserData()));
	}

	@Override
	public void endContact(Contact contact) {

	}

	@Override
	public void postSolve(Contact arg0, ContactImpulse arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preSolve(Contact arg0, Manifold arg1) {
		// TODO Auto-generated method stub
		
	}
	
}
