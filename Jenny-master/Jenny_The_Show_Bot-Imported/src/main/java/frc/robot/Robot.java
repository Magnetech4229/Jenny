/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.GenericHID;

/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  Spark Right1 = new Spark(3);
  Spark Right2 = new Spark(2);
  Spark Left1 = new Spark(1); 
  Spark Left2 = new Spark(0);
  private double joypastL = 0;
  private double joypastR = 0;
  private int Count = 0;
  SpeedControllerGroup Right = new SpeedControllerGroup(Right1, Right2);
  SpeedControllerGroup Left = new SpeedControllerGroup(Left1, Left2);
  XboxController Xbox = new XboxController(0);
  DifferentialDrive Drive = new DifferentialDrive(new SpeedControllerGroup(Right1, Right2), new SpeedControllerGroup(Left1, Left2));

  @Override
  public void robotInit() {
    //System.out.println("Robot code started");
  }

  @Override
  public void teleopPeriodic() {
    //System.out.println("Periodic cycle");

    Drive.tankDrive(((Xbox.getY(GenericHID.Hand.kRight) + joypastR)/2)*.7, ((Xbox.getY(GenericHID.Hand.kLeft) + joypastL)/2)*.7);
    Count = Count+1;
    if (Count == 5) {
      Count = 0;
      joypastL = Xbox.getY(GenericHID.Hand.kLeft);
      joypastR = Xbox.getY(GenericHID.Hand.kRight);
    }
  }
}
