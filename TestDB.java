import java.sql.Connection;
import java.sql.DriverManager;

public class TestDB {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_tracker", "root", "98KQWVC4");
            System.out.println("SUCCESS! root/98KQWVC4 works!");
            conn.close();
        } catch (Exception e) {
            System.out.println("FAILED WITH root/98KQWVC4: " + e.getMessage());
        }
    }
}
