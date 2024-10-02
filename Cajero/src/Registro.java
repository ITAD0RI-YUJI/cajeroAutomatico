import javax.swing.*;

public class Registro {

   private  String edad, nombre, cedula, contraseña;

        //Aca toca que metan algo para que genere el numero de tarjeta
        //La tarjeta del usuario tiene que tener 16 digitos asi es casi siempre creo
    Registro(JTextField edad, JTextField cedula, JTextField nombre, JTextField contraseña) {
        this.edad = edad.getText();
        this.cedula = cedula.getText();
        this.nombre = nombre.getText();
        this.contraseña = contraseña.getText();
        JOptionPane.showMessageDialog(null, "Datos guardados:\nNombre: " + this.nombre +
                "\nEdad: " + this.edad +
                "\nCédula: " + this.cedula +
                "\nContraseña: " + this.contraseña);
    }

}
