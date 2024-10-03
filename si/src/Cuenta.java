import java.io.*;

public class Cuenta {
    private Cliente cliente;
    private double saldo;

    public Cuenta(Cliente cliente, double saldoInicial) {
        this.cliente = cliente;
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public void consignar(double monto) {
        this.saldo += monto;
    }

    public boolean retirar(double monto) {
        if (monto <= saldo) {
            saldo -= monto;
            return true;
        }
        return false;
    }

    public Cliente getCliente() {
        return cliente;
    }

    // Guardar datos de la cuenta en un archivo
    public String toFileString() {
        return cliente.getNombre() + "," + cliente.getCedula() + "," + cliente.getTarjeta() + "," +
                cliente.getContraseña() + "," + saldo;
    }

    // Leer datos de una línea de archivo y crear una cuenta
    public static Cuenta fromFileString(String line) {
        String[] data = line.split(",");
        Cliente cliente = new Cliente(data[0], data[1], data[2], data[3]);
        double saldo = Double.parseDouble(data[4]);
        return new Cuenta(cliente, saldo);
    }
}
