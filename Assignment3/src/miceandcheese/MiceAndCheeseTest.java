package miceandcheese;

import java.util.Scanner;

public class MiceAndCheeseTest {
	private static long startTime;
	private static long totalTime;
	private static int boxOpenings;
	private static Box[][] grid;
	private static final int SIZE = 8;

	private static class CheeseFinder implements Runnable {
		private int startRow, finishRow;
		public CheeseFinder(int startRow, int finishRow) {
			this.startRow = startRow;
			this.finishRow = finishRow;
		}
		@Override
		public void run() {
			startTime = System.currentTimeMillis();
			for (int i = startRow; i < finishRow; i++) {
				for (int j = 0; j < SIZE; j++) {
					try {
						Thread.sleep(10);
						boxOpenings++;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (grid[i][j].containsCheese()) {
						System.out.println(Thread.currentThread().getName() +
								" found cheese at \nx = " + i + " y = " + j);
						totalTime = System.currentTimeMillis() - startTime;
						System.out.println("total time (ms) = " + totalTime +
								"\nbox opening count = " + boxOpenings);
					}
				}
			}
		}
	}
	
	public static void main(String arg[]) {
		Thread mouse0, mouse1, mouse2, mouse3;
		Thread mouse4, mouse5, mouse6, mouse7;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter location of cheese: (0-7)");
		int cheeseLoc = in.nextInt();
		System.out.println("Enter number of mice: (1, 4, 8)");
		int numMice = in.nextInt();
//		if ((numMice != 1) || (numMice != 4) || (numMice != 8)) {
//			
//		}
		in.close();
		
		grid = new Box[SIZE][SIZE];
		for (int row = 0; row < SIZE; row++) {
			for (int col = 0; col < SIZE; col++) {
				// Errors on populating grid
				if ((cheeseLoc == row) && (cheeseLoc == col)) 
					grid[row][col] = new Box(true, row, col);
				else grid[row][col] = new Box(false, row, col);
			}
		}
		System.out.println("Cheese is at: [" +
				cheeseLoc + ", " + cheeseLoc + "]");
		System.out.println("Number of mice: " + numMice);
		switch (numMice) {
		case 1: 
			mouse0 = new Thread(new CheeseFinder(0,8));
			mouse0.start();
			break;
		case 4: 
			mouse0 = new Thread(new CheeseFinder(0,2));
			mouse1 = new Thread(new CheeseFinder(2,4));
			mouse2 = new Thread(new CheeseFinder(4,6));
			mouse3 = new Thread(new CheeseFinder(6,8));
			mouse0.start();
			mouse1.start();
			mouse2.start();
			mouse3.start();
			break;
		case 8:
			mouse0 = new Thread(new CheeseFinder(0,1));
			mouse1 = new Thread(new CheeseFinder(1,2));
			mouse2 = new Thread(new CheeseFinder(2,3));
			mouse3 = new Thread(new CheeseFinder(3,4));
			mouse4 = new Thread(new CheeseFinder(4,5));
			mouse5 = new Thread(new CheeseFinder(5,6));
			mouse6 = new Thread(new CheeseFinder(6,7));
			mouse7 = new Thread(new CheeseFinder(7,8));
			mouse0.start();
			mouse1.start();
			mouse2.start();
			mouse3.start();
			mouse4.start();
			mouse5.start();
			mouse6.start();
			mouse7.start();
			break;
		}

	}
	
}