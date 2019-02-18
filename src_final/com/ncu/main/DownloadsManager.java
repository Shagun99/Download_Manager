package com.ncu.main;

import java.io.*;
import java.net.*;
import java.util.*;
import com.ncu.processors.*;
import com.ncu.exceptions.*;
import com.ncu.validators.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

class DownloadsManager
{
    public static void main(String[] args)
    {
        Properties prop = new Properties();
        FileInputStream input=null; 
        Logger logger = Logger.getLogger(Downloads.class);
        PropertyConfigurator.configure("C://Users//Shagun//Desktop//Download_Manager//configs//logger//logger.properties");
        String cont = "";

        do
        {
            try 
            {
                input = new FileInputStream("C://Users//Shagun//Desktop//Download_Manager//configs//constants//exceptions.properties");
                prop.load(input);

                ConnectionValidation cv = new ConnectionValidation();
                if(cv.connectionValidator() == true)
                {

                    Scanner scan = new Scanner(System.in);
            
                    String fileName;
                    String path;
                    String url;
                    boolean b = false;

                    // input url
                    System.out.println("Enter url to download:");
                    url = scan.next();
                    
                    //validating url
                    DomainValidation dv = new DomainValidation();
                    if(dv.domainValidator(url) == true)
                    {
                        UrlValidation u= new UrlValidation();
                        u.urlValidator(url);
                    }
                    
                    //input folder path
                    System.out.println("Enter path of Output folder:");
                    path = scan.next();

                    //validating output path
                    PathValidation p = new PathValidation();
                    p.pathValidator(path);

                    FileNameValidation fv = new FileNameValidation();
                    do
                    {
                        System.out.println("Save File As:");
                        //input file name
                        fileName = scan.next();

                        try
                        {
                            //validating file
                            b = fv.fileValidator(fileName, path); 
                        }
                        //Catching file name exceptions
                        catch(InvalidFolderException e)
                        {
                            logger.error("\n \n"+e+prop.getProperty("invalidFileMessage")+"\n");
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                    }
                    while(b != true);
                    File f = new File(fileName);
                    
                    //downloading file
                    Downloads d = new Downloads();
                    d.saveUrl(path + "\\" + fileName, url);

                    System.out.println("Do you want to download another file, Yes OR No?");
                    cont = scan.next();                
                }
            }

            //Catching exceptions
            catch(InvalidDomainException e)
            {
                logger.error("\n"+e+prop.getProperty("invalidDomainMessage")+"\n");
            }
            catch(NoInternetAccessException e)
            {
                logger.error("\n"+e+prop.getProperty("NoInternetAccess")+"\n");
            }
            catch(InvalidUrlException e)
            {
                logger.error("\n"+e+prop.getProperty("invalidUrlMessage")+"\n");
            }
            catch(Exception e)
            {
                System.out.println(e);
                logger.error("Caught Exception ", e);
            }
        }
        //while loop iterates till user enters yes
        while(cont.equals("yes") || cont.equals("YES"));
    }
}