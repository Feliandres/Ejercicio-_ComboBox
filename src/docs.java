import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class docs extends JFrame{
    private JComboBox nombreCB;
    private JPanel mainPanel;
    private JComboBox ciudadCB;
    private JComboBox emailCB;
    Statement st;
    ResultSet rs;
    Connection con;

    public docs () {
        this.setContentPane(mainPanel);
        this.setTitle("ComboBox");
        this.setSize(460,560);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null); // centrar la pantalla
        Combobox();




    }

    public void Combobox (){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/mitienda?serverTimezone=UTC","root","");
            st = con.createStatement();
            String sql = "SELECT * FROM users";
            rs= st.executeQuery(sql);

            while (rs.next()) {
                nombreCB.addItem(rs.getString(3));
                ciudadCB.addItem(rs.getString(4));
                emailCB.addItem(rs.getString(2));
            }

        } catch (Exception exception){
            JOptionPane.showMessageDialog(null, "Error");
        } finally {
            try {
                st.close();
                rs.close();
                con.close();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
    }



    public static void main(String[] args) {
        docs docs = new docs();
    }
}
