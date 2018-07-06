package com.bgure;

import java.awt.*;

public class Cursor
{
    private static PointerInfo pointerInfo;
    private static Robot robot;

    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static boolean listenCursorMovement()
    {
        pointerInfo = MouseInfo.getPointerInfo();
        return true;
    }

    public static int getX() { return (int) pointerInfo.getLocation().getX(); }

    public static int getY()
    {
        return (int) pointerInfo.getLocation().getY();
    }

    public static void setX(int x){ setPosition(x, getY()); }

    public static void setY(int y){ setPosition(getX(), y); }

    public static void setPosition(int x, int y)
    {
        robot.mouseMove(x, y);
    }
}
