Assignment:
A team of robotic engineers need to control the robot, the robot in placed in a field which is  rectangular in shape ,the robot must be navigated by the instructions .The  robot’s position and location is represented by a combination of x and y coordinates and a letter representing one of the four directions(N S E W). The field is divided up into a grid to simplify navigation. An example position might be 0, 0, N, which means the robot is in the bottom left corner and facing North.In order to control a robot, engineers sends a simple string of letters. The possible letters are ‘P’, ‘R’ and ‘Q’. ‘P’ and ‘R’ makes the robot spin 90 degrees left or right respectively, without moving from its current spot. ‘Q’ means move forward one grid point, and maintain the same heading. Assume that the square directly North from (x, y) is (x, y+1).

Write a program which takes the inputs in the following format and output as shown below 
INPUT:
The first line of input is the upper-right coordinates of the field, the lower-left coordinates are assumed to be 0,0.The rest of the input is information pertaining to the robots that have been deployed. Each robot has two lines of input. The first line gives the robot’s position, and the second line is a series of instructions telling the robot how to explore the field.The position is made up of two integers and a letter separated by spaces, corresponding to the x and y coordinates and the robot’s orientation.Each robot will be finished sequentially, which means that the second robot won’t start to move until the first one has finished moving.

OUTPUT:
The output for each robot should be its final coordinates and heading.

Example: 
Test Input:
5 5
1 2 N
PQPQPQPQQ
3 3 E
QQRQQRQRRQ

Expected Output:
1 3 N
5 1 E
------------------------------
 
 1. Implemented above assignment in JAVA environment (Eclipse IDE)
 2. Reading the input data from "input.txt" file which is stored in root directory of this project.
 		(RobotController/input.txt)
 3. To check with various input please add the input data in this "input.txt" and run again.
 
