package com.ncu.validators;

import java.util.*;
import java.io.*;
import java.net.*;
import com.ncu.exceptions.*;

public class ConnectionValidation
{   
  public boolean connectionValidator() throws NoInternetAccessException, UnknownHostException, IOException
  {           
    if(connection() != true)
    {
      throw new NoInternetAccessException("No Internet Connection found");
    }
    else
    {
      return true;
    }
  }

  public boolean connection()
  {   
    try
    {
      //Checking internet access
      boolean hasInternetAccess  = InetAddress.getByName("www.google.com").isReachable(1000);
      return hasInternetAccess;
    }
    catch(Exception e)
    {
      return false;
    }
  }

//testing Driver
    public static void main(String args[]) 
    { 
      try
      {
        ConnectionValidation c1 = new ConnectionValidation();
        c1.connectionValidator();
      }
      catch(NoInternetAccessException e) 
      {
        System.out.println(e);
      }
      catch(Exception e) 
      {
        System.out.println(e);
        
      }
    }
}