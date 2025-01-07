package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LED extends SubsystemBase {
    AddressableLED leds;
    AddressableLEDBuffer buffer;

    public LED(int portnumber, int length) {
        this.leds = new AddressableLED(portnumber);
        this.buffer = new AddressableLEDBuffer(length);
        leds.setLength(buffer.getLength());
        leds.setData(buffer);
        leds.start();
    }

    public void LEDColors(Color colors) {
        for (var i = 0; i < buffer.getLength(); i++) {
            buffer.setLED(i, colors);
        }
        leds.setData(buffer);
    }

    public Command setAllanceColor() {
        return Commands.run(() -> {
            Color colors = Color.kYellow;
            if (DriverStation.getAlliance().isPresent()) {
                if (DriverStation.getAlliance().get() == Alliance.Red) {
                    colors = Color.kRed;
                } else {
                    colors = Color.kBlue;
                }
            }
            LEDColors(colors);

        }, this);
    }

    public Command GreenIntake() {
        return Commands.run(() -> {
            LEDColors(Color.kGreen);
        }, this);
    }
}
