
package advandbmp;
import java.sql.*;

public class Database 
{
	private DBConnection connect;

    public Database() 
    {
    	connect = new DBConnection();
	connect.getConnection();
    }
    public long execTime(Query q)
    {
        try{
            ResultSet rs;
            PreparedStatement statement;
            statement = connect.getConnection().prepareStatement(q.getQuery());
            
            long startTimer = System.currentTimeMillis();
            
            rs = statement.executeQuery();
            
            long endTimer = System.currentTimeMillis();
            
            
            long execTimer = endTimer - startTimer;
            q.setExecTime(execTimer);
            
            System.out.println("Query execution sucessfull.");
            
            //int rowCount = 0;
            
//            while(rs.next()){
//                System.out.println("Data: " + rs.getString(1));
//                rowCount++;
//            } 
//            System.out.println("Row Count: " + rowCount);
            System.out.println("Execution Time: " + q.getExecTime() + " ms");
            
            return execTimer ;
                
            
            
        }
        catch(SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        return 0;
        
    }
    public ResultSet execQuery(Query q)
    {
        try{
            ResultSet rs;
            PreparedStatement statement;
            statement = connect.getConnection().prepareStatement(q.getQuery());
            
            long startTimer = System.currentTimeMillis();
            
            rs = statement.executeQuery();
            
            long endTimer = System.currentTimeMillis();
            
            
            long execTimer = endTimer - startTimer;
            q.setExecTime(execTimer);
            
            System.out.println("Query execution sucessfull.");
            
            //int rowCount = 0;
            
//            while(rs.next()){
//                System.out.println("Data: " + rs.getString(1));
//                rowCount++;
//            } 
//            System.out.println("Row Count: " + rowCount);
            System.out.println("Execution Time: " + q.getExecTime() + " ms");
            
            return rs;
                
            
            
        }
        catch(SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        return null;
    }

}