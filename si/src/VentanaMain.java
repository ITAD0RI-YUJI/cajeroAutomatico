import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VentanaMain extends JFrame {
    private static final int MAX_INTENTOS = 3;
    private int intentos = 0;
    private List<Cuenta> cuentas;

    public VentanaMain() {
        // Cargar cuentas desde el archivo
        cuentas = cargarCuentas();

        setTitle("Cajero");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(38, 35, 53));
        iniciar();
        setVisible(true);
    }

    public void iniciar() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(38, 35, 53));

        JLabel cardLabel = new JLabel("N° Tarjeta");
        cardLabel.setForeground(new Color(194, 190, 212));
        cardLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextField tarjetaField = new JTextField();
        tarjetaField.setMaximumSize(new Dimension(300, 20));
        tarjetaField.setBackground(new Color(46, 43, 65));
        tarjetaField.setForeground(Color.WHITE);

        JLabel passLabel = new JLabel("Contraseña");
        passLabel.setForeground(new Color(194, 190, 212));
        passLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPasswordField passField = new JPasswordField();
        passField.setMaximumSize(new Dimension(300, 20));
        passField.setBackground(new Color(46, 43, 65));
        passField.setForeground(Color.WHITE);

        JButton iniciarBtn = new JButton("Iniciar");
        iniciarBtn.addActionListener(e -> {
            String tarjeta = tarjetaField.getText();
            String contraseña = new String(passField.getPassword());

            Cuenta cuenta = validarCuenta(tarjeta, contraseña);
            if (cuenta != null) {
                JOptionPane.showMessageDialog(this, "Ingreso exitoso");
                new VentanaLogin(cuenta, this);
                dispose();
            } else {
                intentos++;
                if (intentos >= MAX_INTENTOS) {
                    JOptionPane.showMessageDialog(this, "Tarjeta bloqueada. Demasiados intentos fallidos.");
                    iniciarBtn.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Tarjeta o contraseña incorrecta. Intento " + intentos + " de " + MAX_INTENTOS);
                }
            }
        });

        JButton registrarBtn = new JButton("Registrar");
        registrarBtn.addActionListener(e -> new VentanaRegistrar(this));

        panel.add(Box.createVerticalGlue());
        panel.add(cardLabel);
        panel.add(tarjetaField);
        panel.add(passLabel);
        panel.add(passField);
        panel.add(iniciarBtn);
        panel.add(registrarBtn);
        panel.add(Box.createVerticalGlue());

        this.getContentPane().add(panel);
    }

    private Cuenta validarCuenta(String tarjeta, String contraseña) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getCliente().getTarjeta().equals(tarjeta) && cuenta.getCliente().getContraseña().equals(contraseña)) {
                return cuenta;
            }
        }
        return null;
    }

    private List<Cuenta> cargarCuentas() {
        List<Cuenta> cuentas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("cuentas.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                cuentas.add(Cuenta.fromFileString(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cuentas;
    }

    public void guardarCuentas() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("cuentas.txt"))) {
            for (Cuenta cuenta : cuentas) {
                pw.println(cuenta.toFileString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
        guardarCuentas();
    }
}
