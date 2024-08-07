// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AutoTank;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.PhotonVision;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class GoToDistance extends SequentialCommandGroup {
  /** Creates a new GoToDistance. */
  public GoToDistance(DriveSubsystem driveSubsystem, PhotonVision photonVision) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
      addCommands(
        new AutoTank(driveSubsystem, () -> 1, () -> 0)
      );
      
      if (photonVision.getDistance() < 4) {
        addCommands(
          new AutoTank(driveSubsystem, () -> 0, () -> 0)
        );
      }
  }
}
