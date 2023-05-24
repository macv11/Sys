import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry;
import java.util.*;


public class Client {  
   private Client() {}  
   public static void main(String[] args) { 
      Scanner sc = new Scanner(System.in); 
      try {  
         // Getting the registry 
         Registry registry = LocateRegistry.getRegistry(null); 
    
         // Looking up the registry for the remote object 
         Hello stub = (Hello) registry.lookup("Hello"); 
    
         // Calling the remote method using the obtained object
         int x, y;
         System.out.println("Enter the first number:");
         x = sc.nextInt();
         System.out.println("Enter the second number:");
         y = sc.nextInt();
         stub.addNum(x, y); 
         
         // System.out.println("Remote method invoked"); 
      } catch (Exception e) {
         System.err.println("Client exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
   } 
}