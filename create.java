import java.lang.Math;
import java.util.Random;

class create {
	public static char[][] Maze(int c, int r, Random random) {
		char[][] grid = new char[c][r];
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				grid[i][j] = '-';
				int rand = random.nextInt(10);
				if (rand >= 6) {
					grid[i][j] = '=';
				}
			}
		}
		return grid;
	}
}