package frc.robot.util;

import frc.robot.commands.*;
import frc.robot.constants.*;
import frc.robot.driver.*;
import frc.robot.subsystems.*;
import frc.robot.util.*;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.*;

public class Controller extends XboxController {

    //private XboxController controller;
    private Button aBtn;
    private Button bBtn;
    private Button xBtn;
    private Button yBtn;
    private Button lbBtn;
    private Button rbBtn;
    private Button ltBtn;
    private Button rtBtn;

    public Controller(int port) {
        super(port);
        //controller = new XboxController(port);
        aBtn = new JoystickButton(this, ControllerMap.A_BUTTON_PORT);
        bBtn = new JoystickButton(this, ControllerMap.B_BUTTON_PORT);
        xBtn = new JoystickButton(this, ControllerMap.X_BUTTON_PORT);
        yBtn = new JoystickButton(this, ControllerMap.Y_BUTTON_PORT);
        lbBtn = new JoystickButton(this, ControllerMap.LB_PORT);
        rbBtn = new JoystickButton(this, ControllerMap.RB_PORT);
        ltBtn = new JoystickButton(this, ControllerMap.LT_PORT);
        rtBtn = new JoystickButton(this, ControllerMap.RT_PORT);
    }

    public Button getABtn() {
        return aBtn;
    }

    public Button getBBtn() {
        return bBtn;
    }

    public Button getXBtn() {
        return xBtn;
    }

    public Button getYBtn() {
        return yBtn;
    }

    public Button getLB() {
        return lbBtn;
    }

    public Button getRB() {
        return rbBtn;
    }

    public Button getLT() {
        return ltBtn;
    }

    public Button getRT() {
        return rtBtn;
    }


}