package RogueLike.Main.Screens;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

public class MainMenuScreen implements Screen{
	
	public int check = 0;
	public void setCheck(int value) {
		check = value;
	}
	
	public char startLeft = '>';
	public char startRight = '<';
	public char helpLeft = '>';
	public char helpRight = '<';
	public char creditsLeft = '>';
	public char creditsRight = '<';
	
	public void changeMarkers(int check) {
		if(check == 0) {
			startLeft = '>';
			startRight = '<';
			helpLeft = ' ';
			helpRight = ' ';
			creditsLeft = ' ';
			creditsRight = ' ';
		}else if(check == 1) {
			startLeft = ' ';
			startRight = ' ';
			helpLeft = '>';
			helpRight = '<';
			creditsLeft = ' ';
			creditsRight = ' ';
		}else if(check == 2) {
			startLeft = ' ';
			startRight = ' ';
			helpLeft = ' ';
			helpRight = ' ';
			creditsLeft = '>';
			creditsRight = '<';
		}
	}

	public void displayOutput(AsciiPanel terminal) {
		changeMarkers(check);
		terminal.clear();
		int y = 1;
		terminal.writeCenter(" _____                      __  ____                  _   ", y++);
		terminal.writeCenter("|  __ \\                    / _|/ __ \\                | |  ", y++);
		terminal.writeCenter("| |  | |_      ____ _ _ __| |_| |  | |_   _  ___  ___| |_ ", y++);
		terminal.writeCenter("| |  | \\ \\ /\\ / / _` | '__|  _| |  | | | | |/ _ \\/ __| __|", y++);
		terminal.writeCenter("| |__| |\\ V  V / (_| | |  | | | |__| | |_| |  __/\\__ \\ |_ ", y++);
		terminal.writeCenter("|_____/  \\_/\\_/ \\__,_|_|  |_|  \\___\\_\\\\__,_|\\___||___/\\__|", y++);
		terminal.writeCenter("", y+=2);
		terminal.writeCenter("+|=|+ Realm of the Nightmare Queen +|=|+", y++);
		terminal.writeCenter("", y++);
		terminal.writeCenter("== Main Menu ==", y++);
		terminal.write(String.format("%c  New Game  %c", startLeft, startRight), 52, y+=2);
		terminal.write(String.format("%c  Help      %c", helpLeft, helpRight), 52, y+=2);
		terminal.write(String.format("%c  Credits   %c", creditsLeft, creditsRight), 52, y+=2);

		terminal.writeCenter("-- [UP / DOWN]: Move Selection | [ENTER]: Confirm and Continue --", 36);
		terminal.writeCenter("-- [ESCAPE]: Return to Title Screen --", 38);
	}

	public Screen respondToUserInput(KeyEvent key) {
		switch(key.getKeyCode()) {
		case KeyEvent.VK_UP:
			if(check == 0) {
				check = 2;
			}else if(check == 1) {
				check = 0;
			}else if(check == 2) {
				check = 1;
			}
			return this;
			
		case KeyEvent.VK_DOWN:
			if(check == 0) {
				check = 1;
			}else if(check == 1) {
				check = 2;
			}else if(check == 2) {
				check = 0;
			}
			return this;
			
		case KeyEvent.VK_ENTER:
			if(check == 0) {
				return new ChooseSpeciesScreen();
			}else if(check == 1) {
				return new HelpScreen(true);
			}else if(check == 2) {
				return new CreditsScreen();
			}
		case KeyEvent.VK_ESCAPE: return new StartScreen();
		}
		
		return this;
		
		
	}
	

}
