import Conc.Concat;
import Conc.ConcatHelper;

import org.omg.CORBA.ORB;

import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

public class Client {
     public static void main(String args[]){
	  try{
	       ORB orb = ORB.init(args,null);
	       org.omg.CORBA.Object objref = orb.resolve_initial_references("NameService");
	       NamingContextExt ncRef = NamingContextExtHelper.narrow(objref);
	       Concat href = ConcatHelper.narrow(ncRef.resolve_str("conc-server"));

	       String nw = href.concatInput("hello ","world!!!");
	       System.out.println(nw);
	       
	  } catch (Exception e){
	       System.out.println(e);
	  }
     }
}
