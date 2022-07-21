package com.iress;

import com.iress.exceptions.robotErroredException;
import com.iress.robot.TableImpl;
import com.iress.robot.IressRobot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {


        TableImpl game_board = new TableImpl(4, 4); // A 5x5 square for the robot move
        IressRobot robot = new IressRobot();
        RobotApplication robotApplication = new RobotApplication(game_board, robot);

        System.out.println("IRESS Robot Code Challenge 2022");
        System.out.println("Below are valid commands:");
        System.out.println("\'PLACE X,Y,NORTH|SOUTH|EAST|WEST\', MOVE, LEFT, RIGHT, REPORT or EXIT");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean isApplicationRunning = true;
        while (isApplicationRunning) {
        	System.out.println("Please Enter a command: ");
            String inputString = br.readLine();
            if ("EXIT".equalsIgnoreCase(inputString)) {
            	isApplicationRunning = false;
            } else {
                try {
                    String outputVal = robotApplication.eval(inputString);
                    System.out.println(outputVal);
                } catch (robotErroredException e) {
                    System.out.println("AN EXCEPTION HAS OCCURED! " + e.getMessage());
                }
            }
        }
    }
}