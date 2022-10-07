package RogueLike.Main.Screens;

import java.awt.event.KeyEvent;

import RogueLike.Main.Creature;
import RogueLike.Main.ObjectFactory;
import asciiPanel.AsciiPanel;

public class IndexPotionScreen implements Screen{
	
	protected Creature player;
	protected ObjectFactory factory;
	
	public IndexPotionScreen(Creature player, ObjectFactory factory) {
		this.player = player;
		this.factory = factory;
	}
	
	@Override
	public void displayOutput(AsciiPanel terminal) {
		terminal.clear();
		terminal.writeCenter("== Index: Potions ==", 1);	
		int y = 3;
		for(int i = 0; i < 12; i++) {
			String potionColor = factory.potionIndex.get(i).appearance();
			String potionName = "???";
			if(player.nameOf(factory.potionIndex.get(i)) == factory.potionIndex.get(i).name()) {
				potionName = factory.potionIndex.get(i).name();
			}
			terminal.write(String.format("%s : %s", potionColor, potionName), 44, y++);
			
		}
		
        y++;
        y++;
        y++;

    
        terminal.writeCenter("-- [LEFT]: Rings | [RIGHT]: Scrolls | [ESCAPE]: Exit --", 38);
		
	}

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		switch(key.getKeyCode()) {
        case KeyEvent.VK_RIGHT: return new IndexScrollScreen(player, factory); 
        case KeyEvent.VK_LEFT: return new IndexRingScreen(player, factory);
        case KeyEvent.VK_ESCAPE: return null;
		}
		return this;
		
	}

}
