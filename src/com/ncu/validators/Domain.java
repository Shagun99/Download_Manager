import java.util.*;
import java.io.*;
import com.ncu.exceptions.*;

public class Domain
{   
  public void domainValidator(String url) throws InvalidDomainException
	{   
    int counter = 0;
    String[] arrOfStr = url.split( "[.]"); 
  
    for (String a : arrOfStr) 
        
      for (int i = 0; i < arrOfStr.length; i ++)
      {
        if (arrOfStr [i] != null)
        {
          counter ++;
          if ( counter <3)
          {
            throw new InvalidDomainException("Invalid Domain");
          }
        }
      }
  }

//testing Driver
    public static void main(String args[]) 
    { 
      int counter = 0;
      String url= "http://www.google.com"; 
      String[] arrOfStr = url.split( "[.]"); 
  
      for (String a : arrOfStr ) 
      System.out.println(a); 
        
      for (int i = 0; i < arrOfStr .length; i ++)
      if (arrOfStr [i] != null)
      counter ++;
          
      try
      {
        Domain d1 = new Domain();
	    	if ( counter <3)
	    	d1.d();
      }
			catch(InvalidDomainException e) 
	    {
        System.out.println(" Invalid domain Exception detected ");
		  }
    }
}