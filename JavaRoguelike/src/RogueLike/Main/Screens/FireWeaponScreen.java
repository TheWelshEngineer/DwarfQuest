package RogueLike.Main.Screens;

import RogueLike.Main.Creature;
import RogueLike.Main.Line;
import RogueLike.Main.Point;

public class FireWeaponScreen extends TargetBasedScreen{

	public FireWeaponScreen(Creature player, int sx, int sy) {
		super(player, "Fire "+player.nameOf(player.weapon())+" at?", sx, sy);
	}
	
	public boolean isAcceptable(int x, int y) {
		if(!player.canSee(x, y, player.z)) {
			return false;
		}
		for(Point p : new Line(player.x, player.y, x, y)) {
			if(!player.realTile(p.x, p.y, player.z).isGround()) {
				return false;
			}
		}
		return true;
	}
	
	public void selectWorldCoordinate(int x, int y, int screenX, int screenY) {
		Creature other = player.creature(x, y, player.z);
		
		if(other == null || other.isContainer() == true || other.disguised() == true) {
			player.notify("There's nothing there to attack.");
		}else {
			player.rangedWeaponAttack(other);
		}
	}

}
