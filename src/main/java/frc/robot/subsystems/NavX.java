package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Subsystem;

public class NavX extends Subsystem {
    public static AHRS navx;
    public static long lastConnectAttempt;
    public static final long CONNECTION_ATTEMPT_COOLDOWN = 1000;

    public NavX() {
        try {
            lastConnectAttempt = System.currentTimeMillis();
            NavX.connectMXPSPI();
        } catch (RuntimeException rte) {
            System.err.println("Failed to connect to the NavX!");
        }
    }

    // ports
    public static synchronized boolean connectUSB() throws RuntimeException {
        if (navx != null && !navx.isConnected()) {
            navx = null;
        }

        if (navx == null) {
            if (System.currentTimeMillis() - lastConnectAttempt >= CONNECTION_ATTEMPT_COOLDOWN) {
                lastConnectAttempt = System.currentTimeMillis();
                navx = new AHRS(SerialPort.Port.kUSB);
                System.out.println("NavX Connected: " + navx.isConnected());
            } else {
                return false;
            }
        }

        return true;
    }

    private static synchronized boolean connectMXPSPI() throws RuntimeException {
        if (navx != null && !navx.isConnected()) {
            navx = null;
        }

        if (System.currentTimeMillis() - lastConnectAttempt >= CONNECTION_ATTEMPT_COOLDOWN) {
            lastConnectAttempt = System.currentTimeMillis();
            navx = new AHRS(SPI.Port.kMXP);
            System.out.println("NavX Connected: " + navx.isConnected());
        } else {
            return false;
        }

        return true;
    }

    private static synchronized boolean connectMXPI2C() throws RuntimeException {
        if (navx != null && !navx.isConnected()) {
            navx = null;
        }

        if (System.currentTimeMillis() - lastConnectAttempt >= CONNECTION_ATTEMPT_COOLDOWN) {
            lastConnectAttempt = System.currentTimeMillis();
            navx = new AHRS(I2C.Port.kMXP);
            System.out.println("NavX Connected: " + navx.isConnected());
        } else {
            return false;
        }

        return true;
    }

    private static synchronized boolean connectMXPSerial() throws RuntimeException {
        if (navx != null && !navx.isConnected()) {
            navx = null;
        }

        if (System.currentTimeMillis() - lastConnectAttempt >= CONNECTION_ATTEMPT_COOLDOWN) {
            lastConnectAttempt = System.currentTimeMillis();
            navx = new AHRS(SerialPort.Port.kMXP);
            System.out.println("NavX Connected: " + navx.isConnected());
        } else {
            return false;
        }

        return true;
    }

    private static synchronized boolean connectI2C() throws RuntimeException {
        if (navx != null && !navx.isConnected()) {
            navx = null;
        }

        if (navx == null && System.currentTimeMillis() - lastConnectAttempt >= CONNECTION_ATTEMPT_COOLDOWN) {
            lastConnectAttempt = System.currentTimeMillis();
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
    }

    public static synchronized AHRS getNavx() throws NullPointerException {
        if (NavX.connectMXPSPI()) {
            return navx;
        } else {
            throw new NullPointerException("Failed to connect to the NavX!");
        }
    }

}
