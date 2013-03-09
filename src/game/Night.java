package game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Night extends StateBasedGame{
	
	public static final int MAINMENUSTATE = 0;
	public static final int GAMEPLAYSTATE = 1;

	public Night() {
		super("Night");
	}
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer app;
		app = new AppGameContainer(new Night());
		app.setDisplayMode(1024, 768, false);
		app.setVSync(true);
		app.start();
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		this.addState(new GameplayState(GAMEPLAYSTATE));
        this.addState(new MainMenuState(MAINMENUSTATE));
		
	}

}
