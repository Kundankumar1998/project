import java.awt.*;
import java.awt.event.*;

public class New_Bill extends Frame implements ActionListener {

    Label lblCustomerDetails, lblMedicineDetails, lblBill;
    Label lblName, lblMobile, lblAddress;
    Label lblMedicineName, lblRate, lblQuantity;
    TextField tfName, tfMobile, tfAddress;
    TextField tfMedicineName, tfRate, tfQuantity;
    Button btnAdd, btnPrint,back;
    TextArea taBill;
    double totalAmount = 0.0;

    public New_Bill() {
        // Initialize UI components
        lblCustomerDetails = new Label("Customer Details:");
        lblCustomerDetails.setForeground(Color.BLUE);

        lblName = new Label("Name:");
        lblMobile = new Label("Mobile:");
        lblAddress = new Label("Address:");
        tfName = new TextField(20);
        tfMobile = new TextField(20);
        tfAddress = new TextField(20);

        lblMedicineDetails = new Label("Medicine Details:");
        lblMedicineDetails.setForeground(Color.RED);

        lblMedicineName = new Label("Medicine Name:");
        lblRate = new Label("Rate:");
        lblQuantity = new Label("Quantity:");
        tfMedicineName = new TextField(20);
        tfRate = new TextField(10);
        tfQuantity = new TextField(5);
        btnAdd = new Button("Add Medicine");
        btnPrint = new Button("Print Bill");
        back=new Button("Back");

        lblBill = new Label("Bill:");
        taBill = new TextArea(15, 40);
        taBill.setEditable(false);

        // Set layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblCustomerDetails, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lblName, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(tfName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(lblMobile, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(tfMobile, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(lblAddress, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        add(tfAddress, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(lblMedicineDetails, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(lblMedicineName, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        add(tfMedicineName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        add(lblRate, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        add(tfRate, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        add(lblQuantity, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        add(tfQuantity, gbc);

        gbc.gridx = 2;
        gbc.gridy = 7;
        add(btnAdd, gbc);

        gbc.gridx = 2;
        gbc.gridy = 8;
        add(btnPrint, gbc);

        back.setBounds(5,20,20,20);
        add(back);

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 3;
        add(lblBill, gbc);

        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        add(taBill, gbc);

        // Set action listeners
        btnAdd.addActionListener(this);
        btnPrint.addActionListener(this);
        back.addActionListener(this);
        setTitle("Medicine Billing");
        setSize(800, 600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            addMedicineToBill();
        } else if (e.getSource() == btnPrint) {
            printBill();
        } else if (e.getSource() == back){
            new Staff();
            dispose();
        }
    }

    private void addMedicineToBill() {
        String medicineName = tfMedicineName.getText();
        double rate = Double.parseDouble(tfRate.getText());
        int quantity = Integer.parseInt(tfQuantity.getText());

        double subtotal = rate * quantity;
        totalAmount += subtotal;

        String medicineDetails = String.format("%s - Rate: %.2f, Quantity: %d, Subtotal: %.2f\n",
                medicineName, rate, quantity, subtotal);
        taBill.append(medicineDetails);

        tfMedicineName.setText("");
        tfRate.setText("");
        tfQuantity.setText("");
    }

    private void printBill() {
        // Code to print the bill using javax.print
        // ...

        // Placeholder message for demonstration
        taBill.append("\nTotal Amount: " + totalAmount);
    }

    public static void main(String[] args) {
        new New_Bill().addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
}