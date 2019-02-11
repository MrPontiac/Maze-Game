class Find {
	public static int[] M(char[][] Maze, int c, int r) {
		int[] pos = new int[2];
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				if (Maze[i][j] == 'm') {
					pos[0] = i;
					pos[1] = j;
				}
			}
		}
		return pos;
	}

	public static boolean P(char[][] Maze, int c, int r) {
		int flag = 0;
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				if (Maze[i][j] == 'P') {
					flag = 1;
				}
			}
		}
		if (flag == 1) {
			return true;
		} else {
			return false;
		}
	}

	public static int[] P1(char[][] Maze, int c, int r) {
		int[] pos = new int[2];
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				if (Maze[i][j] == 'p') {
					pos[0] = i;
					pos[1] = j;
				}
			}
		}
		return pos;
	}
}