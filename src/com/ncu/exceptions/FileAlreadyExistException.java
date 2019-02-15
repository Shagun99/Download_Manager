package com.ncu.exceptions;

public class FileAlreadyExistException extends Exception
{
	//creating an exception for already existing file
	public FileAlreadyExistException(String s)
	{
		super(s);
	}
}