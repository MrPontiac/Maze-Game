
//grab all necessary packages
import java.util.*;
import java.io.File;
import java.lang.Math;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;

//everything gets run from here
public class Main {
	public static boolean checkForBad(long seed1) throws IOException {
		int flag1 = 0;
		Scanner scanner = null;
		try {
			File file = new File("Bad Seeds");
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (line.split(":")[0].equals(Long.toString(seed1))) {
					flag1 = 1;
				}
			}
		} finally {
			scanner.close();
		}
		if (flag1 == 1) {
			return true;
		}
		return false;
	}

	// main thing to be run
	public static void main(String[] args) throws IOException {
		// define a scanner
		Scanner scan = new Scanner(System.in);
		System.out.println("Want to specify a seed? 1 = yes 0 = no");
		File bfile = new File("Bad Seeds");
		if (!bfile.exists()) {
			bfile.createNewFile();
		}
		int choi = scan.nextInt();
		long seed1 = 0;
		if (choi == 1) {
			System.out.println("Input a seed...");
			seed1 = scan.nextLong();
			System.out.println("That seed is a " + (checkForBad(seed1) ? "Bad" : "Good") + " seed");
		} else {
			long max = 9223372036854775806L;
			seed1 = (long) (Math.random() * max);
			while (checkForBad(seed1)) {
				seed1 = (long) (Math.random() * max);
				System.out.println("Checking seed " + seed1 + ": " + checkForBad(seed1));
			}
			System.out.println("Seed is " + seed1 + "...");
		}
		Random random = new Random(seed1);
		System.out.println("Input dimensions for maze: ");

		// take inputs
		int c = scan.nextInt();
		int r = scan.nextInt();

		// create a maze based on previous inputs
		char[][] Maze = create.Maze(c, r, random);

		// add m and p
		Maze = seed.Maze(c, r, Maze, random);

		System.out.println("1 for AI, 0 for manual");
		int d = scan.nextInt();
		if (d == 0) {
			System.out.println(
					"Welcome to my maze game! You have to use WASD to go left, right, up, or down repectively. Your goal is to land an the \"p\". Then you win! Otherwise if the seed is bad, then type bad");

			// run main game loop and retrive moves
			int count = game.main(Maze, c, r, seed1);

			// different endings based on the amount of moves you took
			if (count == 1) {
				System.out.println("Congrats! You Won! And it only took you " + count + " move!");
			} else if (count > 1) {
				System.out.println("Congrats! You Won! And it only took you " + count + " moves!");
			} else {
				System.out.println("Congrats! You Won! And it only took you " + count
						+ " moves! Wait... That shouldn't be possible... Tell MrPontiac this: " + seed1 + ":" + c + ":" + r);
				File file = new File("Weird Seeds");
				if (!file.exists()) {
					file.createNewFile();
				}
				FileWriter write = new FileWriter(file, true);
				write.append("\n" + seed1 + ":" + c + ":" + r);
				write.flush();
				write.close();
				System.exit(1);
			}
		} else if (d == 1) {
			int[] pos = Find.M(Maze, c, r);
			int strX = pos[0];
			int strY = pos[1];
			AI ai = new AI(Maze, strX, strY, new String(""), false, seed1);
			ai.printMaze();
			ai.placePlus();
			ai.solveMaze();
			if (ai.unsolvable) {
				System.out.println("Unsolvable");
			} else {
				System.out.println("Possible Solution: " + ai.currPath);
			}
			System.out.println("Start at [" + strX + ", " + strY + "]\n");
			ai.printMaze();
		}
		scan.close();
	}
}
