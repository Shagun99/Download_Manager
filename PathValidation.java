import java.nio.file.*;
import java.io.*;

class PathValidation
{
	public static boolean pathValidator(String path) 
	{
		Path file = new File(path).toPath();
		//Checking if user entered path exists 
		boolean isDirectory = Files.isDirectory(file); 
		if(isDirectory == true)
		{
			//If path exists return true
			System.out.println("valid path");
			return true;
		}
		else
		{
			//If path does not exists return false		
			System.out.println("invalid path");	
			return false;
		}
	}
	//Testing Driver
	public static void main(String[] args)
	{
		PathValidation p = new PathValidation();
		p.pathValidator("C:\\Users\\Shagun\\Pictures\\Saved Pictures");
	}

}