package com.ncu.validators;

import java.io.*;
import java.net.*;
import com.ncu.exceptions.*;

public class UrlValidation

{
    public void urlValidator(String urlString) throws InvalidUrlException, MalformedURLException, IOException
    {
        BufferedInputStream in = null;

        // BufferedInputstream is used to read bytes from a stream.
        //openStream is used to connect to the url
        in = new BufferedInputStream(new URL(urlString).openStream());
        if (in == null) 
        {
            //exception occurs if url does not exists
            throw new InvalidUrlException("Invalid URL Entered");
        }
    }

//testing Driver
    public static void main (String[] args)
    {
        try
        {

        UrlValidation d = new UrlValidation();
        d.urlValidator("https://www.tutorialspoint.com/java/java_tutorial.pdf");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}