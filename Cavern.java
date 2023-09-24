
public class Cavern {
	
	
	private int id;
	private Cavern north;
	private Cavern south;
	private Cavern east;
	private Cavern west;
	
	
	//Constructor 
	
	public Cavern(int id) {
		this.id = id;
		this.north = null;
		this.south = null;
		this.east = null;
		this.west = null;
		
	}
	
	//Setter Methods
	
	public void setNorth(Cavern north) {
		this.north = north;
	}
	public void setSouth(Cavern south) {
		this.south = south;
	}
	public void setEast(Cavern east) {
		this.east = east;
	}
	public void setWest(Cavern west) {
		this.west = west;
	}
	
	
	//Getter Methods
	
	public static Cavern getCavernByID(int id, Cavern[] caverns) {
        for (Cavern cavern : caverns) {
            if (cavern.getID() == id) { 
                return cavern;
            }
        }
        return null; 
    }
    
    public int getID() { 
        return id;
    }
	public Cavern getNorth() {
		return north;
	}
	public Cavern getSouth() {
		return south;
	}
	public Cavern getEast() {
		return east;
	}
	public Cavern getWest() {
		return west;
	}
	
}
