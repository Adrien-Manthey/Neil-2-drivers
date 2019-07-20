package frc.robot;


import frc.robot.GripPipethree;
import edu.wpi.first.wpilibj.Timer;
//import frc.robot.PixyTest;
//import frc.robot.Main;
import org.opencv.core.*;
import edu.wpi.first.cameraserver.CameraServer;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import org.opencv.core.Point;
//import org.opencv.core.Rect;
//import org.opencv.core.Scalar;
import org.opencv.imgproc.*;
//import frc.robot.GripPipeline;
//import edu.wpi.first.wpilibj.networktables.*;
import java.util.ArrayList;
import java.util.List;
//import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import org.opencv.core.Mat;
//import edu.wpi.cscore.AxisCamera;
//import edu.wpi.cscore.UsbCamera;
//import edu.wpi.first.wpilibj.vision.VisionRunner;
//import edu.wpi.first.wpilibj.vision.VisionThread;
//import edu.wpi.first.vision.VisionPipeline;
import frc.robot.PixyTest; 

public final class Camera {
    public Camera() {

    }
  
    public static void camera() {
        //CameraServer.getInstance().addAxisCamera("10.42.29.90"); //axis camera
        CameraServer.getInstance().startAutomaticCapture(); //USB camera
        
        Mat image = new Mat();
        
        //PixyTest.test();

        CameraServer.getInstance().getVideo().grabFrame(image);
        
        
    }




  }