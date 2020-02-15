/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;
  public static final int LEFT_MOTOR_1 = 14;
  public static final int LEFT_MOTOR_2 = 15;
  public static final int RIGHT_MOTOR_1 = 1;
  public static final int RIGHT_MOTOR_2 = 2;

  public static final int SHOOTER_FEEDER_MOTOR = 0;

  public static final int INTAKE_WHEEL_MOTOR = 0;
  public static final int INTAKE_BELT_MOTOR = 0;
  
  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  public static final int NEO_PULSE = 64;
  public static final double GEARBOX_RATIO = 10.71;
  public static final double WHEEL_DIAMETER = 6.0;
  public static final double PULSE_PER_INCH = GEARBOX_RATIO * NEO_PULSE / (WHEEL_DIAMETER* Math.PI);
}
