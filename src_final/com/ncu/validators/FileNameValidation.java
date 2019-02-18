package com.ncu.validators;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.*;
import java.util.*;
import com.ncu.exceptions.*;


public class FileNameValidation
{
	public boolean nameValidator(String filename) 
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
			return true;			
		}
	}
    
    //fileValidator method
    public boolean fileValidator(String filename, String path) throws InvalidFolderException
	{
		int count = 0;
		File folder = new File(path);

		//getting list of existing files in the folder
	    String[] files = folder.list();
 	
    	for (String file : files)
   		{
   			//counting number of files in the given folder
        	count++;
   	    }

		if(nameValidator(filename) == false)
		{
			//throwing exception for invalid file name
			throw new InvalidFolderException("invalid file name");
		}
		else
		{
			//comparing the user entered name to the existing file names
    	    for(int i= 0; i< count; i++)
    	    {
    	    	if(filename.equals(files[i]))
    	    	{
    	    		//throws exception if file name already exists
	    			throw new InvalidFolderException("file name already exists");	    		
    	    	}
    	    }
        	return true;
		}
	}
	
	//checking if file name is empty
	private void emptyFileName(String filename) throws EmptyFileNameException
	{
		if (filename=="")
			throw new EmptyFileNameException("Empty File Name Exception");
	}

	//checking for extension
	private void missingDot(String fileName)throws MissingExtensionException
	{
		Pattern costPattern = Pattern.compile("[.]");
		Matcher costMatcher = costPattern.matcher(fileName);
		boolean value = costMatcher.find();
		if (!value==true)
			throw new MissingExtensionException("Missing Extension Exception");
	}

	//checking valid file format
	boolean fileFormat(String fileName) 
	{
		String [] extn = fileName.split("\\.");
		if (extn.length<=1) 
		{
			return true;
		}
		else{ 
			return false;
		}
	}

	//checking file name length
	boolean fileLength(String fileName)
	{
		int fileLength=25;
		String namelength = fileName.split("\\.")[0];
		if(namelength.length()>fileLength)
			return true;
		else 
			return false;
	}

	//checking for special characters in file name 
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


	public static void main(String[] args)
	{
		try{
		FileNameValidation csvObject = new FileNameValidation();
		boolean checkValidator;// = csvObject.fileValidator("C:\\Users\\Shagun\\Desktop\\Testurl.java");
		//System.out.println(checkValidator);
		checkValidator = csvObject.fileValidator("java.pdf","C:\\Users\\Shagun\\Desktop");
		System.out.println(checkValidator);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}