import Conc.Concat;
import Conc.ConcatHelper;

import org.omg.CORBA.ORB;

import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

public class Server {
     public static void main(String args[]) {
	  try {
	       ORB orb = ORB.init(args,null);
	       
	       POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA")); //get reference to rootpoa
	       rootpoa.the_POAManager().activate(); //activate rootpoa

	       ConcServer servr = new ConcServer(); //create servant

	       org.omg.CORBA.Object ref = rootpoa.servant_to_reference(servr); //get reference of servant
	       Concat href = ConcatHelper.narrow(ref);

	       org.omg.CORBA.Object objref = orb.resolve_initial_references("NameService");
	       NamingContextExt ncRef = NamingContextExtHelper.narrow(objref);

	       NameComponent path[] = ncRef.to_name("conc-server");
	       ncRef.rebind(path, href);

	       System.out.println("Server ready and Waiting..");

	       orb.run();
	       
	  } catch(Exception e) {
	       System.out.println(e);
	  }
	       System.out.println("Exiting...");
     }
}
