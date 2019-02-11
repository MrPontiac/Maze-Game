class turn {
	public static char[][] right(char[][] Maze, int p1, int p2, int r) {
		if (p2 < r - 1 && Maze[p1][p2 + 1] != '=') {
			Maze[p1][p2] = '-';
			Maze[p1][(p2 + 1)] = 'm';
			return Maze;
		} else {
			return Maze;
		}
	}

	// go left
	public static char[][] left(char[][] Maze, int p1, int p2) {
		if (p2 > 0 && Maze[p1][p2 - 1] != '=') {
			Maze[p1][p2] = '-';
			Maze[p1][(p2 - 1)] = 'm';
			return Maze;
		} else {
			return Maze;
		}
	}

	// go up
	public static char[][] up(char[][] Maze, int p1, int p2) {
		if (p1 > 0 && Maze[p1 - 1][p2] != '=') {
			Maze[p1][p2] = '-';
			Maze[(p1 - 1)][(p2)] = 'm';
			return Maze;
		} else {
			return Maze;
		}
	}

	// go down
	public static char[][] down(char[][] Maze, int p1, int p2, int c) {
		if (p1 < c - 1 && Maze[p1 + 1][p2] != '=') {
			Maze[p1][p2] = '-';
			Maze[(p1 + 1)][(p2)] = 'm';
			return Maze;
		} else {
			return Maze;
		}
	}
}