import Conc.ConcatPOA;

public class ConcServer extends ConcatPOA {
     @Override
     public String concatInput(String a, String b) {
	  return a+b;
     }
}
