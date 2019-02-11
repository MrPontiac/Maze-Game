import java.lang.Math;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AI {
	private char[][] maze;
	public String currPath;
	private int currX;
	private int currY;
	private int c;
	private int r;
	private long seed;
	public boolean unsolvable;

	AI(char[][] aMaze, int stX, int stY, String currentPath, boolean noSolution, long seed1) {
		maze = aMaze;
		currX = stX;
		currY = stY;
		c = aMaze.length;
		r = aMaze[0].length;
		currPath = currentPath;
		unsolvable = noSolution;
		seed = seed1;
	}

	// indicate taken path
	void placePlus() {
		maze[currX][currY] = '+';
	}

	// for backtracking
	void placeMinus() {
		maze[currX][currY] = '-';
	}

	void placeded() {
		maze[currX][currY] = 'd';
	}

	// solve
	// priority in this order East, West, South, North
	void solveMaze() {
		// check for a win
		if (checkForWin()) {
			return;
		}
		// No win, so let's check for an opening
		// check east
		if (currY + 1 < maze[currX].length && checkForOpen(currX, currY + 1)) {
			currY++;
			placePlus();
			currPath += "E"; // Append East to our current path
			// recursive call continue searching
			solveMaze();
			// check west
		} else if (currY - 1 >= 0 && checkForOpen(currX, currY - 1)) {
			currY--;
			placePlus();
			currPath += "W";
			solveMaze();
			// check south
		} else if (currX + 1 < maze.length && checkForOpen(currX + 1, currY)) {
			currX++;
			placePlus();
			currPath += "S";
			solveMaze();
			// check north
		} else if (currX - 1 >= 0 && checkForOpen(currX - 1, currY)) {
			currX--;
			placePlus();
			currPath += "N";
			solveMaze();
		} else { // we've hit a dead end, we need to backtrack
			if (currPath.length() == 0) {
				// we're back at the starting point, the maze is unsolvable
				unsolvable = true;
				try {
					PlaceBad();
				} catch (Exception e) {

				}
				return;
			} else {
				// we've reached a dead end, lets backtrack
				backTrack();
			}
		}
	}

	// see if the spot at a give x, y is open
	boolean checkForOpen(int x, int y) {
		return maze[x][y] == '-';
	}

	// see if any of the surrounding spots are the exit
	boolean checkForWin() {
		// make sure to protect against out of bounds as well
		if (currY + 1 < maze[currX].length && maze[currX][currY + 1] == 'P') {
			currPath += 'E';
		} else if (currY - 1 >= 0 && maze[currX][currY - 1] == 'P') {
			currPath += 'W';
		} else if (currX + 1 < maze.length && maze[currX + 1][currY] == 'P') {
			currPath += 'S';
		} else if (currX - 1 >= 0 && maze[currX - 1][currY] == 'P') {
			currPath += 'N';
		}
		return ((currY + 1 < maze[currX].length && maze[currX][currY + 1] == 'P')
				|| (currY - 1 >= 0 && maze[currX][currY - 1] == 'P')
				|| (currX + 1 < maze.length && maze[currX + 1][currY] == 'P')
				|| (currX - 1 >= 0 && maze[currX - 1][currY] == 'P'));
	}

	void backTrack() {
		// sanity check currPath.length() should always be > 0 when we call backTrack
		if (currPath.length() > 0) {
			placeded();
			switch (currPath.charAt(currPath.length() - 1)) {
			case 'E':
				currY--;
				break;
			case 'W':
				currY++;
				break;
			case 'S':
				currX--;
				break;
			case 'N':
				currX++;
				break;
			}
			currPath = currPath.substring(0, currPath.length() - 1);
			solveMaze();
		}
	}

	void printMaze() {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}
	}

	private void PlaceBad() throws IOException {
		int flag1 = 0;
		File file = new File("Bad Seeds");
		FileWriter write = new FileWriter(file, true);
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if (line.contains(seed + ":" + c + ":" + r)) {
				flag1 = 1;
				break;
			}
		}
		if (flag1 == 0) {
			write.append("\n" + seed + ":" + c + ":" + r);
		}
		write.flush();
		write.close();
	}
}