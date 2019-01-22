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

public class Controller {

    private XboxController controller;
    private Button aBtn;
    private Button bBtn;
    private Button xBtn;
    private Button yBtn;
    private Button lbBtn;
    private Button rbBtn;
    private Button ltBtn;
    private Button rtBtn;

    public Controller(int port) {
        controller = new XboxController(port);
        aBtn = new JoystickButton(controller, ControllerMap.A_BUTTON_PORT);
        bBtn = new JoystickButton(controller, ControllerMap.B_BUTTON_PORT);
        xBtn = new JoystickButton(controller, ControllerMap.X_BUTTON_PORT);
        yBtn = new JoystickButton(controller, ControllerMap.Y_BUTTON_PORT);
        lbBtn = new JoystickButton(controller, ControllerMap.LB_PORT);
        rbBtn = new JoystickButton(controller, ControllerMap.RB_PORT);
        ltBtn = new JoystickButton(controller, ControllerMap.LT_PORT);
        rtBtn = new JoystickButton(controller, ControllerMap.RT_PORT);
    }

    public Button getA() {
        return aBtn;
    }

    public Button getB() {
        return bBtn;
    }

    public Button getX() {
        return xBtn;
    }

    public Button getY() {
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