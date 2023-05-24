import java.rmi.Remote; 
import java.rmi.RemoteException;  

// Creating Remote interface for our application 
public interface Hello extends Remote {  
   void addNum(int x, int y) throws RemoteException;  
} 