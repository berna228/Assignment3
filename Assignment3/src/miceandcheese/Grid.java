package miceandcheese;

public class Grid {
	public static int SIZEROW = 8;
	public static int SIZECOL = 8;
	public static Box grid[][] = new Box[SIZEROW][SIZECOL];
	public static long startTime;
	public static long totalTime;
	public static int boxOpenings; 

	public Grid() {
		for (int row = 0; row < SIZEROW; row++) {
			for (int col = 0; col < SIZECOL; col++) {
				int position[] = {row, col};
				if (col == row) grid[row][col] = new Box(true, position);
				else grid[row][col] = new Box(false, position);
			}
		}
	}

	public void printCheesePosition() {
		for (int row = 0; row < SIZEROW; row++) {
			System.out.print("|");
			for (int col = 0; col < SIZECOL; col++) {
				if (grid[row][col].containsCheese == true) System.out.print("1|");
				else System.out.print("0|");
			}
			System.out.println();
		}
	}
	
	
}
