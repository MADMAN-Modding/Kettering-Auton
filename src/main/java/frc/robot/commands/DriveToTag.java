// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.PhotonVision;

public class DriveToTag extends Command {
  PhotonVision photonVision;
  DriveSubsystem driveSubsystem;

  /** Creates a new DriveToTag. */
  public DriveToTag(DriveSubsystem driveSubsystem, PhotonVision photonVision) {
    this.photonVision = photonVision;
    this.driveSubsystem = driveSubsystem;
    addRequirements(driveSubsystem, photonVision);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // If the tag is more than 4 meters away, go to it (uses 2d april tag)
    if (photonVision.getDistance() >= 4) {
      driveSubsystem.drive(-0.8, 0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveSubsystem.drive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // Ends the command when it gets close enough
    if (photonVision.getDistance() < 4) {
      driveSubsystem.drive(0.2, 0);
      return true;  
    }
    return false;
  }
}
