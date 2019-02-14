import java.io.*;
import java.util.*;

public class FileExists 
{

  public void existing(File f) throws FileAlreadyExistException
  {
    if( f.exists() == true)
    {
      throw new FileAlreadyExistException("File Already Exists");
    }

  }

  public static void main(String[] args)
  {    
    String fileName = "test4.pdf";
    String newfileName = "abc.pdf";
    String path = "C:\\Users\\Shagun\\Desktop\\";
    File f = new File(fileName);

    try 
    {  
      FileExists f1 = new FileExists();
      f1.existing(f);
      System.out.println("file created");        
      
    } 
    catch(FileAlreadyExistException e)
    {
      System.out.println(" File Already exists in the folder  ");
		  e.printStackTrace();
      System.out.println(" Enter new filename ");  
      System.out.println(" the downloaded file is saved with new name =" + newfileName);      
    }
}

  //Exception for filealready exist
  public class FileAlreadyExistException extends Exception
  {
    public FileAlreadyExistException(String s)
    {
      super(s);
    }
  }

}
 