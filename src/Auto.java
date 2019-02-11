import java.lang.Math;
import java.util.*;
import java.io.File;
import java.io.IOException;

class Auto {
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
  
  public static void main(String[] args) throws IOException {
    int c = 0;
    int r = 0;
    if(args.length == 2) {
      c = Integer.parseInt(args[0]);
      r = Integer.parseInt(args[1]);
      
      long max = 9223372036854775806L;
			long seed1 = (long) (Math.random() * max);
			while (checkForBad(seed1)) {
				seed1 = (long) (Math.random() * max);
      }
      Random random = new Random(seed1);
      
      char[][] Maze = create.Maze(c, r, random);
      Maze = seed.Maze(c, r, Maze, random);
      
      int[] pos = Find.M(Maze, c, r);
			int strX = pos[0];
			int strY = pos[1];
			AI ai = new AI(Maze, strX, strY, new String(""), false, seed1);
      
      ai.placePlus();
			ai.solveMaze();
			if (ai.unsolvable) {
				System.out.println("Found Bad");
			} else {
        System.out.println("Solved Silently");
      }
    }
  }
}