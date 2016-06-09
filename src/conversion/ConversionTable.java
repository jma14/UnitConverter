package conversion;

import java.sql.*;

public class ConversionTable {

  private static final String CONVERSION_TABLE = "create table ConversionTable ( "
      + "   id INT PRIMARY KEY, convertFrom VARCHAR, convertTo VARCHAR, convertFactor DOUBLE, unitType VARCHAR"
      + "   title VARCHAR)";

  public static Connection getConnection() throws Exception {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost/mydatabase";
    String username = "root";
    String password = "root";
    Class.forName(driver);
    Connection conn = DriverManager.getConnection(url, username, password);
    return conn;
  }

  public static void main(String args[]) {
    Connection conn = null;
    Statement stmt = null;
    try {
      conn = getConnection();
      stmt = conn.createStatement();
      stmt.executeUpdate(CONVERSION_TABLE);
      stmt.executeUpdate("insert into MyEmployees3(id, firstName) values(100, 'A')");
      stmt.executeUpdate("insert into MyEmployees3(id, firstName) values(200, 'B')");
      System.out.println("CreateEmployeeTableMySQL: main(): table created.");
    } catch (ClassNotFoundException e) {
      System.out.println("error: failed to load MySQL driver.");
      e.printStackTrace();
    } catch (SQLException e) {
      System.out.println("error: failed to create a connection object.");
      e.printStackTrace();
    } catch (Exception e) {
      System.out.println("other error:");
      e.printStackTrace();
    } finally {
      try {
        stmt.close();
        conn.close();        
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}