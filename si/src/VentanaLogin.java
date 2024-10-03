import javax.swing.*;
import java.awt.*;

public class VentanaLogin extends JFrame {
    private Cuenta cuenta;
    private VentanaMain ventanaMain;
    Color fondo = new Color(38, 35, 53);
    Color text = new Color(194, 190, 212);
    Color mini = new Color(46, 43, 65);
    Color margen = new Color(106, 97, 148);

    public VentanaLogin(Cuenta cuenta, VentanaMain ventanaMain) {
        this.cuenta = cuenta;
        this.ventanaMain = ventanaMain;
        setTitle("Operaciones");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(fondo);
        iniciar();
        setVisible(true);
    }

    private void iniciar() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(fondo);

        JLabel saldoLabel = new JLabel("Saldo actual: $" + cuenta.getSaldo());
        saldoLabel.setForeground(text);
        saldoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton retirarBtn = new JButton("Retirar");
        configurarBoton(retirarBtn);
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
        configurarBoton(consignarBtn);
        consignarBtn.addActionListener(e -> {
            String montoStr = JOptionPane.showInputDialog(this, "Ingrese el monto a consignar:");
            double monto = Double.parseDouble(montoStr);
            cuenta.consignar(monto);
            JOptionPane.showMessageDialog(this, "Consignación exitosa. Saldo actual: $" + cuenta.getSaldo());
            ventanaMain.guardarCuentas();
            saldoLabel.setText("Saldo actual: $" + cuenta.getSaldo());
        });

        panel.add(Box.createVerticalGlue());
        panel.add(saldoLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(retirarBtn);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(consignarBtn);
        panel.add(Box.createVerticalGlue());

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(Box.createHorizontalGlue(), BorderLayout.WEST);
        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.getContentPane().add(Box.createHorizontalGlue(), BorderLayout.EAST);
    }

    private void configurarBoton(JButton boton) {
        Dimension buttonSize = new Dimension(100, 30);
        boton.setMinimumSize(buttonSize);
        boton.setPreferredSize(buttonSize);
        boton.setMaximumSize(buttonSize);
        boton.setForeground(Color.WHITE);
        boton.setBackground(fondo);
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton.setBorder(BorderFactory.createLineBorder(margen));
    }
}
