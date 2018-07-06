package com.bgure;

import java.awt.*;

public class InfinityCursor implements Runnable
{

    final int MINIMUM_X_OF_SCREEN = 0;
    final int MINIMUM_Y_OF_SCREEN = 0;
    final int PADDING_OF_SCREEN = 1;

    private int screenWidth = 0;
    private int screenHeight = 0;

    private boolean isStart;

    public InfinityCursor() {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        screenWidth = gd.getDisplayMode().getWidth();
        screenHeight = gd.getDisplayMode().getHeight();
        isStart = true;
    }

    public void setStart(boolean start) {
        isStart = start;
    }

    public boolean isStart() {
        return isStart;
    }

    @Override
    public void run() {

        while(true)
        {
            if(isStart()) {
                Cursor.listenCursorMovement();
                if(Cursor.getX() <= MINIMUM_X_OF_SCREEN) {
                    Cursor.setX(screenWidth - PADDING_OF_SCREEN - 1);
                }

                if(Cursor.getX() >= screenWidth - 1){
                    Cursor.setX(MINIMUM_X_OF_SCREEN + PADDING_OF_SCREEN);
                }

                if(Cursor.getY() <= MINIMUM_Y_OF_SCREEN){
                    Cursor.setY(screenHeight - PADDING_OF_SCREEN - 1);
                }

                if(Cursor.getY() >= screenHeight - 1){
                    Cursor.setY(MINIMUM_Y_OF_SCREEN + PADDING_OF_SCREEN);
                }
            }

        }
    }
}
