/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.LauncherSpeedCommand;
import frc.robot.commands.ShooterLaunchCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  public XboxController xbox = new XboxController(0);
  public Joystick flightStick = new Joystick(1);  
  public Button shooterButton = new JoystickButton(flightStick, RobotMap.SHOOTER_LAUNCH_BUTTON);
  public Button launcherButton = new JoystickButton(flightStick, RobotMap.LAUNCHER_START);

  public OI() {
    shooterButton.whenPressed(new ShooterLaunchCommand());
    launcherButton.whenPressed(new LauncherSpeedCommand());
  }  

}

