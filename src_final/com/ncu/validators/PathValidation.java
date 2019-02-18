package com.ncu.validators;
import com.ncu.exceptions.*;

import java.nio.file.*;
import java.io.*;

public class PathValidation
{
	public static boolean pathValidator(String path) throws InvalidFolderException
	{
		Path file = new File(path).toPath();
		//Checking if user entered path exists 
		boolean isDirectory = Files.isDirectory(file); 
		if(isDirectory != true)
		{
			//If path does not exists return false
            throw new InvalidFolderException("Invalid Folder Path Entered");
			//return false;
		}
		return true;
	}
	
	//Testing Driver
	public static void main(String[] args)
	{
		try
		{
			PathValidation p = new PathValidation();
			p.pathValidator("C:\\Users\\Shagun\\Pictures\\Saved Pictures");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}