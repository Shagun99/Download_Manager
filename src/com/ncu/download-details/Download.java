import java.io.*;
import java.net.*;
import java.util.*;

class Download extends Observable implements Runnable
{
	private static final int MAX_BUFFER_SIZE=1024;
	public static final String STATUSES[]={"Downloading","Paused","Complete","Cancelled","Error"};

	public static final int DOWNLOADING=0;
	public static final int PAUSED=1;
	public static final int COMPLETE=2;
	public static final int CANCELLED=3;
	public static final int ERROR=4;

	private URL url;
	private int size;
	private int downloaded;
	private int status;

	//Constructor for Download class
	public Download(URL url)
	{
		this.url= url;
		size=-1;
		downloaded=0;
		status=DOWNLOADING;
		download();
	}
	//Method to get URL
	public String getUrl()
	{
		return url.toString();
	}

	//Method to get size of file being downloaded
	public int getSize()
	{
		return size;
	}
	
	//Method to get percentage of download progress
	public float getProgress()
	{
		return ((float)downloaded/size)*100;
	}
	
	//Method to get status of download
	public int getStatus()
	{
		return status;
	}
	
	//Method to pause download
	public void pause()
	{
		status=PAUSED;
		stateChanged();
	}
	//Method to resume download
	public void resume()
	{
		status=DOWNLOADING;
		stateChanged();
		download();
	}
	
	//Method to cancel download
	public void cancel()
	{
	status = CANCELED;
	stateChanged();
	}
	
	//Method to set status as error
	private void error()
	{
	status=ERROR;
	stateChanged();
	}
} 