package com.iress.robot;


import java.util.HashMap;
import java.util.Map;

public enum RobotDirection {

    NORTH(0), 
    EAST(1), 
    SOUTH(2), 
    WEST(3);
	
	private static Map<Integer, RobotDirection> directionsMap = new HashMap<Integer, RobotDirection>();
	
	private int directionOfIndex;
	
	private RobotDirection(int direction) {
        this.directionOfIndex = direction;
    }
	
    public static RobotDirection valueOf(int directionNum) {
        return directionsMap.get(directionNum); //RETURNS direction given an index
    }
    
    public RobotDirection rightDirection() {
        int newDirection = (this.directionOfIndex + 1) < 0 ? directionsMap.size() - 1 : (this.directionOfIndex + 1) % directionsMap.size();
        return RobotDirection.valueOf(newDirection); //TURNS the direction of the robot to the right
    }
    
    public RobotDirection leftDirection() {
        int newDirection = (this.directionOfIndex - 1) < 0 ? directionsMap.size() - 1 : (this.directionOfIndex - 1) % directionsMap.size();
        return RobotDirection.valueOf(newDirection); //TURNS the direction of the robot to the left
    }
        
    static {
        for (RobotDirection directionEnum : RobotDirection.values()) {
            directionsMap.put(directionEnum.directionOfIndex, directionEnum); //Populate the directionsMap with directions and their respective index
        }
    }

}
