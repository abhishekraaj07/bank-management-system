package bank.management.system;

import java.io.File;
import java.sql.*;

public class Conn {
    public Connection c; 
    public Statement s;
    
    public Conn() {
        try {
            // Check if MySQL driver is available and MySQL is running
            boolean connected = false;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "root");
                s = c.createStatement();
                connected = true;
                System.out.println("Connected to MySQL Database.");
            } catch (Exception mysqlEx) {
                // Fallback to SQLite (Embedded zero-config database)
                // This ensures the project runs on ANY computer without installing/configuring MySQL!
                Class.forName("org.sqlite.JDBC");
                String dbPath = System.getProperty("user.dir") + File.separator + "bank_database.db";
                c = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
                s = c.createStatement();
                initDatabase();
                connected = true;
                System.out.println("Connected to SQLite Database: " + dbPath);
            }
        } 
        catch (Exception e) {
            System.out.println("Database Connection Error: " + e.getMessage());
        }
    }

    private void initDatabase() {
        try {
            // Create required tables if they don't exist
            String createSignup = "CREATE TABLE IF NOT EXISTS signup (" +
                    "formno VARCHAR(20), name VARCHAR(50), fname VARCHAR(50), " +
                    "dob VARCHAR(30), gender VARCHAR(20), email VARCHAR(50), " +
                    "marital VARCHAR(20), address VARCHAR(100), city VARCHAR(50), " +
                    "pin VARCHAR(20), state VARCHAR(50))";

            String createSignupTwo = "CREATE TABLE IF NOT EXISTS signuptwo (" +
                    "formno VARCHAR(20), religion VARCHAR(30), category VARCHAR(30), " +
                    "income VARCHAR(30), education VARCHAR(30), occupation VARCHAR(30), " +
                    "pan VARCHAR(30), aadhar VARCHAR(30), seniorcitizon VARCHAR(20), " +
                    "existingaccount VARCHAR(20))";

            String createSignupThree = "CREATE TABLE IF NOT EXISTS signupthree (" +
                    "formno VARCHAR(20), accountType VARCHAR(40), cardnumber VARCHAR(30), " +
                    "pin VARCHAR(10), facility VARCHAR(200))";

            String createLogin = "CREATE TABLE IF NOT EXISTS login (" +
                    "formno VARCHAR(20), cardnumber VARCHAR(30), pin VARCHAR(10))";

            String createBank = "CREATE TABLE IF NOT EXISTS bank (" +
                    "pin VARCHAR(10), date VARCHAR(50), type VARCHAR(30), amount VARCHAR(30))";

            s.executeUpdate(createSignup);
            s.executeUpdate(createSignupTwo);
            s.executeUpdate(createSignupThree);
            s.executeUpdate(createLogin);
            s.executeUpdate(createBank);

            // Insert a default test user if login table is empty
            ResultSet rs = s.executeQuery("SELECT count(*) FROM login");
            if (rs.next() && rs.getInt(1) == 0) {
                s.executeUpdate("INSERT INTO login VALUES ('1001', '5040936012345678', '1234')");
                s.executeUpdate("INSERT INTO signupthree VALUES ('1001', 'Saving Account', '5040936012345678', '1234', 'ATM Card, Internet Banking')");
                s.executeUpdate("INSERT INTO bank VALUES ('1234', '2026-10-12', 'Deposit', '10000')");
                System.out.println("Default Demo Account Created: Card = 5040936012345678, PIN = 1234 (Balance: Rs 10,000)");
            }
        } catch (Exception ex) {
            System.out.println("Table initialization error: " + ex.getMessage());
        }
    }
}
