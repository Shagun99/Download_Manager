package com.ncu.exceptions;

public class InvalidFolderException extends Exception
{
	//creating an exception for invalid path
	public InvalidFolderException(String s)
	{
		super(s);
	}
}