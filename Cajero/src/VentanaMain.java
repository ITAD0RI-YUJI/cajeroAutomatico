import javax.swing.*;
import java.awt.*;
public class VentanaMain extends JFrame {
    Color fondo = new Color(38, 35, 53);
    Color text = new Color(194,190,212);
    Color mini = new Color(46,43,65);
    Color margen = new Color(106,97,148);
    Color boton = new Color(30,27,41);
    public VentanaMain() {
        setTitle("Cajero");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        setLocationRelativeTo(null);
        getContentPane().setBackground(fondo);
        iniciar();
        setVisible(true);
    }
    public void iniciar() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(fondo);

        //Ingreso en la tarjeta

        JLabel card = new JLabel("Nombre");
        card.setForeground(text);
        card.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField tarjeta = new JTextField();
        tarjeta.setMaximumSize(new Dimension(300, 20)); // Ajustar el tamaño máximo
        tarjeta.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el campo de texto
        tarjeta.setBackground(mini);
        tarjeta.setBorder(BorderFactory.createLineBorder(margen));
        tarjeta.setForeground(Color.WHITE);
        //Contraseña
        JLabel pass = new JLabel("Contraseña");
        pass.setForeground(text);
        pass.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField contraseña = new JTextField();
        contraseña.setMaximumSize(new Dimension(300, 20)); // Ajustar el tamaño máximo
        contraseña.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el campo de texto
        contraseña.setBackground(mini);
        contraseña.setBorder(BorderFactory.createLineBorder(margen));
        contraseña.setForeground(Color.WHITE);

        panel.add(Box.createVerticalGlue());
        panel.add(card);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio entre componentes
        panel.add(tarjeta);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(pass);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(contraseña);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(Box.createVerticalGlue());


        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(Box.createHorizontalGlue(), BorderLayout.WEST);
        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.getContentPane().add(Box.createHorizontalGlue(), BorderLayout.EAST);
    }

}
