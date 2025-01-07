package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class Swerve extends SubsystemBase {
    VictorSP backLeft = new VictorSP(7);
    VictorSP backRight = new VictorSP(4);
    VictorSP frontLeft = new VictorSP(6);
    VictorSP frontRight = new VictorSP(5);

    public Swerve() {
        backLeft.addFollower(frontLeft);
        frontLeft.setInverted(true);
        backRight.addFollower(frontRight);
    }

    public void Drive(double leftVolts, double rightVolts) {
        backLeft.set(leftVolts);
        backRight.set(rightVolts);
    }

    public Command teleopSwerve(CommandXboxController controller) {
        return this.run(() -> Drive(controller.getLeftY(), controller.getRightY()));
    }

}
