/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.Camera;
import frc.robot.PixyTest; 

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  //Drive Train Motor Declerations
  
    // Drive Train with sparks
      /** 
      Spark M_F_L_Drive = new Spark(0);
      Spark M_F_R_Drive = new Spark(3);
      Spark M_B_L_Drive = new Spark(2);
      Spark M_B_R_Drive = new Spark(1);
      */
    
    // Drive Train with Victor SPX

      
      WPI_VictorSPX M_F_L_Drive = new WPI_VictorSPX(6);
      WPI_VictorSPX M_F_R_Drive = new WPI_VictorSPX(2);
      WPI_VictorSPX M_B_L_Drive = new WPI_VictorSPX(4);
      WPI_VictorSPX M_B_R_Drive = new WPI_VictorSPX(3);
      

      




//Shooter motor decleration with victors
VictorSPX m_v_1 = new VictorSPX(5);
VictorSPX m_v_2 = new VictorSPX(1);


  //Spark m_v_1 = new Spark(0);
  //Spark m_v_2 = new Spark(1);


  
  //ClimbDrive motor decleration with sparks
  
  Spark m_v_3 = new Spark(0);
  Spark m_v_4 = new Spark(1);
  
  // Drive Train Decleration
  MecanumDrive Robo_Drive = new MecanumDrive(M_F_L_Drive, M_B_L_Drive, M_F_R_Drive, M_B_R_Drive);
  

  // Xbox remote setup
  XboxController R_C_0 = new XboxController(0);
  XboxController R_C_1 = new XboxController(1);

    //Setting up pnumatics
    Compressor c = new Compressor(7);
  
    //Solenoids are called S# - number being what port there in
    Solenoid HatchSolenoid = new Solenoid(7,0);
    Solenoid BackSolenoid = new Solenoid(7,1);
    Solenoid FrontSolenoid = new Solenoid(7,2);
    Solenoid S3 = new Solenoid(7,3);

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {

    //PixyTest.test();
    Camera.camera(); 
    
    M_F_L_Drive.set(ControlMode.PercentOutput,0);
    M_F_R_Drive.set(ControlMode.PercentOutput,0);
    M_B_L_Drive.set(ControlMode.PercentOutput,0);
    M_B_R_Drive.set(ControlMode.PercentOutput,0);
    m_v_1.set(ControlMode.PercentOutput,0);
    m_v_2.set(ControlMode.PercentOutput,0);

  
    //m_v_1.set(ControlMode.PercentOutput,0);
    //m_v_2.set(ControlMode.PercentOutput,0);
    
    //m_v_3.set(ControlMode.PercentOutput,0);
    //m_v_4.set(ControlMode.PercentOutput,0);
    
    }
  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
        //Driveing in sandstorm and speeds
        if(R_C_1.getYButton()){ //turbo drive
          Robo_Drive.driveCartesian(R_C_0.getX(GenericHID.Hand.kLeft)*0.80, -1*R_C_0.getY(GenericHID.Hand.kLeft)*0.80,R_C_0.getRawAxis(4)*0.50);
        }
        if(R_C_1.getAButton()){  // turtle drive
          Robo_Drive.driveCartesian(R_C_0.getX(GenericHID.Hand.kLeft)*0.50, -1*R_C_0.getY(GenericHID.Hand.kLeft)*0.50,R_C_0.getRawAxis(4)*0.50);

        }
        else{  // normal drive
          Robo_Drive.driveCartesian(R_C_0.getX(GenericHID.Hand.kLeft)*0.60, -1*R_C_0.getY(GenericHID.Hand.kLeft)*0.60,R_C_0.getRawAxis(4)*0.50);
        }
        
        // ball intake mech.
        
        if(R_C_0.getYButton()) { // out?
          m_v_1.set(ControlMode.PercentOutput,0.8);
          m_v_2.set(ControlMode.PercentOutput,0.8);
        }
        else if(R_C_0.getBButton()) { //in?
          m_v_1.set(ControlMode.PercentOutput,-1);
          m_v_2.set(ControlMode.PercentOutput,-1);
        }
    
        else { // not doing anything
          m_v_1.set(ControlMode.PercentOutput,0);
          m_v_2.set(ControlMode.PercentOutput,0);
        }
        
        
        //Pnumatics for pizza intake
        
        if(R_C_0.getAButton()) { // out
          HatchSolenoid.set(true);
          Timer.delay(0.001);
    
        }
    
    
        else { //in
          HatchSolenoid.set(false);
          Timer.delay(0.001);
    
        }
        

 
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {

    //Driveing in teleop and speeds
    if(R_C_1.getYButton()){ //turbo drive
      Robo_Drive.driveCartesian(R_C_0.getX(GenericHID.Hand.kLeft)*0.80, -1*R_C_0.getY(GenericHID.Hand.kLeft)*0.80,R_C_0.getRawAxis(4)*0.50);
    }
    if(R_C_1.getAButton()){  // turtle drive
      Robo_Drive.driveCartesian(R_C_0.getX(GenericHID.Hand.kLeft)*0.50, -1*R_C_0.getY(GenericHID.Hand.kLeft)*0.50,R_C_0.getRawAxis(4)*0.50);

    }
    else{  // normal drive
      Robo_Drive.driveCartesian(R_C_0.getX(GenericHID.Hand.kLeft)*0.60, -1*R_C_0.getY(GenericHID.Hand.kLeft)*0.60,R_C_0.getRawAxis(4)*0.50);
    }
    
    // ball intake mech.
    
    if(R_C_0.getYButton()) { //out?
      //m_v_1.set(ControlMode.PercentOutput,1);
      m_v_1.set(ControlMode.PercentOutput,0.8);
      m_v_2.set(ControlMode.PercentOutput,0.8);
    }
    else if(R_C_0.getBButton()) { //in?
      m_v_1.set(ControlMode.PercentOutput,-1);
      m_v_2.set(ControlMode.PercentOutput,-1);
    }

		else { //doing nothing
      m_v_1.set(ControlMode.PercentOutput,0);
      m_v_2.set(ControlMode.PercentOutput,0);
    }
    
    
    //Pnumatics for pizza intake
    
		if(R_C_0.getAButton()) { //out
			HatchSolenoid.set(true);
			Timer.delay(0.001);

    }


		else { //in
      HatchSolenoid.set(false);
      Timer.delay(0.001);

    }
    
    // Climber pnumatics
    
    if(R_C_0.getBumper(GenericHID.Hand.kLeft)) { //both out
      BackSolenoid. set(true);
      FrontSolenoid.set(true);
      Timer.delay(0.001);

    }
    else if(R_C_0.getRawButton(8)){ // back in , front out (press me first)
      BackSolenoid.set(false);
      Timer.delay(0.001);

    }
    else if(R_C_0.getRawButton(7)){ //front in, back in (press me second)
      FrontSolenoid.set(false);
      Timer.delay(0.001);

    }
    else{
    }
  
    
    //climber drive wheels
    
    if(R_C_0.getXButton()) {
      m_v_3.set(1);
      m_v_4.set(1);
			
    }

		else {
     m_v_3.set(0);
     m_v_4.set(0);
			
    }
    
    
    
    
    
    
    
   
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {

  }
}
