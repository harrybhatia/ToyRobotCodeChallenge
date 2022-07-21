package com.iress.robot;

import com.iress.exceptions.robotErroredException;

public class IressRobot {

    private PositionOnTable position;

    public IressRobot() {
    }

    public IressRobot(PositionOnTable position) {
        this.position = position;
    }

    public boolean rotateRight() {
        if (this.position.facing_direction == null)
            return false;

        this.position.facing_direction = this.position.facing_direction.rightDirection();
        return true;
    }
    
    public boolean rotateLeft() {
        if (this.position.facing_direction == null)
            return false;

        this.position.facing_direction = this.position.facing_direction.leftDirection();
        return true;
    }

    public boolean setRobotPosition(PositionOnTable position) {
        if (null == position) 
        { 
        	return false; 
        }
        else {
        	this.position = position;
            return true;
        }
    }

    public boolean moveRobot() throws robotErroredException {
        return move(position.getNextPosition());
    }
    
    public boolean move(PositionOnTable newPosition) {
        if (newPosition == null) {
        	return false;
        }
        else {
        	this.position = newPosition;
            return true;
        }
    }

    public PositionOnTable getPosition() {
        return this.position;
    }

}
