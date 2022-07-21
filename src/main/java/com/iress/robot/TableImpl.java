package com.iress.robot;

public class TableImpl implements Table {

    int x_axis;
    int y_axis;

    public TableImpl(int x, int y) { //CREATE a table of given rows & columns
        this.x_axis = x;
        this.y_axis = y;
    }

    public boolean isPositionValid(PositionOnTable current_x_y_position) {
        return !(current_x_y_position.getY() < 0 ||current_x_y_position.getY() > this.x_axis || current_x_y_position.getX() < 0|| current_x_y_position.getX() > this.y_axis );
    }
}
