package com.ncu.validators;
import com.ncu.exceptions.*;

import java.io.*;
import java.util.*;

public class FileValidation
{

  public void existing(File f) throws FileAlreadyExistException
  {
    if( f.exists() == true)
    {
      throw new FileAlreadyExistException("file already exists");
    }
  }
/*
  public boolean fileValidator(File f) throws FileAlreadyExistException
  {
    Scanner scan = new Scanner(System.in);
    try
    {
    FileValidation f1 = new FileValidation();
    if(f1.existing(f) == true)
    {
      throw new FileAlreadyExistException("file already exists");
    }
    return false;
    }
    catch(Exception e)
    {
      System.out.println(e);
      System.out.println("Enter new File Name");
      String g = scan.next();
      f= new File(g);
      return false;    
    }
  }*/

  public static void main(String[] args)
  {    
    try 
    {
      String fileName = "test4.pdf";
      String newfileName = "abc.pdf";
      String path = "C:\\Users\\Shagun\\Desktop\\";
      File f = new File(fileName);  
      FileValidation f1 = new FileValidation();
      f1.existing(f);
      System.out.println("file created");        
      
    } 
    catch(FileAlreadyExistException e)
    {
      System.out.println(" File Already exists in the folder  ");
		  e.printStackTrace();
      System.out.println(" Enter new filename ");  
     // System.out.println(" the downloaded file is saved with new name =" + newfileName);      
    }
  }
}
 