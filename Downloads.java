import java.io.*;
import java.net.*;

class Downloads
{
    public void saveUrl(String filename, String urlString) throws IOException 
    {
        BufferedInputStream in = null;
        FileOutputStream fout = null;

        try
        {
            //openStream() method is used to get an input stream on url mentioned
            // reads bytes and decodes them into characters
            in = new BufferedInputStream(new URL(urlString).openStream());
            fout = new FileOutputStream(filename);

            byte data[] = new byte[1024];
            int count;
            while ((count = in.read(data, 0, 1024)) != -1) 
            {
                fout.write(data, 0, count);
            }
        }
    
        finally 
        {
            if (in != null) 
            {
                in.close();
            }
            if (fout != null)
            {
                fout.close();
            }
        }
    }

    //Testing Driver
    public static void main (String[] args)
    {
        try
        {
            Downloads d = new Downloads();
            d.saveUrl("test4.pdf","https://www.tutorialspoint.com/java/java_tutorial.pdf");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
/*
The following small Java program uses openStream() to get an input stream on the URL http://www.oracle.com/.
It then opens a BufferedReader on the input stream and reads from the BufferedReader thereby reading from the URL. 
Everything read is copied to the standard output stream:
*/