package com.iress;

import com.iress.exceptions.robotErroredException;
import com.iress.robot.*;

public class RobotApplication {

    Table gameBoard;
    IressRobot robot;

    public RobotApplication(Table gameBoard, IressRobot robot) {
        this.gameBoard = gameBoard;
        this.robot = robot;
    }

    public boolean placeToyRobot(PositionOnTable position) throws robotErroredException {

        if (position == null)
            throw new robotErroredException("Invalid robot position");

        if (position.getDirection() == null)
            throw new robotErroredException("Invalid robot direction");

        if (gameBoard == null)
            throw new robotErroredException("Invalid robot gameBoard");

        
        if (!gameBoard.isPositionValid(position))
            return false;
        robot.setRobotPosition(position);
        return true;
    }

    public String eval(String inputString) throws robotErroredException {
        String[] args = inputString.split(" ");
        Commands command;
        try {
            command = Commands.valueOf(args[0]);
        } catch (IllegalArgumentException e) {
            throw new robotErroredException("Invalid command");
        }
        if (command == Commands.PLACE && args.length < 2) {
            throw new robotErroredException("Invalid command");
        }

        // validate PLACE params
        String[] params;
        int x = 0;
        int y = 0;
        RobotDirection commandDirection = null;
        if (command == Commands.PLACE) {
            params = args[1].split(",");
            try {
                x = Integer.parseInt(params[0]);
                y = Integer.parseInt(params[1]);
                commandDirection = RobotDirection.valueOf(params[2]);
            } catch (Exception e) {
                throw new robotErroredException("Invalid command");
            }
        }

        String output;

        switch (command) {
            case PLACE:
                output = String.valueOf(placeToyRobot(new PositionOnTable(x, y, commandDirection)));
                if(output.equalsIgnoreCase("TRUE")) {
                	output = "ROBOT PLACED AT " + x + ", "+ y + "," + commandDirection;
                }
                break;
            case MOVE:
                PositionOnTable newPosition = robot.getPosition().getNextPosition();
                if (!gameBoard.isPositionValid(newPosition))
                    output = String.valueOf(false);
                else
                    output = String.valueOf(robot.move(newPosition));
                	if(output.equalsIgnoreCase("TRUE")) {
                		output = "Robot Moved!";                		
                	}
                break;
            case LEFT:
                output = String.valueOf(robot.rotateLeft());
                if(output.equalsIgnoreCase("TRUE")) {
                	output = "ROBOT ROTATED LEFT";
                }
                break;
            case RIGHT:
                output = String.valueOf(robot.rotateRight());
                if(output.equalsIgnoreCase("TRUE")) {
                	output = "ROBOT ROTATED RIGHT";
                }
                break;
            case REPORT:
                output = report();
                break;
            default:
                throw new robotErroredException("Invalid command");
        }

        return output;
    }
    
    public String report() {
        if (robot.getPosition() == null)
            return null;

        return robot.getPosition().getX() + "," + robot.getPosition().getY() + "," + robot.getPosition().getDirection().toString();
    }
}
