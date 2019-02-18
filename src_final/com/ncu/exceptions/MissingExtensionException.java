package com.ncu.exceptions;

public class MissingExtensionException extends Exception
{
	//creating an exception for missing file extension
	public MissingExtensionException(String s)
	{
		super(s);
	}
}