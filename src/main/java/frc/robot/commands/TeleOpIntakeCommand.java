/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.GenericHID.Hand;

import com.ctre.phoenix.motorcontrol.ControlMode;


public class TeleOpIntakeCommand extends Command {

  double speed = 0.7;

  public TeleOpIntakeCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.intakeSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    
    if(Robot.m_oi.xbox.getTriggerAxis(Hand.kLeft) > 0.1 && Robot.m_oi.xbox.getTriggerAxis(Hand.kRight) > 0.1) Robot.intakeSubsystem.wheels.set(ControlMode.PercentOutput,0);
    else if(Robot.m_oi.xbox.getTriggerAxis(Hand.kLeft) > 0.1) Robot.intakeSubsystem.wheels.set(ControlMode.PercentOutput, Robot.m_oi.xbox.getTriggerAxis(Hand.kLeft)*.7);
    else if(Robot.m_oi.xbox.getTriggerAxis(Hand.kRight) > 0.1) Robot.intakeSubsystem.wheels.set(ControlMode.PercentOutput, -Robot.m_oi.xbox.getTriggerAxis(Hand.kRight)*.7);
    else Robot.intakeSubsystem.wheels.set(ControlMode.PercentOutput,0);
    SmartDashboard.putNumber("Left Trigger", Robot.m_oi.xbox.getTriggerAxis(Hand.kLeft));
    SmartDashboard.putNumber("Right Trigger", Robot.m_oi.xbox.getTriggerAxis(Hand.kRight));
    if(Robot.m_oi.flightStick.getRawButton(RobotMap.INTAKE_BELT_FORWARD_BUTTON) && Robot.m_oi.flightStick.getRawButton(RobotMap.INTAKE_BELT_BACKWARD_BUTTON)) Robot.intakeSubsystem.belt.set(ControlMode.PercentOutput,0);
    else if(Robot.m_oi.flightStick.getRawButton(RobotMap.INTAKE_BELT_FORWARD_BUTTON)) Robot.intakeSubsystem.belt.set(ControlMode.PercentOutput, speed);
    else if(Robot.m_oi.flightStick.getRawButton(RobotMap.INTAKE_BELT_BACKWARD_BUTTON)) Robot.intakeSubsystem.belt.set(ControlMode.PercentOutput, -speed);
    else Robot.intakeSubsystem.belt.set(ControlMode.PercentOutput,0);

    if(Robot.m_oi.xbox.getBumperPressed(Hand.kLeft)) Robot.intakeSubsystem.intakeArm.set(Value.kForward);
    else if(Robot.m_oi.xbox.getBumperPressed(Hand.kRight)) Robot.intakeSubsystem.intakeArm.set(Value.kReverse);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
