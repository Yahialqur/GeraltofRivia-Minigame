import java.io.*;

public class Main {
	
	public static final String ANSI_RESET = "\u001B[0m"; 
	public static final String ANSI_BLACK = "\u001B[30m"; 
	public static final String ANSI_RED = "\u001B[31m"; 
	public static final String ANSI_GREEN = "\u001B[32m"; 
	public static final String ANSI_YELLOW = "\u001B[33m"; 
	public static final String ANSI_BLUE = "\u001B[34m"; 
	public static final String ANSI_PURPLE = "\u001B[35m"; 
	public static final String ANSI_CYAN = "\u001B[36m"; 
	public static final String ANSI_WHITE = "\u001B[37m"; 


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println(ANSI_RED + "========================================\n"
						 + "\n"
						 + "\t    Geralt Minigame             \n"
						 + "\n"
						 + "========================================\n\n" + ANSI_RESET);
		
		displayGameInstructions();
		displayStory();
		
		Game game = new Game();
		game.play();
		

	}
	
	
	
	static void displayGameInstructions() {
		
		System.out.println(ANSI_YELLOW + "HOW TO PLAY:");
		System.out.println("There are 5 commands in the game: Look, Pick, Move, Attack, and Exit");
		System.out.println("Look will give a description of the room your in. It will mention any items or monsters near you. It will also state your inventory and paths available");
		System.out.println("Pick will pickup any item available for pickup in the room");
		System.out.println("Move must be used in conjunction with a direction such as North, South, East, or West");
		System.out.println("Exit will exit the game");
		System.out.println("Attack will attack monsters in the room. Note that some monsters require certain tools or potions to kill, otherwise you die\n\n" + ANSI_RESET);
		
	}
	
	
	static void displayStory() {
		
		System.out.println(ANSI_CYAN + "You are Geralt of Rivia, a witcher. You have been hired by a town to clear a nearby cave of all monsters.");
		System.out.println("You arive at the cave and rest outside to prepare for the fights ahead, but upon awaking you find that your potions and swords have dissapeared!");
		System.out.println("Using your witcher senses, you know that your items have been taken into the cave, so you enter.\n\n" + ANSI_RESET);
		
	}

}
