import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Program to execute the robot instructions to navigation the robot in a given
 * field.
 */
public class RoboController {

	// Robot navigation directions
	private static final int LEFT = 1;
	private static final int RIGHT = 2;

	// Fields to store robot current status
	private static int currentX;
	private static int currentY;
	private static char currentDirection;
	private static int fieldRow, fieldCol;

	private static ArrayList<Robot> robots = new ArrayList<>();

	public static void main(String[] args) throws FileNotFoundException {

		// Scanner scanner = new Scanner(System.in);

		// Using scanner class to read input from the file which is store root
		// directory of this project.
		Scanner scanner = new Scanner(new File("input.txt"));

		try {
			fieldRow = scanner.nextInt();
			fieldCol = scanner.nextInt();

			Robot robo;
			while (scanner.hasNext()) {
				robo = new Robot();
				robo.x = scanner.nextInt();
				robo.y = scanner.nextInt();
				robo.direction = scanner.next().charAt(0);
				robo.instructions = scanner.next();

				robots.add(robo);
			}

		} catch (NoSuchElementException e) {
			System.out.println("Error in input data.");
		}

		for (int index = 0; index < robots.size(); index++) {
			executeRoboInstructions(robots.get(index));
		}
	}

	/**
	 * Method to execute the Robot instructions and print it's final coordinates
	 * and direction.
	 * 
	 * @param robot
	 *            Robot Object
	 */
	private static void executeRoboInstructions(Robot robot) {
		currentX = robot.x;
		currentY = robot.y;
		currentDirection = robot.direction;
		char instructions[] = robot.instructions.toCharArray();
		for (int i = 0; i < instructions.length; i++) {
			if (instructions[i] == 'P') {
				changeDirection(LEFT);
			} else if (instructions[i] == 'R') {
				changeDirection(RIGHT);
			} else if (instructions[i] == 'Q') {
				moveRobot();
			}
		}
		System.out.println(currentX + " " + currentY + " " + currentDirection);
	}

	/**
	 * Method to move the robot position by one unit based on it's current
	 * direction.
	 * 
	 * Check if the robot direction moves out of boundary of the field, 
	 * if it moves out of boundary don't move.
	 */
	private static void moveRobot() {
		switch (currentDirection) {
		case 'N':
			if (currentY + 1 <= fieldCol) {
				currentY += 1;
			}
			break;
		case 'W':
			if (currentX - 1 >= 0) {
				currentX -= 1;
			}
			break;
		case 'S':
			if (currentY - 1 >= 0) {
				currentY -= 1;
			}
			break;
		case 'E':
			if (currentX + 1 <= fieldRow) {
				currentX += 1;
			}
			break;
		}
	}

	/**
	 * Method to change the direction of the robot
	 * 
	 * @param direction
	 *            Robot direction (LEFT/RIGHT)
	 */
	private static void changeDirection(int direction) {
		if (direction == LEFT) {
			if (currentDirection == 'N') {
				currentDirection = 'W';
			} else if (currentDirection == 'W') {
				currentDirection = 'S';
			} else if (currentDirection == 'S') {
				currentDirection = 'E';
			} else if (currentDirection == 'E') {
				currentDirection = 'N';
			}
		} else if (direction == RIGHT) {
			if (currentDirection == 'N') {
				currentDirection = 'E';
			} else if (currentDirection == 'E') {
				currentDirection = 'S';
			} else if (currentDirection == 'S') {
				currentDirection = 'W';
			} else if (currentDirection == 'W') {
				currentDirection = 'N';
			}
		}
	}
}
