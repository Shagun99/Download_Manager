package com.ncu.processors;

import java.io.*;
import java.util.*;
import java.net.*;
import com.ncu.exceptions.*;
import com.ncu.validators.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Downloads
{
    public void saveUrl(String filename, String url) throws IOException
    {

        BufferedInputStream in = null;
        FileOutputStream fout = null;
        String status = "";


        Properties prop = new Properties();
        FileInputStream input=null; 
        Logger logger = Logger.getLogger(Downloads.class);
        PropertyConfigurator.configure("C://Users//Shagun//Desktop//DM//configs//logger//logger.properties");

        try
        {
            input = new FileInputStream("C://Users//Shagun//Desktop//DM//configs//constants//exceptions.properties");
            prop.load(input);
            UrlValidation uv = new UrlValidation();
            uv.urlValidator(url);

            //openStream() method is used to get an input stream on url mentioned
            //BufferedInputStream() reads bytes and decodes them into characters
            in = new BufferedInputStream(new URL(url).openStream());

            //FileOutputStream() is used for writing data to a File
            fout = new FileOutputStream(filename);

            byte data[] = new byte[1024];
            int count;
            while ((count = in.read(data, 0, 1024)) != -1) 
            {
                fout.write(data, 0, count);
            }
            in.close();
            fout.close();
            status = "Download Complete";        
            System.out.println(status);
        }
        catch(InvalidUrlException e)
        {
            logger.error("\n \n"+e+prop.getProperty("invalidUrlMessage")+"\n");
        }
        catch(Exception e)
        {
            status = "Download Failed";
            System.out.println(status);
            System.out.println(e);
        }
        logger.info(url + "\t" + status);
    }

    //Testing Driver
    public static void main (String[] args)
    {
        try
        {
            Downloads d = new Downloads();
            d.saveUrl("C:\\Users\\Shagun\\Documents\\test4.pdf","https://www.tutorialspoint.com/java/java_tutorial.pdf");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}