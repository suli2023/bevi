import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataService {
    public void insertCustomers(ArrayList<Customer> customerList) throws SQLException {
        String user = "bevi";
        String pass = "titok";
        String url = "jdbc:mariadb://localhost:3306/bevi";
        Connection conn = DriverManager.getConnection(url, user, pass);

        String sql = """
                insert into customers
                (id,name,email)
                values
                (?,?,?)
                """;
        for (Customer customer : customerList) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, customer.id);
            ps.setString(2, customer.name);
            ps.setString(3, customer.email);
            ps.execute();
        }
        conn.close();
    }
    public void insertIncomings(ArrayList<Incoming> incomingList) throws SQLException {
        String user = "bevi";
        String pass = "titok";
        String url = "jdbc:mariadb://localhost:3306/bevi";
        Connection conn = DriverManager.getConnection(url, user, pass);

        String sql = """
                insert into incomings
                (id,total,date, source, customerId)
                values
                (?,?,?,?,?)
                """;
        for (Incoming incoming : incomingList) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, incoming.id);
            ps.setDouble(2, incoming.total);
            ps.setDate(3, java.sql.Date.valueOf( incoming.date));
            ps.setString(4, incoming.source);
            ps.setInt(5, incoming.customerId);
            ps.execute();
        }
        conn.close();

    }

}
