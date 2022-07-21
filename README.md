# ToyRobotCodeChallenge
The application is a simulation of a toy robot moving on a square table top, of dimensions x & y units. There are no
other obstructions on the table surface. The robot is free to roam around the surface of the table, but must be prevented
from falling to destruction. Any movement that would result in the robot falling from the table must be prevented,
however further valid movement commands must still be allowed.

**Game Instructions**
`PLACE` will put the toy robot on the table in position X,Y and facing NORTH, SOUTH, EAST or WEST. The origin (0,0)
can be considered to be the SOUTH WEST most corner. It is required that the first command to the robot is a PLACE
command, after that, any sequence of commands may be issued, in any order, including another PLACE command. The
application should discard all commands in the sequence until a valid PLACE command has been executed.
`MOVE` will move the toy robot one unit forward in the direction it is currently facing.
`LEFT` and `RIGHT` will rotate the robot 90 degrees in the specified direction without changing the position of the robot.
`REPORT` will announce the X,Y and F of the robot. This can be in any form, but standard output is sufficient.
A robot that is not on the table can choose to ignore the `MOVE`, `LEFT`, `RIGHT` and `REPORT` commands.



**Instructions to Run**
<br>  Ensure maven and Java Home are installed on the system running this application.
<br>  To compile application run `mvn compile`
<br> To run application run `mvn spring-boot:run`

