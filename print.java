class print {
	public static void Maze(char[][] grid, int c, int r) {
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}
}