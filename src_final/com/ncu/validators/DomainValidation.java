package com.ncu.validators;

import java.util.*;
import java.io.*;
import com.ncu.exceptions.*;

public class DomainValidation
{   
  public boolean domainValidator(String url) throws InvalidDomainException
  {   
    int counter = 0;
    //splitting url domain
    String[] arrOfStr = url.split( "[.]"); 
  
    //for (String a : arrOfStr) 
        
    if ( arrOfStr.length < 2)
    {
      //if domain name splits in less than 2 parts, exception is thrown
      throw new InvalidDomainException("Invalid Domain");
    }
    else
    {
      return true;
    }
    return false;
  }

//testing Driver
    public static void main(String args[]) 
    { 
      String url= "http://www.google.com";             
      try
      {
        DomainValidation d1 = new DomainValidation();
        d1.domainValidator("http://www.google.com");
      }
      catch(InvalidDomainException e) 
      {
        System.out.println(e);
      }
    }
}