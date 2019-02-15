package com.ncu.main;

import java.io.*;
import java.net.*;
import java.util.*;
import com.ncu.processors.*;
import com.ncu.exceptions.*;
import com.ncu.validators.*;

class DownloadsManager
{
    public static void main(String[] args)
    {
        try 
        { 
            Scanner scan = new Scanner(System.in);
        
            String fileName;
            String path;
            String url;
            boolean b = false;
//            System.out.println("");

            System.out.println("Enter url to download:");
            url = scan.next();

            UrlValidation u= new UrlValidation();
            u.urlValidator(url);

            System.out.println("Enter path of Output folder:");
            path = scan.next();

            PathValidation p = new PathValidation();
            p.pathValidator(path);

            //fileName = scan.next();

            FileNameValidation fv = new FileNameValidation();
            do
            {
                System.out.println("Save File As:");
                fileName = scan.next();
                b = fv.nameValidator(fileName);  

            }while(b == false);
            File f = new File(fileName);


           /* do{
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
            }while(b== false);*/
               
            Downloads d = new Downloads();
            d.saveUrl(path + "\\" + fileName, url);
            
        }

        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}