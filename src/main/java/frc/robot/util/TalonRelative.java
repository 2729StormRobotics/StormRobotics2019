/*
 Description: 	READ THIS FIRST

 This example demonstrates how to best take advantage of the absolute
 pulse width encoded signal from the CTRE Magnetic Encoder.

 THIS IS NOT A CLOSED-LOOP EXAMPLE.  Instead see the motion magic GitHub example.

 In such applications, a mechanism rotates the mag encoder with a range of < 360 deg.
 This is necessary when tracking the position of an elevator, arm, and other mechanisms
 that do not spin continuously, i.e. have hard limits.

 In such circumstances, the magnet may wrap from the 359' position to the 0' in the
 mechanism range depending on magnet orientation.  Two examples are displayed below.
 The shaded region represents the portion of the magnetic encoder used in your mechanism.

 The top of the circle | mark represents the overflow from 359' to 0'.
 Note when using a CTRE Magnetic encoder, 360' => 4096 units.

                  Scenario 1                      Scenario 2
               From 10' to 350'                 From 100' to 80'
               No discontinuity.              Discontinuity present.

                359' | 0'                        359' | 0'
                     |                                |
                     |                                |
        (350')    %@@@@%    (10')                  %@@@@%
             *@@@         @@*                   @@@@@@@@@@@@@
           @@@@@@&       &@@@@@              @@@@@@@@@@@@@@@@@@#  (80')
         .@@@@@@@@      @@@@@@@@.          #@@@@@@@@@@@@@@@@@@@@@.
         @@@@@@@@@@    #@@@@@@@@@         #@@@@@@@@@@@@@@@@@@#   #.
        @@@@@@@@@@@@  #@@@@@@@@@@@       ,@@@@@@@@@@@@@@@@@*      @
        @@@@@@@@@@@@**@@@@@@@@@@@@      ,@@@@@@@@@@@@@@@@         ,%
        @@@@@@@@@@@@@@@@@@@@@@@@@@      ,@@@@@@@@@@@@@@            @
        @@@@@@@@@@@@@@@@@@@@@@@@@@       @@@@@@@@@@@@@@@@@#       ,%
        .@@@@@@@@@@@@@@@@@@@@@@@@.        @@@@@@@@@@@@@@@@@@@@*   @
         *@@@@@@@@@@@@@@@@@@@@@@*          @@@@@@@@@@@@@@@@@@@@@@@  (100')
           @@@@@@@@@@@@@@@@@@@@             @@@@@@@@@@@@@@@@@@@@@
             &@@@@@@@@@@@@@@&                 @@@@@@@@@@@@@@@@@
                 *@@@@@@*                        #@@@@@@@@@*

 In scenario 1, the pulse width sensor (with overflows removed) has one hard limit at 10'
 and another hard limit at 350' with no discontinuities in the travel (shaded part).
 This also means the travel is also 340', with the remaining 20' not used.

 In scenario 2, the pulse width sensor (with overflows removed) has one hard limit at 80'
 and another hard limit at 100' with a discontinuity in the travel (shaded part).
 This also means the travel is also 340', with the remaining 20' not used.

 When the magnet is in scenario 2, an offset can be applied to produce an absolute pulse width
 measurement with no discontinuities.
 This can be done by subtracting the middle of the unused part.  In scenario 2 that would
 be (80' + 100')/2 or 90'.  This also makes the middle of the unused part the new discontinuity.

                    Scenario 2 (with - 90 offset)
                Discontinuity moved to unshaded area

                           | (0' => 270')
                           |
                           |
                        %@@@@%
                     @@@@@@@@@@@@@
                  @@@@@@@@@@@@@@@@@@#  (80' => 350')
                #@@@@@@@@@@@@@@@@@@@@@.
               #@@@@@@@@@@@@@@@@@@#   #.
              ,@@@@@@@@@@@@@@@@@*      @
             ,@@@@@@@@@@@@@@@@         ,%
             ,@@@@@@@@@@@@@@            @
              @@@@@@@@@@@@@@@@@#       ,%
               @@@@@@@@@@@@@@@@@@@@*   @
                @@@@@@@@@@@@@@@@@@@@@@@  (100' => 10')
                 @@@@@@@@@@@@@@@@@@@@@
                   @@@@@@@@@@@@@@@@@
                      #@@@@@@@@@*

 * Test procedure
 * [1] Adjust Talon device ID and Gamepad button assignment
 * [2] Deploy this application
 * [3] Manually move mechanism from hard limit to hard limit.
 * Note the pulseWidPos value in the console output.
 * Note if there is a wrap (4096 => 0 or 0 => 4096).
 * [4] Record measured sensor hard limit values during [3] at kBookEnd defines
 * [5] Record if sensor discontinuity was observed during [3] at kDiscontinuityPresent.
 * [6] Re-deploy and confirm selSenPos is continuous and maintains value after power cycles (persistent).
 *
 * Controls:
 * Button 1: When button is pressed, seed the quadrature register. You can do this once
 * 	on boot or during teleop/auton init. If you power cycle the Talon, press the button
 * 	to confirm it's position is restored.
 *
 * Supported Version:
 * - Talon SRX: 4.0
 * - Victor SPX: 4.0
 * - Pigeon IMU: 4.0
 * - CANifier: 4.0
 */
package frc.robot.util;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import org.hamcrest.internal.SelfDescribingValueIterator;

public class TalonRelative {
	/** Hardware */
	private TalonSRX _talon = new TalonSRX(3);

	/**
	 * This function is called once on roboRIO bootup
	 * Select the quadrature/mag encoder relative sensor
	 */
	public TalonRelative() {
		/* Factory Default Hardware to prevent unexpected behaviour */
		_talon.configFactoryDefault();


		/* Configure Selected Sensor for Talon */
		_talon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);								// Timeout
	}

	/**
	 * Get the selected sensor register and print it
	 */
	public void debugEncoder() {

		/**
		 * Quadrature is selected for soft-lim/closed-loop/etc. initQuadrature()
		 * will initialize quad to become absolute by using PWD
		 */
		int selSenPos = _talon.getSelectedSensorPosition(0);

		/**
		 * Display how we've adjusted PWM to produce a QUAD signal that is
		 * absolute and continuous. Show in sensor units and in rotation
		 * degrees.
		 */
		System.out.print("selSenPos:" + selSenPos);
        System.out.println();
	}

    public int get() {
        return _talon.getSelectedSensorPosition(0);
    }
}
