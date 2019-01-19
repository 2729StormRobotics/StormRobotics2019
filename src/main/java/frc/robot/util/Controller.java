package frc.robot.util;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID;

public class Controller {
    private XboxController driver;
    private XboxController weapons;

    public Controller() {
        driver = new XboxController(0);
        weapons = new XboxController(1);
    }

    public double getLeftSpeed() {
        return driver.getY(GenericHID.Hand.kLeft);
    }

    public double getRightSpeed() {
        return driver.getY(GenericHID.Hand.kRight);
    }
}