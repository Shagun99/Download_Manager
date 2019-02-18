package com.ncu.exceptions;

public class NoInternetAccessException extends Exception
{ 
	//creating an exception for no Internet Access
	public NoInternetAccessException ( String s )     
    {          
      super(s);
    }
}