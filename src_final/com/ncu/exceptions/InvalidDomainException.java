package com.ncu.exceptions;

public class InvalidDomainException extends Exception
{ 
	//creating an exception for invalid domain
	public  InvalidDomainException ( String s )     
    {          
      super(s);
    }
}