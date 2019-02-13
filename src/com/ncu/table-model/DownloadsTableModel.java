import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

class DownloadsTableModel extends AbstractTableModel implements Observer
{
	//Defining tables column names
	private static final String[] columnNames = {"URL","Size","Progress","Status"};

	//Defining classes for each column value
	private static final Class[] columnClasses ={String.class,String.class,JProgressBar.class,String.class};

	//The table contains arraylist of download
	private ArrayList<Download> downloadDetail = new ArrayList<Download>();

	//Add new download to the table
	public void addDownload(Download download)
	{
	//Notifies when the download changes
	download.addObserver(this);
	downloadDetail.add(download);

	//Inserting row in table
	fireTableRowsInserted(getRowCount() -1,getRowCount() -1);
	}

	public Download getDownload(int row)
	{
	return downloadDetail.get(row);
	}
	
	public int getColumnCount()
	{
	return columnNames.length;
	}
	
	public String getColumnName(int col)
	{
	return columnNames[col];
	}
	
	public Class getColumnClass(int col)
	{
	return columnClasses[col];
	}
	
	public int getRowCount()
	{
	return downloadDetail.size();
	}
	
	//Get value for a specific row and column combination.
	public Object getValueAt(int row,int col)
	{
	Download download = downloadDetail.get(row);
		switch(col)
		{
		case 0: //URL
		return download.getUrl();
		case 1: //Size
		int size = download.getSize();
		return (size == -1) ? "": Integer.toString(size);
		case 2: //Progress
		return new Float(download .getProgress());
		case 3: //Status
		return Download.STATUSES[download.getStatus()];
		}
		return "";
	}
}


class TestTable
{
	public static void main(String[] args)
	{
		DownloadsTableModel table = new DownloadsTableModel();
		int r = table.getRowCount();
		int c = table.getColumnCount();

		//MessageFormat header = new MessageFormat("Download Details");
		try {
				for(int i = 0; i < r; i++)
				{
					for(int j = 0; j < c; j++)
					{
		    			System.out.print(table.getValueAt(i,j));						
					}
				}

			} 
		catch (Exception e) 
		{
    		System.out.println(e.getMessage());
		}
	}
}