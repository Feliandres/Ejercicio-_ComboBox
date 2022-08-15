import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static final String DB_URL  = "jdbc:mysql://localhost/mitienda?serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static  final String PASSWORD = "";
    private Connection con = null;

    public Connection getConexion() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/mitienda?serverTimezone=UTC","root","");


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error");
        }
        return con;
    }
}
