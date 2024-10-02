import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaRegistrar extends JFrame{
    Color fondo = new Color(38, 35, 53);
    Color text = new Color(194,190,212);
    Color mini = new Color(46,43,65);
    Color margen = new Color(106,97,148);
    Color boton = new Color(30,27,41);
    public VentanaRegistrar() {
        setTitle("Registro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        setLocationRelativeTo(null);
        getContentPane().setBackground(fondo);
        incicar();
        setVisible(true);
    }
        private void incicar(){
        JPanel panel = new JPanel();
        panel.setBackground(fondo);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("Registro:");
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setForeground(text);

        JLabel nombre = new JLabel("Nombre");
        nombre.setAlignmentX(Component.CENTER_ALIGNMENT);
        nombre.setForeground(text);

        JTextField nombreText = new JTextField();
        nombreText.setAlignmentX(Component.CENTER_ALIGNMENT);
        nombreText.setBackground(mini);
        nombreText.setBorder(BorderFactory.createLineBorder(margen));
        nombreText.setMaximumSize(new Dimension(300, 20));
        nombreText.setForeground(Color.white);

        JLabel edad = new JLabel("Edad");
        edad.setAlignmentX(Component.CENTER_ALIGNMENT);
        edad.setForeground(text);

        JTextField edadText = new JTextField();
        edadText.setAlignmentX(Component.CENTER_ALIGNMENT);
        edadText.setBackground(mini);
        edadText.setBorder(BorderFactory.createLineBorder(margen));
        edadText.setMaximumSize(new Dimension(300, 20));
        edadText.setForeground(Color.white);

        JLabel cedula = new JLabel("Cédula:");
        cedula.setForeground(text);
        cedula.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField cedulaText = new JTextField();
        cedulaText.setAlignmentX(Component.CENTER_ALIGNMENT);
        cedulaText.setBackground(mini);
        cedulaText.setForeground(Color.white);
        cedulaText.setBorder(BorderFactory.createLineBorder(margen));
        cedulaText.setMaximumSize(new Dimension(300, 30));

        JLabel contraseña = new JLabel("Contraseña");
        contraseña.setForeground(text);
        contraseña.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextField contraseñaText = new JTextField();

        contraseñaText.setAlignmentX(Component.CENTER_ALIGNMENT);
        contraseñaText.setBackground(mini);
        contraseñaText.setForeground(Color.white);
        contraseñaText.setBorder(BorderFactory.createLineBorder(margen));
        contraseñaText.setMaximumSize(new Dimension(300, 30));

        JButton confirmar = new JButton("Confirmar");
        Dimension buttonSize = new Dimension(100, 20);
            confirmar.setBackground(fondo);
            confirmar.setForeground(Color.WHITE);
            confirmar.setMinimumSize(buttonSize);
            confirmar.setPreferredSize(buttonSize);
            confirmar.setMaximumSize(buttonSize);
            confirmar.setAlignmentX(Component.CENTER_ALIGNMENT);
            confirmar.setBackground(fondo);
            confirmar.setForeground(Color.WHITE);
            confirmar.addActionListener(e->new VentanaRegistrar());

        confirmar.addActionListener(e ->new Registro(edadText,nombreText,cedulaText,contraseñaText));

            panel.add(Box.createVerticalGlue());
            panel.add(titulo);
            panel.add(Box.createRigidArea(new Dimension(0, 20))); // Espacio entre componentes
            panel.add(nombre);
            panel.add(Box.createRigidArea(new Dimension(0, 10)));
            panel.add(nombreText);
            panel.add(Box.createRigidArea(new Dimension(0, 10)));
            panel.add(edad);
            panel.add(Box.createRigidArea(new Dimension(0, 10)));
            panel.add(edadText);
            panel.add(Box.createRigidArea(new Dimension(0, 10)));
            panel.add(cedula);
            panel.add(Box.createRigidArea(new Dimension(0, 10)));
            panel.add(cedulaText);
            panel.add(Box.createRigidArea(new Dimension(0, 10)));
            panel.add(contraseña);
            panel.add(Box.createRigidArea(new Dimension(0, 10)));
            panel.add(contraseñaText);
            panel.add(Box.createRigidArea(new Dimension(0, 10)));
            panel.add(confirmar);
            panel.add(Box.createRigidArea(new Dimension(0, 10)));
            panel.add(Box.createVerticalGlue());


            this.getContentPane().setLayout(new BorderLayout());
            this.getContentPane().add(Box.createHorizontalGlue(), BorderLayout.WEST);
            this.getContentPane().add(panel, BorderLayout.CENTER);
            this.getContentPane().add(Box.createHorizontalGlue(), BorderLayout.EAST);
        }
}
