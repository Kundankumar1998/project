import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class MedicineBillingInterface extends Frame implements ActionListener {
    private TextField tfMedicineName, tfQuantity, tfUnitPrice;
    private Button btnAdd, btnPrint;
    private TextArea taBill;

    private Connection connection;

    public MedicineBillingInterface() {
        // Initialize UI components
        tfMedicineName = new TextField(20);
        tfQuantity = new TextField(5);
        tfUnitPrice = new TextField(10);
        btnAdd = new Button("Add Medicine");
        btnPrint = new Button("Print Bill");
        taBill = new TextArea(15, 40);

        // Set layout and add components
        setLayout(new FlowLayout());
        add(new Label("Medicine Name:"));
        add(tfMedicineName);
        add(new Label("Quantity:"));
        add(tfQuantity);
        add(new Label("Unit Price:"));
        add(tfUnitPrice);
        add(btnAdd);
        add(btnPrint);
        add(taBill);

        // Set action listeners
        btnAdd.addActionListener(this);
        btnPrint.addActionListener(this);

        // Establish database connection
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "kundan", "kundan");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        setTitle("Medicine Billing Interface");
        setSize(500, 400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            addMedicineToBill();
        } else if (e.getSource() == btnPrint) {
            printBill();
        }
    }

    private void addMedicineToBill() {
        String medicineName = tfMedicineName.getText();
        int quantity = Integer.parseInt(tfQuantity.getText());
        double unitPrice = Double.parseDouble(tfUnitPrice.getText());

        // Calculate subtotal
        double subtotal = quantity * unitPrice;

        // Add medicine details to the TextArea
        String medicineDetails = String.format("%s - Quantity: %d, Unit Price: %.2f, Subtotal: %.2f\n",
            medicineName, quantity, unitPrice, subtotal);
        taBill.append(medicineDetails);

        // Clear input fields
        tfMedicineName.setText("");
        tfQuantity.setText("");
        tfUnitPrice.setText("");
    }

    private void printBill() {
        // Code to send the content of taBill to the printer
        // ...

        JOptionPane.showMessageDialog(this, "Bill printed successfully!");
    }

    public static void main(String[] args) {
        new MedicineBillingInterface().addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
}
