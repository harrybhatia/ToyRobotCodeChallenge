package com.iress.robot;

import com.iress.exceptions.robotErroredException;

public class PositionOnTable {
    int x_axis;
    int y_axis;
    RobotDirection facing_direction;

    public PositionOnTable(int x, int y, RobotDirection direction) {
        this.x_axis = x;
        this.y_axis = y;
        this.facing_direction = direction;
    }
    public PositionOnTable(PositionOnTable position) {
        this.x_axis = position.getX();
        this.y_axis = position.getY();
        this.facing_direction = position.getDirection();
    }

    public int getX() {
        return this.x_axis;
    }

    public int getY() {
        return this.y_axis;
    }

    public RobotDirection getDirection() {
        return this.facing_direction;
    }

    public void setDirection(RobotDirection direction) {
        this.facing_direction = direction;
    }

    public void change(int x, int y) {
        this.x_axis = this.x_axis + x;
        this.y_axis = this.y_axis + y;
    }

    public PositionOnTable getNextPosition() throws robotErroredException {
        if (this.facing_direction == null)
            throw new robotErroredException("Invalid robot direction");
        
        PositionOnTable newPosition = new PositionOnTable(this);
        switch (this.facing_direction) {
	        case WEST:
	            newPosition.change(-1, 0);
	            break;
	        case SOUTH:
                newPosition.change(0, -1);
                break;
	        case EAST:
                newPosition.change(1, 0);
                break;
            case NORTH:
                newPosition.change(0, 1);
                break; 
        }
        return newPosition;
    }
}
