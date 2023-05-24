package CalculatorApp;


/**
* CalculatorApp/CalculatorHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Calculator.idl
* Monday, 22 May, 2023 4:13:33 PM IST
*/

abstract public class CalculatorHelper
{
  private static String  _id = "IDL:CalculatorApp/Calculator:1.0";

  public static void insert (org.omg.CORBA.Any a, CalculatorApp.Calculator that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static CalculatorApp.Calculator extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (CalculatorApp.CalculatorHelper.id (), "Calculator");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static CalculatorApp.Calculator read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_CalculatorStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, CalculatorApp.Calculator value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static CalculatorApp.Calculator narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof CalculatorApp.Calculator)
      return (CalculatorApp.Calculator)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      CalculatorApp._CalculatorStub stub = new CalculatorApp._CalculatorStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static CalculatorApp.Calculator unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof CalculatorApp.Calculator)
      return (CalculatorApp.Calculator)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      CalculatorApp._CalculatorStub stub = new CalculatorApp._CalculatorStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
