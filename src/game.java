import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class game {
	public static int main(char[][] Maze, int c, int r, long seed1) throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println();
		print.Maze(Maze, c, r);
		int count = 0;
		int flag = 0;
		while (Find.P(Maze, c, r) && flag == 0) {
			int[] pos = Find.M(Maze, c, r);
			int p1 = pos[0];
			int p2 = pos[1];
			System.out.println("Where to next?");
			String l = scan.nextLine();
			if (l.equals("d")) {
				turn.right(Maze, p1, p2, r);
				System.out.println();
				print.Maze(Maze, c, r);
				count++;
			} else if (l.equals("a")) {
				turn.left(Maze, p1, p2);
				System.out.println();
				print.Maze(Maze, c, r);
				count++;
			} else if (l.equals("w")) {
				turn.up(Maze, p1, p2);
				System.out.println();
				print.Maze(Maze, c, r);
				count++;
			} else if (l.equals("s")) {
				turn.down(Maze, p1, p2, c);
				System.out.println();
				print.Maze(Maze, c, r);
				count++;
			} else if (l.equalsIgnoreCase("bad")) {
				System.out.println("Duly Noted");
				File file = new File("Bad Seeds");
				FileWriter write = new FileWriter(file, true);
				write.append("\n" + seed1 + ":" + c + ":" + r);
				write.flush();
				write.close();
				flag = 1;
				count++;
			} else {
				System.out.println("Wrong input");
			}
		}
		return count;
	}
}