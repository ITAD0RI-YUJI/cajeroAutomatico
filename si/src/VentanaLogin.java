import javax.swing.*;
import java.awt.*;

public class VentanaLogin extends JFrame {
    private Cuenta cuenta;
    private VentanaMain ventanaMain;

    public VentanaLogin(Cuenta cuenta, VentanaMain ventanaMain) {
        this.cuenta = cuenta;
        this.ventanaMain = ventanaMain;
        setTitle("Operaciones");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iniciar();
        setVisible(true);
    }

    private void iniciar() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel saldoLabel = new JLabel("Saldo actual: $" + cuenta.getSaldo());
        saldoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton retirarBtn = new JButton("Retirar");
        retirarBtn.addActionListener(e -> {
            String montoStr = JOptionPane.showInputDialog(this, "Ingrese el monto a retirar:");
            double monto = Double.parseDouble(montoStr);

            if (cuenta.retirar(monto)) {
                JOptionPane.showMessageDialog(this, "Retiro exitoso. Saldo actual: $" + cuenta.getSaldo());
                ventanaMain.guardarCuentas();
            } else {
                JOptionPane.showMessageDialog(this, "Saldo insuficiente.");
            }

            saldoLabel.setText("Saldo actual: $" + cuenta.getSaldo());
        });

        JButton consignarBtn = new JButton("Consignar");
        consignarBtn.addActionListener(e -> {
            String montoStr = JOptionPane.showInputDialog(this, "Ingrese el monto a consignar:");
            double monto = Double.parseDouble(montoStr);
            cuenta.consignar(monto);
            JOptionPane.showMessageDialog(this, "Consignación exitosa. Saldo actual: $" + cuenta.getSaldo());
            ventanaMain.guardarCuentas();
            saldoLabel.setText("Saldo actual: $" + cuenta.getSaldo());
        });

        panel.add(saldoLabel);
        panel.add(retirarBtn);
        panel.add(consignarBtn);

        this.getContentPane().add(panel);
    }
}
