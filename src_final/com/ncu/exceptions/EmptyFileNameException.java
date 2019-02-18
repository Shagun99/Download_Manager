package com.ncu.exceptions;

public class EmptyFileNameException extends Exception
{
	//creating an exception for empty file name
	public EmptyFileNameException(String s)
	{
		super(s);
	}
}