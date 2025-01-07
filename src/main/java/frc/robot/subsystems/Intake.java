package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    VictorSP IntakeMotor1 = new VictorSP(1);
    VictorSP IntakeMotor2 = new VictorSP(2);

    public Intake() {
        IntakeMotor2.setInverted(true);
        IntakeMotor2.addFollower(IntakeMotor1);
    }

    public void intake() {
        IntakeMotor2.set(1);
    }

    public void outtake() {
        IntakeMotor2.set(-1);
    }

    public void stop() {
        IntakeMotor2.set(0);
    }

    public Command intakeCommand() {
        return Commands.runEnd(this::intake, () -> stop());
    }

    public Command outtakeCommand() {
        return Commands.runEnd(this::outtake, () -> stop());
    }
}
