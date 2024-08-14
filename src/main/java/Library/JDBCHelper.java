package Library;

import java.sql.*;

/**
 *
 * @author Kien Luu
 */
public class JDBCHelper {
    static {
       try {
           String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
           Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }   
    
    public static PreparedStatement prepareStatement(String sql, Object...args) throws SQLException {
        String dburl = "jdbc:sqlserver://localhost:1433;databaseName=QLKS_DuAn1;encrypt=true;trustServerCertificate=true;";
        String username = "sa";
        String password = "1";
        Connection conn = DriverManager.getConnection(dburl,username,password);
        PreparedStatement pstmt = null;
        if(sql.trim().startsWith("{")) {
            pstmt = conn.prepareCall(sql);
        }
        else {
            pstmt = conn.prepareStatement(sql);
        }
        for(int i=0; i<args.length;i++) {
            pstmt.setObject(i+1, args[i]);
        }
        return pstmt;
    }
    
    public static void executeUpdate(String sql, Object...args) {
        try {
            PreparedStatement stmt = prepareStatement(sql, args);
            try {
                stmt.execute();
            } 
            finally {
                stmt.getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } 
    }
    
    public static ResultSet executeQuery(String sql, Object...args) {
        try {
            PreparedStatement stmt = prepareStatement(sql, args);
            return stmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
