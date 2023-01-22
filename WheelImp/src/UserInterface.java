import java.util.Scanner;
import P2PInterfacePackage.*;
import EncryptorSubsystem.EncryptorFacade;
public class UserInterface{
   AuditInterfaceFactory aIf = 
                      new AuditInterfaceFactory();
      
   AuditInterfaceStubBase aInt = aIf.create(1);
   AuthorizationInterfaceFactory  aIf2 = 
                      new AuthorizationInterfaceFactory ();
      
   AuthorizationInterfaceStubBase aInt2 = aIf2.create(1);
  
   EncryptorFacade eFac = 
                       EncryptorFacade.Instance();

   String userName;
   String password;
   void getTeamName(){
      Scanner myObj = new Scanner(System.in);
      System.out.println("Enter username");
      userName = myObj.nextLine() + "X";
   }
   void getPassword(){
      Scanner myObj = new Scanner(System.in);
      System.out.println("Enter password");
      password = myObj.nextLine() + "X";
  }
  void testUser(){
   if (aInt2.authenticate(userName, password)){
      aInt.SendLOK(userName, "good", true);
      
   }
   else{
      aInt.SendLNOK(userName, "Input a valid userName and passowrd", false);
      getTeamName();
      getPassword();
      testUser();
      
   }
  }
  public int getEncryptionOption(){
   boolean tester;
   Scanner myObj = new Scanner(System.in);
   System.out.println("Enter 1 for encrypt 2 for decrypt");
   int eord = myObj.nextInt();
   return eord;
  }
  Scanner myObj = new Scanner(System.in);
  int getWheelStartPosition1(){
     System.out.println("Enter Wheel 1 Position");
     int wheel1pos = myObj.nextInt();
     return wheel1pos;
 }
 int getWheelStartPosition2(){
     System.out.println("Enter Wheel 2 Position");
     int wheel2pos = myObj.nextInt();
     return wheel2pos;
 }

 int getWheelStartPosition3(){
    System.out.println("Enter Wheel 3 Position");
     int wheel3pos = myObj.nextInt();
     return wheel3pos;
 }

     
  void displayWheelEndPosition(w){
      int w1 = eFac.getWheel1Pos();
      int w2 = eFac.getWheel2Pos();
      int w3 = eFac.getWheel3Pos();
      System.out.println("Wheel 1 Position " + w1);
      System.out.println("Wheel 2 Position " + w2);
      System.out.println("Wheel 3 Position " + w3);
  }
  void displayResult(){
   System.out.println("success");
 } 
  
}