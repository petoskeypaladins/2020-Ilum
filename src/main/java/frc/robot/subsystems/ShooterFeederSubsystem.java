/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.FillFeederCommand;

/**
 * Add your docs here.
 */
public class ShooterFeederSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  TalonSRX feeder = new TalonSRX(RobotMap.SHOOTER_FEEDER_MOTOR);
  public DigitalInput proxSensor = new DigitalInput(RobotMap.SHOOTER_LIMIT_SWITCH);


  public void feederSpin (double speed){
    feeder.set(ControlMode.PercentOutput, speed);
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new FillFeederCommand(false));
  }
}
