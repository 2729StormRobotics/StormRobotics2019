package main.java.frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class NavX extends Subsystem {
    public static AHRS navx;


    public NavX() {
        NavX.connectUSB();
    }

    //ports
    public static synchronized boolean connectUSB() throws RuntimeException {

        if (navx == null || !navx.isConnected()) { 
            navx = new AHRS(SerialPort.Port.kUSB);
            System.out.println("NavX Connected: " + navx.isConnected());
        }

        return true;
    }

    private static synchronized boolean connectMXPSPI() throws RuntimeException {
        if (navx == null || !navx.isConnected()) {
            navx = new AHRS(SPI.Port.kMXP);
            System.out.println("NavX Connected: " + navx.isConnected());
        }

        return true;
    }

    private static synchronized boolean connectMXPI2C() throws RuntimeException {
        if (navx == null || !navx.isConnected()) {
            navx = new AHRS(I2C.Port.kMXP);
            System.out.println("NavX Connected: " + navx.isConnected());
        }

        return true;
    }

    private static synchronized boolean connectMXPSerial() throws RuntimeException {
        if (navx == null || !navx.isConnected()) {
            navx = new AHRS(SerialPort.Port.kMXP);
            System.out.println("NavX Connected: " + navx.isConnected());
        }

        return true;
    }

    private static synchronized boolean connectI2C() throws RuntimeException {
        if (navx == null || !navx.isConnected()) {
            navx = new AHRS(I2C.Port.kOnboard);
            System.out.println("NavX Connected: " + navx.isConnected());
        }

        return true;
    }

    @Override
    protected void initDefaultCommand() {
        periodic();
    }

    @Override
    public void periodic() {
        super.periodic();
        NavX.connect();
    }

    //call method
    public static synchronized AHRS getNavx() throws NullPointerException {
        if (NavX.connect()) {
            return navx;
        } else {
            throw new NullPointerException("Failed to connect to the NavX!");
        }
    }

}