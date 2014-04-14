package miceandcheese;

public class MiceAndCheeseTest {
	public static long startTime;
	public static long totalTime;
	public static int boxOpenings;
	public static Box[][] grid;


	private static class CheeseFinder implements Runnable {
		private int startRow, finishRow;
		public CheeseFinder(int startRow, int finishRow) {
			this.startRow = startRow;
			this.finishRow = finishRow;
		}
		@Override
		public void run() {
			startTime = System.currentTimeMillis();
			for (int i = 0; i < 8; i++) {
				for (int j = startRow; j < finishRow; j++) {
					if (grid[i][j].containsCheese) {
						System.out.println(Thread.currentThread().getName() +
								" found cheese at x = " + i + " y = " + j);
						totalTime = System.currentTimeMillis() - startTime;
						System.out.println("total time (ms) = " + totalTime +
								" box opening count = " + boxOpenings);
					}
				}
			}
		}
	}
	
	public static void main(String arg[]) {
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if (col == row) grid[row][col] = new Box(true, row, col);
				else grid[row][col] = new Box(false, row, col);
			}
		}
		Thread mouse0 = new Thread(new CheeseFinder(0,8));
		
		mouse0.start();
	}
	
}