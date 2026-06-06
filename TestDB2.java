import java.sql.Connection;

public class TestDB2 {
    public static void main(String[] args) {
        try {
            Connection con = DBConnection.getConnection();
            System.out.println("OK");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}