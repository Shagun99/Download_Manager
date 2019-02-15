package com.ncu.validators;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.*;
import java.util.*;
import com.ncu.exceptions.*;


public class FileNameValidation
{
	public boolean nameValidator(String filename) throws InvalidFolderException
	{
		boolean b;
		try
		{	
			emptyFileName(filename);
			missingDot(filename);
		}
		catch(EmptyFileNameException e)
		{
			System.out.println(e);
		}
		catch(MissingExtensionException e)
		{
			System.out.println(e);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

		b=fileFormat(filename);
		if (b==true)
			return false;
		b=fileLength(filename);
		if (b==true)
			return false;
		b=specialCharacter(filename);
		if (b==true)
			return false;
		else
		{
			b=fileNotAvailable(filename);
			if (b==true)
				return false;
		}
		return true;

		if(b==false)
		{
			throw new InvalidFolderException("Invalid folder");
		}
	}
	
	private void emptyFileName(String filename) throws EmptyFileNameException
	{
		if (filename=="")
			throw new EmptyFileNameException("Empty File Name Exception");
	}

	private void missingDot(String fileName)throws MissingExtensionException
	{
		Pattern costPattern = Pattern.compile("[.]");
		Matcher costMatcher = costPattern.matcher(fileName);
		boolean value = costMatcher.find();
		if (!value==true)
			throw new MissingExtensionException("Missing Extension Exception");
	}

	boolean fileFormat(String fileName) 
	{
		String [] extn = fileName.split("\\.");
		if (extn.length<=1) {
			return true;
		}
		else{ 
			return false;
		}
	}

	boolean fileLength(String fileName)
	{
		int fileLength=25;
		String namelength = fileName.split("\\.")[0];
		if(namelength.length()>fileLength)
			return true;
		else 
			return false;
	}

	boolean specialCharacter(String fileName)
	{
		fileName = fileName.split("\\.")[0];
		Pattern  patternGet = Pattern.compile("[@#$%^&(,)_]");
		Matcher check = patternGet.matcher(fileName);
		boolean finalValue = check.find();
		if (finalValue == true)
			return true;
		else
			return false;
	}

	boolean fileNotAvailable(String fileName)
	{
		File f = new File(fileName);
		if(f.exists()==true)
			return true;
		else
			return false;
	}


	public static void main(String[] args)
	{
		try{
		FileNameValidation csvObject = new FileNameValidation();
		boolean checkValidator = csvObject.nameValidator("downloads.ja");
		System.out.println(checkValidator);
		checkValidator = csvObject.nameValidator("downloads.java");
		System.out.println(checkValidator);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}