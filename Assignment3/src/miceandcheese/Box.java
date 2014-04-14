package miceandcheese;

public class Box {
	// positions contains {x, y} coordinates of the Box in the 8x8 grid
	public int position[] = {0, 0};
	public Boolean containsCheese = false;

	// Constructor for Box object
	public Box(Boolean containsCheese, int row, int col) {
		this.containsCheese = containsCheese;
		this.position[0] = row;
		this.position[1] = col;
		
	}
	
}
