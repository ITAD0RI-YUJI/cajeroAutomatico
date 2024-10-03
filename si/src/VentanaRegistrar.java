import javax.swing.*;
import java.awt.*;

public class VentanaRegistrar extends JFrame {
    private VentanaMain ventanaMain;
    Color fondo = new Color(38, 35, 53);
    Color text = new Color(194, 190, 212);
    Color mini = new Color(46, 43, 65);
    Color margen = new Color(106, 97, 148);

    public VentanaRegistrar(VentanaMain ventanaMain) {
        this.ventanaMain = ventanaMain;
        setTitle("Registro de Cliente");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(fondo);
        iniciar();
        setVisible(true);
    }

    private void iniciar() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(fondo);

        JLabel nombreLabel = new JLabel("Nombre");
        nombreLabel.setForeground(text);
        nombreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField nombreField = new JTextField();
        nombreField.setMaximumSize(new Dimension(300, 20));
        nombreField.setBackground(mini);
        nombreField.setBorder(BorderFactory.createLineBorder(margen));
        nombreField.setForeground(Color.WHITE);

        JLabel cedulaLabel = new JLabel("Cédula");
        cedulaLabel.setForeground(text);
        cedulaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField cedulaField = new JTextField();
        cedulaField.setMaximumSize(new Dimension(300, 20));
        cedulaField.setBackground(mini);
        cedulaField.setBorder(BorderFactory.createLineBorder(margen));
        cedulaField.setForeground(Color.WHITE);

        JLabel passLabel = new JLabel("Contraseña");
        passLabel.setForeground(text);
        passLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPasswordField passField = new JPasswordField();
        passField.setMaximumSize(new Dimension(300, 20));
        passField.setBackground(mini);
        passField.setBorder(BorderFactory.createLineBorder(margen));
        passField.setForeground(Color.WHITE);

        JButton registrarBtn = new JButton("Registrar");
        configurarBoton(registrarBtn);
        registrarBtn.addActionListener(e -> {
            String nombre = nombreField.getText();
            String cedula = cedulaField.getText();
            String contraseña = new String(passField.getPassword());

            if (!nombre.isEmpty() && !cedula.isEmpty() && !contraseña.isEmpty()) {
                String numeroTarjeta = GeneradorTarjeta.generarNumeroTarjeta();
                Cliente nuevoCliente = new Cliente(nombre, cedula, numeroTarjeta, contraseña);
                Cuenta nuevaCuenta = new Cuenta(nuevoCliente, 0.0);
                ventanaMain.agregarCuenta(nuevaCuenta);
                JOptionPane.showMessageDialog(this, "Registro exitoso. N° Tarjeta: " + numeroTarjeta);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
            }
        });

        panel.add(Box.createVerticalGlue());
        panel.add(nombreLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(nombreField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(cedulaLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(cedulaField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(passLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(passField);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(registrarBtn);
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
