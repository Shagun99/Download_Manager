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
    public static void saveUrl(String filename, String url) throws IOException
    {

        FileOutputStream fout = null;
        URL u = new URL(url);
        String status = "";

        UrlValidation uv = new UrlValidation();
        Properties prop = new Properties();
        FileInputStream input=null; 
        Logger logger = Logger.getLogger(Downloads.class);
        PropertyConfigurator.configure("C://Users//Shagun//Desktop//Download_Manager//configs//logger//logger.properties");

        try
        {
            input = new FileInputStream("C://Users//Shagun//Desktop//Download_Manager//configs//constants//exceptions.properties");
            prop.load(input);
            uv.urlValidator(url);

            HttpURLConnection httpConn = (HttpURLConnection) u.openConnection();

            long length = httpConn.getContentLength();
            
            InputStream inStream = httpConn.getInputStream();

            //FileOutputStream() is used for writing data to a File
            fout = new FileOutputStream(filename);

            byte data[] = new byte[1024];
            int count, percent, i, j;
            double sumCount = 0;

            //Reading data from url
            while ((count = inStream.read(data, 0, 1024)) != -1) 
            {
                //writing data in the file
                fout.write(data, 0, count);

                sumCount += count;
                if (length > 0)
                {
                    percent = (int)((sumCount / length) * 100);

                    String str = ("Download Progress: " + percent + "%");

                    //Printing progress bar
                    System.out.print("[");
                    for(i= 0; i< (percent/2); i++)
                    {
                        System.out.print("*");
                    }
                    for(j= i+1; j< 50; j++)
                    {
                        System.out.print(" ");
                    }
                    System.out.print("]\t" + str + "\r");
                }
            }
            //closing url
            inStream.close();
            //closing file
            fout.close();
            //disconnecting the http Connection
            httpConn.disconnect();

            System.out.println();
            //Printing Status
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
        //logging the downloads
        logger.info("URL Requested: " + url + " \r\nSaved As: " + filename + " \r\nStatus: " + status);
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