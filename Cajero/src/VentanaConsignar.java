import javax.swing.*;
import java.awt.*;

public class VentanaConsignar extends JFrame{

    Color fondo = new Color(38, 35, 53);
    Color text = new Color(194,190,212);
    Color mini = new Color(46,43,65);
    Color margen = new Color(106,97,148);
    Color boton = new Color(30,27,41);

    public VentanaConsignar() {
        setTitle("Consignar");
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

        JLabel monto = new JLabel("Ingrese el monto a consignar");
        monto.setForeground(text);
        monto.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField dinero = new JTextField();
        dinero.setAlignmentX(Component.CENTER_ALIGNMENT);
        dinero.setBackground(mini);
        dinero.setBorder(BorderFactory.createLineBorder(margen));
        dinero.setMaximumSize(new Dimension(300, 20));
        dinero.setForeground(Color.white);

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
        confirmar.addActionListener(e -> new VentanaMain());//Aca tienen que poner lo que guarde los datos

        panel.add(Box.createVerticalGlue());
        panel.add(monto);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Espacio entre componentes
        panel.add(dinero);
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
