package RogueLike.Main.Screens;

import java.awt.event.KeyEvent;
import java.util.List;

import RogueLike.Main.Creature;
import RogueLike.Main.Effect;
import RogueLike.Main.ExtraMaths;
import RogueLike.Main.Spell;
import RogueLike.Main.Inventory;
import asciiPanel.AsciiPanel;

public class InventoryScreen implements Screen{
	
	protected Creature player;
	protected List<Effect> effects;
	protected Inventory inventory;
	private int sx;
	private int sy;
	
	public int check = 0;
	public void setCheck(int value) {
		check = value;
	}
	
	public int itemsPerPage = 30;
	public int pageNumber = 1;
	
	public InventoryScreen(Creature player, int sx, int sy) {
		this.player = player;
		this.effects = player.effects();
		this.inventory= player.inventory();
		this.sx = sx;
		this.sy = sy;
	}
	
	public boolean checkIfSelected(int index, int check) {
		if(index == check) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public void displayOutput(AsciiPanel terminal) {
		//
		//
		terminal.clear();
		terminal.writeCenter("== Inventory ==", 1);	
		int y = 3;
		//
		pageNumber = ExtraMaths.spellbookPageNumber(check);
		//
		for(int i = (itemsPerPage*(pageNumber-1)); i < itemsPerPage*pageNumber; i++) {
			//System.out.println(String.format("i = %d", i));
			if(i < inventory.getItems().size()) {//spellbook.get(0).name()
				if(checkIfSelected(i, check)) {
					
					String equipped = "";
					if(inventory.get(i) == player.weapon() || inventory.get(i) == player.armor() || inventory.get(i) == player.shield() || inventory.get(i) == player.ring() || inventory.get(i) == player.ammunition()) {
						equipped = " (equipped)";
					}
					
					terminal.write(String.format(">> %s x%d%s", player.nameOf(inventory.get(i)), inventory.get(i).stackAmount(), equipped, check), 5, y++);
				}else {

					String equipped = "";
					if(inventory.get(i) == player.weapon() || inventory.get(i) == player.armor() || inventory.get(i) == player.shield() || inventory.get(i) == player.ring() || inventory.get(i) == player.ammunition()) {
						equipped = " (equipped)";
					}
					
					terminal.write(String.format("%s x%d%s", player.nameOf(inventory.get(i)), inventory.get(i).stackAmount(), equipped, check), 5, y++);
				}
				if(checkIfSelected(i, check) && inventory.get(i).equippable() > 0) {
					terminal.writeCenter("-- [X]: Equip --", 36);
				}
				
				
				
				
			}
		}
		//

    
        terminal.writeCenter("-- [UP / DOWN]: Move Selection | [ESCAPE]: Cancel --", 38);
		
	}
	
    /*protected Screen use(Spell spell){
    	if(spell.isSelfCast()) {
    		//player.doAction("check");
    		player.castSpell(spell, player.x(), player.y(), null);
    		return null;
    	}else {
    		//return null;
    		return new CastSpellScreen(player, "Cast spell at?", sx, sy, spell, null);
    	}
        //return new CastSpellScreen(player, "Cast spell at?", sx, sy, spell, item);
    }*/

	@Override
	public Screen respondToUserInput(KeyEvent key) {
		switch(key.getKeyCode()) {
		case KeyEvent.VK_UP:
			if(check == 0) {
				check = inventory.getItems().size()-1;
			}else {
				check--;
			}
			return this;
		case KeyEvent.VK_DOWN:
			if(check == inventory.getItems().size()-1) {
				check = 0;
			}else {
				check++;
			}
			return this;
		case KeyEvent.VK_ESCAPE:
			return null;
		/*case KeyEvent.VK_ENTER:
			if(spellbook.getSpells().size() > 0) {
				return use(spellbook.get(check));
			}
			return null;*/
		case KeyEvent.VK_X:
			if(inventory.get(check).equippable() > 0) {
				player.equip(inventory.get(check));
				return null;
			}else {
				return this;
			}
		
		case KeyEvent.VK_D:
			player.drop(inventory.get(check));
			return null;
			
		case KeyEvent.VK_E:
			if(inventory.get(check).foodValue() > 0) {
				player.eat(inventory.get(check));
				return null;
			}else {
				return this;
			}
		
		case KeyEvent.VK_Q:
			if(inventory.get(check).quaffEffect() != null) {
				player.quaff(inventory.get(check));
				return null;
			}else {
				return this;
			}
		
		default: return this;
		}
	}

}


