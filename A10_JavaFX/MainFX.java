import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;

public class MainFX extends Application {

    static final String URL = "jdbc:mysql://localhost:3306/RestaurantDB?useSSL=false&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "9598763794@Pp";

    TextField nameField = new TextField();
    TextField priceField = new TextField();
    TextField resIdField = new TextField();
    TextArea output = new TextArea();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        nameField.setPromptText("Item Name");
        priceField.setPromptText("Price");
        resIdField.setPromptText("Restaurant ID");

        Button insertBtn = new Button("Insert");
        Button viewBtn = new Button("View All");
        Button updateBtn = new Button("Update Price ≤100 → 200");
        Button deleteBtn = new Button("Delete (Name starts with P)");

        insertBtn.setOnAction(e -> insert());
        viewBtn.setOnAction(e -> view());
        updateBtn.setOnAction(e -> update());
        deleteBtn.setOnAction(e -> delete());

        VBox root = new VBox(10,
                nameField, priceField, resIdField,
                insertBtn, viewBtn, updateBtn, deleteBtn,
                output);

        root.setPadding(new Insets(15));

        stage.setTitle("JavaFX CRUD App");
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }

    // 🔹 INSERT
    void insert() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {

            String sql = "INSERT INTO MenuItem(Name, Price, ResId) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nameField.getText());
            ps.setInt(2, Integer.parseInt(priceField.getText()));
            ps.setInt(3, Integer.parseInt(resIdField.getText()));

            ps.executeUpdate();
            output.setText("Inserted Successfully ✅");

        } catch (Exception e) {
            output.setText(e.getMessage());
        }
    }

    // 🔹 SELECT
    void view() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM MenuItem")) {

            StringBuilder sb = new StringBuilder("ID | Name | Price | ResId\n");

            while (rs.next()) {
                sb.append(rs.getInt("Id")).append(" | ")
                  .append(rs.getString("Name")).append(" | ")
                  .append(rs.getInt("Price")).append(" | ")
                  .append(rs.getInt("ResId")).append("\n");
            }

            output.setText(sb.toString());

        } catch (Exception e) {
            output.setText(e.getMessage());
        }
    }

    // 🔹 UPDATE
    void update() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = con.createStatement()) {

            int rows = stmt.executeUpdate("UPDATE MenuItem SET Price=200 WHERE Price<=100");
            output.setText("Updated rows: " + rows);

        } catch (Exception e) {
            output.setText(e.getMessage());
        }
    }

    // 🔹 DELETE
    void delete() {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = con.createStatement()) {

            int rows = stmt.executeUpdate("DELETE FROM MenuItem WHERE Name LIKE 'P%'");
            output.setText("Deleted rows: " + rows);

        } catch (Exception e) {
            output.setText(e.getMessage());
        }
    }
}