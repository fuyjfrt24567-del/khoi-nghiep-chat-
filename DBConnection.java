import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() throws Exception {

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        String url =
                "jdbc:sqlserver://127.0.0.1:1433;" +
                "databaseName=sql khoi nghiep;" +
                "encrypt=true;" +
                "trustServerCertificate=true;";

        return DriverManager.getConnection(
                url,
                "sa",
                "123456"
        );
    }
}