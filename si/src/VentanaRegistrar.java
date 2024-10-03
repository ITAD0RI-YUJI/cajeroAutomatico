import javax.swing.*;
import java.awt.*;

public class VentanaRegistrar extends JFrame {
    private VentanaMain ventanaMain;

    public VentanaRegistrar(VentanaMain ventanaMain) {
        this.ventanaMain = ventanaMain;
        setTitle("Registro de Cliente");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        iniciar();
        setVisible(true);
    }

    private void iniciar() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel nombreLabel = new JLabel("Nombre");
        JTextField nombreField = new JTextField();
        nombreField.setMaximumSize(new Dimension(300, 20));

        JLabel cedulaLabel = new JLabel("Cédula");
        JTextField cedulaField = new JTextField();
        cedulaField.setMaximumSize(new Dimension(300, 20));

        JLabel passLabel = new JLabel("Contraseña");
        JPasswordField passField = new JPasswordField();
        passField.setMaximumSize(new Dimension(300, 20));

        JButton registrarBtn = new JButton("Registrar");
        registrarBtn.addActionListener(e -> {
            String nombre = nombreField.getText();
            String cedula = cedulaField.getText();
            String contraseña = new String(passField.getPassword());

            if (!nombre.isEmpty() && !cedula.isEmpty() && !contraseña.isEmpty()) {
                String numeroTarjeta = GeneradorTarjeta.generarNumeroTarjeta();
                Cliente nuevoCliente = new Cliente(nombre, cedula, numeroTarjeta, contraseña);
                Cuenta nuevaCuenta = new Cuenta(nuevoCliente, 0.0);  // Saldo inicial de 0.0
                ventanaMain.agregarCuenta(nuevaCuenta);  // Añadir nueva cuenta al sistema
                JOptionPane.showMessageDialog(this, "Registro exitoso. N° Tarjeta: " + numeroTarjeta);
                dispose();  // Cerrar la ventana de registro
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
            }
        });

        panel.add(nombreLabel);
        panel.add(nombreField);
        panel.add(cedulaLabel);
        panel.add(cedulaField);
        panel.add(passLabel);
        panel.add(passField);
        panel.add(registrarBtn);

        this.getContentPane().add(panel);
    }
}