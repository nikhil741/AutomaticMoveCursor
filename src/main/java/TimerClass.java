/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nikhil
 */
import java.util.TimerTask;
import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TimerClass extends TimerTask {
    private Robot robot;
    private static int state;
    private Random rand;
    
    TimerClass(){
        state = 0;
        rand = new Random();
        try {
            robot = new Robot();
        } catch (AWTException ex) {
            Logger.getLogger(TimerClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void setState(int state){
        TimerClass.state = state;
    }
    
    public static int getState(){
        return TimerClass.state;
    }
    
    @Override
    public void run() {
        int x_new_pos=0, y_new_pos=0;
        if(state == 0){
            x_new_pos = MouseInfo.getPointerInfo().getLocation().x + 1;
            y_new_pos = MouseInfo.getPointerInfo().getLocation().y + 1;
        }
        else{
            //Random = new Random();
            x_new_pos = y_new_pos = rand.nextInt(1000);
        }
        robot.mouseMove(x_new_pos, y_new_pos);
    }
}
