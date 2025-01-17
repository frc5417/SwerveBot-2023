package frc.robot;

import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.SerialPort;
import frc.lib.util.SwerveModuleConstants;

public final class Constants {

  public static final class Swerve {
    public static final double stickDeadband = 0.2;

    public static final SerialPort.Port pigeonID = SerialPort.Port.kMXP;
    public static final boolean invertGyro = false; // Always ensure Gyro is CCW+ CW-

    /* Drivetrain Constants */
    public static final double trackWidth = Units.inchesToMeters(27.00);
    public static final double wheelBase = Units.inchesToMeters(25.00);
    public static final double wheelDiameter = Units.inchesToMeters(4.0);
    public static final double wheelCircumference = wheelDiameter * Math.PI;

    public static final double openLoopRamp = 0.25;
    public static final double closedLoopRamp = 0.0;

    public static final double driveGearRatio = (6.12 / 1.0); // 5.14:1
    public static final double angleGearRatio = (12.8 / 1.0); // 12.8:1

    public static final SwerveDriveKinematics swerveKinematics =
        new SwerveDriveKinematics(
            new Translation2d(wheelBase / 2.0, -trackWidth / 2.0),
            new Translation2d(wheelBase / 2.0, trackWidth / 2.0),
            new Translation2d(-wheelBase / 2.0, trackWidth / 2.0),
            new Translation2d(-wheelBase / 2.0, -trackWidth / 2.0));

    /* Swerve Compensation */
    public static final double voltageComp = 12.0;

    /* Swerve Current Limiting */
    public static final int angleContinuousCurrentLimit = 20;
    public static final int driveContinuousCurrentLimit = 80;

    /* Angle Motor PID Values */
    public static final double angleKP = 0.01;
    public static final double angleKI = 0.0;
    public static final double angleKD = 0.005;
    public static final double angleKFF = 0.0;

    /* Drive Motor PID Values */
    public static final double driveKP = 0.0;
    public static final double driveKI = 0.0;
    public static final double driveKD = 0.0;
    public static final double driveKFF = 0.0;

    /* Drive Motor Characterization Values */
    public static final double driveKS = 0.667;
    public static final double driveKV = 2.44;
    public static final double driveKA = 0.27;

    /* Drive Motor Conversion Factors */
    public static final double driveConversionVelocityFactor =
        ((wheelDiameter * Math.PI) / driveGearRatio) / 60.0;
    public static final double angleConversionFactor = 360.0 / 12.8;

    /* Swerve Profiling Values */
    public static final double maxSpeed = 7.5; //3.5; //2.5; //4.5; // meters per second
    public static final double maxAngularVelocity = 17.5; //5.0; //11.5;

    /* Neutral Modes */
    public static final IdleMode angleNeutralMode = IdleMode.kBrake;
    public static final IdleMode driveNeutralMode = IdleMode.kBrake;

    /* Motor Inverts */
    public static final boolean driveInvert = false;
    public static final boolean angleInvert = false;

    /* Angle Encoder Invert */
    public static final boolean canCoderInvert = false;

    /* Module Specific Constants */
    /* Front Left Module - Module 0 */
    //Called 1 on the robot
    public static final class Mod0 {
      public static final int driveMotorID = 11;
      public static final int angleMotorID = 10;
      public static final int pwmID = 0;
      public static final Rotation2d angleOffset = Rotation2d.fromDegrees(0.0);
      public static final SwerveModuleConstants constants =
          new SwerveModuleConstants(driveMotorID, angleMotorID, pwmID, angleOffset);
    }

    /* Front Right Module - Module 1 */
    //Called 2 on the robot
    public static final class Mod1 {
      public static final int driveMotorID = 21;
      public static final int angleMotorID = 20;
      public static final int pwmID = 1;
      public static final Rotation2d angleOffset = Rotation2d.fromDegrees(0.0);
      public static final SwerveModuleConstants constants =
          new SwerveModuleConstants(driveMotorID, angleMotorID, pwmID, angleOffset);
    }

    /* Back Left Module - Module 2 */
    //Called 3 on the robot
    public static final class Mod2 {
      public static final int driveMotorID = 31;
      public static final int angleMotorID = 30;
      public static final int pwmID = 2;
      public static final Rotation2d angleOffset = Rotation2d.fromDegrees(270.0);
      public static final SwerveModuleConstants constants =
          new SwerveModuleConstants(driveMotorID, angleMotorID, pwmID, angleOffset);
    }

    /* Back Right Module - Module 3 */
    //Called 4 on the robot
    public static final class Mod3 {
      public static final int driveMotorID = 40;
      public static final int angleMotorID = 41;
      public static final int pwmID = 3;
      public static final Rotation2d angleOffset = Rotation2d.fromDegrees(90.0);
      public static final SwerveModuleConstants constants =
          new SwerveModuleConstants(driveMotorID, angleMotorID, pwmID, angleOffset);
    }
  }

  public static final class AutoConstants {
    public static final double kMaxSpeedMetersPerSecond = 3;
    public static final double kMaxAccelerationMetersPerSecondSquared = 3;
    public static final double kMaxAngularSpeedRadiansPerSecond = Math.PI;
    public static final double kMaxAngularSpeedRadiansPerSecondSquared = Math.PI;

    public static final double kPXController = 1;
    public static final double kPYController = 1;
    public static final double kPThetaController = 1;

    // Constraint for the motion profilied robot angle controller
    public static final TrapezoidProfile.Constraints kThetaControllerConstraints =
        new TrapezoidProfile.Constraints(
            kMaxAngularSpeedRadiansPerSecond, kMaxAngularSpeedRadiansPerSecondSquared);
  }
}