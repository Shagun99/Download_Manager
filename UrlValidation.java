import java.io.*;
import java.net.*;

class UrlValidation{

public void UrlValidator(String urlString) throws IOException 
{
    BufferedInputStream in = null;
    try
    {
        in = new BufferedInputStream(new URL(urlString).openStream());
    }
    
    finally 
    {
        if (in != null) 
        {
            System.out.println("valid");
        }
        else
        {
            System.out.println("invalid");
        }
    }
}

public static void main (String[] args)
{
    try
    {

    UrlValidation d = new UrlValidation();
    d.UrlValidator("https://www.tutorialspoint.com/java/java_tutorial.pdf");
    }
    catch(Exception e)
    {
        System.out.println(e);
    }

}

}