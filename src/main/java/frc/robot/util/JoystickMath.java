package frc.robot.util;

import frc.robot.Robot;
import frc.robot.commands.*;
import frc.robot.constants.*;
import frc.robot.driver.*;
import frc.robot.subsystems.*;
import frc.robot.util.*;


public abstract class JoystickMath {
    
    private JoystickMath() {
        
    }


    /**
     * 
     * @param stickValue input value from controller
     * @param power value between 0 and infnity, with 0<n<1 being positive acceleration and n>1 being negative acceleration
     * 
     * @return the corresponding stick value after precision curves are applied
     */
    public static double getPower(double stickValue, double power) {
        if (Math.abs(stickValue) < RobotMap.CONTROLLER_DEADZONE) {
            return 0;
        }

        if (stickValue >= 0) {
            return Math.pow(stickValue, power);
        }
            return - Math.abs(Math.pow(stickValue, power));
    }
    
    public static double getLinear(double stickValue) {
        return JoystickMath.getPower(stickValue, 1);
    }
    
    public static double getQuadratic(double stickValue) {
        return JoystickMath.getPower(stickValue, 2);
    }

    public static double getCubic(double stickValue) {
        return JoystickMath.getPower(stickValue, 3);
    }


}