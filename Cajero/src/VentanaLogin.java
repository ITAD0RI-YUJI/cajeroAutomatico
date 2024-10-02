import javax.swing.*;
import java.awt.*;

public class VentanaLogin extends JFrame {
    Color fondo = new Color(38, 35, 53);
    Color text = new Color(194,190,212);
    Color mini = new Color(46,43,65);
    Color margen = new Color(106,97,148);
    Color boton = new Color(30,27,41);
    //aca toca poner algo para verificar los datos antes del ingrso sebastian todo suyo

    public VentanaLogin() {
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
        panel.setBackground(fondo);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));


        JButton retirar = new JButton("Retirar");
        Dimension buttonSize = new Dimension(300, 200);
        retirar.setBackground(fondo);
        retirar.setForeground(Color.WHITE);
        retirar.setMinimumSize(buttonSize);
        retirar.setPreferredSize(buttonSize);
        retirar.setMaximumSize(buttonSize);
        retirar.setAlignmentX(Component.CENTER_ALIGNMENT);
        retirar.setBackground(fondo);
        retirar.setForeground(Color.WHITE);
        retirar.addActionListener(e->new VentanaRetirar());

        JButton consignar = new JButton("Consignar");
        consignar.setBackground(fondo);
        consignar.setForeground(Color.WHITE);
        consignar.setMinimumSize(buttonSize);
        consignar.setPreferredSize(buttonSize);
        consignar.setMaximumSize(buttonSize);
        consignar.setAlignmentX(Component.CENTER_ALIGNMENT);
        consignar.setBackground(fondo);
        consignar.setForeground(Color.WHITE);
        consignar.addActionListener(e->new VentanaConsignar());

        panel.add(Box.createVerticalGlue());
        panel.add(retirar);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Espacio entre componentes
        panel.add(consignar);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(Box.createVerticalGlue());

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(Box.createHorizontalGlue(), BorderLayout.WEST);
        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.getContentPane().add(Box.createHorizontalGlue(), BorderLayout.EAST);
    }
}
