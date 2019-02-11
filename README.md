# Maze-Test
This is just a small Maze Game made in Java with a seed system, a bad seed system (as in unsolveable mazes), and a (relatively dumb) AI
* Main is the main runner class for the program
* Create creates a 2d Char Array
* Seed adds m and P
* Game is the class containing the code for the main game; it returns the number of moves you took
* AI is the class containing the dumb ai
* Auto is a file used to find bad seeds and is run as `java Auto [width] [height]`
* Find is a helper class meant to help find m and P
* Print is another helper class meant to print the char array
* Turn is the last of the helper methods that just implement going up, down, right, or left
* Run.sh is a utility program to run `java Auto 10 10` 100 times

To start using it just make sure you have [java] installed

Then just do `java Main` and you'll be running it

This also contains both the compiled class files and source code

Please credit me if you use this code.

[java]: https://www.java.com/en/download/manual.jsp "Java Download Page"
