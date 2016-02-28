package advandbmp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection
{
	private String url, username, password;
	private boolean connectionStatus = false;
	private Connection connection;
	private static DBConnection instance;

	public DBConnection()
	{
		this.url = "jdbc:mysql://localhost:3306/db_hpq";

                File f = new File("C:\\Users\\baldi_000\\Documents\\Advandb\\ADVANDBMP\\access.txt");
                if(f.isFile())
                {
                     BufferedReader inputStream = null;
                    try 
                    {
                        String line;
                        inputStream = new BufferedReader(new FileReader(f));
                        
                        while ((line = inputStream.readLine()) != null) {
                            //System.out.println(line + " ");
                            if(line.contains("username"))
                                this.username = line.replace("username: ", "");
                            else if(line.contains("password"))
                                this.password = line.replace("password: ", "");    
                        }
                    }
                    catch (Exception e)
                    {
                        System.out.println("Error reading access.txt");
                    } 
                }
                
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection(url, username,
					password);
			connectionStatus = true;
		} catch (Exception e)
		{
                     e.printStackTrace();
		}

	}

	public boolean getConnectionStatus()
	{
		return this.connectionStatus;
	}

	public Connection getConnection()
	{
		return this.connection;
	}

	public static DBConnection getInstance()
	{
		if (instance == null)
			instance = new DBConnection();

		return instance;
	}

}
