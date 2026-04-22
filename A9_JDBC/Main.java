import java.sql.*;

public class Main {

    static final String URL = "jdbc:mysql://localhost:3306/RestaurantDB?useSSL=false&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "9598763794@Pp";

    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement stmt = con.createStatement();

            System.out.println("Connected to database ✅");

            // 1. CREATE TABLES
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Restaurant (" +
                    "Id INT PRIMARY KEY AUTO_INCREMENT, Name VARCHAR(100), Address VARCHAR(200))");

            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS MenuItem (" +
                    "Id INT PRIMARY KEY AUTO_INCREMENT, Name VARCHAR(100), Price INT, ResId INT, " +
                    "FOREIGN KEY (ResId) REFERENCES Restaurant(Id))");

            // 2. INSERT RESTAURANTS (clear first to avoid duplicates)
            stmt.executeUpdate("DELETE FROM MenuItem");
            stmt.executeUpdate("DELETE FROM Restaurant");

            String[] restaurants = {
                    "('Cafe Java','Pune')","('Spice Hub','Mumbai')","('Food Palace','Delhi')",
                    "('Green Bowl','Bangalore')","('Tasty Treat','Hyderabad')",
                    "('Urban Bites','Chennai')","('Royal Dine','Jaipur')",
                    "('Street Eats','Kolkata')","('Ocean Grill','Goa')",
                    "('Fusion Feast','Ahmedabad')"
            };

            for (String r : restaurants) {
                stmt.executeUpdate("INSERT INTO Restaurant (Name, Address) VALUES " + r);
            }

            // 3. INSERT MENU ITEMS
            String[] items = {
                    "('Pasta',120,1)","('Pizza',90,1)","('Burger',80,2)",
                    "('Paneer Tikka',150,3)","('Pav Bhaji',70,4)",
                    "('Noodles',110,5)","('Paratha',60,6)",
                    "('Sandwich',50,7)","('Soup',40,8)","('Pudding',95,1)"
            };

            for (String i : items) {
                stmt.executeUpdate("INSERT INTO MenuItem (Name, Price, ResId) VALUES " + i);
            }

            // 4. SELECT price <= 100
            System.out.println("\n--- Menu Items with Price <= 100 ---");
            printResult(stmt.executeQuery("SELECT * FROM MenuItem WHERE Price <= 100"));

            // 5. SELECT items from Cafe Java
            System.out.println("\n--- Items from Cafe Java ---");
            printResult(stmt.executeQuery(
                    "SELECT m.* FROM MenuItem m JOIN Restaurant r ON m.ResId=r.Id WHERE r.Name='Cafe Java'"
            ));

            // 6. UPDATE price <= 100 → 200
            int updated = stmt.executeUpdate("UPDATE MenuItem SET Price=200 WHERE Price <= 100");
            System.out.println("\nRows Updated: " + updated);

            System.out.println("\n--- After Update ---");
            printResult(stmt.executeQuery("SELECT * FROM MenuItem"));

            // 7. DELETE items starting with P
            int deleted = stmt.executeUpdate("DELETE FROM MenuItem WHERE Name LIKE 'P%'");
            System.out.println("\nRows Deleted: " + deleted);

            System.out.println("\n--- After Delete ---");
            printResult(stmt.executeQuery("SELECT * FROM MenuItem"));

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // FUNCTION TO PRINT RESULTSET IN TABLE FORMAT
    static void printResult(ResultSet rs) throws Exception {
        ResultSetMetaData md = rs.getMetaData();
        int cols = md.getColumnCount();

        // Print column names
        for (int i = 1; i <= cols; i++) {
            System.out.print(md.getColumnName(i) + "\t");
        }
        System.out.println();

        // Print rows
        while (rs.next()) {
            for (int i = 1; i <= cols; i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println();
        }
    }
}