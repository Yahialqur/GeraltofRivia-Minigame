import java.util.Scanner;

public class Game {
	
	//Global Variables
	public static final String ANSI_RESET = "\u001B[0m"; 
	public static final String ANSI_BLACK = "\u001B[30m"; 
	public static final String ANSI_RED = "\u001B[31m"; 
	public static final String ANSI_GREEN = "\u001B[32m"; 
	public static final String ANSI_YELLOW = "\u001B[33m"; 
	public static final String ANSI_BLUE = "\u001B[34m"; 
	public static final String ANSI_PURPLE = "\u001B[35m"; 
	public static final String ANSI_CYAN = "\u001B[36m"; 
	public static final String ANSI_WHITE = "\u001B[37m";
	public static final String ANSI_ORANGE = "\u001b[31m";
	
	private Cavern [] caverns;
	private int  currentCavern = 0;
	private boolean isAlive = true;
	private boolean winner = false;
	private boolean swordPicked = false;
	private boolean potionPicked = false;
	private boolean bladeOilPicked = false;
	private boolean isAliveTroll = true;
	private boolean isAliveGhouls = true;
	private boolean isAliveKatakan = true;
	
	
	
	//Play logic method
	void play() {
		
		Cavern cavern0 = new Cavern(0);
		Cavern cavern1 = new Cavern(1);
		Cavern cavern2 = new Cavern(2);
		Cavern cavern3 = new Cavern(3);
		Cavern cavern4 = new Cavern(4);
		Cavern cavern5 = new Cavern(5);
		Cavern cavern6 = new Cavern(6);
		Cavern cavern7 = new Cavern(7);
		Cavern cavern8 = new Cavern(8);
		
		caverns = new Cavern[] {cavern0, cavern1, cavern2, cavern3, cavern4, cavern5, cavern6, cavern7, cavern8};
		
		cavern0.setSouth(cavern1);
		cavern0.setEast(cavern2);
		
		cavern1.setNorth(cavern0);
		
		cavern2.setNorth(cavern3);
		cavern2.setEast(cavern5);
		cavern2.setWest(cavern0);
		
		cavern3.setSouth(cavern2);
		cavern3.setEast(cavern4);
		
		cavern4.setWest(cavern3);
		
		cavern5.setSouth(cavern6);
		cavern5.setWest(cavern2);
		cavern5.setEast(cavern7);
		
		cavern6.setNorth(cavern5);
		
		cavern7.setEast(cavern8);
		cavern7.setWest(cavern5);
		
		cavern8.setWest(cavern7);
		
		look();
		
		while(isAlive == true && winner == false) {
			System.out.println();
			System.out.println(ANSI_GREEN + "What would you like to do? " + ANSI_RESET);
			Scanner scan = new Scanner(System.in);
			String choice = scan.nextLine();
			choice = choice.toLowerCase();
			choice = choice.replace(" ", "");
			
			//For player choice
			switch (choice) {
				case "look":
					look();
					break;
				case "movenorth":
					moveNorth();
					break;
				case "movesouth":
					moveSouth();
					break;
				case "moveeast":
					moveEast();
					break;
				case "movewest":
					moveWest();
					break;
				case "pick":
					pick();
					break;
				case "attack":
					attack();
					break;
				case "exit":
					exit();
					break;
				default:
					System.out.println(ANSI_PURPLE + "Enter a valid command\n" + ANSI_RESET);
					break;
			}
			winner();
		}
		
		if(winner == true) {
			System.out.println(ANSI_BLUE + "You completed your mission and returned to the village to receive payment. The villagers were happy to hear the cave will not bring any more trouble");
			System.out.println("After taking the payment you mount your horse, Roach, and return to the path");
			System.out.println("Congratulations Witcher" + ANSI_RESET);
			exit();
		}
		if(isAlive == false) {
			System.out.println(ANSI_BLACK + "Word spread of the great Geral of Rivia's death.");
			System.out.println("No one ever dared to enter the cave after your death, not even another witcher");
			System.out.println("The village relocated after hearing news of your death" + ANSI_RESET);
			exit();
		}
	}
	
	
	
	//All look options for every cavern
	//8 caverns in total
	void look() {
		switch(currentCavern) {
			case 0:
				System.out.println("\nIt was a long walk and after squeezing through the crevices of the cave you have finally reached a large cavern.");
				System.out.println("It is dark and damp. You hear countless echoes of different creatures throughout the cave.");
				System.out.println("You see a path to the South and East.");
				break;
			case 1:
				if(potionPicked == false) {
					System.out.println("\nYou have reached a small cavern. It is very dark here but lukily you spot one of your potions.");
					System.out.println("It is the cat potion, granting you total visibility in darkness. It would be impossible to fight the monsters of this cave without it.");
					System.out.println("There is one path North.");
				}
				else {
					System.out.println("\nYou have reached a small cavern. This is the same cavern where you found your cat potion.");
					System.out.println("There is one path North.");
				}
				break;
			case 2:
				System.out.println("\nAnother cavern. You have three paths, one leading North, another East, and back west.");
				break;
			case 3:
				if(swordPicked == false) {
					System.out.println("\nAs you enter this cavern you see a shiny reflection. As you walk closer to investigate you see it is your silver sword.");
					System.out.println("It would be impossible to slay the monsters without your sword.");
					System.out.println("There are two paths, one South and another East. You here some strange noises coming from the East.");
				}
				else if(swordPicked == true && isAliveTroll == true){
					System.out.println("\nYou return to the cavern where you found your sword");
					System.out.println("There are two paths, one South and another East. You here some strange noises coming from the East.");
				}
				else {
					System.out.println("\nYou return to the cavern where you found your sword");
					System.out.println("There are two paths, one South and another East.");
				}
				break;
			case 4:
				if(isAliveTroll == true) {
					System.out.println("\nAs you enter the cavern the strange noises get louder.");
					System.out.println("Inside this large cavern you spot a Rock troll. You believe it was the troll that stole your items.");
					System.out.println("You have one path to the west.");
				}
				else {
					System.out.println("\nThe body of the Rock Troll you defeated lays in the middle of this cavern.");
					System.out.println("You have one path to the west.");
				}
				break;
			case 5:
				if(isAliveGhouls == true) {
					System.out.println("\nYou have reached a crossroads, there is a path South, East, and West. There are strange noises coming from the south.");
				}
				else {
					System.out.println("\nYou have reached a crossroads, there is a path South, East, and West. There is an awful stench coming from the south.");
				}
				break;
			case 6:
				if(isAliveGhouls == true) {
					System.out.println("\nAs you enter, viscious noises get louder and louder.");
					System.out.println("You see two ghouls devouring a corpse of one of the nearby villagers.");
					System.out.println("Fighting these monsters must be done with the right tools.");
					System.out.println("There is one path to the North.");
				}
				else {
					System.out.println("\nThe carcasses of two ghouls lay in the cavern. An awful stench eminating from the ghouls.");
					System.out.println("There is one path to the North.");
				}
				break;
			case 7:
				if(bladeOilPicked == false && isAliveKatakan == true) {
					System.out.println("\nYou enter another cavern. In here you spot your vampire blade oil.");
					System.out.println("The blade oils are very useful tools, and this one would be great for any vampire fights.");
					System.out.println("There are two paths, West and East. Strange noises come from the East.");
				}
				else if (bladeOilPicked == true && isAliveKatakan == true){
					System.out.println("\nThis is the cavern where you found you vampire blade oil. Strange noises can be heard coming from the East");
					System.out.println("There are two paths, West and East.");
				}
				else {
					System.out.println("\nThis is the cavern where you found you vampire blade oil.");
					System.out.println("There are two paths, West and East.");
				}
				break;
			case 8:
				if(isAliveKatakan == true) {
					System.out.println("\nAs you enter you see a big creature. Resembling a bat but standing on two legs you conclude that it is an old Katakan, a vampire.");
					System.out.println("You can tell it is an old Katakan by the length of its fangs and talons. You must handle this creature carefully and with the right tools.");
					System.out.println("There is a path to the west.");
				}
				else {
					System.out.println("\nThe body of the old katakan lays in the cavern. Deep sword wounds are apparent all over the katakans body.");
					System.out.println("You are reminded of the difficult battle you had with this creature.");
					System.out.println("There is a path to the west.");
				}
			
		}
		
		inventoryDescription();
	}
	
	
	
	//All move methods
	void moveNorth() {
		
		Object temp;
		temp = Cavern.getCavernByID(currentCavern, caverns);
		
		if(((Cavern) temp).getNorth() != null) {
			temp = ((Cavern) temp).getNorth();
			System.out.println(ANSI_PURPLE + "\nYou took the path North\n" + ANSI_RESET);
		}
		else {
			System.out.println(ANSI_PURPLE + "\nThere is no path North\n" + ANSI_RESET);
		}
		
		currentCavern = ((Cavern) temp).getID();
	}
	void moveSouth() {
		
		Object temp;
		temp = Cavern.getCavernByID(currentCavern, caverns);
		
		if(((Cavern) temp).getSouth() != null) {
			temp = ((Cavern) temp).getSouth();
			System.out.println(ANSI_PURPLE + "\nYou took the path South\n" + ANSI_RESET);
		}
		else {
			System.out.println(ANSI_PURPLE + "\nThere is no path South\n" + ANSI_RESET);
		}
		
		currentCavern = ((Cavern) temp).getID();
	}
	void moveEast() {
		
		Object temp;
		temp = Cavern.getCavernByID(currentCavern, caverns);
		
		if(((Cavern) temp).getEast() != null) {
			temp = ((Cavern) temp).getEast();
			System.out.println(ANSI_PURPLE + "\nYou took the path East\n" + ANSI_RESET);
		}
		else {
			System.out.println(ANSI_PURPLE + "\nThere is no path East\n" + ANSI_RESET);
		}
		
		currentCavern = ((Cavern) temp).getID();
	}
	void moveWest() {
		
		Object temp;
		temp = Cavern.getCavernByID(currentCavern, caverns);
		
		if(((Cavern) temp).getWest() != null) {
			temp = ((Cavern) temp).getWest();
			System.out.println(ANSI_PURPLE + "\nYou took the path West\n" + ANSI_RESET);
		}
		else {
			System.out.println(ANSI_PURPLE + "\nThere is no path West\n" + ANSI_RESET);
		}
		
		currentCavern = ((Cavern) temp).getID();
	}
	
	
	
	//Logic for picking items
	void pick() {
		
		if (currentCavern == 1 && potionPicked == false) {
			System.out.println(ANSI_PURPLE + "\nYou picked the cat potion\n" + ANSI_RESET);
			potionPicked = true;
		}
		else if (currentCavern == 3 && swordPicked == false) {
			System.out.println(ANSI_PURPLE + "\nYou picked up the silver sword\n" + ANSI_RESET);
			swordPicked = true;
		}
		else if (currentCavern == 7 && bladeOilPicked == false) {
			System.out.println(ANSI_PURPLE + "\nYou picked up the vampire blade oil\n" + ANSI_RESET);
			bladeOilPicked = true;
		}
		else {
			System.out.println(ANSI_PURPLE + "\nThere is nothing to pick up\n" + ANSI_RESET);
		}
	}
	
	
	
	//Logic for attacking monsters. Also prints fight descriptions
	void attack() {
		
		if (currentCavern == 4 && swordPicked == true && isAliveTroll == true) {
			System.out.println(ANSI_RED + "\nIt was a long and brutal battle. Rock trolls are known for their notorious strength and armored bodies.\n"
					+ "You dodge countless attacks waiting for the perfect moment to strike the rock trolls weakness, his neck. Finally the chance arises and you land a perfect blow." + ANSI_RESET);
			System.out.println(ANSI_PURPLE + "\nYou have slain the rock troll" + ANSI_RESET);
			isAliveTroll = false;
		}
		else if(currentCavern == 4 && swordPicked == false) {
			System.out.println(ANSI_RED + "\nYou are DEAD");
			System.out.println("The rock troll has defeated you" + ANSI_RESET);
			isAlive = false;
		}
		else if(currentCavern == 6 && swordPicked == true && potionPicked == true && isAliveGhouls == true) {
			System.out.println(ANSI_RED + "\nGhouls are necrophages, generally seeking out dead bodies and eating the remains. As you approach they leave the dead villager and start running towards you.\n"
					+ "Using your witcher signs you are able to slow them down and you land a perfect strike on one of the ghouls. \nThe other ghoul attacks with full force"
					+ " but he is no match to a master witcher." + ANSI_RESET);
			System.out.println(ANSI_PURPLE + "\nYou defeated the ghouls" + ANSI_RESET);
			isAliveGhouls = false;
		}
		else if(currentCavern == 6 && swordPicked == false && potionPicked == true) {
			System.out.println(ANSI_RED + "\nYou are DEAD");
			System.out.println("The ghouls have defeated you" + ANSI_RESET);
			isAlive = false;
		}
		else if(currentCavern == 6 && swordPicked == true && potionPicked == false) {
			System.out.println(ANSI_RED + "\nYou are DEAD");
			System.out.println("The ghouls have defeated you" + ANSI_RESET);
			isAlive = false;
		}
		else if(currentCavern == 6 && swordPicked == false && potionPicked == false) {
			System.out.println(ANSI_RED + "\nYou are DEAD");
			System.out.println("The ghouls have defeated you" + ANSI_RESET);
			isAlive = false;
		}
		else if(currentCavern == 8 && swordPicked == true && potionPicked == true && bladeOilPicked == true && isAliveKatakan == true) {
			System.out.println(ANSI_RED + "\nYou think to yourself, \'This is the biggest Katakan I have seen\'. \nKatakans are known for their speed and inteligence."
					+ " However, you have the vampire blade oil which means you only need to land one strike on this Katakan. \nYou approach try a few attacks but "
					+ "the Katakan manages to evade all of them. As the Katakan retaliates, you are hit by one of its talons. Luckily this caused the Katakan to let"
					+ " its guard down. You are able to land one blow with your sword, and now the vampire oil will spread through its body like poison." + ANSI_RESET);
			System.out.println(ANSI_PURPLE + "\nYou have defeated the Katakan" + ANSI_RESET);
			isAliveKatakan = false;
		}
		else if(currentCavern == 8 && swordPicked == false && potionPicked == true && bladeOilPicked == true) {
			System.out.println(ANSI_RED + "\nYou are DEAD");
			System.out.println("The katakan has defeated you" + ANSI_RESET);
			isAlive = false;
		}
		else if(currentCavern == 8 && swordPicked == true && potionPicked == false && bladeOilPicked == true) {
			System.out.println(ANSI_RED + "\nYou are DEAD");
			System.out.println("The katakan has defeated you" + ANSI_RESET);
			isAlive = false;
		}
		else if(currentCavern == 8 && swordPicked == true && potionPicked == true && bladeOilPicked == false) {
			System.out.println(ANSI_RED + "\nYou are DEAD");
			System.out.println("The katakan has defeated you" + ANSI_RESET);
			isAlive = false;
		}
		else if(currentCavern == 8 && swordPicked == false && potionPicked == false && bladeOilPicked == true) {
			System.out.println(ANSI_RED + "\nYou are DEAD");
			System.out.println("The katakan has defeated you" + ANSI_RESET);
			isAlive = false;
		}
		else if(currentCavern == 8 && swordPicked == false && potionPicked == true && bladeOilPicked == false) {
			System.out.println(ANSI_RED + "\nYou are DEAD");
			System.out.println("The katakan has defeated you" + ANSI_RESET);
			isAlive = false;
		}
		else if(currentCavern == 8 && swordPicked == true && potionPicked == false && bladeOilPicked == false) {
			System.out.println(ANSI_RED + "\nYou are DEAD");
			System.out.println("The katakan has defeated you" + ANSI_RESET);
			isAlive = false;
		}
		else {
			System.out.println("\nThere is nothing to attack" + ANSI_RESET);
		}
	}
	
	
	
	//Prints what is in the inventory
	void inventoryDescription() {
		if(swordPicked == true && potionPicked == false && bladeOilPicked == false) {
			System.out.println(ANSI_BLACK + "\nCurrent Inventory: Silver Sword" + ANSI_RESET);
		}
		if(swordPicked == true && potionPicked == true && bladeOilPicked == false) {
			System.out.println(ANSI_BLACK + "\nCurrent Inventory: Silver Sword, Cat Potion" + ANSI_RESET);
		}
		if(swordPicked == true && potionPicked == true && bladeOilPicked == true) {
			System.out.println(ANSI_BLACK + "\nCurrent Inventory: Silver Sword, Cat Potion, Vampire Blade Oil" + ANSI_RESET);
		}
		if(swordPicked == false && potionPicked == true && bladeOilPicked == false) {
			System.out.println(ANSI_BLACK + "\nCurrent Inventory: Cat Potion" + ANSI_RESET);
		}
		if(swordPicked == false && potionPicked == true && bladeOilPicked == true) {
			System.out.println(ANSI_BLACK + "\nCurrent Inventory: Cat Potion, Vampire Blade Oil" + ANSI_RESET);
		}
		if(swordPicked == false && potionPicked == false && bladeOilPicked == true) {
			System.out.println(ANSI_BLACK + "\nCurrent Inventory: Vampire Blade Oil" + ANSI_RESET);
		}
	}
	
	
	
	//Checks if player has won
	void winner() {
		if(isAliveTroll == false && isAliveGhouls == false && isAliveKatakan == false) {
			winner = true;
		}
	}
	
	
	
	void exit() {
		System.exit(0);
	}
	
}
