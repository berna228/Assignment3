package miceandcheese;

public class Grid {
	public int SIZEROW = 8;
	public int SIZECOL = 8;
	public Box grid[][] = new Box[SIZEROW][SIZECOL];

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
