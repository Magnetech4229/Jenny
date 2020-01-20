# Jenny
Code from our old show-bot Jenny

Currently configured to run a DifferentialDrive with Spark motor controllers and an Xbox control setup

Uses the TimedRobot configuration, has driving code and no other subsystems

Driving code works using the left-and-right joysticks
    -Left joystick controls speed of the left motors (push joystick forward to move forward, pull back to reverse), likewise for the right side

Motor setup:
    -Can work with two motors or four motors in two speed controller groups
    -Written for Spark motor controllers
    -The left Sparks plug into PWM ports 0 and 1, the right Sparks plug into 2 and 3

