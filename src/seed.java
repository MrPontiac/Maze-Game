import java.util.Random;

class seed {
	public static char[][] Maze(int c, int r, char[][] Maze, Random random) {
		int flag = 0;
		int flag1 = 0;
		while (flag1 == 0 || flag == 0) {
			for (int i = 0; i < c; i++) {
				for (int j = 0; j < r; j++) {
					int rand1 = random.nextInt(100);
					if (rand1 > 97 && flag1 == 0) {
						flag1 = 1;
						Maze[i][j] = 'P';
					}
					int rand = random.nextInt(100);
					if (rand > 2 && rand < 10 && flag == 0 && Maze[i][j] != 'P') {
						flag = 1;
						Maze[i][j] = 'm';
					}
					
				}
			}
		}
		return Maze;
	}

}