package frc.robot.util;

import frc.robot.commands.*;
import frc.robot.constants.*;
import frc.robot.driver.*;
import frc.robot.subsystems.*;
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
    private Button startBtn;
    private Button backBtn;

    public Controller(int port) {
        super(port);
        //controller = new XboxController(port);
        aBtn = new JoystickButton(this, ControllerMap.A_BUTTON_PORT);
        bBtn = new JoystickButton(this, ControllerMap.B_BUTTON_PORT);
        xBtn = new JoystickButton(this, ControllerMap.X_BUTTON_PORT);
        yBtn = new JoystickButton(this, ControllerMap.Y_BUTTON_PORT);
        lbBtn = new JoystickButton(this, ControllerMap.LB_PORT);
        rbBtn = new JoystickButton(this, ControllerMap.RB_PORT);
        startBtn = new JoystickButton(this, ControllerMap.START_PORT);
        backBtn = new JoystickButton(this, ControllerMap.BACK_PORT);
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

    public Button getStart() {
        return startBtn;
    }

    public Button getBack() {
        return backBtn;
    }

    public Button getStartBack() {
        return new Button() {

            @Override
            public boolean get() {
                return getStartButton() && getBackButton();
            }

        };
    }

    public Button getDPadRight() {
        return new Button() {
            @Override
            public boolean get() {
                return getPOV(0) == 90;
            }
        };
    }

    public Button getDPadUp() {
        return new Button() {
            @Override
            public boolean get() {
                return getPOV(0) == 0;
            }
        };
    }

    public Button getDPadLeft() {
        return new Button() {
            @Override
            public boolean get() {
                return getPOV(0) == 270;
            }
        };
    }

    public Button getDPadDown() {
        return new Button() {
            @Override
            public boolean get() {
                return getPOV(0) == 180;
            }
        };
    }



}
